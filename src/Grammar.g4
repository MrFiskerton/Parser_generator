grammar Grammar;

source_file:
    header? members? grammar_rule+ EOF;
header:  '@header'  JAVA_CODE # headerLabel;
members: '@members' JAVA_CODE # membersLabel;
grammar_rule:
    nonterminal | terminal ;

nonterminal
    : NON_TERM_NAME inherited? synthesized? ':' nonterminalProd ('|' nonterminalProd)* ';' # nonTerminalLabel;

terminal
    : TERM_NAME ':' terminalProd ('|' terminalProd)* ';' # terminalLabel;

inherited:   '[' argument (',' argument)* ']';
synthesized: '[returns ' result ']';

argument: arg_type arg_name;

arg_type: NON_TERM_NAME | TERM_NAME | JAVA_NAME;
arg_name: NON_TERM_NAME | TERM_NAME | JAVA_NAME;

result
    : NON_TERM_NAME ('<' (arg_type)? '>')?
    | TERM_NAME ('<' (arg_type)? '>')?
    | JAVA_NAME ('<' (arg_type)? '>')?
    ;

nonterminalProd:    (nonterminalVariant)* JAVA_CODE?;
nonterminalVariant: ((NON_TERM_NAME callAttrs?)| TERM_NAME);
callAttrs:          '[' JAVA_CODE (',' JAVA_CODE)* ']';

terminalProd: SINGLE_QUOTE_STRING+;

NON_TERM_NAME : LOWERCASE_LETTER CHAR* ;
TERM_NAME : UPPERCASE_LETTER CHAR* ;

JAVA_CODE : '{' (~[{}]+ JAVA_CODE?)* '}' ;
SINGLE_QUOTE_STRING : '\'' (~'\'' | '\\\'')* '\'' ;

JAVA_NAME: LETTER CHAR*;

fragment CHAR: DIGIT | LETTER | UNDERSCORE;
fragment LETTER: UPPERCASE_LETTER | LOWERCASE_LETTER;
fragment UPPERCASE_LETTER: [A-Z];
fragment LOWERCASE_LETTER: [a-z];
fragment UNDERSCORE: [_];
fragment DIGIT: [0-9];

WS : [ \t\r\n]+ -> skip ;
BLOCK_COMMENT: '/*' .*? '*/' -> skip;
COMMENT: '//' ~[\r\n]* -> skip;
