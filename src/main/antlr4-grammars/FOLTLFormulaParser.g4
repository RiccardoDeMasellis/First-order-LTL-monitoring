grammar FOLTLFormulaParser;

import FOFormulaParser;

start
    :   acrossQuantifiedFormula EOF
    ;

acrossQuantifiedFormula
		:		((FORALL | EXISTS) VARIABLE)? LPAREN? temporalFormula RPAREN?
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
    |   NOT? LSEPARATOR temporalFormula RSEPARATOR
    ;

ltlfAtom
    :   LAST
    |   localQuantifiedFormula
    ;


LAST : ('Last')|('LAST')|('last');

WEAKUNTIL : ('WU'|'W');

UNTIL : ('U');

RELEASE : ('R');

GLOBALLY : ('[]'|'G');

EVENTUALLY : ('<>'|'F');

WEAKNEXT : ('WX');

NEXT : ('X');