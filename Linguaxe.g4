grammar Linguaxe;

//Parser rules

s : class_def	#classDef
	| code		#sCode
	;

class_def : SYMBOL ( INHERIT SYMBOL )? nl? '{' nl? fields? methods? '}' ;

fields : (var_decl nl)+ ;

var_decl : data_type SYMBOL (ASSIGN operation)? ;

methods : (method nl?)+ ;

method : ( data_type SYMBOL ASSIGN )? metname=SYMBOL '(' args? ')' nl? '{' code? '}' ;

args : data_type SYMBOL ( ',' data_type SYMBOL )* ;

code : nl? line (nl line)* nl? ;

line : exp_if
	| exp_for
	| exp_user
	| operation
	| var_decl
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
	| operation op=(MUL|DIV) operation						#MulDiv
	| operation op=(ADD|SUB) operation						#AddSub
	| operation op=(NEQ|EQ|GREQ|LESEQ|LESS|GREAT) operation	#compare
	| operation op=(OR|AND) operation						#logic
	| variable ASSIGN operation								#assign
	| variable '[' operation ']' ASSIGN operation			#indexAssign
	| operation MOVE operation								#move
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
	| '{' (operation (',' operation)*)? '}'					#list
	;

parens : '(' operation ')' ;

new_obj : 'new' SYMBOL '(' (operation (',' operation)*)? ')' ;

sharp_identifier : '#' INT_NUMBER ;

room : ROOM room_path ;

room_path : SYMBOL											#relativeRoom
	|														#rootRoom
	| room_path '/' SYMBOL									#leafRoom
	;

exp_if : IF '(' operation ')' nl? '{' code '}' ( nl? ELSE nl? '{' code '}' )? ;

exp_for : FOR '(' SYMBOL ':' operation ')' nl? '{' code '}' ;

exp_user : USERNAME USEROBJ operation ;

data_type : 'int'
	| 'float'
	| 'string'
	| SYMBOL
	| data_type '[]'
	;

nl : '\n'+;

//Lexer rules

D : [dD] ;
IF: [Ii][Ff] ;
ELSE: [Ee][Ll][Ss][Ee] ;
FOR: [Ff][Oo][Rr] ;

SYMBOL : ([dD][a-zA-Z_]|[a-cA-Ce-zE-Z_])[a-zA-Z0-9_]* ;
USERNAME : '$'[a-zA-Z0-9_]+ ;
INT_NUMBER: [0-9]+;
FLOAT_NUMBER : [0-9]+'.'[0-9]+ ;
BOOLEAN : [Tt][Rr][Uu][Ee] | [Ff][Aa][Ll][Ss][Ee] ;
TEXT_STRING : '"' .*? '"' ;
WS : [ \t\r]+ -> skip ; // skip spaces, tabs, newlines
COMMENT : '/*' .*? '*/' -> skip ; // multiline comments
COMMENT2:  '//' (~'\n')* -> skip ;	//one line comments

MUL : '*' ; // assigns token name to '*' used above in grammar
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
EQ: '==' ;
NEQ: '!=' ;
GREQ: '>=' ;
LESEQ: '<=' ;
GREAT: '>' ;
LESS: '<' ;
AND: '&' ;
OR: '|' ;
ASSIGN: '=';
MOVE: '>>' ;
INHERIT: ':' ;
ROOM: '@' ;
USEROBJ: '->' ;