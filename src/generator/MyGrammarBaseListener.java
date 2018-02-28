package generator;

import generator.grammar.GrammarBaseListener;
import generator.grammar.GrammarParser;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Created by mrfiskerton on 25.01.2018.
 */
public class MyGrammarBaseListener extends GrammarBaseListener {
    private ParserGenerator pg;

    MyGrammarBaseListener(ParserGenerator pg) {
        this.pg = pg;
    }

    @Override
    public void enterHeaderLabel(GrammarParser.HeaderLabelContext ctx) {
        if (ctx.CODE() != null) pg.header = ParserGenerator.makeCode(ctx.CODE());

    }

    @Override
    public void enterMembersLabel(GrammarParser.MembersLabelContext ctx) {
        if (ctx.CODE() != null)  pg.members = ParserGenerator.makeCode(ctx.CODE());
    }

    @Override
    public void enterTerminalLabel(GrammarParser.TerminalLabelContext ctx) {
        String name = ctx.TERM_NAME().getText();
        Node curNode = pg.getTerm(name);

        for (GrammarParser.TerminalProductionContext terminalContext : ctx.terminalProduction()) {
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
    public void enterNonTerminalLabel(GrammarParser.NonTerminalLabelContext ctx) {
        Node currentNode = pg.getNonTerm(ctx.NON_TERM_NAME().getText());

        if (ctx.synthesized() != null) {
            if (ctx.synthesized().NON_TERM_NAME() != null) {
                currentNode.setReturnType(ctx.synthesized().NON_TERM_NAME().getText());
            } else if (ctx.synthesized().TERM_NAME() != null) {
                currentNode.setReturnType(ctx.synthesized().TERM_NAME().getText());
            } else if (ctx.synthesized().MIXED_CASE() != null) {
                currentNode.setReturnType(ctx.synthesized().MIXED_CASE().getText());
            }
        }

        if (ctx.inherited() != null) {
            for (GrammarParser.ArgContext arg : ctx.inherited().declAttrs().arg()) {
                currentNode.putDeclAttrs(arg.argName().getText(), arg.argType().getText());
            }
        }

        for (GrammarParser.NonterminalProductionContext nonterminalContext : ctx.nonterminalProduction()) {
            Element el = new Element();

            if (nonterminalContext.nonterminalVariant().isEmpty()) {
                el.add(pg.getTerm("EPS"));
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
