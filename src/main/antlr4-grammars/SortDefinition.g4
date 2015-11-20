grammar SortDefinition;

@header{
	package antlr4_generated;
}

start
	: sortDefinition EOF
	;

sortDefinition
	: sortDeclaration* sortAssignment*
	;

sortDeclaration
	: SORTNAME ':=' '{'CONSTANT (',' CONSTANT)* '}' LS
	;

sortAssignment
	: VARIABLE '<-' SORTNAME LS
	;


LS : ';' ;

VARIABLE : '?' (('a'..'z') | ('0'..'9')) CHARACTER* ;

CONSTANT : (('a'..'z') | ('0'..'9')) CHARACTER* ;

PREPOSITION : ('A'..'Z') CHARACTER* ;

fragment CHARACTER : ('0'..'9' | 'a'..'z' | 'A'..'Z' | '_') ;

WS : (' ' | '\t' | '\r' | '\n')+ ->skip ;