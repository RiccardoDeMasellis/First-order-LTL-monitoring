grammar FOLTLFormulaParser;

import FOFormulaParser;

start
    :   acrossQuantifiedFormula EOF
    ;

acrossQuantifiedFormula
		:		((FORALL | EXISTS) VARIABLE)? temporalFormula
		;

temporalFormula
    :   temporalDoubleImplication
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
    :   NEXT? notTemp
    ;

notTemp
    :   ltlfAtom
    |   NOT? LPAREN temporalFormula RPAREN
    ;

ltlfAtom
    :   LAST
    |   LPAREN? localQuantifiedFormula RPAREN?
    ;


LAST : TEMPOP ('Last' | 'LAST' | 'last');

WEAKUNTIL : TEMPOP ('WU'|'W');

UNTIL : TEMPOP ('U');

RELEASE : TEMPOP ('R');

GLOBALLY : TEMPOP ('[]'|'G');

EVENTUALLY : TEMPOP ('<>'|'F');

WEAKNEXT : TEMPOP ('WX');

NEXT : TEMPOP ('X');

fragment TEMPOP : '°';