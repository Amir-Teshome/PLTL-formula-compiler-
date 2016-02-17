lexer grammar LexerGrammar;

PREVIOUS: [Y];        		// match a formula of Y
SINCE :   [S];
EPAST :   [P];
GPAST :   [H];
ELEMENT : [E];
EQU: 	'EQ';
NOT:	'NOT';
AND:	'AND';
OR:	'OR';
EXIST:  'EXIST';
ALL:    'ALL';
IN :    'IN';

FLOW :    [>];				// match flow oprator
IFLOW :   '>>';		
ID  :   [a-zA-Z]+ ;          // match identifiers
INT :   [0-9]+ ;        	 // match integers
NEWLINE:'\r'? '\n' ;   		 // return newlines to parser (end-statement signal)
WS  :   [ \t]+ -> skip ; 	 // toss out whitespace
