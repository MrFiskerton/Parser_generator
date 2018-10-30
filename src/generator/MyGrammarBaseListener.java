package generator;

import generator.grammar.GrammarBaseListener;
import generator.grammar.GrammarParser;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Created by mrfiskerton on 25.01.2018.
 */
public class MyGrammarBaseListener extends GrammarBaseListener {
    private ParserGenerator pgenerator;

    MyGrammarBaseListener(ParserGenerator pgenerator) {
        this.pgenerator = pgenerator;
    }

    @Override
    public void enterHeaderLabel(GrammarParser.HeaderLabelContext context) {
        if (context.CODE() != null) pgenerator.header = ParserGenerator.makeCode(context.CODE());
    }

    @Override
    public void enterMembersLabel(GrammarParser.MembersLabelContext context) {
        if (context.CODE() != null) pgenerator.members = ParserGenerator.makeCode(context.CODE());
    }

    @Override
    public void enterTerminalLabel(GrammarParser.TerminalLabelContext context) {
        String name = context.TERM_NAME().getText();
        Node curNode = pgenerator.getTerm(name);

        for (GrammarParser.TerminalProductionContext terminalContext : context.terminalProduction()) {
            Element el = new Element();
            String s = "";
            for (TerminalNode term : terminalContext.STRING()) {
                s += term.getText().substring(1);
                s = s.substring(0, s.length() - 1);
            }
            el.add(new Node(s));
            curNode.add(el);
        }
    }

    @Override
    public void enterNonTerminalLabel(GrammarParser.NonTerminalLabelContext context) {
        Node currentNode = pgenerator.getNonTerm(context.NON_TERM_NAME().getText());

        if (context.synthesized() != null) {
            if (context.synthesized().NON_TERM_NAME() != null) {
                currentNode.setReturnType(context.synthesized().NON_TERM_NAME().getText());
            } else if (context.synthesized().TERM_NAME() != null) {
                currentNode.setReturnType(context.synthesized().TERM_NAME().getText());
            } else if (context.synthesized().MIXED_CASE() != null) {
                currentNode.setReturnType(context.synthesized().MIXED_CASE().getText());
            }
        }

        if (context.inherited() != null) {
            for (GrammarParser.ArgContext arg : context.inherited().arg()) {
                currentNode.putDeclAttrs(arg.argName().getText(), arg.argType().getText());
            }
        }

        for (GrammarParser.NonterminalProductionContext nonterminalContext : context.nonterminalProduction()) {
            Element el = new Element();

            if (nonterminalContext.nonterminalVariant().isEmpty()) {
                el.add(pgenerator.getTerm("EPS"));
            }

            for (GrammarParser.NonterminalVariantContext variantContext : nonterminalContext.nonterminalVariant()) {
                Node part;
                if (variantContext.NON_TERM_NAME() != null) {
                    part = new Node(variantContext.NON_TERM_NAME().getText());
                    if (variantContext.callAttrs() != null) {
                        part.setCallAttrs(ParserGenerator.refactorCallAttrs(variantContext.callAttrs()));
                    }
                } else {
                    part = new Node(variantContext.TERM_NAME().getText());
                }
                el.add(part);
            }

            if (nonterminalContext.CODE() != null) {
                el.setJavaCode(ParserGenerator.makeCode(nonterminalContext.CODE()));
            }
            currentNode.add(el);
        }
    }
}
