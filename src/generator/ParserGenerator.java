package generator;

import generator.grammar.GrammarBaseListener;
import generator.grammar.GrammarLexer;
import generator.grammar.GrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by mrfiskerton on 25.01.2018.
 */
public class ParserGenerator {
    private static final String EOF = "EOF";
    private static final String EPS = "EPS";

    String name, header = "", members = "";
    private final HashMap<String, Node> nonTerminals = new HashMap<>();
    private final HashMap<String, Node> terminals = new HashMap<>();
    private final HashMap<String, HashSet<String>> first = new HashMap<>();
    private final HashMap<String, HashSet<String>> follow = new HashMap<>();
    private File out;
    private Node start;

    public ParserGenerator(File out) {
        this.out = out;
    }


    private void prepare(File grammar) throws IOException {
        name = grammar.getName().split("[.]")[0];

        GrammarLexer lexer = new GrammarLexer(CharStreams.fromStream(new FileInputStream(grammar)));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokens);

        GrammarBaseListener visitor = new MyGrammarBaseListener(this);
        ParseTree tree = parser.source_file();

        new ParseTreeWalker().walk(visitor, tree);

        if (!terminals.containsKey(EOF)) terminals.put(EOF, new Node(EOF));

        if (!nonTerminals.containsKey("start")) {
            throw new RuntimeException("No entry point");
        } else {
            start = getNonTerm("start");
        }
    }

    private void generateTokens() throws IOException {
        File tokenFile = new File(out, "Token.java");
        tokenFile.getParentFile().mkdirs();

        PrintWriter res = new PrintWriter(tokenFile);

        res.println(header);
        res.println("public enum Token {\n\t");

        List<String> tokenNames = new ArrayList<>(terminals.keySet());
        for (int i = 0; i < tokenNames.size(); i++) {
            res.print(tokenNames.get(i) + (i != tokenNames.size() - 1 ? ", " : ""));
        }
        res.println("\n}");

        res.close();
    }

    private void generateMain() throws IOException {
        File file = new File(out, "Main.java");
        PrintWriter res = new PrintWriter(file);

        res.println(header);
        res.println("import java.io.*;");
        res.println("import java.text.ParseException;");

        res.println("public class Main {");
        res.println("\tpublic static void main(String[] args) throws IOException, ParseException {");
        res.println("\t\tString s = \"\";");
        res.println("\t\ttry {");
        res.println("\t\t\tInputStream is = new ByteArrayInputStream(s.getBytes(\"UTF-8\"));");
        res.println("\t\t\t" + (start.getReturnType().equals("void") ? "" : start.getReturnType() + " result = ") + "(new " + name + "Parser" + "()).parse(is" + (start.getDeclAttrs(true).isEmpty() ? "" : ", " + start.getDeclAttrs(false)) + ");");
        res.println("\t\t} catch(Exception e) {");
        res.println("\t\t\tSystem.err.println(e.getMessage());");
        res.println("\t\t}");
        res.println("\t}");
        res.print("}");
        res.close();
    }

    private void generateLexer() throws IOException {
        final String LEXER = name + "Lexer";
        File lexerFile = new File(out, LEXER + ".java");
        PrintWriter res = new PrintWriter(lexerFile);

        res.println(header);
        res.println("import java.io.IOException;");
        res.println("import java.io.InputStream;");
        res.println("import java.text.ParseException;\n");

        res.println("public class " + LEXER + " {");
        res.println("\tprivate InputStream is;");
        res.println("\tprivate int curChar;");
        res.println("\tprivate int curPos;");
        res.println("\tprivate Token curToken;");
        res.println("\tprivate String curString;\n");
        res.println("\tprivate final String strEOF = \"@eof\";");

        res.println("\tpublic " + LEXER + "(InputStream is) throws ParseException, IOException {");
        res.println("\t\tthis.is = is;");
        res.println("\t\tcurPos = 0;");
        res.println("\t\tnextChar();");
        res.println("\t}\n");

        res.println("\tprivate boolean isBlank(int c) { return c == ' ' || c == '\\r' || c == '\\n' || c == '\\t'; }\n");

        res.println("\tprivate void nextChar() throws ParseException, IOException {");
        res.println("\t\tcurPos++;");
        res.println("\t\ttry {");
        res.println("\t\t\tcurChar = is.read();");
        res.println("\t\t} catch (IOException e) {");
        res.println("\t\t\tthrow new ParseException(e.getMessage(), curPos);");
        res.println("\t\t}");
        res.println("\t}\n");


        res.println("\tprivate String eat() throws IOException, ParseException {");
        res.println("\t\tString result = \"\", tmp = \"\";");
        res.println("\n");
        res.println("\t\twhile (isBlank(curChar)) nextChar();");
        res.println("\t\tif (curChar == -1) return strEOF;");
        res.println("\t\twhile (!isBlank(curChar)) {");
        res.println("\t\t\ttmp += (char) curChar;");
        res.println("\t\t\tif (isValidString(tmp)) {");
        res.println("\t\t\t\tresult += (char) curChar;");
        res.println("\t\t\t} else break;");
        res.println("\t\t\tnextChar();");
        res.println("\t\t\t//System.out.println(\"[\" + result + \"]\");");
        res.println("\t\t\tif (curChar == -1) return result;");
        res.println("\t\t}");
        res.println("\t\t//System.out.println(\"Result:= [\" + result + \"]\");");
        res.println("\t\treturn result;");
        res.println("\t");
        res.println("\t}\n");

        res.println("\tpublic Token curToken() {\n\t\treturn curToken;\n\t}\n");

        res.println("\tpublic int curPos() {\n\t\treturn curPos;\n\t}\n");

        res.println("\tpublic String curString() {\n\t\treturn curString;\n\t}\n");

        ///--------------------------------------------------------------------------------------------
        res.println("\tpublic void nextToken() throws ParseException, IOException {");
        res.println("\t\tcurString = eat();");

        StringBuilder valid_str_expr = new StringBuilder();
        valid_str_expr.append("\t\tif ((strEOF).contains(str)) {\n")
                .append("\t\t\treturn true;\n\t\t}\n ");
        StringBuilder tmp_accumulator = new StringBuilder();

        res.print("\t\tif (curString.equals(strEOF)) {\n");
        res.print("\t\t\tcurToken = Token.EOF;\n\t\t}\n ");

        for (String curStringTerminal : terminals.keySet()) {
            for (Element elementString : terminals.get(curStringTerminal).getElementList()) {
                if (elementString.get(0).getName().length() > 1 &&
                        elementString.get(0).getName().charAt(0) == '/' &&
                        elementString.get(0).getName().charAt(elementString.get(0).getName().length() - 1) == '/') {
                    valid_str_expr.append(String.format(
                            "\t\telse if(str.matches(\"%1$s\")) {\n" +
                                    "\t\t\treturn true;\n" +
                                    "\t\t}\n",
                            elementString.get(0).getName().substring(1, elementString.get(0).getName().length() - 1)));

                    tmp_accumulator.append(String.format(//TODO:
                            "\t\telse if(curString.matches(\"%1$s\")) {\n" +
                                    "\t\t\tcurToken = Token.%2$s;\n" +
                                    "\t\t\t//System.out.println(\"\\\"\" + curString + \"\\\" matched by \" + \"%1$s\");\n" +
                                    "\t\t}",
                            elementString.get(0).getName().substring(1, elementString.get(0).getName().length() - 1),
                            curStringTerminal.toUpperCase()));
                } else {
                    res.println(String.format(
                            "\t\telse if" +
                                    " (curString.equals(\"%1$s\")) {\n" +
                                    "\t\t\tcurToken = Token.%2$s;\n" +
                                    "\t\t}",
                            elementString.get(0).getName(), curStringTerminal.toUpperCase()
                    ));
                    valid_str_expr.append(String.format(
                            "\t\telse if" +
                                    " ((\"%1$s\").contains(str)) {\n" +
                                    "\t\t\treturn true;\n" +
                                    "\t\t} \n",
                            elementString.get(0).getName()));
                }
            }
        }
        res.println(tmp_accumulator.toString());
        res.println("\t\t else throw new AssertionError(\"Illegal character \" + (char) curChar + \" at position \" + curPos + \"\\n CUR_STRING: \" + curString);");
        res.println("\t}\n");
        ///--------------------------------------------------------------------------------------------

        res.println("\tprivate boolean isValidString(String str) {");
        res.println(valid_str_expr.toString());
        res.println("\t\treturn false;");
        res.println("\t}\n");

        res.println("}\n");
        res.close();
    }

    private void generateParser() throws IOException {
        computeFirst();
        computeFollow();

        final String PARSER = name + "Parser";
        final String LEXER = name + "Lexer";

        File parserFile = new File(out, PARSER + ".java");
        PrintWriter res = new PrintWriter(parserFile);

        res.println(header);

        res.println("import java.io.InputStream;");
        res.println("import java.text.ParseException;");
        res.println("import java.io.IOException;");
        res.println("import java.util.ArrayList;");
        res.println("import java.util.List;\n");

        res.println("public class " + PARSER + " {");
        res.println("\tprivate " + LEXER + " lex;");

        res.println(addPrefix("\t", members));
        res.println("\tpublic " + start.getReturnType() + " parse(InputStream is" + (start.getDeclAttrs(true).isEmpty() ? "" : ", " + start.getDeclAttrs(true)) + ") throws ParseException, IOException {");
        res.println("\t\tlex = new " + LEXER + "(is);");
        res.println("\t\tlex.nextToken();");

        res.print("\t\t");
        if (!start.getReturnType().equals("void")) res.print(start.getReturnType() + " result = ");
        res.println(start.getName() + "(" + start.getDeclAttrs(false) + ");");

        res.println("\t\tif (!lex.curToken().toString().equals(\"EOF\")) throw new AssertionError(\"Last token not END, was\" + lex.curToken().toString()); ");
        res.println("\t\t" + (start.getReturnType().equals("void") ? "" : "return result;"));
        res.println("\t}\n");

        for (String nonTerm : nonTerminals.keySet()) {
            res.println("\tprivate " + getNonTerm(nonTerm).getReturnType() + " " + nonTerm + "(" + getNonTerm(nonTerm).getDeclAttrs(true) + ") throws ParseException, IOException {");
            res.println("\t\t//System.out.println(" + "\"" + nonTerm +" \" + " + "lex.curToken().toString() + \" \" + lex.curString());");
            res.println("\t\tswitch (lex.curToken()) {");

            Set<String> set = new HashSet<>(first.get(nonTerm));
            if (set.contains(EPS)) set.addAll(follow.get(nonTerm));
            set.remove(EPS);

            for (String term : set) {
                res.println("\t\t\tcase " + term + ": {");

                boolean ret = false;
                int suitableProds = 0;
                Set<String> rules = new HashSet<>();
                for (Element el : nonTerminals.get(nonTerm).getElementList()) {
                    if (suitableProds == 0 && el.get(0).getName().equals(EPS)) {
                        if (!el.getJavaCode().isEmpty()) {
                            res.println(addPrefix("\t\t\t\t", el.getJavaCode()));
                            ret = true;
                        }
                    } else if (first.get(el.get(0).getName()).contains(term)) {
                        for (Node node : el.getNodes()) {
                            String name = node.getName();
                            if (!rules.contains(node.getName())) {
                                if (nonTerminals.containsKey(name) && !getNonTerm(name).getReturnType().equals("void")) {
                                    res.println("\t\t\t\tList<" + getNonTerm(name).getReturnType() + "> " + name + " = new ArrayList<>();");
                                    rules.add(node.getName());
                                } else if (terminals.containsKey(name)) {
                                    res.println("\t\t\t\tList<String> " + name + " = new ArrayList<>();");
                                    rules.add(name);
                                }
                            }
                        }

                        suitableProds++;

                        for (Node node : el.getNodes()) {
                            String name = node.getName();
                            if (terminals.containsKey(node.getName())) {
                                res.println("\t\t\t\tif (lex.curToken().toString().equals(\"" + name + "\")) {");
                                res.println("\t\t\t\t\t" + name + ".add(lex.curString());");
                                res.println("\t\t\t\t} else {");
                                res.println("\t\t\t\t\tthrow new AssertionError(\"" + name + " expected, instead of \" + lex.curToken().toString());");
                                res.println("\t\t\t\t}");
                                res.println("\t\t\t\tlex.nextToken();");
                            } else if (nonTerminals.containsKey(name) && !getNonTerm(name).getReturnType().equals("void")) {
                                res.print(String.format("\t\t\t\t" + name + ".add(" + name + "(" + node.getCallAttrs() + "));\n", name));
                            } else {
                                res.println("\t\t\t\t" + name + "(" + node.getCallAttrs() + ");");
                            }
                        }
                        if (!el.getJavaCode().isEmpty()) {
                            res.println(addPrefix("\t\t\t\t", el.getJavaCode()));
                            ret = true;
                        }
                    }
                }

                if (suitableProds > 1) {
                    res.close();
                    throw new AssertionError(String.format("Ambigous rule: %s %d", nonTerm, suitableProds));
                } else {
                    if (getNonTerm(nonTerm).getReturnType().equals("String"))
                        res.print((ret ? "" : "\t\t\t\treturn \"\";\n"));
                    else if (getNonTerm(nonTerm).getReturnType().equals("void"))
                        res.print("\t\t\t\tbreak;\n");
                    else
                        res.print((ret ? "" : "\t\t\t\treturn;\n"));
                    res.print("\t\t\t}\n");
                }
            }
            res.print("\t\t\tdefault:\n" + "\t\t\t\tthrow new AssertionError(lex.curToken().toString());\n" + "\t\t}\n" + "\t}\n\n");
        }
        res.println("}\n");
        res.close();
    }

    private void computeFirst() {
        for (String name : terminals.keySet()) {
            first.put(name, new HashSet<String>() {{
                add(name);
            }});
        }

        for (String name : nonTerminals.keySet()) {
            first.put(name, new HashSet<>());
            for (Element el : nonTerminals.get(name).getElementList()) {
                if (el.get(0).getName().equals(EPS)) first.get(name).add(EPS);
            }
        }

        boolean changed = true;
        while (changed) {
            changed = false;
            for (String name : nonTerminals.keySet()) {
                for (Element el : nonTerminals.get(name).getElementList()) {
                    for (int i = 0; i < el.size(); i++) {
                        String label = el.get(i).getName();
                        boolean flag = first.get(label).contains(EPS);

                        for (String cur : first.get(label)) {
                            if (!first.get(name).contains(cur)) {
                                first.get(name).add(cur);
                                changed = true;
                            }
                        }

                        if (flag) {
                            if (i == el.size() - 1) {
                                if (!first.get(name).contains(EPS)) {
                                    first.get(name).add(EPS);
                                    changed = true;
                                }
                            }
                        } else break;
                    }
                }
            }
        }
    }


    private void computeFollow() {
        for (String name : nonTerminals.keySet()) {
            follow.put(name, new HashSet<>());
        }

        follow.get(start.getName()).add(EOF);

        boolean changed = true;
        while (changed) {
            changed = false;

            for (String name : nonTerminals.keySet()) {
                for (Element el : nonTerminals.get(name).getElementList()) {
                    for (int i = 0; i < el.size() - 1; i++) {
                        if (nonTerminals.containsKey(el.get(i).getName())) {
                            for (String cur : first.get(el.get(i + 1).getName())) {
                                if (!cur.equals(EPS) && !follow.get(el.get(i).getName()).contains(cur)) {
                                    follow.get(el.get(i).getName()).add(cur);
                                    changed = true;
                                }
                            }
                        }
                    }

                    int i = el.size() - 1;
                    if (nonTerminals.containsKey(el.get(i).getName())) {
                        for (String cur : follow.get(name)) {
                            if (!cur.equals(EPS) && !follow.get(el.get(i).getName()).contains(cur)) {
                                follow.get(el.get(i).getName()).add(cur);
                                changed = true;
                            }
                        }
                    }

                    if (el.size() > 1 && first.get(el.get(el.size() - 1).getName()).contains(EPS)) {
                        i = el.size() - 2;
                        if (nonTerminals.containsKey(el.get(i).getName())) {
                            for (String cur : follow.get(el.get(i + 1).getName())) {
                                if (!cur.equals(EPS) && !follow.get(el.get(i).getName()).contains(cur)) {
                                    follow.get(el.get(i).getName()).add(cur);
                                    changed = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    Node getTerm(String name) {
        if (!terminals.containsKey(name)) {
            terminals.put(name, new Node(name));
        }
        return terminals.get(name);
    }

    Node getNonTerm(String name) {
        if (!nonTerminals.containsKey(name)) {
            nonTerminals.put(name, new Node(name));
        }
        return nonTerminals.get(name);
    }

    public void generate(File grammar) throws IOException {
        prepare(grammar);
        generateTokens();
        generateMain();
        generateLexer();
        generateParser();
    }

    static List<String> refactorCallAttrs(GrammarParser.CallAttrsContext context) {
//        List<String> codes = new ArrayList<>();
//        for (TerminalNode code : context.JAVA_CODE()) codes.add(makeCode(code));
        return context.JAVA_CODE().stream().map(ParserGenerator::makeCode).collect(Collectors.toList());
    }

    static String addPrefix(String prefix, String code) {
        StringBuilder sb = new StringBuilder();

        for (String line : code.split("\\n"))
            sb.append(prefix).append(line);
        return sb.toString();
    }

    static String makeCode(TerminalNode codeNode) {
        String content = codeNode.getText().trim();
        if (content.length() == 0) return "";
        if (content.charAt(0) == '{' && content.charAt(content.length() - 1) == '}') {
            return content.substring(1, content.length() - 1).trim();
        }
        return content;
    }
}
