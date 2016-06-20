grammar Linguaxe;

//Parser rules

s : class_def	#classDef
	| code		#sCode
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

variable : SYMBOL					#rootVariable
	| variable '.' SYMBOL			#intermediateVariable
	;

function : (variable '.')? SYMBOL '(' (operation (',' operation)*)? ')' ;

operation : function										#functionOp
	| '-' operation											#negative
	| D operation											#dice
	| operation D operation									#multDice
	| operation '^' operation								#exponent
	| operation op=('*'|'/') operation						#MulDiv
	| operation op=('+'|'-') operation						#AddSub
	| operation op=('!='|'='|'>='|'<='|'<'|'>') operation	#compare
	| operation op=('|'|'&') operation						#logic
	| variable ':=' operation								#assign
	| variable '[' operation ']' ':=' operation				#indexAssign
	| operation op=('>>'|'>>') operation					#move
	| variable												#variableOp
	| operation '[' operation ']'							#index
	| new_obj												#newObj
	| INT_NUMBER											#int
	| FLOAT_NUMBER											#float
	| BOOLEAN												#bool
	| TEXT_STRING											#string
	| sharp_identifier										#sharp
	| room													#roomOp
	| parens												#parensOp
	| '{' operation (',' operation)* '}'					#list
	;

parens : '(' operation ')' ;

new_obj : 'new' SYMBOL '(' (operation (',' operation)*)? ')' ;

sharp_identifier : '#' INT_NUMBER ;
room : '@' room_path ;

room_path : SYMBOL
	| room_path '/' SYMBOL ;

exp_if : 'if' '(' line ')' '/n'* '{' code '}' ( '/n'* 'else' '/n'* '{' code '}' )? ;

exp_for : 'for' '(' SYMBOL ':' operation ')' '/n'* '{' code '}' ;

exp_user : username '->' operation ;

username : '$' SYMBOL ;

data_type : 'int'
	| 'float'
	| 'string'
	;

//Lexer rules

D : 'd' ;
SYMBOL : ('d'[a-z]|[a-c|e-z])[a-z0-9]* ;
INT_NUMBER: [0-9]+;
FLOAT_NUMBER : [0-9]+'.'[0-9]+ ;
BOOLEAN : 'true' | 'false' ;
TEXT_STRING : '"' .*? '"' ;
WS : [ \t\r]+ -> skip ; // skip spaces, tabs, newlines
COMMENT : '/*' .*? '*/' -> skip ; // .*? matches anything until the first */
COMMENT2:  '//' (~'\n')* -> skip ;

MUL : '*' ; // assigns token name to '*' used above in grammar
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
EQ: '=' ;
NEQ: '!=' ;
GREQ: '>=' ;
LESEQ: '<=' ;
GREAT: '>' ;
LESS: '<' ;
AND: '&' ;
OR: '|' ;
MOVE_RIGHT: '>>' ;
MOVE_LEFT: '<<' ;