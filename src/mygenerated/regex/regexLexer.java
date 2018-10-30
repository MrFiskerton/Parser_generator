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
		curString = "";
		while (isBlank(curChar)) nextChar();
		if (curChar == -1) {
			curToken = Token.EOF;
			return;
		}
		if ('[' == ((char) curChar)) {
			curToken = Token.OPEN_SQUARE;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('|' == ((char) curChar)) {
			curToken = Token.OR;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('(' == ((char) curChar)) {
			curToken = Token.OPEN_BRACKET;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if (')' == ((char) curChar)) {
			curToken = Token.CLOSE_BRACKET;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if (']' == ((char) curChar)) {
			curToken = Token.CLOSE_SQUARE;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('*' == ((char) curChar)) {
			curToken = Token.ASTERISK;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('+' == ((char) curChar)) {
			curToken = Token.ASTERISK;
			curString += (char) curChar;
			nextChar();
			return;
		}
		while (true) {
			curString += (char) curChar;
			if(curString.matches("[a-z]")) {
				curToken = Token.CHAR;
				//System.out.println("\"" + curString + "\" matched by " + "[a-z]");
				nextChar();
				return;
			}

			nextChar();
			while (isBlank(curChar)) nextChar();
			if (curChar == -1) {
				throw new AssertionError("\"" + curString + "\" doesn't match regexp");
			}
		}
	}
}
