package regex;
import generator.Tree;
import java.io.InputStream;
import java.text.ParseException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class regexParser {
	private regexLexer lex;
	
	public Tree parse(InputStream is) throws ParseException, IOException {
		lex = new regexLexer(is);
		lex.nextToken();
		Tree result = start();
		if (!lex.curToken().toString().equals("EOF")) throw new AssertionError("Last token not END, was" + lex.curToken().toString()); 
		return result;
	}

	private Tree charrs() throws ParseException, IOException {
		switch (lex.curToken()) {
			case CHAR: {
				List<Tree> chars = new ArrayList<>();
				chars.add(chars());
				return chars.get(0);
			}
			case CLOSE_SQUARE: {
				return new Tree("charrs");
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private Tree a() throws ParseException, IOException {
		switch (lex.curToken()) {
			case OPEN_SQUARE: {
				List<String> OPEN_SQUARE = new ArrayList<>();
				List<Tree> chars = new ArrayList<>();
				List<String> CLOSE_SQUARE = new ArrayList<>();
				if (lex.curToken().toString().equals("OPEN_SQUARE")) {
					OPEN_SQUARE.add(lex.curString());
				} else {
					throw new AssertionError("OPEN_SQUARE expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				chars.add(chars());
				if (lex.curToken().toString().equals("CLOSE_SQUARE")) {
					CLOSE_SQUARE.add(lex.curString());
				} else {
					throw new AssertionError("CLOSE_SQUARE expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				return new Tree("A", new Tree(OPEN_SQUARE.get(0)), chars.get(0), new Tree(CLOSE_SQUARE.get(0)));
			}
			case OPEN_BRACKET: {
				List<String> OPEN_BRACKET = new ArrayList<>();
				List<Tree> e = new ArrayList<>();
				List<String> CLOSE_BRACKET = new ArrayList<>();
				if (lex.curToken().toString().equals("OPEN_BRACKET")) {
					OPEN_BRACKET.add(lex.curString());
				} else {
					throw new AssertionError("OPEN_BRACKET expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				e.add(e());
				if (lex.curToken().toString().equals("CLOSE_BRACKET")) {
					CLOSE_BRACKET.add(lex.curString());
				} else {
					throw new AssertionError("CLOSE_BRACKET expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				return new Tree("A", new Tree(OPEN_BRACKET.get(0)), e.get(0), new Tree(CLOSE_BRACKET.get(0)));
			}
			case CHAR: {
				List<String> CHAR = new ArrayList<>();
				if (lex.curToken().toString().equals("CHAR")) {
					CHAR.add(lex.curString());
				} else {
					throw new AssertionError("CHAR expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				return new Tree("A", new Tree(CHAR.get(0)));
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private Tree t() throws ParseException, IOException {
		switch (lex.curToken()) {
			case OPEN_SQUARE: {
				List<Tree> f = new ArrayList<>();
				List<Tree> t1 = new ArrayList<>();
				f.add(f());
				t1.add(t1());
				return new Tree("T", f.get(0), t1.get(0));
			}
			case OPEN_BRACKET: {
				List<Tree> f = new ArrayList<>();
				List<Tree> t1 = new ArrayList<>();
				f.add(f());
				t1.add(t1());
				return new Tree("T", f.get(0), t1.get(0));
			}
			case CHAR: {
				List<Tree> f = new ArrayList<>();
				List<Tree> t1 = new ArrayList<>();
				f.add(f());
				t1.add(t1());
				return new Tree("T", f.get(0), t1.get(0));
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private Tree e() throws ParseException, IOException {
		switch (lex.curToken()) {
			case OPEN_SQUARE: {
				List<Tree> t = new ArrayList<>();
				List<Tree> e1 = new ArrayList<>();
				t.add(t());
				e1.add(e1());
				return new Tree("E", t.get(0), e1.get(0));
			}
			case OPEN_BRACKET: {
				List<Tree> t = new ArrayList<>();
				List<Tree> e1 = new ArrayList<>();
				t.add(t());
				e1.add(e1());
				return new Tree("E", t.get(0), e1.get(0));
			}
			case CHAR: {
				List<Tree> t = new ArrayList<>();
				List<Tree> e1 = new ArrayList<>();
				t.add(t());
				e1.add(e1());
				return new Tree("E", t.get(0), e1.get(0));
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private Tree f() throws ParseException, IOException {
		switch (lex.curToken()) {
			case OPEN_SQUARE: {
				List<Tree> a = new ArrayList<>();
				List<Tree> f1 = new ArrayList<>();
				a.add(a());
				f1.add(f1());
				return new Tree("F", a.get(0), f1.get(0));
			}
			case OPEN_BRACKET: {
				List<Tree> a = new ArrayList<>();
				List<Tree> f1 = new ArrayList<>();
				a.add(a());
				f1.add(f1());
				return new Tree("F", a.get(0), f1.get(0));
			}
			case CHAR: {
				List<Tree> a = new ArrayList<>();
				List<Tree> f1 = new ArrayList<>();
				a.add(a());
				f1.add(f1());
				return new Tree("F", a.get(0), f1.get(0));
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private Tree start() throws ParseException, IOException {
		switch (lex.curToken()) {
			case OPEN_SQUARE: {
				List<Tree> e = new ArrayList<>();
				e.add(e());
				return new Tree("S", e.get(0));
			}
			case OPEN_BRACKET: {
				List<Tree> e = new ArrayList<>();
				e.add(e());
				return new Tree("S", e.get(0));
			}
			case CHAR: {
				List<Tree> e = new ArrayList<>();
				e.add(e());
				return new Tree("S", e.get(0));
			}
			case EOF: {
				return new Tree("S");
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private Tree f1() throws ParseException, IOException {
		switch (lex.curToken()) {
			case OPEN_SQUARE: {
				return new Tree("F'");
			}
			case OR: {
				return new Tree("F'");
			}
			case OPEN_BRACKET: {
				return new Tree("F'");
			}
			case ASTERISK: {
				List<String> ASTERISK = new ArrayList<>();
				List<Tree> f1 = new ArrayList<>();
				if (lex.curToken().toString().equals("ASTERISK")) {
					ASTERISK.add(lex.curString());
				} else {
					throw new AssertionError("ASTERISK expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				f1.add(f1());
				return new Tree("F'", new Tree(ASTERISK.get(0)), f1.get(0));
			}
			case CHAR: {
				return new Tree("F'");
			}
			case CLOSE_BRACKET: {
				return new Tree("F'");
			}
			case EOF: {
				return new Tree("F'");
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private Tree e1() throws ParseException, IOException {
		switch (lex.curToken()) {
			case OR: {
				List<String> OR = new ArrayList<>();
				List<Tree> t = new ArrayList<>();
				List<Tree> e1 = new ArrayList<>();
				if (lex.curToken().toString().equals("OR")) {
					OR.add(lex.curString());
				} else {
					throw new AssertionError("OR expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				t.add(t());
				e1.add(e1());
				return new Tree("E'", t.get(0), e1.get(0));
			}
			case CLOSE_BRACKET: {
				return new Tree("E'");
			}
			case EOF: {
				return new Tree("E'");
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private Tree t1() throws ParseException, IOException {
		switch (lex.curToken()) {
			case OPEN_SQUARE: {
				List<Tree> f = new ArrayList<>();
				List<Tree> t1 = new ArrayList<>();
				f.add(f());
				t1.add(t1());
				return new Tree("T'", f.get(0), t1.get(0));
			}
			case OR: {
				return new Tree("T'");
			}
			case OPEN_BRACKET: {
				List<Tree> f = new ArrayList<>();
				List<Tree> t1 = new ArrayList<>();
				f.add(f());
				t1.add(t1());
				return new Tree("T'", f.get(0), t1.get(0));
			}
			case CHAR: {
				List<Tree> f = new ArrayList<>();
				List<Tree> t1 = new ArrayList<>();
				f.add(f());
				t1.add(t1());
				return new Tree("T'", f.get(0), t1.get(0));
			}
			case CLOSE_BRACKET: {
				return new Tree("T'");
			}
			case EOF: {
				return new Tree("T'");
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private Tree chars() throws ParseException, IOException {
		switch (lex.curToken()) {
			case CHAR: {
				List<String> CHAR = new ArrayList<>();
				List<Tree> charrs = new ArrayList<>();
				if (lex.curToken().toString().equals("CHAR")) {
					CHAR.add(lex.curString());
				} else {
					throw new AssertionError("CHAR expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				charrs.add(charrs());
				return new Tree("chars", new Tree(CHAR.get(0)), charrs.get(0));
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

}

