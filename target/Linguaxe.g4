grammar Linguaxe;

@header {
package linguaxe;
}

SYMBOL : [a-z][a-z0-9]* ;
INT_NUMBER: [0-9]+;
FLOAT_NUMBER : [0-9]*'.'[0-9]+ ;
BOOLEAN : 'TRUE' | 'FALSE' ;
TEXT_STRING : '"' .*? '"' ;
WS : [ \t\r]+ -> skip ; // skip spaces, tabs, newlines
COMMENT : '/*' .*? '*/' -> skip ; // .*? matches anything until the first */
COMMENT2:  '//' (~'\n')* -> skip ;


s : class_def
	| code
	;

class_def : SYMBOL ( '<' SYMBOL )? ('/n')* '{' attributes methods '}' ;

attributes : (attrib ('\n')+)* ;

attrib : data_type SYMBOL (':=' operation)? ;

methods : (method '\n'*)+ ;

method : ( '(' params ')' ':=' )? SYMBOL '(' params ')' ('\n')* '{' code? '}' ;

params : data_type SYMBOL ( ',' data_type SYMBOL )* ;

code : ('\n')* line aline* ('\n')* ;

aline : '\n' line
	| '\n'
	;

line : operation
	| exp_if
	| exp_for
	| exp_user
	;

member : SYMBOL ('.' SYMBOL)* ('(' (operation (',' operation)*)? ')')?	;

operation : member					#memberOp
	| 'd' operation					#dice
	| '-' operation					#negative
	| operation '[' operation ']'	#index
	| operation 'd' operation		#multDice
	| operation '^' operation		#potence
	| operation ('*'|'/') operation		#MulDiv
	| operation ('+'|'-') operation		#AddSub
	| operation ('!='|'='|'>='|'<='|'<'|'>') operation		#compare
	| operation ('|'|'&') operation		#logic
	| operation ':='<assoc=right> operation	#assign
	| operation ('>>'|'>>') operation	#move
	| new_obj							#newObj
	| INT_NUMBER						#int
	| FLOAT_NUMBER						#float
	| BOOLEAN							#bool
	| TEXT_STRING						#string
	| sharp_identifier					#sharp
	| room								#roomOp
	| '(' operation ')'					#parens
	| '{' operation (',' operation)* '}'	#list
	;

new_obj : 'new' SYMBOL '(' operation (',' operation)* ')' ;

sharp_identifier : '#' INT_NUMBER ;
room : '@' room_path ;

room_path : SYMBOL
	| room_path '/' SYMBOL ;

exp_if : 'if' '(' line ')' '/n'* '{' code '}' ( '/n'* 'else' '/n'* '{' code '}' )? ;

exp_for : 'for' '(' SYMBOL ':' operation ')' '/n'* '{' code '}' ;

exp_user : username '->' operation ;

username : '$' SYMBOL ;

data_type : 'INT'
	| 'FLOAT'
	| 'STRING'
	| 'BOOL'
	;

MUL : '*' ; // assigns token name to '*' used above in grammar
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;