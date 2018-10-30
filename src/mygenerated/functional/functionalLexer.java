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
		if (',' == ((char) curChar)) {
			curToken = Token.COMMA;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('*' == ((char) curChar)) {
			curToken = Token.OPS2;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('/' == ((char) curChar)) {
			curToken = Token.OPS2;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('%' == ((char) curChar)) {
			curToken = Token.OPS2;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('<' == ((char) curChar)) {
			curToken = Token.OPS2;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('>' == ((char) curChar)) {
			curToken = Token.OPS2;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('A' == ((char) curChar)) {
			curToken = Token.FUNC;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('B' == ((char) curChar)) {
			curToken = Token.FUNC;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('C' == ((char) curChar)) {
			curToken = Token.FUNC;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('D' == ((char) curChar)) {
			curToken = Token.FUNC;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('E' == ((char) curChar)) {
			curToken = Token.FUNC;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('X' == ((char) curChar)) {
			curToken = Token.FUNC;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('Y' == ((char) curChar)) {
			curToken = Token.FUNC;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('Z' == ((char) curChar)) {
			curToken = Token.FUNC;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('=' == ((char) curChar)) {
			curToken = Token.EQUAL;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('(' == ((char) curChar)) {
			curToken = Token.LPAREN;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('T' == ((char) curChar)) {
			curToken = Token.TRUE;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if (')' == ((char) curChar)) {
			curToken = Token.RPAREN;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('0' == ((char) curChar)) {
			curToken = Token.INT;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('1' == ((char) curChar)) {
			curToken = Token.INT;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('2' == ((char) curChar)) {
			curToken = Token.INT;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('3' == ((char) curChar)) {
			curToken = Token.INT;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('4' == ((char) curChar)) {
			curToken = Token.INT;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('5' == ((char) curChar)) {
			curToken = Token.INT;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('6' == ((char) curChar)) {
			curToken = Token.INT;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('7' == ((char) curChar)) {
			curToken = Token.INT;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('8' == ((char) curChar)) {
			curToken = Token.INT;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('9' == ((char) curChar)) {
			curToken = Token.INT;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('!' == ((char) curChar)) {
			curToken = Token.NOT;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('+' == ((char) curChar)) {
			curToken = Token.OPS;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('-' == ((char) curChar)) {
			curToken = Token.OPS;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('|' == ((char) curChar)) {
			curToken = Token.OPS;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('&' == ((char) curChar)) {
			curToken = Token.OPS;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('_' == ((char) curChar)) {
			curToken = Token.BORDER;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('#' == ((char) curChar)) {
			curToken = Token.HASHTAG;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if (':' == ((char) curChar)) {
			curToken = Token.QUADRODOT;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('F' == ((char) curChar)) {
			curToken = Token.FALSE;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('a' == ((char) curChar)) {
			curToken = Token.IDENTIFIER;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('b' == ((char) curChar)) {
			curToken = Token.IDENTIFIER;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('c' == ((char) curChar)) {
			curToken = Token.IDENTIFIER;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('d' == ((char) curChar)) {
			curToken = Token.IDENTIFIER;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('e' == ((char) curChar)) {
			curToken = Token.IDENTIFIER;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('x' == ((char) curChar)) {
			curToken = Token.IDENTIFIER;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('y' == ((char) curChar)) {
			curToken = Token.IDENTIFIER;
			curString += (char) curChar;
			nextChar();
			return;
		}
		else if ('z' == ((char) curChar)) {
			curToken = Token.IDENTIFIER;
			curString += (char) curChar;
			nextChar();
			return;
		}
		while (true) {
			curString += (char) curChar;
			if(curString.matches("INT")) {
				curToken = Token.INT;
				//System.out.println("\"" + curString + "\" matched by " + "INT");
				nextChar();
				return;
			}
			if(curString.matches("~>")) {
				curToken = Token.ARROW;
				//System.out.println("\"" + curString + "\" matched by " + "~>");
				nextChar();
				return;
			}
			if(curString.matches("BOOL")) {
				curToken = Token.BOOL;
				//System.out.println("\"" + curString + "\" matched by " + "BOOL");
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
