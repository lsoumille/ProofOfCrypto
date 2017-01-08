grammar Grammar;
//program : (c)+ ;
//shapeDefinition : sphereDefinition | cubeDefinition ;
//sphereDefinition : SPHERE_KEYWORD coordinates ;
//cubeDefinition : CUBE_KEYWORD coordinates ;
//coordinates : NUMBER NUMBER NUMBER ;
//SPHERE_KEYWORD : 'sphere' ;
//CUBE_KEYWORD : 'cube' ;
//NUMBER : [1-9]+ ;
WS : ([ \t\r\n]+) -> skip ; // skip spaces, tabs, newlines

program : c(';' c)*;
//p : E OP E ;
//E : [1-9]+ ;
//OP : [*+-/] ;

c : VAR ':=' expr
    | VAR ':=' probFun
    | 'if (' expr ') then {'program'} else {'program'}'
    | 'while (' expr ') do {'program'}'
    | /* Epsilon*/
    ;
expr : CONST exprBis
      | VAR exprBis ;
exprBis : OP expr exprBis
      | /*Epsilon*/
      ;
VAR : [a-zA-Z ]+ ;
CONST : [0-9 ]+ ;
OP : '+'
    | '-'
    | '*'
    | '/'
    | '='
    | '<'
    | '>' ;
probFun :'{' CONST (',' CONST)* '}'
         | 'Z (' CONST ')'
         ;
