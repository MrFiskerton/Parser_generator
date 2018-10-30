package mygenerated.regex;
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

	private Tree re_p() throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case OR: {
				List<String> OR = new ArrayList<>();
				List<Tree> concat = new ArrayList<>();
				List<Tree> re_p = new ArrayList<>();
				if (lex.curToken().toString().equals("OR")) {
					OR.add(lex.curString());
				} else {
					throw new AssertionError("OR expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				concat.add(concat());
				re_p.add(re_p());
				return new Tree("RE'", concat.get(0), re_p.get(0));
			}
			case CLOSE_BRACKET: {
				return new Tree("RE'");
			}
			case EOF: {
				return new Tree("RE'");
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private Tree kleene_p() throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case OPEN_SQUARE: {
				return new Tree("kleene'");
			}
			case OR: {
				return new Tree("kleene'");
			}
			case OPEN_BRACKET: {
				return new Tree("kleene'");
			}
			case ASTERISK: {
				List<String> ASTERISK = new ArrayList<>();
				List<Tree> kleene_p = new ArrayList<>();
				if (lex.curToken().toString().equals("ASTERISK")) {
					ASTERISK.add(lex.curString());
				} else {
					throw new AssertionError("ASTERISK expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				kleene_p.add(kleene_p());
				return new Tree("kleene'", new Tree(ASTERISK.get(0)), kleene_p.get(0));
			}
			case CHAR: {
				return new Tree("kleene'");
			}
			case CLOSE_BRACKET: {
				return new Tree("kleene'");
			}
			case EOF: {
				return new Tree("kleene'");
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private Tree re() throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case OPEN_SQUARE: {
				List<Tree> concat = new ArrayList<>();
				List<Tree> re_p = new ArrayList<>();
				concat.add(concat());
				re_p.add(re_p());
				return new Tree("RE", concat.get(0), re_p.get(0));
			}
			case OPEN_BRACKET: {
				List<Tree> concat = new ArrayList<>();
				List<Tree> re_p = new ArrayList<>();
				concat.add(concat());
				re_p.add(re_p());
				return new Tree("RE", concat.get(0), re_p.get(0));
			}
			case CHAR: {
				List<Tree> concat = new ArrayList<>();
				List<Tree> re_p = new ArrayList<>();
				concat.add(concat());
				re_p.add(re_p());
				return new Tree("RE", concat.get(0), re_p.get(0));
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private Tree chars_p() throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case CHAR: {
				List<Tree> chars = new ArrayList<>();
				chars.add(chars());
				return chars.get(0);
			}
			case CLOSE_SQUARE: {
				return new Tree("chars_p");
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private Tree start() throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case OPEN_SQUARE: {
				List<Tree> re = new ArrayList<>();
				re.add(re());
				return new Tree("Start", re.get(0));
			}
			case OPEN_BRACKET: {
				List<Tree> re = new ArrayList<>();
				re.add(re());
				return new Tree("Start", re.get(0));
			}
			case CHAR: {
				List<Tree> re = new ArrayList<>();
				re.add(re());
				return new Tree("Start", re.get(0));
			}
			case EOF: {
				return new Tree("Start");
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private Tree concat() throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case OPEN_SQUARE: {
				List<Tree> kleene = new ArrayList<>();
				List<Tree> concat_p = new ArrayList<>();
				kleene.add(kleene());
				concat_p.add(concat_p());
				return new Tree("concat", kleene.get(0), concat_p.get(0));
			}
			case OPEN_BRACKET: {
				List<Tree> kleene = new ArrayList<>();
				List<Tree> concat_p = new ArrayList<>();
				kleene.add(kleene());
				concat_p.add(concat_p());
				return new Tree("concat", kleene.get(0), concat_p.get(0));
			}
			case CHAR: {
				List<Tree> kleene = new ArrayList<>();
				List<Tree> concat_p = new ArrayList<>();
				kleene.add(kleene());
				concat_p.add(concat_p());
				return new Tree("concat", kleene.get(0), concat_p.get(0));
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private Tree concat_p() throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case OPEN_SQUARE: {
				List<Tree> kleene = new ArrayList<>();
				List<Tree> concat_p = new ArrayList<>();
				kleene.add(kleene());
				concat_p.add(concat_p());
				return new Tree("concat'", kleene.get(0), concat_p.get(0));
			}
			case OR: {
				return new Tree("concat'");
			}
			case OPEN_BRACKET: {
				List<Tree> kleene = new ArrayList<>();
				List<Tree> concat_p = new ArrayList<>();
				kleene.add(kleene());
				concat_p.add(concat_p());
				return new Tree("concat'", kleene.get(0), concat_p.get(0));
			}
			case CHAR: {
				List<Tree> kleene = new ArrayList<>();
				List<Tree> concat_p = new ArrayList<>();
				kleene.add(kleene());
				concat_p.add(concat_p());
				return new Tree("concat'", kleene.get(0), concat_p.get(0));
			}
			case CLOSE_BRACKET: {
				return new Tree("concat'");
			}
			case EOF: {
				return new Tree("concat'");
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private Tree n() throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
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
				return new Tree("n", new Tree(OPEN_SQUARE.get(0)), chars.get(0), new Tree(CLOSE_SQUARE.get(0)));
			}
			case OPEN_BRACKET: {
				List<String> OPEN_BRACKET = new ArrayList<>();
				List<Tree> re = new ArrayList<>();
				List<String> CLOSE_BRACKET = new ArrayList<>();
				if (lex.curToken().toString().equals("OPEN_BRACKET")) {
					OPEN_BRACKET.add(lex.curString());
				} else {
					throw new AssertionError("OPEN_BRACKET expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				re.add(re());
				if (lex.curToken().toString().equals("CLOSE_BRACKET")) {
					CLOSE_BRACKET.add(lex.curString());
				} else {
					throw new AssertionError("CLOSE_BRACKET expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				return new Tree("n", new Tree(OPEN_BRACKET.get(0)), re.get(0), new Tree(CLOSE_BRACKET.get(0)));
			}
			case CHAR: {
				List<String> CHAR = new ArrayList<>();
				if (lex.curToken().toString().equals("CHAR")) {
					CHAR.add(lex.curString());
				} else {
					throw new AssertionError("CHAR expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				return new Tree("n", new Tree(CHAR.get(0)));
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private Tree chars() throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case CHAR: {
				List<String> CHAR = new ArrayList<>();
				List<Tree> chars_p = new ArrayList<>();
				if (lex.curToken().toString().equals("CHAR")) {
					CHAR.add(lex.curString());
				} else {
					throw new AssertionError("CHAR expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				chars_p.add(chars_p());
				return new Tree("chars", new Tree(CHAR.get(0)), chars_p.get(0));
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private Tree kleene() throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case OPEN_SQUARE: {
				List<Tree> n = new ArrayList<>();
				List<Tree> kleene_p = new ArrayList<>();
				n.add(n());
				kleene_p.add(kleene_p());
				return new Tree("kleene", n.get(0), kleene_p.get(0));
			}
			case OPEN_BRACKET: {
				List<Tree> n = new ArrayList<>();
				List<Tree> kleene_p = new ArrayList<>();
				n.add(n());
				kleene_p.add(kleene_p());
				return new Tree("kleene", n.get(0), kleene_p.get(0));
			}
			case CHAR: {
				List<Tree> n = new ArrayList<>();
				List<Tree> kleene_p = new ArrayList<>();
				n.add(n());
				kleene_p.add(kleene_p());
				return new Tree("kleene", n.get(0), kleene_p.get(0));
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

}

