package mygenerated.obfuscate;
import generator.Tree;
import java.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public class obfuscateLexer {
	private InputStream is;
	private int curChar;
	private int curPos;
	private Token curToken;
	private String curString;

	private final String strEOF = "@eof";
	public obfuscateLexer(InputStream is) throws ParseException, IOException {
		this.is = is;
		curPos = 0;
		nextChar();
	}

	private boolean isBlank(int c) { return c == ' ' || c == '\r' || c == '\n' || c == '\t'; }

	private void nextChar() throws ParseException, IOException {
		curPos++;
		try {
			curChar = is.read();
		} catch (IOException e) {
			throw new ParseException(e.getMessage(), curPos);
		}
	}

	private String eat() throws IOException, ParseException {
		String result = "", tmp = "";


		while (isBlank(curChar)) nextChar();
		if (curChar == -1) return strEOF;
		while (!isBlank(curChar)) {
			tmp += (char) curChar;
			if (isValidString(tmp)) {
				result += (char) curChar;
			} else break;
			nextChar();
			//System.out.println("[" + result + "]");
			if (curChar == -1) return result;
		}
		//System.out.println("Result:= [" + result + "]");
		return result;
	
	}

	public Token curToken() {
		return curToken;
	}

	public int curPos() {
		return curPos;
	}

	public String curString() {
		return curString;
	}

	public void nextToken() throws ParseException, IOException {
		curString = eat();
		if (curString.equals(strEOF)) {
			curToken = Token.EOF;
		}
 		else if (curString.equals("float")) {
			curToken = Token.FLOAT;
		}
		else if (curString.equals("<")) {
			curToken = Token.LS;
		}
		else if (curString.equals(";")) {
			curToken = Token.SEMI;
		}
		else if (curString.equals("char")) {
			curToken = Token.CHAR;
		}
		else if (curString.equals("int")) {
			curToken = Token.INT;
		}
		else if (curString.equals("}")) {
			curToken = Token.RFPAREN;
		}
		else if (curString.equals("else")) {
			curToken = Token.ELSE;
		}
		else if (curString.equals("main")) {
			curToken = Token.MAIN;
		}
		else if(curString.matches("[a-zA-Z_]([a-zA-Z_]|[0-9])*")) {
			curToken = Token.IDENTIFIER;
			//System.out.println("\"" + curString + "\" matched by " + "[a-zA-Z_]([a-zA-Z_]|[0-9])*");
		}
		else if (curString.equals("double")) {
			curToken = Token.DOUBLE;
		}
		else if(curString.matches("[1-9][0-9]*")) {
			curToken = Token.INTCONST;
			//System.out.println("\"" + curString + "\" matched by " + "[1-9][0-9]*");
		}
		else if (curString.equals("#include")) {
			curToken = Token.INCLUDE;
		}
		else if (curString.equals("if")) {
			curToken = Token.IF;
		}
		else if (curString.equals(".h")) {
			curToken = Token.DOTH;
		}
		else if (curString.equals(",")) {
			curToken = Token.COMMA;
		}
		else if (curString.equals("{")) {
			curToken = Token.LFPAREN;
		}
		else if (curString.equals("(")) {
			curToken = Token.LPAREN;
		}
		else if (curString.equals(".")) {
			curToken = Token.DOT;
		}
		else if (curString.equals("for")) {
			curToken = Token.FOR;
		}
		else if (curString.equals(">")) {
			curToken = Token.GR;
		}
		else if (curString.equals(")")) {
			curToken = Token.RPAREN;
		}
		else if (curString.equals("short")) {
			curToken = Token.SHORT;
		}
		else if (curString.equals("void")) {
			curToken = Token.VOID;
		}
		 else throw new AssertionError("Illegal character " + (char) curChar + " at position " + curPos + "\n CUR_STRING: " + curString);
	}

	private boolean isValidString(String str) {
		if ((strEOF).contains(str)) {
			return true;
		}
 		else if (("float").contains(str)) {
			return true;
		} 
		else if (("<").contains(str)) {
			return true;
		} 
		else if ((";").contains(str)) {
			return true;
		} 
		else if (("char").contains(str)) {
			return true;
		} 
		else if (("int").contains(str)) {
			return true;
		} 
		else if (("}").contains(str)) {
			return true;
		} 
		else if (("else").contains(str)) {
			return true;
		} 
		else if (("main").contains(str)) {
			return true;
		} 
		else if(str.matches("[a-zA-Z_]([a-zA-Z_]|[0-9])*")) {
			return true;
		}
		else if (("double").contains(str)) {
			return true;
		} 
		else if(str.matches("[1-9][0-9]*")) {
			return true;
		}
		else if (("#include").contains(str)) {
			return true;
		} 
		else if (("if").contains(str)) {
			return true;
		} 
		else if ((".h").contains(str)) {
			return true;
		} 
		else if ((",").contains(str)) {
			return true;
		} 
		else if (("{").contains(str)) {
			return true;
		} 
		else if (("(").contains(str)) {
			return true;
		} 
		else if ((".").contains(str)) {
			return true;
		} 
		else if (("for").contains(str)) {
			return true;
		} 
		else if ((">").contains(str)) {
			return true;
		} 
		else if ((")").contains(str)) {
			return true;
		} 
		else if (("short").contains(str)) {
			return true;
		} 
		else if (("void").contains(str)) {
			return true;
		} 

		return false;
	}

}

