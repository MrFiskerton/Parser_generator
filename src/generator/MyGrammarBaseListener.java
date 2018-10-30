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
        if (context.JAVA_CODE() != null) pgenerator.header = ParserGenerator.makeCode(context.JAVA_CODE());
    }

    @Override
    public void enterMembersLabel(GrammarParser.MembersLabelContext context) {
        if (context.JAVA_CODE() != null) pgenerator.members = ParserGenerator.makeCode(context.JAVA_CODE());
    }

    @Override
    public void enterTerminalLabel(GrammarParser.TerminalLabelContext context) {
        String name = context.TERM_NAME().getText();
        Node curNode = pgenerator.getTerm(name);

        for (GrammarParser.TerminalProdContext terminalContext : context.terminalProd()) {
            Element el = new Element();
            String s = "";
            for (TerminalNode term : terminalContext.SINGLE_QUOTE_STRING()) {
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
            if (context.synthesized().result().NON_TERM_NAME() != null) {
                currentNode.setReturnType(context.synthesized().result().NON_TERM_NAME().getText());
            } else if (context.synthesized().result().TERM_NAME() != null) {
                currentNode.setReturnType(context.synthesized().result().TERM_NAME().getText());
            } else if (context.synthesized().result().JAVA_NAME() != null) {
                currentNode.setReturnType(context.synthesized().result().JAVA_NAME().getText());
            }
        }

        if (context.inherited() != null) {
            for (GrammarParser.ArgumentContext arg : context.inherited().argument()) {
                currentNode.putDeclAttrs(arg.arg_name().getText(), arg.arg_type().getText());
            }
        }

        for (GrammarParser.NonterminalProdContext nonterminalContext : context.nonterminalProd()) {
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

            if (nonterminalContext.JAVA_CODE() != null) {
                el.setJavaCode(ParserGenerator.makeCode(nonterminalContext.JAVA_CODE()));
            }
            currentNode.add(el);
        }
    }
}
