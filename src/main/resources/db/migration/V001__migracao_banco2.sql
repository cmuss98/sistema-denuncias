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

CREATE TABLE `paragem` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(30) NOT NULL,
  `codigo_rota` bigint NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `licenca` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `numero` varchar(20) NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `veiculo` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `matricula` varchar(20) NOT NULL,
  `cor` varchar(20) NOT NULL,
  `codigo_licenca` bigint NOT NULL,
  `codigo_rota` bigint NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Morada` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `avenida` varchar(30) NOT NULL,
  `casa` varchar(10) NOT NULL,
  `bairro` varchar(30) NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tipoDocumento` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(20) NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `trabalho`(
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(30) NOT NULL,
  `dirrecao` varchar(20) NOT NULL,
  Primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `funcionario` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `dataNascimento` date NOT NULL,
  `genero` varchar(10) NOT NULL,
  `user` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `codigo_morada` bigint NOT NULL,
  `codigo_trabalho` bigint NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `proprietario` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `dataNascimento` date NOT NULL,
  `genero` varchar(10) NOT NULL,
  `codigo_veiculo` bigint NOT NULL,
  `codigo_morada` bigint NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Documento` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `numero` varchar(20) NOT NULL,
  `dataEmissao` date NOT NULL,
  `dataValidade` date NOT NULL,
  `codigo_tipoDocumento` bigint NOT NULL,
  `codigo_proprietario` bigint NOT NULL,
  `codigo_veiculo` bigint NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Avaliacao` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(10) NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `denuncia` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100)NOT NULL,
  `status` varchar(10) NOT NULL,
  `localizacao` Point DEFAULT NULL,
  `data` date NOT NULL,
  `hora` time NOT NULL,
  `foto` longblob DEFAULT NULL,
  `codigo_veiculo` bigint NOT NULL,
  `codigo_avaliacao` bigint NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `contacto` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(10) NOT NULL,
  `numero` varchar(20) NOT NULL,
  `codigo_proprietario` bigint NOT NULL,
  `codigo_funcionario` bigint NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Reclamacao` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100)NOT NULL,
  `status` varchar(10)NOT NULL,
  `data` date NOT NULL,
  `hora` time NOT NULL,
  `codigo_veiculo` bigint NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



--
-- Limitadores para a tabela `rota`
--
 

ALTER TABLE `rota`
  ADD CONSTRAINT `fk_cor_codigo` FOREIGN KEY (`codigo_cor`) REFERENCES `corBarra` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;


--
-- Limitadores para a tabela `paragem`
--
 

ALTER TABLE `paragem`
  ADD CONSTRAINT `fk_rotap_codigo` FOREIGN KEY (`codigo_rota`) REFERENCES `rota` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `veiculo`
--


ALTER TABLE `veiculo`
  ADD CONSTRAINT `fk_rotav_codigo` FOREIGN KEY (`codigo_rota`) REFERENCES `rota` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `veiculo`
  ADD CONSTRAINT `fk_licenca_codigo` FOREIGN KEY (`codigo_licenca`) REFERENCES `licenca` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `rota_origemDestino`
--


ALTER TABLE `rota_origemDestino`
  ADD CONSTRAINT `fk_rotaod_codigo` FOREIGN KEY (`codigo_rota`) REFERENCES `rota` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `rota_origemDestino`
  ADD CONSTRAINT `fk_origemDestino_codigo` FOREIGN KEY (`codigo_origemDestino`) REFERENCES `origemDestino` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;


--
-- Limitadores para a tabela `denuncia` 
--
 
ALTER TABLE `denuncia` 
  ADD CONSTRAINT `fk_veiculod_codigo` FOREIGN KEY (`codigo_veiculo`) REFERENCES `veiculo` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `denuncia`
  ADD CONSTRAINT `fk_avaliacao_codigo` FOREIGN KEY (`codigo_avaliacao`) REFERENCES `avaliacao` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `funcionario`
--


ALTER TABLE `funcionario`
  ADD CONSTRAINT `fk_moradaf_codigo` FOREIGN KEY (`codigo_morada`) REFERENCES `morada` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `funcionario`
  ADD CONSTRAINT `fk_trabalho_codigo` FOREIGN KEY (`codigo_trabalho`) REFERENCES `trabalho` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `proprietario` 
--
 
ALTER TABLE `proprietario` 
  ADD CONSTRAINT `fk_veiculop_codigo` FOREIGN KEY (`codigo_veiculo`) REFERENCES `veiculo` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `proprietario`
  ADD CONSTRAINT `fk_moradap_codigo` FOREIGN KEY (`codigo_morada`) REFERENCES `morada` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `documento`
--


ALTER TABLE `documento`
  ADD CONSTRAINT `fk_tipoDocumento_codigo` FOREIGN KEY (`codigo_tipoDocumento`) REFERENCES `tipoDocumento` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `documento`
  ADD CONSTRAINT `fk_proprietariod_codigo` FOREIGN KEY (`codigo_proprietario`) REFERENCES `proprietario` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `documento`
  ADD CONSTRAINT `fk_veiculodo_codigo` FOREIGN KEY (`codigo_veiculo`) REFERENCES `veiculo` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;



--
-- Limitadores para a tabela `contacto` 
--
 
ALTER TABLE `contacto` 
  ADD CONSTRAINT `fk_proprietario_codigo` FOREIGN KEY (`codigo_proprietario`) REFERENCES `proprietario` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `contacto`
  ADD CONSTRAINT `fk_funcionario_codigo` FOREIGN KEY (`codigo_funcionario`) REFERENCES `funcionario` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;


--
-- Limitadores para a tabela `reclamacao` 
--
 
ALTER TABLE `reclamacao` 
   ADD CONSTRAINT `fk_veiculor_codigo` FOREIGN KEY (`codigo_veiculo`) REFERENCES `veiculo` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;



