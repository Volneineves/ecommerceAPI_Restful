CREATE DATABASE ecommerce_api_grupo7;

CREATE table endereco
(
	endereco_id serial not null primary key,
	cep CHAR(8),
	rua VARCHAR(100),
	bairro VARCHAR(30),
	cidade VARCHAR(30),
	numero VARCHAR(10),
	complemento VARCHAR(100),
	UF CHAR(2)
);

create table cliente
(
	cliente_id SERIAL not null primary key,
	email CHAR(35),
	username VARCHAR(15),
	senha VARCHAR(20),
	nome VARCHAR(200),
	cpf CHAR(11) not null unique,
	telefone VARCHAR(11),
	data_nascimento DATE
);

create table pedido
(
	pedido_id SERIAL not null primary key,
	numero_pedido INT,
	lista_produtos_do_pedido varchar(200),
	valor_total_pedido MONEY,
	data_pedido DATE not null default now(),
	status boolean
);

create table produto_pedido
(
	produto_pedido_id SERIAL not null primary key,
	qtd_produto_pedido INT,
	preco_produto_pedido MONEY
);

create table produto
(
	produto_id SERIAL not null primary key,
	nome_produto VARCHAR(50),
	descricao_produto VARCHAR(200),
	preco_produto MONEY,
	qtd_estoque INT,
	data_cadastro_produto DATE,
	imagem BYTEA
);

create table categoria 
(
	categoria_id SERIAL not null primary key,
	nome_categoria VARCHAR(20),
	descricao_categoria VARCHAR(200)
);

--Adição de chaves estrangeiras:

alter table cliente add endereco_id INT not null references 
endereco (endereco_id);

alter table pedido add cliente_id INT not null references 
cliente (cliente_id);

alter table produto_pedido add produto_id INT not null references 
produto (produto_id);

alter table produto_pedido add pedido_id INT not null references 
pedido (pedido_id);

alter table produto add categoria_id INT not null references 
categoria (categoria_id);

--Alterações 
alter table produto drop column imagem;
alter table produto add imagem VARCHAR;

alter table pedido drop column lista_produtos_do_pedido;