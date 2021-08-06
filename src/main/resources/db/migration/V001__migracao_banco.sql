CREATE TABLE `aeronave` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `referencia` varchar(15) NOT NULL,
  `capacidade` int(5) DEFAULT NULL,
  `codigo_companhia_area` bigint NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `voopro` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `codigo_voo` bigint NOT NULL,
  `codigo_provincia` bigint NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `provincia` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(15) NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `nacionalidade` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `pais` varchar(15) NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `cliente` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) NOT NULL,
  `genero` char(1) NOT NULL,
  `tipo_documento` varchar(25) NOT NULL,
  `numero_documento` varchar(20) NOT NULL,
  `telef` varchar(15) NOT NULL,
  `email` varchar(40) NOT NULL,
  `data_nascimento` date NOT NULL,
  `data_reserva` date NOT NULL,
  `codigo_nacionalidade` bigint NOT NULL,
  `codigo_voo` bigint NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `companhia_aerea` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  `codigo_nacionalidade` bigint NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `usuario`(
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `user` varchar(30) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `codigo_perfil` bigint NOT NULL,
  Primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `perfil`(
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `perfil` varchar(20) NOT NULL,
  Primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `voo` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `hora_partida` time NOT NULL,
  `hora_chegada` time NOT NULL,
  `preco` decimal NOT NULL,
  `codigo_aeronave` bigint NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
ALTER TABLE `aeronave`
  ADD CONSTRAINT `fk_ca_codigo` FOREIGN KEY (`codigo_companhia_area`) REFERENCES `companhia_aerea` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_perfil_codigo` FOREIGN KEY (`codigo_perfil`) REFERENCES `perfil` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_nacionalidade_codigo` FOREIGN KEY (`codigo_nacionalidade`) REFERENCES `nacionalidade` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_voo_codigo1` FOREIGN KEY (`codigo_voo`) REFERENCES `voo` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `voopro`
  ADD CONSTRAINT `fk_provincia_codigo` FOREIGN KEY (`codigo_provincia`) REFERENCES `provincia` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_voo_codigo` FOREIGN KEY (`codigo_voo`) REFERENCES `voo` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `bilhete`
--
 


ALTER TABLE `companhia_aerea` ADD CONSTRAINT `fk_nacionalidade_codigo1` FOREIGN KEY (`codigo_nacionalidade`) REFERENCES `nacionalidade` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;
--
-- Limitadores para a tabela `voo`
--
ALTER TABLE `voo`
  ADD CONSTRAINT `fk_aeronave_codigo` FOREIGN KEY (`codigo_aeronave`) REFERENCES `aeronave` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;


insert into provincia(nome) values ("Maputo"), ("Beira"), ("Chimoio"),("Tete"),("Nampula"), ("Quelimane"), ("Lichinga");

insert into nacionalidade(pais) values ("Mocambique"), ("Mocambique"), ("Africa do Sul"), ("Zimbabwe"), ("Namibia"), ("Etiopia"), ("Nigeria"), ("Gana"), ("Portugal"), ("Inglaterra"), ("EUA"), ("Brasil"), ("India"), ("China"), ("Russia"), ("Polo Norte"), ("Madagascar"), ("Tanzania"), ("Qatar"),("Etiopia");


insert into perfil(perfil) values ("Administrador"), ("Gerente"), ("Funcionario Comum");