grammar FoLtlSortDefinition;

@header{
	package antlr4_generated;
}

start
	: sortDefinition EOF
	;

sortDefinition
	: sortDeclaration*
	;

sortDeclaration
	: SORTNAME ':=' '{'CONSTANT (',' CONSTANT)* '}' ';'
	;



CONSTANT : (('a'..'z') | ('0'..'9')) CHARACTER* ;

SORTNAME : ('A'..'Z') CHARACTER* ;

fragment CHARACTER : ('0'..'9' | 'a'..'z' | 'A'..'Z' | '_') ;

WS : (' ' | '\t' | '\r' | '\n')+ ->skip ;