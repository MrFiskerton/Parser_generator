grammar Grammar;

source_file
    : header? members? grammar_rule+ EOF;

header
    : '@header' CODE # headerLabel;

members
    : '@members' CODE # membersLabel;

grammar_rule
    :  nonterminal | terminal ;

nonterminal
    : NON_TERM_NAME inherited? ('[returns ' synthesized ']')? ':' nonterminalProduction ('|' nonterminalProduction)* ';'
    # nonTerminalLabel;

terminal
    : TERM_NAME ':' terminalProduction ('|' terminalProduction)* ';'
    # terminalLabel;

inherited
    : '[' arg (',' arg)* ']';

callAttrs
    : '[' CODE (',' CODE)* ']';

arg
    : argType argName;

argType
    : NON_TERM_NAME | TERM_NAME | MIXED_CASE;

argName
    : NON_TERM_NAME | TERM_NAME | MIXED_CASE;

synthesized
    : NON_TERM_NAME ('<' (argType)? '>')?
    | TERM_NAME ('<' (argType)? '>')?
    | MIXED_CASE ('<' (argType)? '>')?
    ;

nonterminalVariant
    : ((NON_TERM_NAME callAttrs?)| TERM_NAME);

nonterminalProduction
    : (nonterminalVariant)* CODE?;

terminalProduction
    : STRING+;

NON_TERM_NAME : [a-z] [a-zA-Z_0-9]* ;
TERM_NAME : [A-Z] [A-Z_0-9]* ;
MIXED_CASE : [A-Za-z] [a-z_A-Z0-9]* ;
CODE : '{' (~[{}]+ CODE?)* '}' ;
STRING : '\'' (~'\'' | '\\\'')* '\'' ;
WS : [ \t\r\n]+ -> skip ;