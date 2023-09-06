create table imoveis (
    id bigint not null auto_increment,
    nome varchar(100) not null,
    valor double not null,
    descricao text,
    cidade varchar(100) not null,
    uf char(2) not null,
    logradouro varchar(100) not null,
    numero varchar(20) not null,
    quartos int,
    suites int,
    garagem bool,
    banheiros int,

    primary key(id)
);