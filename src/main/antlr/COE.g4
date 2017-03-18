grammar COE;

//Parser rules

s : nl? class_def nl? EOF	#classDef
	| nl? code nl? EOF		#sCode
	| nl? EOF				#empty
	;

class_def : SYMBOL ( INHERIT SYMBOL )? nl? '{' nl? fields? methods? '}' ;

fields : (field_decl nl)+ ;

field_decl : (tags nl?)? STATICKEY? data_type SYMBOL (ASSIGN operation)? ;

var_decl : data_type SYMBOL (ASSIGN operation)? ;

methods : (method nl?)+ ;

method : (tags nl?)? ( data_type SYMBOL ASSIGN )? metname=SYMBOL '(' args? ')' nl? '{' nl? code? nl? '}' ;

args : data_type SYMBOL ( ',' data_type SYMBOL )* ;

code : line (nl line)* ;

line : exp_if
	| exp_for
	| exp_user
	| exp_throw
	| echo
	| operation
	| var_decl
	;

function_call : SYMBOL '(' (operation (',' operation)*)? ')' ;

tags : '<' SYMBOL '>';

operation : operation '.' INVENTORY							#someContents
	| room '.' INVENTORY									#roomContents
	| function_call											#functionOp
	| operation '.' SYMBOL '(' (operation (',' operation)*)? ')' #methodOp
	| operation '.' SYMBOL									#intermediateVariable
	| operation '.' ROOM									#location
	| operation '.' '$'										#getUser
	| operation '.' '#'										#getId
	| operation '.' ROOM									#getLoc
	| operation INSTANCEOFSYMBOL SYMBOL						#instanceofOp
	| NOT operation											#notOp
	| '-' operation											#negative
	| D operation											#dice
	| operation D operation									#multDice
	| operation op=(MUL|DIV) operation						#MulDiv
	| operation op=(ADD|SUB) operation						#AddSub
	| operation op=(NEQ|EQ|GREQ|LESEQ|LESS|GREAT) operation	#compare
	| operation op=(OR|AND) operation						#logic
	| operation CONCAT operation							#concat
	| operation ASSIGN operation							#assign
	| operation MOVE operation								#move
	| SYMBOL												#variable
	| NULLOBJ												#nullObj
	| operation '[' operation ']'							#index
	| new_obj												#newObj
	| INT_NUMBER											#int
	| FLOAT_NUMBER											#float
	| bool												    #boolean
	| TEXT_STRING											#string
	| sharp_identifier										#sharp
	| room													#roomOp
	| parens												#parensOp
	| '{' (operation (',' operation)*)? '}'					#list
	;

parens : '(' operation ')' ;

new_obj : 'new' SYMBOL '(' (operation (',' operation)*)? ')' ;

sharp_identifier : '#' INT_NUMBER ;

room : ROOM room_path										#someRoom
	| ROOM													#thisRoom
	;

region : SYMBOL
	| '.'
	| '..'
	;

room_path : region											#relativeRoom
	| '/' region											#rootRoom
	| room_path '/' region									#leafRoom
	;

exp_if : IF '(' operation ')' nl? '{' nl? code? nl? '}' exp_else?
	| IF '(' operation ')' nl?  nl? line? nl? exp_else? ;

exp_else : nl? ELSE nl? '{' nl? code? nl? '}'
	| nl? ELSE nl? nl? line? nl?  ;

exp_for : FOR '(' SYMBOL ':' operation ')' nl? '{'  nl? code? nl? '}'
	| FOR '(' SYMBOL ':' operation ')' nl?  nl? line nl? ;

exp_user : USERNAME USEROBJ operation ;

exp_throw : THROWKEY operation ;

echo : ECHO operation ;

data_type : INT_TYPE										#intType
	| FLOAT_TYPE											#floatType
	| STRING_TYPE											#stringType
	| SYMBOL												#symbolType
	| ROOM													#roomType
	| INVENTORY												#inventoryType
	| data_type '[]'										#listType
	;

bool : v=(TRUE | FALSE) ;

nl : '\n'+;

//Lexer rules

D : [Dd] ;
IF: [Ii][Ff] ;
ELSE: [Ee][Ll][Ss][Ee] ;
FOR: [Ff][Oo][Rr] ;

ECHO: '!' ;

INT_TYPE: [Ii][Nn][Tt] ;
FLOAT_TYPE: [Ff][Ll][Oo][Aa][Tt] ;
STRING_TYPE: [Ss][Tt][Rr] ;
TRUE: [Tt][Rr][Uu][Ee] ;
FALSE: [Ff][Aa][Ll][Ss][Ee] ;
NOT: [Nn][Oo][Tt] ;
INSTANCEOFSYMBOL : [Ii][Nn][Ss][Tt][Aa][Nn][Cc][Ee][Oo][Ff] ;
NULLOBJ : [Nn][Uu][Ll][Ll] ;
THROWKEY : [Tt][Hh][Rr][Oo][Ww];
STATICKEY : [Ss][Tt][Aa][Tt][Ii][Cc];


SYMBOL : ([dD][a-zA-Z_]|[a-cA-Ce-zE-Z_])[a-zA-Z0-9_]* ;
USERNAME : '$'[a-zA-Z0-9_]+ ;
INT_NUMBER: [0-9]+;
FLOAT_NUMBER : [0-9]+'.'[0-9]+ ;
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
INVENTORY: '%' ;
CONCAT: '++' ;