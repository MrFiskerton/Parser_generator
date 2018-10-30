// Generated from /home/mrfiskerton/Documents/University-tasks/Translation/4th_lab/Parser_generator/src/Grammar.g4 by ANTLR 4.7
package generator.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#source_file}.
	 * @param ctx the parse tree
	 */
	void enterSource_file(GrammarParser.Source_fileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#source_file}.
	 * @param ctx the parse tree
	 */
	void exitSource_file(GrammarParser.Source_fileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code headerLabel}
	 * labeled alternative in {@link GrammarParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeaderLabel(GrammarParser.HeaderLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code headerLabel}
	 * labeled alternative in {@link GrammarParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeaderLabel(GrammarParser.HeaderLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code membersLabel}
	 * labeled alternative in {@link GrammarParser#members}.
	 * @param ctx the parse tree
	 */
	void enterMembersLabel(GrammarParser.MembersLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code membersLabel}
	 * labeled alternative in {@link GrammarParser#members}.
	 * @param ctx the parse tree
	 */
	void exitMembersLabel(GrammarParser.MembersLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#grammar_rule}.
	 * @param ctx the parse tree
	 */
	void enterGrammar_rule(GrammarParser.Grammar_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#grammar_rule}.
	 * @param ctx the parse tree
	 */
	void exitGrammar_rule(GrammarParser.Grammar_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nonTerminalLabel}
	 * labeled alternative in {@link GrammarParser#nonterminal}.
	 * @param ctx the parse tree
	 */
	void enterNonTerminalLabel(GrammarParser.NonTerminalLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nonTerminalLabel}
	 * labeled alternative in {@link GrammarParser#nonterminal}.
	 * @param ctx the parse tree
	 */
	void exitNonTerminalLabel(GrammarParser.NonTerminalLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code terminalLabel}
	 * labeled alternative in {@link GrammarParser#terminal}.
	 * @param ctx the parse tree
	 */
	void enterTerminalLabel(GrammarParser.TerminalLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code terminalLabel}
	 * labeled alternative in {@link GrammarParser#terminal}.
	 * @param ctx the parse tree
	 */
	void exitTerminalLabel(GrammarParser.TerminalLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#inherited}.
	 * @param ctx the parse tree
	 */
	void enterInherited(GrammarParser.InheritedContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#inherited}.
	 * @param ctx the parse tree
	 */
	void exitInherited(GrammarParser.InheritedContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#callAttrs}.
	 * @param ctx the parse tree
	 */
	void enterCallAttrs(GrammarParser.CallAttrsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#callAttrs}.
	 * @param ctx the parse tree
	 */
	void exitCallAttrs(GrammarParser.CallAttrsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(GrammarParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(GrammarParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#argType}.
	 * @param ctx the parse tree
	 */
	void enterArgType(GrammarParser.ArgTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#argType}.
	 * @param ctx the parse tree
	 */
	void exitArgType(GrammarParser.ArgTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#argName}.
	 * @param ctx the parse tree
	 */
	void enterArgName(GrammarParser.ArgNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#argName}.
	 * @param ctx the parse tree
	 */
	void exitArgName(GrammarParser.ArgNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#synthesized}.
	 * @param ctx the parse tree
	 */
	void enterSynthesized(GrammarParser.SynthesizedContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#synthesized}.
	 * @param ctx the parse tree
	 */
	void exitSynthesized(GrammarParser.SynthesizedContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#nonterminalVariant}.
	 * @param ctx the parse tree
	 */
	void enterNonterminalVariant(GrammarParser.NonterminalVariantContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#nonterminalVariant}.
	 * @param ctx the parse tree
	 */
	void exitNonterminalVariant(GrammarParser.NonterminalVariantContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#nonterminalProduction}.
	 * @param ctx the parse tree
	 */
	void enterNonterminalProduction(GrammarParser.NonterminalProductionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#nonterminalProduction}.
	 * @param ctx the parse tree
	 */
	void exitNonterminalProduction(GrammarParser.NonterminalProductionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#terminalProduction}.
	 * @param ctx the parse tree
	 */
	void enterTerminalProduction(GrammarParser.TerminalProductionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#terminalProduction}.
	 * @param ctx the parse tree
	 */
	void exitTerminalProduction(GrammarParser.TerminalProductionContext ctx);
}