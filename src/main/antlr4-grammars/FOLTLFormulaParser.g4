grammar FOLTLFormulaParser;

import FOFormulaParser;

start
    :   foltlFormula EOF
    ;

foltlFormula
		:		localQuantifiedFormula
		|		acrossQuantifiedFormula
		;

acrossQuantifiedFormula
		:		((FORALL | EXISTS) VARIABLE) LPAREN acrossQuantifiedFormula RPAREN
		|		temporalDoubleImplication
		;

temporalDoubleImplication
    :   temporalImplication (DOUBLEIMPLY temporalImplication)*
    ;

temporalImplication
    :   temporalDisjunction (IMPLY temporalDisjunction)*
    ;

temporalDisjunction
    :   temporalConjunction (OR temporalConjunction)*
    ;

temporalConjunction
    :   weakUntil (AND weakUntil)*
    ;

weakUntil
    :   release (WEAKUNTIL release)*
    ;

release
    :   until(RELEASE until)*
    ;

until
    :   globally(UNTIL globally)*
    ;

globally
    :   GLOBALLY? eventually
    ;

eventually
    :   EVENTUALLY? weakNext
    ;

weakNext
    :   WEAKNEXT? next
    ;

next
    :   NEXT? temporalNegation
    ;

temporalNegation
    :   NOT? ( ltlfAtom | LPAREN temporalDoubleImplication RPAREN )
    ;

ltlfAtom
    :   LAST
    |   localQuantifiedFormula
    ;


/* TOKENS
	 DO NOT USE AS PREDICATE/CONSTANT NAMES
*/

LAST : ('Last' | 'LAST' | 'last');

WEAKUNTIL : ('WU'|'W');

UNTIL : ('U');

RELEASE : ('R');

GLOBALLY : ('[]'|'G');

EVENTUALLY : ('<>'|'F');

WEAKNEXT : ('WX');

NEXT : ('X');