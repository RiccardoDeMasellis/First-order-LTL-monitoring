grammar FOFormulaParser;

@header{
    package antlr4_generated;
}


/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

start
		:	localQuantifiedFormula EOF
		;

localQuantifiedFormula
    : ((FORALL | EXISTS) VARIABLE)? localDoubleImplication
    ;

localDoubleImplication
		:	localImplication (DOUBLEIMPLY localImplication)*
		;

localImplication
		: localDisjunction (IMPLY localDisjunction)*
		;

localDisjunction
    : localConjunction (OR localConjunction)*
    ;

localConjunction
    : localNegation (AND localNegation)*
    ;

localNegation
    : NOT? (folAtom | LPAREN localQuantifiedFormula RPAREN)
    ;

folAtom
		: predicate
		| equality
		;

equality
		:	(VARIABLE | CONSTANT) EQUAL (VARIABLE | CONSTANT)
		;

predicate
		: PREPOSITION LPAREN (VARIABLE | CONSTANT) (',' (VARIABLE | CONSTANT))* RPAREN
		;




/* OLD GRAMMAR RULES

predicate
    : PREPOSITION predicateTuple
    | equality
    ;

equality
		:	term EQUAL term
		;

predicateTuple
    : LPAREN term (',' term)* RPAREN
    ;

term
    : VARIABLE
    | CONSTANT
    ;

*/

/*
term
    : function | VARIABLE
    ;

function
    : CONSTANT functionTuple
    | CONSTANT
    ;

functionTuple
    : LPAREN (CONSTANT | VARIABLE) (',' (CONSTANT | VARIABLE) )* RPAREN
    ;
*/



/* Tokens */

LPAREN : '(' ;

RPAREN : ')' ;

DOUBLEIMPLY : '<->' ;

IMPLY : '->' ;

AND : '&' | '&&' ;

OR : '|' | '||';

NOT : '!' ;

FORALL : 'Forall' ;

EXISTS : 'Exists' ;

EQUAL : '=' ;

VARIABLE : '?' (('a'..'z') | ('0'..'9')) CHARACTER* ;

CONSTANT : (('a'..'z') | ('0'..'9')) CHARACTER* ;

PREPOSITION : ('A'..'Z') CHARACTER* ;

fragment CHARACTER : ('0'..'9' | 'a'..'z' | 'A'..'Z' | '_') ;

WS : (' ' | '\t' | '\r' | '\n')+ ->skip ;