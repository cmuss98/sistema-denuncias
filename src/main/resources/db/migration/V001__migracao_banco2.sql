CREATE TABLE `corBarra` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `cor` varchar(20) NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `OrigemDestino` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(30) NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `rota` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `via` varchar(30) NOT NULL,
  `codigo_cor` bigint NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `rota_OrigemDestino` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `codigo_rota` bigint NOT NULL,
  `codigo_origemDestino` bigint NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tipoDocumento` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(20) NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Documento` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `numero` varchar(20) NOT NULL,
  `dataEmissao` date NOT NULL,
  `dataValidade` date NOT NULL,
  `codigo_tipoDocumento` bigint NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `dirrecao`(
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(30) NOT NULL,
  Primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `trabalho`(
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(30) NOT NULL,
  `codigo_dirrecao` bigint NOT NULL,
  Primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `usuario`(
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `user` varchar(20) NOT NULL,
  `password` varchar(15) NOT NULL,
  Primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `funcionario` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `dataNascimento` date NOT NULL,
  `genero` varchar(10) NOT NULL,
  `avenida` varchar(30) NOT NULL,
  `casa` varchar(10) NOT NULL,
  `bairro` varchar(30) NOT NULL,
  `contacto` varchar(20) NOT NULL,
  `codigo_usuario` bigint NOT NULL,
  `codigo_trabalho` bigint NOT NULL,
  `codigo_documento` bigint NOT NULL,
  `codigo_rota` bigint DEFAULT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ocorrencia` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `tipo` varchar(15)NOT NULL,
  `descricao` varchar(100)NOT NULL,
  `status` varchar(10) NOT NULL,
  `localizacao` Point DEFAULT NULL,
  `data` date NOT NULL,
  `hora` time NOT NULL,
  `foto` longblob DEFAULT NULL,
  `matricula` varchar(10) NOT NULL,
  `codigo_rota` bigint NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Limitadores para a tabela `rota`
--
 

ALTER TABLE `rota`
  ADD CONSTRAINT `fk_cor_codigo` FOREIGN KEY (`codigo_cor`) REFERENCES `corBarra` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;


--
-- Limitadores para a tabela `rota_origemDestino`
--


ALTER TABLE `rota_origemDestino`
  ADD CONSTRAINT `fk_rotaod_codigo` FOREIGN KEY (`codigo_rota`) REFERENCES `rota` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `rota_origemDestino`
  ADD CONSTRAINT `fk_origemDestinor_codigo` FOREIGN KEY (`codigo_origemDestino`) REFERENCES `origemDestino` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;


--
-- Limitadores para a tabela `denuncia` 
--
 
ALTER TABLE `ocorrencia`
  ADD CONSTRAINT `fk_rotad_codigo` FOREIGN KEY (`codigo_rota`) REFERENCES `rota` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `funcionario`
--


ALTER TABLE `funcionario`
  ADD CONSTRAINT `fk_usuariof_codigo` FOREIGN KEY (`codigo_usuario`) REFERENCES `usuario` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `funcionario`
  ADD CONSTRAINT `fk_trabalho_codigo` FOREIGN KEY (`codigo_trabalho`) REFERENCES `trabalho` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `funcionario`
	ADD CONSTRAINT `fk_documentof_codigo` FOREIGN KEY (`codigo_documento`) REFERENCES `documento` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;
 ALTER TABLE `funcionario`
	ADD CONSTRAINT `fk_rotaf_codigo` FOREIGN KEY (`codigo_rota`) REFERENCES `rota` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;
  

--
-- Limitadores para a tabela `documento`
--


ALTER TABLE `documento`
  ADD CONSTRAINT `fk_tipoDocumento_codigo` FOREIGN KEY (`codigo_tipoDocumento`) REFERENCES `tipoDocumento` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `trabalho` 
--
 
ALTER TABLE `trabalho`
  ADD CONSTRAINT `fk_dirrecaor_codigo` FOREIGN KEY (`codigo_dirrecao`) REFERENCES `dirrecao` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;


