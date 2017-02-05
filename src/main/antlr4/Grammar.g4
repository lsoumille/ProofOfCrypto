grammar Grammar;

WS : ([ \t\r\n]+) -> skip ; // skip spaces, tabs, newlines

program : c(';' c)*;

c : VAR ':=' expr
    | VAR ':=' probFun
    | ifInst
    | whileInst
    | /* Epsilon*/
    ;
ifInst : 'if (' expr ') then {'program'} else {'program'}'
    ;
whileInst : 'while (' expr ') do {'program'}'
    ;

expr : CONST exprBis
      | VAR exprBis
      ;
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
    | '>'
    | '>='
    | '<='
    | '%'
    | '^'
    ;

probFun : ensemble
        | zq
        | powerEnsemble
        | countones
        ;
powerEnsemble : '{' CONST (',' CONST)* '}' CONST
              ;
ensemble : '{' CONST (',' CONST)* '}'
         ;
zq : 'Z (' CONST ')'
   ;
countones : 'countones(' VAR ')'
          ;
