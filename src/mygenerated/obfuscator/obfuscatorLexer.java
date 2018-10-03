package mygenerated.obfuscator;
import java.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public class obfuscatorLexer {
	private InputStream is;
	private int curChar;
	private int curPos;
	private Token curToken;
	private String curString;

	public obfuscatorLexer(InputStream is) throws ParseException, IOException {
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
		else throw new AssertionError("Illegal character " + (char) curChar);
	}
}
