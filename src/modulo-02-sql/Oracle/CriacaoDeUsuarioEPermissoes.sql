-- Cria��o de usu�rio
create user curso1 identified by curso1;

-- Concedendo permiss�es para conectar e criar objetos
grant connect, resource, create view to curso1;

-- Apontar o diret�rio para exportar a base de dados
create directory cursosql as 'C:\Oracle\DATAPUMP';

-- Cria��o de usu�rio
create user crescer15 identified by crescer15;

-- Concedendo permiss�es para conectar e criar objetos
grant connect, resource, create view to crescer15;