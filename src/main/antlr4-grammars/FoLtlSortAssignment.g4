grammar FoLtlSortAssignment;

@header{
	package antlr4_generated;
}

start
	: sortAssignments EOF
	;

sortAssignments
	: sortAssignment*
	;

sortAssignment
	: VARIABLE '<-' SORTNAME ';'
	;



VARIABLE : '?' (('a'..'z') | ('0'..'9')) CHARACTER* ;

CONSTANT : (('a'..'z') | ('0'..'9')) CHARACTER* ;

SORTNAME : ('A'..'Z') CHARACTER* ;

fragment CHARACTER : ('0'..'9' | 'a'..'z' | 'A'..'Z' | '_') ;

WS : (' ' | '\t' | '\r' | '\n')+ ->skip ;