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

fieldDeclaration returns [Type type]
    :   typeType Identifier ';'
    ;

methodDeclaration   returns [Scope scope, Type tyep]
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

formalParameter returns [Type type]
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

localVariableDeclaration returns[Type type]
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
    |
    ;

statementExpression
    :   expression
    ;

expression  returns [Type type, int flag]
    :   ind   #IndRef
    |   expression '.' expression  #DotRef
    |   'new' creator   #CreatorRef
    |   expression '(' expressionList  ')' #FuncRef
    |   <assoc=right> expression
        (   '='
        )
        expression  #AssignRef
    |   literal #LiteralRef
    ;

ind returns [int flag]: Identifier;

literal
    :   IntegerLiteral
    |   FloatingPointLiteral
    |   StringLiteral
    |   'null'
    ;

creator returns [Type type]
    :   typeType '(' ')';

main returns [Scope scope]
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

