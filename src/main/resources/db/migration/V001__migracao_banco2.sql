CREATE TABLE `cores_barra` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `cor` varchar(20) NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `rota` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `origem` varchar(30) NOT NULL,
  `destino` varchar(30) NOT NULL,
  `via` varchar(30) NOT NULL,
  `codigo_cor` bigint NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `veiculo` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `matricula` varchar(20) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `tipo_doc` varchar(20) NOT NULL,
  `nr_doc` varchar(25) NOT NULL,
  `telefone1` int(15) NOT NULL,
  `telefone2` int(15) DEFAULT NULL,
  `bairro` varchar(30) NOT NULL,
  `avenida` varchar(30) NOT NULL,
  `quarteirao` int(3) NOT NULL,
  `nr_casa` int(3) NOT NULL,
  `codigo_rota` bigint NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `denuncia` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `pontoReferencia` varchar(20) NOT NULL,
  `descricao` varchar(100)NOT NULL,
  `status` varchar(10) NOT NULL,
  `foto` longblob DEFAULT NULL,
  `codigo_vei` bigint NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `usuario`(
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `user` varchar(30) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `perfil` varchar(20) NOT NULL,
  Primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Limitadores para a tabela `rota`
--
 

ALTER TABLE `rota`
  ADD CONSTRAINT `fk_cor_codigo` FOREIGN KEY (`codigo_cor`) REFERENCES `cores_barra` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `veiculo`
--

ALTER TABLE `veiculo`
  ADD CONSTRAINT `fk_rota_codigo` FOREIGN KEY (`codigo_rota`) REFERENCES `rota` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `denuncia` 
--
 
ALTER TABLE `denuncia` 
  ADD CONSTRAINT `fk_vei_codigo` FOREIGN KEY (`codigo_vei`) REFERENCES `veiculo` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;


insert into cores_barra (cor) values ("Amarelo"), ("Vermelho"), ("Rosa"), ("Azul"), ("Verde"); 

insert into usuario(user, senha, perfil) values ("Admin","admin2022","Administrador"), ("PM","pm2022","Policia Municipal"), ("CMCM","cmcm2022","Funcionario do CM"); 

insert into rota (origem, destino, via, codigo_cor) values ("Costa de Sol", "A. Voador", "Eduardo Mondlane", 3),("Museu", "Laulane", "Compone", 1), ("Baixa", "P, Combatentes","Compone", 2), ("Xipamanine", "A. Voador","Alto Mae", 4), ("Xipamanine", "Museu","Alto Mae", 4), ("Xipamanine", "P. Combatentes", "Alto Mae",4), ("Malhazine", "Xipamanine","25 de Junho", 5), ("Xipamanine", "Laulane", "Alto Mae",4), ("Xipamanine", "Magoanine", "Alto Mae",4);


insert into veiculo (matricula, nome, tipo_doc, nr_doc, telefone1, telefone2, bairro, avenida, quarteirao, nr_casa, codigo_rota) values ("AFJ-994-MC", "Mercio Machava", "BI", "1122222222S", 845554333, 856789999, "Central B", "Eduardo Mondlane", 14, 34, 1) , ("ABJ-234-MC", "Claudia Mercia", "BI", "1122222222S", 845554333, 856789999, "Central A", "Eduardo Mondlane", 14, 34, 3);

