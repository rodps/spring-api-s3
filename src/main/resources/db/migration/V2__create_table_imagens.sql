create table imagens (
    id bigint not null auto_increment,
    nome varchar(100) not null,
    imovel_id bigint not null,

    primary key(id),
    foreign key(imovel_id) references imoveis(id)
);