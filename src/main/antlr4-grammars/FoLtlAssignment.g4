grammar FoLtlAssignment;

@header{
	package antlr4_generated;
}

start
	: assignmentDefinition EOF
	;

assignmentDefinition
	: variableAssignment*
	;

variableAssignment
	: VARIABLE '<-' CONSTANT LS
	;


LS : ';' ;

VARIABLE : '?' (('a'..'z') | ('0'..'9')) CHARACTER* ;

CONSTANT : (('a'..'z') | ('0'..'9')) CHARACTER* ;

fragment CHARACTER : ('0'..'9' | 'a'..'z' | 'A'..'Z' | '_') ;

WS : (' ' | '\t' | '\r' | '\n')+ ->skip ;