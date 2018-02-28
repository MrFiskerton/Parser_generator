package generated.regex;
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
		}
		else if ('|' == ((char) curChar)) {
			curToken = Token.OR;
			curString += (char) curChar;
			nextChar();
		}
		else if ('(' == ((char) curChar)) {
			curToken = Token.OPEN_BRACKET;
			curString += (char) curChar;
			nextChar();
		}
		else if (')' == ((char) curChar)) {
			curToken = Token.CLOSE_BRACKET;
			curString += (char) curChar;
			nextChar();
		}
		else if (']' == ((char) curChar)) {
			curToken = Token.CLOSE_SQUARE;
			curString += (char) curChar;
			nextChar();
		}
		else if ('*' == ((char) curChar)) {
			curToken = Token.ASTERISK;
			curString += (char) curChar;
			nextChar();
		}
		else if ('+' == ((char) curChar)) {
			curToken = Token.ASTERISK;
			curString += (char) curChar;
			nextChar();
		}
		else if ('a' == ((char) curChar)) {
			curToken = Token.CHAR;
			curString += (char) curChar;
			nextChar();
		}
		else if ('b' == ((char) curChar)) {
			curToken = Token.CHAR;
			curString += (char) curChar;
			nextChar();
		}
		else if ('c' == ((char) curChar)) {
			curToken = Token.CHAR;
			curString += (char) curChar;
			nextChar();
		}
		else if ('d' == ((char) curChar)) {
			curToken = Token.CHAR;
			curString += (char) curChar;
			nextChar();
		}
		else if ('e' == ((char) curChar)) {
			curToken = Token.CHAR;
			curString += (char) curChar;
			nextChar();
		}
		else if ('f' == ((char) curChar)) {
			curToken = Token.CHAR;
			curString += (char) curChar;
			nextChar();
		}
		else throw new AssertionError("Illegal character " + (char) curChar);
	}
}
