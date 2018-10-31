package mygenerated.functional;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public class functionalLexer {
	private InputStream is;
	private int curChar;
	private int curPos;
	private Token curToken;
	private String curString;

	private final String strEOF = "@eof";
	public functionalLexer(InputStream is) throws ParseException, IOException {
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
 		else if (curString.equals(",")) {
			curToken = Token.COMMA;
		}
		else if (curString.equals("*")) {
			curToken = Token.OPS2;
		}
		else if (curString.equals("/")) {
			curToken = Token.OPS2;
		}
		else if (curString.equals("%")) {
			curToken = Token.OPS2;
		}
		else if (curString.equals("<")) {
			curToken = Token.OPS2;
		}
		else if (curString.equals(">")) {
			curToken = Token.OPS2;
		}
		else if(curString.matches("f[A-Z]*")) {
			curToken = Token.FUNC;
			//System.out.println("\"" + curString + "\" matched by " + "f[A-Z]*");
		}
		else if (curString.equals("==")) {
			curToken = Token.EQUAL;
		}
		else if (curString.equals("(")) {
			curToken = Token.LPAREN;
		}
		else if (curString.equals("TRUE")) {
			curToken = Token.TRUE;
		}
		else if (curString.equals(")")) {
			curToken = Token.RPAREN;
		}
		else if (curString.equals("INT")) {
			curToken = Token.INT;
		}
		else if(curString.matches("[0-9]+")) {
			curToken = Token.INT;
			//System.out.println("\"" + curString + "\" matched by " + "[0-9]+");
		}
		else if (curString.equals("!")) {
			curToken = Token.NOT;
		}
		else if (curString.equals("+")) {
			curToken = Token.OPS;
		}
		else if (curString.equals("-")) {
			curToken = Token.OPS;
		}
		else if (curString.equals("|")) {
			curToken = Token.OPS;
		}
		else if (curString.equals("&")) {
			curToken = Token.OPS;
		}
		else if (curString.equals("->")) {
			curToken = Token.ARROW;
		}
		else if (curString.equals("_")) {
			curToken = Token.BORDER;
		}
		else if (curString.equals("#=")) {
			curToken = Token.HASHTAG;
		}
		else if (curString.equals("BOOL")) {
			curToken = Token.BOOL;
		}
		else if (curString.equals(":")) {
			curToken = Token.QUADRODOT;
		}
		else if (curString.equals("FALSE")) {
			curToken = Token.FALSE;
		}
		else if(curString.matches("[a-z]+")) {
			curToken = Token.IDENTIFIER;
			//System.out.println("\"" + curString + "\" matched by " + "[a-z]+");
		}
		 else throw new AssertionError("Illegal character " + (char) curChar + " at position " + curPos + "\n CUR_STRING: " + curString);
	}

	private boolean isValidString(String str) {
		if ((strEOF).contains(str)) {
			return true;
		}
 		else if ((",").contains(str)) {
			return true;
		} 
		else if (("*").contains(str)) {
			return true;
		} 
		else if (("/").contains(str)) {
			return true;
		} 
		else if (("%").contains(str)) {
			return true;
		} 
		else if (("<").contains(str)) {
			return true;
		} 
		else if ((">").contains(str)) {
			return true;
		} 
		else if(str.matches("f[A-Z]*")) {
			return true;
		}
		else if (("==").contains(str)) {
			return true;
		} 
		else if (("(").contains(str)) {
			return true;
		} 
		else if (("TRUE").contains(str)) {
			return true;
		} 
		else if ((")").contains(str)) {
			return true;
		} 
		else if (("INT").contains(str)) {
			return true;
		} 
		else if(str.matches("[0-9]+")) {
			return true;
		}
		else if (("!").contains(str)) {
			return true;
		} 
		else if (("+").contains(str)) {
			return true;
		} 
		else if (("-").contains(str)) {
			return true;
		} 
		else if (("|").contains(str)) {
			return true;
		} 
		else if (("&").contains(str)) {
			return true;
		} 
		else if (("->").contains(str)) {
			return true;
		} 
		else if (("_").contains(str)) {
			return true;
		} 
		else if (("#=").contains(str)) {
			return true;
		} 
		else if (("BOOL").contains(str)) {
			return true;
		} 
		else if ((":").contains(str)) {
			return true;
		} 
		else if (("FALSE").contains(str)) {
			return true;
		} 
		else if(str.matches("[a-z]+")) {
			return true;
		}

		return false;
	}

}

