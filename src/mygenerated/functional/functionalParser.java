package mygenerated.functional;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;
import java.text.ParseException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class functionalParser {
	private functionalLexer lex;
	private Map<String, Map<List<String>, String>> conds = new HashMap<>(); //condtions
	public void parse(InputStream is) throws ParseException, IOException {
		lex = new functionalLexer(is);
		lex.nextToken();
		start();
		if (!lex.curToken().toString().equals("EOF")) throw new AssertionError("Last token not END, was" + lex.curToken().toString()); 
		
	}

	private String primitive() throws ParseException, IOException {
		switch (lex.curToken()) {
			case TRUE: {
				List<String> bool = new ArrayList<>();
				bool.add(bool());
				return bool.get(0);
			}
			case FALSE: {
				List<String> bool = new ArrayList<>();
				bool.add(bool());
				return bool.get(0);
			}
			case INT: {
				List<String> INT = new ArrayList<>();
				if (lex.curToken().toString().equals("INT")) {
					INT.add(lex.curString());
				} else {
					throw new AssertionError("INT expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				return INT.get(0);
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private String bool() throws ParseException, IOException {
		switch (lex.curToken()) {
			case TRUE: {
				List<String> TRUE = new ArrayList<>();
				if (lex.curToken().toString().equals("TRUE")) {
					TRUE.add(lex.curString());
				} else {
					throw new AssertionError("TRUE expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				return "true";
			}
			case FALSE: {
				List<String> FALSE = new ArrayList<>();
				if (lex.curToken().toString().equals("FALSE")) {
					FALSE.add(lex.curString());
				} else {
					throw new AssertionError("FALSE expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				return "false";
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private List values() throws ParseException, IOException {
		switch (lex.curToken()) {
			case TRUE: {
				List<String> value = new ArrayList<>();
				List<List> valuess = new ArrayList<>();
				value.add(value());
				valuess.add(valuess());
				List<String> args = new ArrayList<>();
			}
			case FALSE: {
				List<String> value = new ArrayList<>();
				List<List> valuess = new ArrayList<>();
				value.add(value());
				valuess.add(valuess());
				List<String> args = new ArrayList<>();
			}
			case IDENTIFIER: {
				List<String> value = new ArrayList<>();
				List<List> valuess = new ArrayList<>();
				value.add(value());
				valuess.add(valuess());
				List<String> args = new ArrayList<>();
			}
			case INT: {
				List<String> value = new ArrayList<>();
				List<List> valuess = new ArrayList<>();
				value.add(value());
				valuess.add(valuess());
				List<String> args = new ArrayList<>();
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private String type() throws ParseException, IOException {
		switch (lex.curToken()) {
			case BOOL: {
				List<String> BOOL = new ArrayList<>();
				if (lex.curToken().toString().equals("BOOL")) {
					BOOL.add(lex.curString());
				} else {
					throw new AssertionError("BOOL expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				return "bool";
			}
			case LPAREN: {
				List<String> LPAREN = new ArrayList<>();
				List<List> typeDef = new ArrayList<>();
				List<String> RPAREN = new ArrayList<>();
				if (lex.curToken().toString().equals("LPAREN")) {
					LPAREN.add(lex.curString());
				} else {
					throw new AssertionError("LPAREN expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				typeDef.add(typeDef());
				if (lex.curToken().toString().equals("RPAREN")) {
					RPAREN.add(lex.curString());
				} else {
					throw new AssertionError("RPAREN expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				StringBuilder res = new StringBuilder();
			}
			case INT: {
				List<String> INT = new ArrayList<>();
				if (lex.curToken().toString().equals("INT")) {
					INT.add(lex.curString());
				} else {
					throw new AssertionError("INT expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				return "int";
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private String equationF() throws ParseException, IOException {
		switch (lex.curToken()) {
			case FUNC: {
				List<String> function = new ArrayList<>();
				List<String> LPAREN = new ArrayList<>();
				List<String> functionArgs = new ArrayList<>();
				List<String> RPAREN = new ArrayList<>();
				function.add(function());
				if (lex.curToken().toString().equals("LPAREN")) {
					LPAREN.add(lex.curString());
				} else {
					throw new AssertionError("LPAREN expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				functionArgs.add(functionArgs());
				if (lex.curToken().toString().equals("RPAREN")) {
					RPAREN.add(lex.curString());
				} else {
					throw new AssertionError("RPAREN expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				StringBuilder sb = new StringBuilder();
			}
			case LPAREN: {
				List<String> LPAREN = new ArrayList<>();
				List<String> equation = new ArrayList<>();
				List<String> RPAREN = new ArrayList<>();
				if (lex.curToken().toString().equals("LPAREN")) {
					LPAREN.add(lex.curString());
				} else {
					throw new AssertionError("LPAREN expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				equation.add(equation());
				if (lex.curToken().toString().equals("RPAREN")) {
					RPAREN.add(lex.curString());
				} else {
					throw new AssertionError("RPAREN expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				return "(" + equation.get(0) + ")";
			}
			case TRUE: {
				List<String> primitive = new ArrayList<>();
				primitive.add(primitive());
				return primitive.get(0);
			}
			case FALSE: {
				List<String> primitive = new ArrayList<>();
				primitive.add(primitive());
				return primitive.get(0);
			}
			case IDENTIFIER: {
				List<String> variable = new ArrayList<>();
				variable.add(variable());
				return variable.get(0);
			}
			case INT: {
				List<String> primitive = new ArrayList<>();
				primitive.add(primitive());
				return primitive.get(0);
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private List typeDef() throws ParseException, IOException {
		switch (lex.curToken()) {
			case BOOL: {
				List<String> type = new ArrayList<>();
				List<List> typeDeff = new ArrayList<>();
				type.add(type());
				typeDeff.add(typeDeff());
				List<String> args = new ArrayList<>();
			}
			case LPAREN: {
				List<String> type = new ArrayList<>();
				List<List> typeDeff = new ArrayList<>();
				type.add(type());
				typeDeff.add(typeDeff());
				List<String> args = new ArrayList<>();
			}
			case INT: {
				List<String> type = new ArrayList<>();
				List<List> typeDeff = new ArrayList<>();
				type.add(type());
				typeDeff.add(typeDeff());
				List<String> args = new ArrayList<>();
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void file() throws ParseException, IOException {
		switch (lex.curToken()) {
			case FUNC: {
				form();
				ffile();
				return;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private String equationn() throws ParseException, IOException {
		switch (lex.curToken()) {
			case COMMA: {
				List<String> COMMA = new ArrayList<>();
				List<String> equation = new ArrayList<>();
				if (lex.curToken().toString().equals("COMMA")) {
					COMMA.add(lex.curString());
				} else {
					throw new AssertionError("COMMA expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				equation.add(equation());
				StringBuilder sb = new StringBuilder(); return sb.append(equation.get(0)).append(", ").toString();
			}
			case RPAREN: {
				return "";
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private String function() throws ParseException, IOException {
		switch (lex.curToken()) {
			case FUNC: {
				List<String> FUNC = new ArrayList<>();
				if (lex.curToken().toString().equals("FUNC")) {
					FUNC.add(lex.curString());
				} else {
					throw new AssertionError("FUNC expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				int i = scope.indexOf(FUNC.get(0));
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void defOrExpr(String function) throws ParseException, IOException {
		switch (lex.curToken()) {
			case HASHTAG: {
				expression(function);
				return;
			}
			case BORDER: {
				expression(function);
				return;
			}
			case QUADRODOT: {
				definition(function);
				return;
			}
			case TRUE: {
				expression(function);
				return;
			}
			case FALSE: {
				expression(function);
				return;
			}
			case IDENTIFIER: {
				expression(function);
				return;
			}
			case INT: {
				expression(function);
				return;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void definition(String function) throws ParseException, IOException {
		switch (lex.curToken()) {
			case QUADRODOT: {
				List<String> QUADRODOT = new ArrayList<>();
				List<List> typeDef = new ArrayList<>();
				if (lex.curToken().toString().equals("QUADRODOT")) {
					QUADRODOT.add(lex.curString());
				} else {
					throw new AssertionError("QUADRODOT expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				typeDef.add(typeDef());
				addFunction(function, typeDef.get(0)); return;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private List expressionLeft() throws ParseException, IOException {
		switch (lex.curToken()) {
			case TRUE: {
				List<List> values = new ArrayList<>();
				values.add(values());
				return values.get(0);
			}
			case FALSE: {
				List<List> values = new ArrayList<>();
				values.add(values());
				return values.get(0);
			}
			case IDENTIFIER: {
				List<List> values = new ArrayList<>();
				values.add(values());
				return values.get(0);
			}
			case INT: {
				List<List> values = new ArrayList<>();
				values.add(values());
				return values.get(0);
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private String equationTPrime() throws ParseException, IOException {
		switch (lex.curToken()) {
			case COMMA: {
				return "";
			}
			case OPS: {
				return "";
			}
			case HASHTAG: {
				return "";
			}
			case OPS2: {
				List<String> OPS2 = new ArrayList<>();
				List<String> equationF = new ArrayList<>();
				List<String> equationTPrime = new ArrayList<>();
				if (lex.curToken().toString().equals("OPS2")) {
					OPS2.add(lex.curString());
				} else {
					throw new AssertionError("OPS2 expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				equationF.add(equationF());
				equationTPrime.add(equationTPrime());
				return " " + OPS2.get(0) + " " + equationF.get(0) + equationTPrime.get(0);
			}
			case FUNC: {
				return "";
			}
			case EQUAL: {
				List<String> EQUAL = new ArrayList<>();
				List<String> equationF = new ArrayList<>();
				List<String> equationTPrime = new ArrayList<>();
				if (lex.curToken().toString().equals("EQUAL")) {
					EQUAL.add(lex.curString());
				} else {
					throw new AssertionError("EQUAL expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				equationF.add(equationF());
				equationTPrime.add(equationTPrime());
				return " == " + equationF.get(0) + equationTPrime.get(0);
			}
			case RPAREN: {
				return "";
			}
			case EOF: {
				return "";
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private String value() throws ParseException, IOException {
		switch (lex.curToken()) {
			case TRUE: {
				List<String> primitive = new ArrayList<>();
				primitive.add(primitive());
				return primitive.get(0);
			}
			case FALSE: {
				List<String> primitive = new ArrayList<>();
				primitive.add(primitive());
				return primitive.get(0);
			}
			case IDENTIFIER: {
				List<String> variable = new ArrayList<>();
				variable.add(variable());
				return variable.get(0);
			}
			case INT: {
				List<String> primitive = new ArrayList<>();
				primitive.add(primitive());
				return primitive.get(0);
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private List valuess() throws ParseException, IOException {
		switch (lex.curToken()) {
			case HASHTAG: {
				return new ArrayList<>();
			}
			case BORDER: {
				return new ArrayList<>();
			}
			case TRUE: {
				List<List> values = new ArrayList<>();
				values.add(values());
				return values.get(0);
			}
			case FALSE: {
				List<List> values = new ArrayList<>();
				values.add(values());
				return values.get(0);
			}
			case IDENTIFIER: {
				List<List> values = new ArrayList<>();
				values.add(values());
				return values.get(0);
			}
			case INT: {
				List<List> values = new ArrayList<>();
				values.add(values());
				return values.get(0);
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private List expressionRight() throws ParseException, IOException {
		switch (lex.curToken()) {
			case HASHTAG: {
				List<String> HASHTAG = new ArrayList<>();
				List<String> condition = new ArrayList<>();
				if (lex.curToken().toString().equals("HASHTAG")) {
					HASHTAG.add(lex.curString());
				} else {
					throw new AssertionError("HASHTAG expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				condition.add(condition());
				return condition;
			}
			case BORDER: {
				List<String> BORDER = new ArrayList<>();
				List<String> condition = new ArrayList<>();
				List<String> HASHTAG = new ArrayList<>();
				if (lex.curToken().toString().equals("BORDER")) {
					BORDER.add(lex.curString());
				} else {
					throw new AssertionError("BORDER expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				condition.add(condition());
				if (lex.curToken().toString().equals("HASHTAG")) {
					HASHTAG.add(lex.curString());
				} else {
					throw new AssertionError("HASHTAG expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				condition.add(condition());
				return condition;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void expression(String function) throws ParseException, IOException {
		switch (lex.curToken()) {
			case HASHTAG: {
				List<List> expressionRight = new ArrayList<>();
				expressionRight.add(expressionRight());
				List<String> conditions = expressionRight.get(0);
			}
			case BORDER: {
				List<List> expressionRight = new ArrayList<>();
				expressionRight.add(expressionRight());
				List<String> conditions = expressionRight.get(0);
			}
			case TRUE: {
				List<List> expressionLeft = new ArrayList<>();
				List<List> expressionRight = new ArrayList<>();
				expressionLeft.add(expressionLeft());
				expressionRight.add(expressionRight());
				List<String> conditions = expressionRight.get(0);
			}
			case FALSE: {
				List<List> expressionLeft = new ArrayList<>();
				List<List> expressionRight = new ArrayList<>();
				expressionLeft.add(expressionLeft());
				expressionRight.add(expressionRight());
				List<String> conditions = expressionRight.get(0);
			}
			case IDENTIFIER: {
				List<List> expressionLeft = new ArrayList<>();
				List<List> expressionRight = new ArrayList<>();
				expressionLeft.add(expressionLeft());
				expressionRight.add(expressionRight());
				List<String> conditions = expressionRight.get(0);
			}
			case INT: {
				List<List> expressionLeft = new ArrayList<>();
				List<List> expressionRight = new ArrayList<>();
				expressionLeft.add(expressionLeft());
				expressionRight.add(expressionRight());
				List<String> conditions = expressionRight.get(0);
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private String equation() throws ParseException, IOException {
		switch (lex.curToken()) {
			case FUNC: {
				List<String> equationT = new ArrayList<>();
				List<String> equationEPrime = new ArrayList<>();
				equationT.add(equationT());
				equationEPrime.add(equationEPrime());
				return equationT.get(0) + equationEPrime.get(0);
			}
			case LPAREN: {
				List<String> equationT = new ArrayList<>();
				List<String> equationEPrime = new ArrayList<>();
				equationT.add(equationT());
				equationEPrime.add(equationEPrime());
				return equationT.get(0) + equationEPrime.get(0);
			}
			case TRUE: {
				List<String> equationT = new ArrayList<>();
				List<String> equationEPrime = new ArrayList<>();
				equationT.add(equationT());
				equationEPrime.add(equationEPrime());
				return equationT.get(0) + equationEPrime.get(0);
			}
			case FALSE: {
				List<String> equationT = new ArrayList<>();
				List<String> equationEPrime = new ArrayList<>();
				equationT.add(equationT());
				equationEPrime.add(equationEPrime());
				return equationT.get(0) + equationEPrime.get(0);
			}
			case IDENTIFIER: {
				List<String> equationT = new ArrayList<>();
				List<String> equationEPrime = new ArrayList<>();
				equationT.add(equationT());
				equationEPrime.add(equationEPrime());
				return equationT.get(0) + equationEPrime.get(0);
			}
			case INT: {
				List<String> equationT = new ArrayList<>();
				List<String> equationEPrime = new ArrayList<>();
				equationT.add(equationT());
				equationEPrime.add(equationEPrime());
				return equationT.get(0) + equationEPrime.get(0);
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void start() throws ParseException, IOException {
		switch (lex.curToken()) {
			case FUNC: {
				file();
				return;
			}
			case EOF: {
				return;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void ffile() throws ParseException, IOException {
		switch (lex.curToken()) {
			case FUNC: {
				file();
				return;
			}
			case EOF: {
				StringBuilder res = new StringBuilder();
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private String condition() throws ParseException, IOException {
		switch (lex.curToken()) {
			case NOT: {
				List<String> NOT = new ArrayList<>();
				List<String> condition = new ArrayList<>();
				if (lex.curToken().toString().equals("NOT")) {
					NOT.add(lex.curString());
				} else {
					throw new AssertionError("NOT expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				condition.add(condition());
				return "not " + condition.get(0);
			}
			case FUNC: {
				List<String> equation = new ArrayList<>();
				equation.add(equation());
				return equation.get(0);
			}
			case LPAREN: {
				List<String> equation = new ArrayList<>();
				equation.add(equation());
				return equation.get(0);
			}
			case TRUE: {
				List<String> equation = new ArrayList<>();
				equation.add(equation());
				return equation.get(0);
			}
			case FALSE: {
				List<String> equation = new ArrayList<>();
				equation.add(equation());
				return equation.get(0);
			}
			case IDENTIFIER: {
				List<String> equation = new ArrayList<>();
				equation.add(equation());
				return equation.get(0);
			}
			case INT: {
				List<String> equation = new ArrayList<>();
				equation.add(equation());
				return equation.get(0);
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private List typeDeff() throws ParseException, IOException {
		switch (lex.curToken()) {
			case ARROW: {
				List<String> ARROW = new ArrayList<>();
				List<List> typeDef = new ArrayList<>();
				if (lex.curToken().toString().equals("ARROW")) {
					ARROW.add(lex.curString());
				} else {
					throw new AssertionError("ARROW expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				typeDef.add(typeDef());
				return typeDef.get(0);
			}
			case FUNC: {
				return new ArrayList<>();
			}
			case RPAREN: {
				return new ArrayList<>();
			}
			case EOF: {
				return new ArrayList<>();
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void form() throws ParseException, IOException {
		switch (lex.curToken()) {
			case FUNC: {
				List<String> function = new ArrayList<>();
				function.add(function());
				defOrExpr(function.get(0));
				return;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private String equationEPrime() throws ParseException, IOException {
		switch (lex.curToken()) {
			case COMMA: {
				return "";
			}
			case OPS: {
				List<String> OPS = new ArrayList<>();
				List<String> equationT = new ArrayList<>();
				List<String> equationEPrime = new ArrayList<>();
				if (lex.curToken().toString().equals("OPS")) {
					OPS.add(lex.curString());
				} else {
					throw new AssertionError("OPS expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				equationT.add(equationT());
				equationEPrime.add(equationEPrime());
				return " " + OPS.get(0) + " " + equationT.get(0) + equationEPrime.get(0);
			}
			case HASHTAG: {
				return "";
			}
			case FUNC: {
				return "";
			}
			case RPAREN: {
				return "";
			}
			case EOF: {
				return "";
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private String functionArgs() throws ParseException, IOException {
		switch (lex.curToken()) {
			case FUNC: {
				List<String> equation = new ArrayList<>();
				List<String> equationn = new ArrayList<>();
				equation.add(equation());
				equationn.add(equationn());
				StringBuilder sb = new StringBuilder();
			}
			case LPAREN: {
				List<String> equation = new ArrayList<>();
				List<String> equationn = new ArrayList<>();
				equation.add(equation());
				equationn.add(equationn());
				StringBuilder sb = new StringBuilder();
			}
			case TRUE: {
				List<String> equation = new ArrayList<>();
				List<String> equationn = new ArrayList<>();
				equation.add(equation());
				equationn.add(equationn());
				StringBuilder sb = new StringBuilder();
			}
			case FALSE: {
				List<String> equation = new ArrayList<>();
				List<String> equationn = new ArrayList<>();
				equation.add(equation());
				equationn.add(equationn());
				StringBuilder sb = new StringBuilder();
			}
			case IDENTIFIER: {
				List<String> equation = new ArrayList<>();
				List<String> equationn = new ArrayList<>();
				equation.add(equation());
				equationn.add(equationn());
				StringBuilder sb = new StringBuilder();
			}
			case RPAREN: {
				return "()";
			}
			case INT: {
				List<String> equation = new ArrayList<>();
				List<String> equationn = new ArrayList<>();
				equation.add(equation());
				equationn.add(equationn());
				StringBuilder sb = new StringBuilder();
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private String variable() throws ParseException, IOException {
		switch (lex.curToken()) {
			case IDENTIFIER: {
				List<String> IDENTIFIER = new ArrayList<>();
				if (lex.curToken().toString().equals("IDENTIFIER")) {
					IDENTIFIER.add(lex.curString());
				} else {
					throw new AssertionError("IDENTIFIER expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				int i = scope.indexOf(IDENTIFIER.get(0));
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private String equationT() throws ParseException, IOException {
		switch (lex.curToken()) {
			case FUNC: {
				List<String> equationF = new ArrayList<>();
				List<String> equationTPrime = new ArrayList<>();
				equationF.add(equationF());
				equationTPrime.add(equationTPrime());
				return equationF.get(0) + equationTPrime.get(0);
			}
			case LPAREN: {
				List<String> equationF = new ArrayList<>();
				List<String> equationTPrime = new ArrayList<>();
				equationF.add(equationF());
				equationTPrime.add(equationTPrime());
				return equationF.get(0) + equationTPrime.get(0);
			}
			case TRUE: {
				List<String> equationF = new ArrayList<>();
				List<String> equationTPrime = new ArrayList<>();
				equationF.add(equationF());
				equationTPrime.add(equationTPrime());
				return equationF.get(0) + equationTPrime.get(0);
			}
			case FALSE: {
				List<String> equationF = new ArrayList<>();
				List<String> equationTPrime = new ArrayList<>();
				equationF.add(equationF());
				equationTPrime.add(equationTPrime());
				return equationF.get(0) + equationTPrime.get(0);
			}
			case IDENTIFIER: {
				List<String> equationF = new ArrayList<>();
				List<String> equationTPrime = new ArrayList<>();
				equationF.add(equationF());
				equationTPrime.add(equationTPrime());
				return equationF.get(0) + equationTPrime.get(0);
			}
			case INT: {
				List<String> equationF = new ArrayList<>();
				List<String> equationTPrime = new ArrayList<>();
				equationF.add(equationF());
				equationTPrime.add(equationTPrime());
				return equationF.get(0) + equationTPrime.get(0);
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

}
