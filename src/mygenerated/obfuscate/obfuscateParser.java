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
	private static Map<String, String> identifierMap = new HashMap<String, String>();		static void write(String x) {System.out.print(x);}		static void debug(String x) {System.err.print(x);}		static String last_result = "";		static String generateIDENTIFIER() {	    StringBuilder result = new StringBuilder();	    Random r = new Random();		    final String alphabet = "OI10";		    if (!last_result.isEmpty()) {	        if (last_result.contains("0")) {	            last_result = last_result.replace('0', 'O');	            return last_result;	        } else if (last_result.contains("1")) {	            last_result = last_result.replace('1', 'I');	            return last_result;	        }	        last_result = "";	    }		    int min_length = 5;	    result.append(alphabet.charAt(r.nextInt(alphabet.length() - 2)));	    for (int i = 1; i < r.nextInt(13) + min_length; i++) {	        result.append(alphabet.charAt(r.nextInt(alphabet.length())));	    }	    last_result = result.toString();		    return last_result;	}		static void declareIDENTIFIER(String identifier) {	    String new_identifier;	    do {	        new_identifier = generateIDENTIFIER();	    } while (identifierMap.containsValue(new_identifier));	    identifierMap.put(identifier, new_identifier);	}		static String obfuscate(String identifier) {	    if(!identifierMap.containsKey(identifier)) {	        declareIDENTIFIER(identifier);	    }	    return identifierMap.get(identifier);	}		static void tabs(int amount) {for(int i=0; i<amount; i++) System.out.print(' ');}
	public void parse(InputStream is) throws ParseException, IOException {
		lex = new obfuscateLexer(is);
		lex.nextToken();
		start();
		if (!lex.curToken().toString().equals("EOF")) throw new AssertionError("Last token not END, was" + lex.curToken().toString()); 
		
	}

	private void include() throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case INCLUDE: {
				List<String> INCLUDE = new ArrayList<>();
				List<String> LS = new ArrayList<>();
				List<String> IDENTIFIER = new ArrayList<>();
				List<String> DOTH = new ArrayList<>();
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
				if (lex.curToken().toString().equals("DOTH")) {
					DOTH.add(lex.curString());
				} else {
					throw new AssertionError("DOTH expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
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

	private void print_include(String id) throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case DOTH: {
				write("#include <" + id + ".h>\n");
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void print_tabs(int amount) throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void lfparen() throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
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

	private void start() throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case INCLUDE: {
				includes();
				main();
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void includes() throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case INCLUDE: {
				include();
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void main() throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
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
				body();
				write("\nint main () ");
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void rfparen() throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
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

	private void body() throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
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

	private void items() throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case RFPAREN: {
				break;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

}

