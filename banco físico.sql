DROP DATABASE IF EXISTS centro_de_distribuicao;
CREATE DATABASE centro_de_distribuicao;
use centro_de_distribuicao;

CREATE TABLE tb_cliente (
	codigo_cliente integer not null AUTO_INCREMENT primary key UNIQUE,
	nome_cliente varchar(60) not null,
	email varchar(50) not null UNIQUE,
	cep char(8) not null,
	logradouro varchar(50) not null,
	numero varchar(8) not null,
	bairro varchar(40) not null,
	cidade varchar(40) not null,
	uf char(2) not null,
	cpf char(11),
	cnpj char(14),
	tipo_cliente char(2) not null,
	CONSTRAINT CHK_tipo_cliente CHECK (tipo_cliente = 'PF' or tipo_cliente ='PJ')
);

CREATE TABLE tb_telefone_cliente (
	telefone_cliente varchar(14) not null unique,
	codigo_cliente integer not null,
	constraint fk_cliente_telefone foreign key (codigo_cliente) references tb_cliente(codigo_cliente),
	constraint pk_tb_telefone_cliente primary key (telefone_cliente, codigo_cliente)
);

CREATE TABLE tb_fornecedor (
	codigo_fornecedor integer not null AUTO_INCREMENT primary key UNIQUE,
	nome varchar(60) not null,
	cep char(8) not null,
	logradouro varchar(50) not null,
	numero varchar(8) not null,
	bairro varchar(40) not null,
	cidade varchar(40) not null,
	uf  char(2) not null
);

CREATE TABLE tb_telefone_fornecedor (
	telefone_fornecedor varchar(14) not null UNIQUE,
	codigo_fornecedor integer not null,
	constraint fk_fornecedor_telefone foreign key (codigo_fornecedor) references tb_fornecedor(codigo_fornecedor),
	constraint pk_tb_telefone_fornecedor primary key (telefone_fornecedor, codigo_fornecedor)
);

CREATE TABLE tb_funcionario (
	matricula integer not null AUTO_INCREMENT primary key UNIQUE,
	nome_funcionario varchar(60) not null,
	email varchar(50) not null UNIQUE,
	rg char(7) not null UNIQUE,
	cpf char(11) not null UNIQUE,
	senha varchar(40) not null,
	cep char(8) not null,
	logradouro varchar(50) not null,
	numero varchar(8) not null,
	bairro varchar(40) not null,
	cidade varchar(40) not null,
	uf char(2) not null
);

CREATE TABLE tb_telefone_funcionario (
	telefone_funcionario varchar(14) not null UNIQUE,
	matricula integer not null,
	constraint fk_funcionario_telefone foreign key (matricula) references tb_funcionario(matricula),
	constraint pk_tb_telefone_funcionario primary key (telefone_funcionario, matricula)
);

CREATE TABLE tb_produto (
	codigo_produto integer not null AUTO_INCREMENT primary key UNIQUE,
	nome varchar(60) not null,
	descricao varchar(300) not null,
	quantidade integer not null,
	data_entrada date not null,
	matricula integer not null,
	codigo_fornecedor integer not null,
	constraint fk_funcionario_produto foreign key (matricula) references tb_funcionario(matricula),
	constraint fk_fornecedor_produto foreign key (codigo_fornecedor) references tb_fornecedor(codigo_fornecedor),
	CONSTRAINT CHK_quantidade CHECK (quantidade >= 0)
);

CREATE TABLE tb_pedido (
	codigo_pedido integer not null AUTO_INCREMENT primary key UNIQUE,
	codigo_cliente integer not null,
	constraint fk_cliente_pedido foreign key (codigo_cliente) references tb_cliente(codigo_cliente)
);

CREATE TABLE  tb_pedido_produto (
	codigo_pedido integer not null,
	codigo_produto integer not null,
	matricula integer not null,
	quantidade int not null,
	data_saida date not null,
	constraint fk_pedido_pedido_produto foreign key (codigo_pedido) references tb_pedido(codigo_pedido),
	constraint fk_produto_pedido_produto foreign key (codigo_produto) references tb_produto(codigo_produto),
	constraint pk_tb_pedido_produto primary key (codigo_pedido, codigo_produto),
	constraint CHK_quantidade_item CHECK (quantidade > 0)
);

/*Inserindo dados na tabela tb_cliente*/
INSERT INTO tb_cliente (nome_cliente, email, cep, logradouro, numero, bairro, cidade, uf, cpf, cnpj, tipo_cliente) VALUES ('Isaac Rodrigues Ferreira', 'isaacrf@gmail.com', '04546001', 'RUA CASA DO ATOR', '275', 'VILA OLÍMPIA', 'SÃO PAULO', 'SP','89087643289',null,'PF');
INSERT INTO tb_cliente (nome_cliente, email, cep, logradouro, numero, bairro, cidade, uf, cpf, cnpj, tipo_cliente) VALUES ('Accenture', 'accenture@gmail.com', '50030230', 'Edifício Vasco Rodrigues Rua Cais Do Apolo', '222', 'Recife Antigo', 'RECIFE', 'PE', null, '96534094002797', 'PJ');
INSERT INTO tb_cliente (nome_cliente, email, cep, logradouro, numero, bairro, cidade, uf, cpf, cnpj, tipo_cliente) VALUES ('Avanade', 'avanade@gmail.com', '50030220', 'Rua, Cais do Apolo', '222', 'Recife', 'RECIFE', 'PE', null, '4049976000100', 'PJ');
INSERT INTO tb_cliente (nome_cliente, email, cep, logradouro, numero, bairro, cidade, uf, cpf, cnpj, tipo_cliente) VALUES ('Pietro Martins da Silva Gomes', 'pietromsg@gmail.com', '04576020', 'RUA GEORGE HOM', '230', 'BROOKLIN NOVO', 'SÃO PAULO', 'SP', '45398763521', null, 'PF');
INSERT INTO tb_cliente (nome_cliente, email, cep, logradouro, numero, bairro, cidade, uf, cpf, cnpj, tipo_cliente) VALUES ('Helena Kettelin Dias Porto De Oliveira','helenakdpo@gmail.com', '13420640', 'AVENIDA ANTONIA PAZZINATO STURION', '1221', 'JD PETROPOLIS- PIRACICABA', 'SÃO PAULO', 'SP', '78954389787', null, 'PF');

/*Inserindo dados na tabela tb_telefone_cliente*/
INSERT INTO tb_telefone_cliente (telefone_cliente, codigo_cliente) VALUES ('+5511987965467',1);
INSERT INTO tb_telefone_cliente (telefone_cliente, codigo_cliente) VALUES ('8121236733',2);
INSERT INTO tb_telefone_cliente (telefone_cliente, codigo_cliente) VALUES ('8121222234',3);
INSERT INTO tb_telefone_cliente (telefone_cliente, codigo_cliente) VALUES ('+5511998765843',4);
INSERT INTO tb_telefone_cliente (telefone_cliente, codigo_cliente) VALUES ('+5511998765678',5);

/*Inserindo dados na tabela tb_fornecedor*/
INSERT INTO tb_fornecedor (nome, cep, logradouro, numero, bairro, cidade, uf) VALUES ('Celite', '50950000', 'Rua João Lopes', '10', 'Curado', 'Recife', 'PE');
INSERT INTO tb_fornecedor (nome, cep, logradouro, numero, bairro, cidade, uf) VALUES ('Eternit', '53635745', 'R. Alameda dos Cravos', '20', 'Cruz de Rebouças', 'Igarassu', 'PE');
INSERT INTO tb_fornecedor (nome, cep, logradouro, numero, bairro, cidade, uf) VALUES ('Deca', '51180020', 'Rua Madrid', '190', 'Imbiribeira', 'Recife', 'PE');
INSERT INTO tb_fornecedor (nome, cep, logradouro, numero, bairro, cidade, uf) VALUES ('Pial', '54340320', 'Rodovia Antiga', '2141', 'Prazeres', 'Jaboatão dos Guararapes', 'PE');
INSERT INTO tb_fornecedor (nome, cep, logradouro, numero, bairro, cidade, uf) VALUES ('Botafogo', '22290040', 'Av. Venceslau Brás', '72', 'Botafogo', 'Rio de Janeiro', 'RJ');

/*Inserindo dados na tabela tb_telefone_fornecedor*/
INSERT INTO tb_telefone_fornecedor (telefone_fornecedor, codigo_fornecedor) VALUES ('8134568790', 1);
INSERT INTO tb_telefone_fornecedor (telefone_fornecedor, codigo_fornecedor) VALUES ('8132256778', 2);
INSERT INTO tb_telefone_fornecedor (telefone_fornecedor, codigo_fornecedor) VALUES ('8121223285', 3);
INSERT INTO tb_telefone_fornecedor (telefone_fornecedor, codigo_fornecedor) VALUES ('8132222732', 4);
INSERT INTO tb_telefone_fornecedor (telefone_fornecedor, codigo_fornecedor) VALUES ('2122348531', 5);

/*Inserindo dados na tabela tb_funcionario*/
INSERT INTO tb_funcionario (nome_funcionario, email, rg, cpf, senha, cep, logradouro, numero, bairro, cidade, uf) VALUES ('Marianna Martins da Silva Gomes', 'mariannamsg@gmail.com', '8796443', '87694488876', 'mari123', '04546001' , 'RUA CASA DO ATOR', '294', 'VILA OLÍMPIA', 'SÃO PAULO', 'SP');
INSERT INTO tb_funcionario (nome_funcionario, email, rg, cpf, senha, cep, logradouro, numero, bairro, cidade, uf) VALUES ('Adam Vitor Dias Porto De Oliveira', 'adamvdpo@gmail.com', '1234879', '01293883392', 'adam123', '01333010', 'RUA CINCINATO BRAGA', '306', 'VILA MARIANA', 'SÃO PAULO', 'SP');
INSERT INTO tb_funcionario (nome_funcionario, email, rg, cpf, senha, cep, logradouro, numero, bairro, cidade, uf) VALUES ('Melissa da Fonseca Diniz', 'melissafd@gmail.com', '9328732', '98724787324', 'melissa123','04532082' , 'RUA JESUINO ARRUDA', '676', 'ITAIM BIBI ', 'SÃO PAULO', 'SP');
INSERT INTO tb_funcionario (nome_funcionario, email, rg, cpf, senha, cep, logradouro, numero, bairro, cidade, uf) VALUES ('Calebe Mendes de Oliveira', 'calebemo@gmail.com', '2138943', '23239108213', 'calebe123', '04544000', 'RUA DR ALCEU DE CAMPOS RODRIGUES', '213', 'ITAIM BIBI', 'SÃO PAULO', 'SP');
INSERT INTO tb_funcionario (nome_funcionario, email, rg, cpf, senha, cep, logradouro, numero, bairro, cidade, uf) VALUES ('Isabelly Victoria de Carvalho Moreira', 'isabellyvcm@gmail.com', '9833242', '21332098213', 'isabelly123','04571090' , 'RUA SANSÃO ALVES DOS SANTOS', '373', 'BROOKLIN', 'SÃO PAULO', 'SP');

/*Inserindo dados na tabela tb_telefone_funcionario*/
INSERT INTO tb_telefone_funcionario (telefone_funcionario, matricula) VALUES ('+5511998343434' , 1);
INSERT INTO tb_telefone_funcionario (telefone_funcionario, matricula) VALUES ('+5511983247923' , 2);
INSERT INTO tb_telefone_funcionario (telefone_funcionario, matricula) VALUES ('+5511949823749' , 3);
INSERT INTO tb_telefone_funcionario (telefone_funcionario, matricula) VALUES ('+5511934892723' , 4);
INSERT INTO tb_telefone_funcionario (telefone_funcionario, matricula) VALUES ('+5511998743298' , 5);

/*Inserindo dados na tabela tb_produto*/
INSERT INTO tb_produto (nome, descricao, quantidade, data_entrada, matricula, codigo_fornecedor) VALUES ('Vaso Sanitário Celite', 'Vaso Sanitário com Caixa Acoplada 3/6L Saída Vertical Eco Plus Branco Celite',10,'2020-03-26', 2, 1);
INSERT INTO tb_produto (nome, descricao, quantidade, data_entrada, matricula, codigo_fornecedor) VALUES ('Telha de Fibrocimento', 'Telha de Fibrocimento Vogatex 4mm 50x244cm',10,'2020-03-26', 2, 2);
INSERT INTO tb_produto (nome, descricao, quantidade, data_entrada, matricula, codigo_fornecedor) VALUES ('Vaso Sanitário Deca', 'Vaso Sanitário Convencional Saída Vertical Monte Carlo Gelo Deca',10,'2020-03-26', 2, 3);
INSERT INTO tb_produto (nome, descricao, quantidade, data_entrada, matricula, codigo_fornecedor) VALUES ('Interruptor Pial', 'Conjunto de Interruptor Simples 10A Branco Pial Plus Pial Legrand',10,'2020-03-26', 2, 4);
INSERT INTO tb_produto (nome, descricao, quantidade, data_entrada, matricula, codigo_fornecedor) VALUES ('Escada Botafogo', 'Banco Escada em Alumínio 3 Degraus Prata',10,'2020-03-26', 2, 5);

/*Inserindo dados na tabela tb_pedido*/
INSERT INTO tb_pedido (codigo_cliente) VALUES (2);
INSERT INTO tb_pedido (codigo_cliente) VALUES (2);
INSERT INTO tb_pedido (codigo_cliente) VALUES (1);
INSERT INTO tb_pedido (codigo_cliente) VALUES (3);
INSERT INTO tb_pedido (codigo_cliente) VALUES (5);

/*Inserindo dados na tabela tb_pedido_produto*/
INSERT INTO tb_pedido_produto (codigo_pedido, codigo_produto, matricula, quantidade, data_saida) VALUES (1, 1, 4, 1, '2020-03-31');
INSERT INTO tb_pedido_produto (codigo_pedido, codigo_produto, matricula, quantidade, data_saida) VALUES (2, 3, 3, 1, '2020-05-07');
INSERT INTO tb_pedido_produto (codigo_pedido, codigo_produto, matricula, quantidade, data_saida) VALUES (3, 4, 2, 5, '2020-03-27');
INSERT INTO tb_pedido_produto (codigo_pedido, codigo_produto, matricula, quantidade, data_saida) VALUES (4, 5, 5, 1, '2020-04-06');
INSERT INTO tb_pedido_produto (codigo_pedido, codigo_produto, matricula, quantidade, data_saida) VALUES (5, 5, 5, 1, '2020-04-16');