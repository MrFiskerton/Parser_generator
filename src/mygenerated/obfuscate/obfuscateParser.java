package mygenerated.obfuscate;
import generator.Tree;
import java.util.*;
import java.io.InputStream;
import java.text.ParseException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class obfuscateParser {
	private obfuscateLexer lex;
	private static Map<String, String> identifierMap = new HashMap<String, String>();		static void write(String x) {System.out.print(x);}		static void debug(String x) {System.err.print(x);}		static String last_result = "";		static String generateIDENTIFIER() {	    StringBuilder result = new StringBuilder();	    Random r = new Random();		    final String alphabet = "OI10";		    if (!last_result.isEmpty()) {	        if (last_result.contains("0")) {	            last_result = last_result.replace('0', 'O');	            return last_result;	        } else if (last_result.contains("1")) {	            last_result = last_result.replace('1', 'I');	            return last_result;	        }	        last_result = "";	    }		    int min_length = 5;	    result.append(alphabet.charAt(r.nextInt(alphabet.length() - 2)));	    for (int i = 1; i < r.nextInt(13) + min_length; i++) {	        result.append(alphabet.charAt(r.nextInt(alphabet.length())));	    }	    last_result = result.toString();		    return last_result;	}		static void declareIdentifier(String identifier) {	    String new_identifier;	    do {	        new_identifier = generateIDENTIFIER();	    } while (identifierMap.containsValue(new_identifier));	    identifierMap.put(identifier, new_identifier);	}		static String obfuscate(String identifier) {	    if(!identifierMap.containsKey(identifier)) {	        declareIdentifier(identifier);	    }	    return identifierMap.get(identifier);	}		static void tabs(int amount) {for(int i=0; i<amount; i++) System.out.print(' ');}
	public void parse(InputStream is) throws ParseException, IOException {
		lex = new obfuscateLexer(is);
		lex.nextToken();
		start();
		if (!lex.curToken().toString().equals("EOF")) throw new AssertionError("Last token not END, was" + lex.curToken().toString()); 
		
	}

	private void print_main() throws ParseException, IOException {
		//System.out.println("print_main " + lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case LFPAREN: {
				write("\nint main () ");
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void main() throws ParseException, IOException {
		//System.out.println("main " + lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case EOF: {
				break;
			}
			case INT: {
				List<String> INT = new ArrayList<>();
				List<String> MAIN = new ArrayList<>();
				List<String> LPAREN = new ArrayList<>();
				List<String> RPAREN = new ArrayList<>();
				if (lex.curToken().toString().equals("INT")) {
					INT.add(lex.curString());
				} else {
					throw new AssertionError("INT expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				if (lex.curToken().toString().equals("MAIN")) {
					MAIN.add(lex.curString());
				} else {
					throw new AssertionError("MAIN expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				if (lex.curToken().toString().equals("LPAREN")) {
					LPAREN.add(lex.curString());
				} else {
					throw new AssertionError("LPAREN expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				if (lex.curToken().toString().equals("RPAREN")) {
					RPAREN.add(lex.curString());
				} else {
					throw new AssertionError("RPAREN expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				print_main();
				body();
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void sum() throws ParseException, IOException {
		//System.out.println("sum " + lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case IDENTIFIER: {
				id();
				assign();
				id();
				plus();
				id();
				semicolon();
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void body() throws ParseException, IOException {
		//System.out.println("body " + lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case LFPAREN: {
				lfparen();
				items();
				rfparen();
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void type() throws ParseException, IOException {
		//System.out.println("type " + lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case FLOAT: {
				List<String> FLOAT = new ArrayList<>();
				if (lex.curToken().toString().equals("FLOAT")) {
					FLOAT.add(lex.curString());
				} else {
					throw new AssertionError("FLOAT expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				write("float");
				break;
			}
			case CHAR: {
				List<String> CHAR = new ArrayList<>();
				if (lex.curToken().toString().equals("CHAR")) {
					CHAR.add(lex.curString());
				} else {
					throw new AssertionError("CHAR expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				write("char");
				break;
			}
			case DOUBLE: {
				List<String> DOUBLE = new ArrayList<>();
				if (lex.curToken().toString().equals("DOUBLE")) {
					DOUBLE.add(lex.curString());
				} else {
					throw new AssertionError("DOUBLE expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				write("double");
				break;
			}
			case VOID: {
				List<String> VOID = new ArrayList<>();
				if (lex.curToken().toString().equals("VOID")) {
					VOID.add(lex.curString());
				} else {
					throw new AssertionError("VOID expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				write("void");
				break;
			}
			case INT: {
				List<String> INT = new ArrayList<>();
				if (lex.curToken().toString().equals("INT")) {
					INT.add(lex.curString());
				} else {
					throw new AssertionError("INT expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				write("int");
				break;
			}
			case SHORT: {
				List<String> SHORT = new ArrayList<>();
				if (lex.curToken().toString().equals("SHORT")) {
					SHORT.add(lex.curString());
				} else {
					throw new AssertionError("SHORT expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				write("short");
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void print_tabs(int amount) throws ParseException, IOException {
		//System.out.println("print_tabs " + lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void lfparen() throws ParseException, IOException {
		//System.out.println("lfparen " + lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case LFPAREN: {
				List<String> LFPAREN = new ArrayList<>();
				if (lex.curToken().toString().equals("LFPAREN")) {
					LFPAREN.add(lex.curString());
				} else {
					throw new AssertionError("LFPAREN expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				write("{\n");
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void statement() throws ParseException, IOException {
		//System.out.println("statement " + lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case IDENTIFIER: {
				sum();
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void id() throws ParseException, IOException {
		//System.out.println("id " + lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case IDENTIFIER: {
				List<String> IDENTIFIER = new ArrayList<>();
				if (lex.curToken().toString().equals("IDENTIFIER")) {
					IDENTIFIER.add(lex.curString());
				} else {
					throw new AssertionError("IDENTIFIER expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				write(obfuscate(IDENTIFIER.get(0)));
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void semicolon() throws ParseException, IOException {
		//System.out.println("semicolon " + lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case SEMI: {
				List<String> SEMI = new ArrayList<>();
				if (lex.curToken().toString().equals("SEMI")) {
					SEMI.add(lex.curString());
				} else {
					throw new AssertionError("SEMI expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				write(";");
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void print_newline() throws ParseException, IOException {
		//System.out.println("print_newline " + lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case FLOAT: {
				write("\n");
				break;
			}
			case CHAR: {
				write("\n");
				break;
			}
			case DOUBLE: {
				write("\n");
				break;
			}
			case IDENTIFIER: {
				write("\n");
				break;
			}
			case VOID: {
				write("\n");
				break;
			}
			case INT: {
				write("\n");
				break;
			}
			case RFPAREN: {
				write("\n");
				break;
			}
			case SHORT: {
				write("\n");
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void include() throws ParseException, IOException {
		//System.out.println("include " + lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case INCLUDE: {
				List<String> INCLUDE = new ArrayList<>();
				List<String> LS = new ArrayList<>();
				List<String> IDENTIFIER = new ArrayList<>();
				List<String> GR = new ArrayList<>();
				if (lex.curToken().toString().equals("INCLUDE")) {
					INCLUDE.add(lex.curString());
				} else {
					throw new AssertionError("INCLUDE expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				if (lex.curToken().toString().equals("LS")) {
					LS.add(lex.curString());
				} else {
					throw new AssertionError("LS expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				if (lex.curToken().toString().equals("IDENTIFIER")) {
					IDENTIFIER.add(lex.curString());
				} else {
					throw new AssertionError("IDENTIFIER expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				print_include(IDENTIFIER.get(0));
				if (lex.curToken().toString().equals("GR")) {
					GR.add(lex.curString());
				} else {
					throw new AssertionError("GR expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void item() throws ParseException, IOException {
		//System.out.println("item " + lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case FLOAT: {
				declaration();
				break;
			}
			case CHAR: {
				declaration();
				break;
			}
			case DOUBLE: {
				declaration();
				break;
			}
			case IDENTIFIER: {
				statement();
				break;
			}
			case VOID: {
				declaration();
				break;
			}
			case INT: {
				declaration();
				break;
			}
			case SHORT: {
				declaration();
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void start() throws ParseException, IOException {
		//System.out.println("start " + lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case INCLUDE: {
				includes();
				main();
				break;
			}
			case EOF: {
				break;
			}
			case INT: {
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void includes() throws ParseException, IOException {
		//System.out.println("includes " + lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case INCLUDE: {
				include();
				includes();
				break;
			}
			case EOF: {
				break;
			}
			case INT: {
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void declaration() throws ParseException, IOException {
		//System.out.println("declaration " + lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case FLOAT: {
				type();
				simple_declaration();
				semicolon();
				break;
			}
			case CHAR: {
				type();
				simple_declaration();
				semicolon();
				break;
			}
			case DOUBLE: {
				type();
				simple_declaration();
				semicolon();
				break;
			}
			case VOID: {
				type();
				simple_declaration();
				semicolon();
				break;
			}
			case INT: {
				type();
				simple_declaration();
				semicolon();
				break;
			}
			case SHORT: {
				type();
				simple_declaration();
				semicolon();
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void plus() throws ParseException, IOException {
		//System.out.println("plus " + lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case PLUS: {
				List<String> PLUS = new ArrayList<>();
				if (lex.curToken().toString().equals("PLUS")) {
					PLUS.add(lex.curString());
				} else {
					throw new AssertionError("PLUS expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				write(" + ");
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void declare_id() throws ParseException, IOException {
		//System.out.println("declare_id " + lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case IDENTIFIER: {
				List<String> IDENTIFIER = new ArrayList<>();
				if (lex.curToken().toString().equals("IDENTIFIER")) {
					IDENTIFIER.add(lex.curString());
				} else {
					throw new AssertionError("IDENTIFIER expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				obfuscate_id(IDENTIFIER.get(0));
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void print_include(String id) throws ParseException, IOException {
		//System.out.println("print_include " + lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case GR: {
				write("#include <" + id + ">\n");
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void intconst() throws ParseException, IOException {
		//System.out.println("intconst " + lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case INTCONST: {
				List<String> INTCONST = new ArrayList<>();
				if (lex.curToken().toString().equals("INTCONST")) {
					INTCONST.add(lex.curString());
				} else {
					throw new AssertionError("INTCONST expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				write(INTCONST.get(0));
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void simple_declaration() throws ParseException, IOException {
		//System.out.println("simple_declaration " + lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case IDENTIFIER: {
				declare_id();
				assign();
				intconst();
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void rfparen() throws ParseException, IOException {
		//System.out.println("rfparen " + lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case RFPAREN: {
				List<String> RFPAREN = new ArrayList<>();
				if (lex.curToken().toString().equals("RFPAREN")) {
					RFPAREN.add(lex.curString());
				} else {
					throw new AssertionError("RFPAREN expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				write("}\n");
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void items() throws ParseException, IOException {
		//System.out.println("items " + lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case FLOAT: {
				item();
				print_newline();
				items();
				break;
			}
			case CHAR: {
				item();
				print_newline();
				items();
				break;
			}
			case DOUBLE: {
				item();
				print_newline();
				items();
				break;
			}
			case IDENTIFIER: {
				item();
				print_newline();
				items();
				break;
			}
			case VOID: {
				item();
				print_newline();
				items();
				break;
			}
			case INT: {
				item();
				print_newline();
				items();
				break;
			}
			case RFPAREN: {
				break;
			}
			case SHORT: {
				item();
				print_newline();
				items();
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void assign() throws ParseException, IOException {
		//System.out.println("assign " + lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case EQ: {
				List<String> EQ = new ArrayList<>();
				if (lex.curToken().toString().equals("EQ")) {
					EQ.add(lex.curString());
				} else {
					throw new AssertionError("EQ expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				write(" = ");
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void obfuscate_id(String id) throws ParseException, IOException {
		//System.out.println("obfuscate_id " + lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case EQ: {
				declareIdentifier(id); write(" " + obfuscate(id));
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

}

