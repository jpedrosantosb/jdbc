CREATE TABLE departamento (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Name varchar(60) DEFAULT NULL,
  PRIMARY KEY (Id)
);

CREATE TABLE vendedor (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Nome varchar(60) NOT NULL,
  Email varchar(100) NOT NULL,
  DataContrato datetime NOT NULL,
  SalarioBase double NOT NULL,
  DepartamentoId int(11) NOT NULL,
  PRIMARY KEY (Id),
  FOREIGN KEY (DepartamentoId) REFERENCES departamento (id)
);

INSERT INTO departamento (Nome) VALUES 
  ('Computadores'),
  ('Eletronicos'),
  ('Moda'),
  ('Livros');

INSERT INTO vendedor (Nome, Email, DataContrato, SalarioBase, DepartamentoId) VALUES 
  ('Joao Santos','joao@gmail.com','2002-04-21 00:00:00',1000,1),
  ('Maria Aparecida','maria@gmail.com','2006-12-31 00:00:00',3500,2),
  ('Alex Telles','alex@gmail.com','2013-01-15 00:00:00',2200,1),
  ('Marta Maria','marta@gmail.com','2015-11-30 00:00:00',3000,4),
  ('Cristiano Ronaldo','ronaldo@gmail.com','2000-01-09 00:00:00',4000,3),
  ('Neymar Junior','ney@gmail.com','2020-03-04 00:00:00',3000,2);