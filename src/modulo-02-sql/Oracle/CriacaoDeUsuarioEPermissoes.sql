-- Criação de usuário
create user curso1 identified by curso1;

-- Concedendo permissões para conectar e criar objetos
grant connect, resource, create view to curso1;

-- Apontar o diretório para exportar a base de dados
create directory cursosql as 'C:\Oracle\DATAPUMP';

-- Criação de usuário
create user crescer15 identified by crescer15;

-- Concedendo permissões para conectar e criar objetos
grant connect, resource, create view to crescer15;