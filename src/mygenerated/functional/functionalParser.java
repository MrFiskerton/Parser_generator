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
	private Map<String, Map<List<String>, String>> conds = new HashMap<>(); //condtions	private Map<String, String> functions = new LinkedHashMap<>(); //function signatures	private Map<String, Integer> variables = new HashMap<>(); //amount of variables		private final String tab = "	";	private List<String> scope = new ArrayList<>();		private void addElement(String key, List<String> args, String value) {		conds.get(key).put(args, value);	}		private void addFunction(String key, List<String> args) {		StringBuilder res = new StringBuilder();		String type = args.get(args.size() - 1);		if ((type.equals("bool")) || (type.equals("int"))) res.append(type);		else res.append("void *");			res.append(" ").append(key).append("(");			for (int i = 0; i < args.size() - 1; i++) {			type = args.get(i);			if ((type.equals("bool")) || (type.equals("int"))) {				res.append(type).append(" ").append((char) ('a' + i)).append(", ");			} else {				//it will be function pointer, we constructed it before				res.append(type.replace("###", "" + (char) ('a' + i))).append(", ");			}		}			if (args.size() > 1) res.setLength(res.length() - 2);		res.append(")");			functions.put(key, res.toString());		variables.put(key, args.size() - 1);		conds.put(key, new LinkedHashMap<>());	}
	public void parse(InputStream is) throws ParseException, IOException {
		lex = new functionalLexer(is);
		lex.nextToken();
		start();
		if (!lex.curToken().toString().equals("EOF")) throw new AssertionError("Last token not END, was" + lex.curToken().toString()); 
		
	}

	private String primitive() throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
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
		System.out.println(lex.curToken().toString() + " " + lex.curString());
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
		System.out.println(lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case TRUE: {
				List<String> value = new ArrayList<>();
				List<List> valuess = new ArrayList<>();
				value.add(value());
				valuess.add(valuess());
				List<String> args = new ArrayList<>();				args.add(value.get(0));				args.addAll(valuess.get(0));				scope = args;				return args;
			}
			case FALSE: {
				List<String> value = new ArrayList<>();
				List<List> valuess = new ArrayList<>();
				value.add(value());
				valuess.add(valuess());
				List<String> args = new ArrayList<>();				args.add(value.get(0));				args.addAll(valuess.get(0));				scope = args;				return args;
			}
			case IDENTIFIER: {
				List<String> value = new ArrayList<>();
				List<List> valuess = new ArrayList<>();
				value.add(value());
				valuess.add(valuess());
				List<String> args = new ArrayList<>();				args.add(value.get(0));				args.addAll(valuess.get(0));				scope = args;				return args;
			}
			case INT: {
				List<String> value = new ArrayList<>();
				List<List> valuess = new ArrayList<>();
				value.add(value());
				valuess.add(valuess());
				List<String> args = new ArrayList<>();				args.add(value.get(0));				args.addAll(valuess.get(0));				scope = args;				return args;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private String type() throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
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
				StringBuilder res = new StringBuilder();				String type = (String) typeDef.get(0).get(typeDef.get(0).size() - 1);								if ((type.equals("bool")) || (type.equals("int"))) res.append(type);				else res.append("void *");								res.append(" ").append("(*###) ").append("(");												for (int i = 0; i < typeDef.get(0).size() - 1; i++) {					type = (String) typeDef.get(0).get(i);					if ((type.equals("bool")) || (type.equals("int"))) res.append(type).append(" ").append((char) ('a' + i)).append(", ");					else {						//it will be function pointer, we constructed it before						res.append(type.replace("###", "" + (char) ('a' + i))).append(", ");					}				}								if (typeDef.get(0).size() > 1) res.setLength(res.length() - 2);				res.append(")");				return res.toString();
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
		System.out.println(lex.curToken().toString() + " " + lex.curString());
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
				StringBuilder sb = new StringBuilder();				sb.append(function.get(0));				sb.append(functionArgs.get(0));				return sb.toString();
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
		System.out.println(lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case BOOL: {
				List<String> type = new ArrayList<>();
				List<List> typeDeff = new ArrayList<>();
				type.add(type());
				typeDeff.add(typeDeff());
				List<String> args = new ArrayList<>();				args.add(type.get(0));				args.addAll(typeDeff.get(0));				return args;
			}
			case LPAREN: {
				List<String> type = new ArrayList<>();
				List<List> typeDeff = new ArrayList<>();
				type.add(type());
				typeDeff.add(typeDeff());
				List<String> args = new ArrayList<>();				args.add(type.get(0));				args.addAll(typeDeff.get(0));				return args;
			}
			case INT: {
				List<String> type = new ArrayList<>();
				List<List> typeDeff = new ArrayList<>();
				type.add(type());
				typeDeff.add(typeDeff());
				List<String> args = new ArrayList<>();				args.add(type.get(0));				args.addAll(typeDeff.get(0));				return args;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void file() throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
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
		System.out.println(lex.curToken().toString() + " " + lex.curString());
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
		System.out.println(lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case FUNC: {
				List<String> FUNC = new ArrayList<>();
				if (lex.curToken().toString().equals("FUNC")) {
					FUNC.add(lex.curString());
				} else {
					throw new AssertionError("FUNC expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				int i = scope.indexOf(FUNC.get(0));				String txt = "";				if (i >= 0) txt = "(*" + (char) ('a' + i) + ")";				else txt = FUNC.get(0);				return txt;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private void defOrExpr(String function) throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
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
		System.out.println(lex.curToken().toString() + " " + lex.curString());
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
		System.out.println(lex.curToken().toString() + " " + lex.curString());
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
		System.out.println(lex.curToken().toString() + " " + lex.curString());
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
		System.out.println(lex.curToken().toString() + " " + lex.curString());
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
		System.out.println(lex.curToken().toString() + " " + lex.curString());
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
		System.out.println(lex.curToken().toString() + " " + lex.curString());
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
		System.out.println(lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case HASHTAG: {
				List<List> expressionRight = new ArrayList<>();
				expressionRight.add(expressionRight());
				List<String> conditions = expressionRight.get(0);				List<String> values = new ArrayList<>();								if (conditions.size() == 1) {					addElement(function, values, conditions.get(0));				} else {					values.add(conditions.get(0));					addElement(function, values, conditions.get(1));				}				scope = new ArrayList<>();				return;
			}
			case BORDER: {
				List<List> expressionRight = new ArrayList<>();
				expressionRight.add(expressionRight());
				List<String> conditions = expressionRight.get(0);				List<String> values = new ArrayList<>();								if (conditions.size() == 1) {					addElement(function, values, conditions.get(0));				} else {					values.add(conditions.get(0));					addElement(function, values, conditions.get(1));				}				scope = new ArrayList<>();				return;
			}
			case TRUE: {
				List<List> expressionLeft = new ArrayList<>();
				List<List> expressionRight = new ArrayList<>();
				expressionLeft.add(expressionLeft());
				expressionRight.add(expressionRight());
				List<String> conditions = expressionRight.get(0);				List<String> values = expressionLeft.get(0);								if (conditions.size() == 1) {					addElement(function, values, conditions.get(0));				} else {					values.add(conditions.get(0));					addElement(function, values, conditions.get(1));				}				scope = new ArrayList<>();				return;
			}
			case FALSE: {
				List<List> expressionLeft = new ArrayList<>();
				List<List> expressionRight = new ArrayList<>();
				expressionLeft.add(expressionLeft());
				expressionRight.add(expressionRight());
				List<String> conditions = expressionRight.get(0);				List<String> values = expressionLeft.get(0);								if (conditions.size() == 1) {					addElement(function, values, conditions.get(0));				} else {					values.add(conditions.get(0));					addElement(function, values, conditions.get(1));				}				scope = new ArrayList<>();				return;
			}
			case IDENTIFIER: {
				List<List> expressionLeft = new ArrayList<>();
				List<List> expressionRight = new ArrayList<>();
				expressionLeft.add(expressionLeft());
				expressionRight.add(expressionRight());
				List<String> conditions = expressionRight.get(0);				List<String> values = expressionLeft.get(0);								if (conditions.size() == 1) {					addElement(function, values, conditions.get(0));				} else {					values.add(conditions.get(0));					addElement(function, values, conditions.get(1));				}				scope = new ArrayList<>();				return;
			}
			case INT: {
				List<List> expressionLeft = new ArrayList<>();
				List<List> expressionRight = new ArrayList<>();
				expressionLeft.add(expressionLeft());
				expressionRight.add(expressionRight());
				List<String> conditions = expressionRight.get(0);				List<String> values = expressionLeft.get(0);								if (conditions.size() == 1) {					addElement(function, values, conditions.get(0));				} else {					values.add(conditions.get(0));					addElement(function, values, conditions.get(1));				}				scope = new ArrayList<>();				return;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private String equation() throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
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
		System.out.println(lex.curToken().toString() + " " + lex.curString());
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
		System.out.println(lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case FUNC: {
				file();
				return;
			}
			case EOF: {
				StringBuilder res = new StringBuilder();								for (Map.Entry<String, String> func : functions.entrySet()) {					String name = func.getKey();					res.append(func.getValue()).append(" {\n");									List<String> generatedCond = new ArrayList<>(), collectedBody = new ArrayList<>();					for (Map.Entry<List<String>, String> cond : conds.get(name).entrySet()) {						List<String> parts = cond.getKey();						String value = cond.getValue();						StringBuilder fullCond = new StringBuilder();										int argsCount = variables.get(name), count = 0;										for (int i = 0; i < argsCount; i++) {							String part = parts.get(i);							if (part.matches("-?\\d+(\\.\\d+)?") || part.equals("true") || part.equals("false")) {								count++;								fullCond.append("(").append((char) ('a' + i)).append(" == ").append(part).append(") and ");							}						}										if (parts.size() == argsCount + 1) fullCond.append("(").append(parts.get(argsCount)).append(")");						else if (count > 0) fullCond.setLength(fullCond.length() - 5);										generatedCond.add(fullCond.toString());						collectedBody.add(value);					}									for (int i = 0; i < generatedCond.size(); i++) {						boolean need = generatedCond.get(i).length() > 0;										if (need) res.append(tab);						if (i != 0 && need) res.append("else ");						if (need) res.append("if ").append(generatedCond.get(i)).append(" {\n").append(tab);										//maybe we need cast function pointers to void* here						res.append(tab).append("return ").append(collectedBody.get(i)).append(";\n");										if (need) res.append(tab).append("}\n");									}					res.append("}\n\n");					}								System.out.println(res);				return;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private String condition() throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
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
		System.out.println(lex.curToken().toString() + " " + lex.curString());
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
		System.out.println(lex.curToken().toString() + " " + lex.curString());
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
		System.out.println(lex.curToken().toString() + " " + lex.curString());
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
		System.out.println(lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case FUNC: {
				List<String> equation = new ArrayList<>();
				List<String> equationn = new ArrayList<>();
				equation.add(equation());
				equationn.add(equationn());
				StringBuilder sb = new StringBuilder();				sb.append("(").append(equation.get(0)).append(", ");				sb.append(equationn.get(0));				sb.setLength(sb.length() - 2);				sb.append(")");				return sb.toString();
			}
			case LPAREN: {
				List<String> equation = new ArrayList<>();
				List<String> equationn = new ArrayList<>();
				equation.add(equation());
				equationn.add(equationn());
				StringBuilder sb = new StringBuilder();				sb.append("(").append(equation.get(0)).append(", ");				sb.append(equationn.get(0));				sb.setLength(sb.length() - 2);				sb.append(")");				return sb.toString();
			}
			case TRUE: {
				List<String> equation = new ArrayList<>();
				List<String> equationn = new ArrayList<>();
				equation.add(equation());
				equationn.add(equationn());
				StringBuilder sb = new StringBuilder();				sb.append("(").append(equation.get(0)).append(", ");				sb.append(equationn.get(0));				sb.setLength(sb.length() - 2);				sb.append(")");				return sb.toString();
			}
			case FALSE: {
				List<String> equation = new ArrayList<>();
				List<String> equationn = new ArrayList<>();
				equation.add(equation());
				equationn.add(equationn());
				StringBuilder sb = new StringBuilder();				sb.append("(").append(equation.get(0)).append(", ");				sb.append(equationn.get(0));				sb.setLength(sb.length() - 2);				sb.append(")");				return sb.toString();
			}
			case IDENTIFIER: {
				List<String> equation = new ArrayList<>();
				List<String> equationn = new ArrayList<>();
				equation.add(equation());
				equationn.add(equationn());
				StringBuilder sb = new StringBuilder();				sb.append("(").append(equation.get(0)).append(", ");				sb.append(equationn.get(0));				sb.setLength(sb.length() - 2);				sb.append(")");				return sb.toString();
			}
			case RPAREN: {
				return "()";
			}
			case INT: {
				List<String> equation = new ArrayList<>();
				List<String> equationn = new ArrayList<>();
				equation.add(equation());
				equationn.add(equationn());
				StringBuilder sb = new StringBuilder();				sb.append("(").append(equation.get(0)).append(", ");				sb.append(equationn.get(0));				sb.setLength(sb.length() - 2);				sb.append(")");				return sb.toString();
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private String variable() throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
		switch (lex.curToken()) {
			case IDENTIFIER: {
				List<String> IDENTIFIER = new ArrayList<>();
				if (lex.curToken().toString().equals("IDENTIFIER")) {
					IDENTIFIER.add(lex.curString());
				} else {
					throw new AssertionError("IDENTIFIER expected, instead of " + lex.curToken().toString());
				}
				lex.nextToken();
				int i = scope.indexOf(IDENTIFIER.get(0));				String txt = "";				if (i >= 0) txt = "" + (char) ('a' + i);				else txt = IDENTIFIER.get(0);				return txt;
			}
			default:
				throw new AssertionError(lex.curToken().toString());
		}
	}

	private String equationT() throws ParseException, IOException {
		System.out.println(lex.curToken().toString() + " " + lex.curString());
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

