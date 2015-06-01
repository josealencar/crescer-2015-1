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

Create tablespace DESAFIO1_DAT
datafile 'C:\oraclexe\app\oracle\oradata\XE\desafio1_dat01.dbf'
size 100m
autoextend on
next 100m
maxsize 6144m;

Create user DESAFIO1 identified by DESAFIO1 default tablespace DESAFIO1_DAT;

Grant connect, resource, create view to DESAFIO1;

Select directory_path
from dba_directories
where directory_name = 'DATA_PUMP_DIR';