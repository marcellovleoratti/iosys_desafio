create table filmes(
id bigint not null auto_increment,
titulo_filme varchar(70) not null,
genero_filme varchar(90) not null,
duracao decimal(2,2) not null,
atores varchar(88) not null,
diretores_filme varchar(90) not null,
observacoes varchar(255) not null,

usuario_nome varchar(150) not null,
usuario_senha varchar(6) not null,
usuario_titulo varchar(56) not null,

primary key(id)
	
);


alter table filmes add constraint fk_Filme_Usuario
foreign key (id) references usuario (id_usuario);

		
	
	