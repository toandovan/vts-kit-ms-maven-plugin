grammar JDL;

program: (entity_declaration|relationship |dto_declaration)* EOF;

// api_declaration: API ;
entity_declaration : ENTITY ID table_name? entity_body?; 
table_name: LSB ID RSB;
entity_body: LP entity_field* RP;
entity_field: ID type entity_validate* SEMI;
entity_validate: REQUIRE | UNIQUE;

//relationship
relationship: RELATIONSHIP relation_type LP relationsip_list+ RP;
relationsip_list:relation_ele 'to' relation_ele SEMI;
relation_ele: ID relation_ele_body?;
relation_ele_body: LP ID display_field? REQUIRE? RP;
display_field: LB ID RB;
//DTO
dto_declaration : DTO dto_list;
dto_list: ID LSB dto_field* RSB;// DTO Test[ ABC String require, XYZ String require]
dto_field: ID type REQUIRE? SEMI;

type: STRING | FLOAT | DOUBLE | LONG | INTERGER;
//Type:
STRING: 'String';
FLOAT: 'Float';
DOUBLE: 'Double';
LONG: 'Long';
INTERGER: 'Interger';

//(OneToMany | ManyToOne | OneToOne | ManyToMany)
ONETOONE: 'OneToOne';
ONETOMANY: 'OneToMany';
MANYTOONE: 'ManyToOne';
MANYTOMANY: 'ManyToMany';

relation_type: ONETOMANY | ONETOONE | MANYTOMANY |MANYTOONE ;

//keywords
ENTITY: 'ENTITY';
API: 'API';
DTO: 'DTO';
RELATIONSHIP: 'RELATIONSHIP';

REQUIRE: 'require';
UNIQUE: 'unique';

//comment
BLOCK_CMT:'/*' .*? '*/'-> skip;
LINE_CMT:'//'~[\r\n\f]*->skip;



// fragment ESC:'\\' [bfrnt"\\];
// fragment CHARACTER: ~[\b\f\r\n\t"\\]| ESC;

// //separators
LB: '(' ;
RB: ')' ;
LP: '{';
RP: '}';
SEMI: ';' ;
LSB:'[';
RSB:']';
COMMA:',';

//identifiers
ID: [_a-zA-Z][_a-zA-Z0-9]*;

//whitespace
WS : [ \t\r\n]+ -> channel(HIDDEN);// skip spaces, tabs, newlines




