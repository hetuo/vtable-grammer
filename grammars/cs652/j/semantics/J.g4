grammar J;

@header {
    import cs652.j.semantics.*;
    import org.antlr.symtab.*;
}

file    returns [GlobalScope scope]
    :   classDeclaration* main EOF
    ;

classDeclaration    returns [Scope scope]
    :   'class' Identifier ('extends' typeType)? classBody
    ;

typeType
    :   Identifier | 'int' | 'fload' | 'void'
    ;

classBody
    :   '{' classBodyDeclaration* '}'
    ;

classBodyDeclaration
    :   ';'
    |   memberDeclaration
    ;

memberDeclaration
    :   methodDeclaration
    |   fieldDeclaration
    ;

fieldDeclaration
    :   typeType Identifier ';'
    ;

methodDeclaration   returns [Scope scope]
    :   typeType Identifier formalParameters
        (   methodBody
        |   ';'
        )
    ;

formalParameters
    :   '(' formalParameterList? ')'
    ;

formalParameterList
    :   formalParameter (',' formalParameter)*
    ;

formalParameter
    :   typeType Identifier
    ;

methodBody
    :   block
    ;

block   returns [Scope scope]
    :   '{' blockStatement* '}'
    ;

blockStatement
    :   localVariableDeclarationStatement
    |   statement
    ;

localVariableDeclarationStatement
    :    localVariableDeclaration ';'
    ;

localVariableDeclaration
    :    typeType Identifier
    ;

statement
    :   block
    |   'if' parExpression statement ('else' statement)?
    |   'while' parExpression statement
    |   'return' expression? ';'
    |   ';'
    |   statementExpression ';'
    ;

// EXPRESSIONS

parExpression
    :   '(' expression ')'
    ;

expressionList
    :   expression (',' expression)*
    ;

statementExpression
    :   expression
    ;

expression  returns [Type type]
    :   primary
    |   expression '.' Identifier ('(' ')')?
    |   'new' creator
    |   expression '(' expressionList ')'
    |   <assoc=right> expression
        (   '='
        )
        expression
    ;

primary
    :   '(' expression ')'
    |   'this'
    |   literal
    |   Identifier ('(' ')')?
    ;
literal
    :   IntegerLiteral
    |   FloatingPointLiteral
    |   StringLiteral
    |   'null'
    ;

creator
    :   typeType '(' ')';

main
    :   blockStatement*;

StringLiteral : '"' StringCharacters? '"';

fragment
StringCharacters : StringCharacter+;
fragment
StringCharacter: ~["\\] | '\\';

IntegerLiteral
    :   '-'? [0-9] [0-9]*
    ;

FloatingPointLiteral
        :   [0-9] [0-9]* '.' ([0-9] [0-9]*)?
        |   '.' [0-9] [0-9]*
    ;

Identifier
    :   [a-zA-Z_] [a-zA-Z_0-9]*
    ;

STRING : '"' (~'"'|'\\"')* '"';

WS  :  [ \t\r\n\u000C]+ -> skip
    ;
LINE_COMMENT
    :   '//' ~[\r\n]* -> channel(HIDDEN);

COMMENT : '/*' .*? '*/' -> channel(HIDDEN);

