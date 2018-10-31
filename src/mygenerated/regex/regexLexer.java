package mygenerated.regex;
import generator.Tree;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public class regexLexer {
	private InputStream is;
	private int curChar;
	private int curPos;
	private Token curToken;
	private String curString;

	private final String strEOF = "@eof";
	public regexLexer(InputStream is) throws ParseException, IOException {
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
		System.out.println("Result:= [" + result + "]");
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
 		else if (curString.equals("[")) {
			curToken = Token.OPEN_SQUARE;
		}
		else if (curString.equals("|")) {
			curToken = Token.OR;
		}
		else if (curString.equals("(")) {
			curToken = Token.OPEN_BRACKET;
		}
		else if (curString.equals(")")) {
			curToken = Token.CLOSE_BRACKET;
		}
		else if (curString.equals("]")) {
			curToken = Token.CLOSE_SQUARE;
		}
		else if (curString.equals("*")) {
			curToken = Token.ASTERISK;
		}
		else if (curString.equals("+")) {
			curToken = Token.ASTERISK;
		}
		else if(curString.matches("[a-z]+")) {
			curToken = Token.CHAR;
			//System.out.println("\"" + curString + "\" matched by " + "[a-z]+");
		}
		 else throw new AssertionError("Illegal character " + (char) curChar + " at position " + curPos + "\n CUR_STRING: " + curString);
	}

	private boolean isValidString(String str) {
		if ((strEOF).contains(str)) {
			return true;
		}
 		else if (("[").contains(str)) {
			return true;
		} 
		else if (("|").contains(str)) {
			return true;
		} 
		else if (("(").contains(str)) {
			return true;
		} 
		else if ((")").contains(str)) {
			return true;
		} 
		else if (("]").contains(str)) {
			return true;
		} 
		else if (("*").contains(str)) {
			return true;
		} 
		else if (("+").contains(str)) {
			return true;
		} 
		else if(str.matches("[a-z]+")) {
			return true;
		}

		return false;
	}

}

