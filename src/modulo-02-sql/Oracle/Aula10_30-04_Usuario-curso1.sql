CREATE TABLE Pessoa
  (
    IDPessoa        INTEGER NOT NULL,
    Nome            VARCHAR2(50) NOT NULL,
    Data_Nascimento DATE,
    Endereco        VARCHAR2(35),
    Cidade          VARCHAR2(50),
    UF              VARCHAR2(2),
    CONSTRAINT PK_Pessoa PRIMARY KEY (IDPessoa)
  );
CREATE sequence sqPessoa;

Insert into Pessoa (IDPessoa, Nome, Data_Nascimento, Endereco, Cidade, UF)
Values(sqPessoa.nextval, 'Maria Cavalcante', to_date('01/02/1990', 'dd/mm/yyyy'),
'Rua A, 230', 'Taquara', 'RS');
Insert into Pessoa (IDPessoa, Nome, Data_Nascimento, Endereco, Cidade, UF)
Values(sqPessoa.nextval, 'Pedro de Souza', to_date('21/03/1985', 'dd/mm/yyyy'),
'Av. Ipiranga, 4200', 'Porto Alegre', 'RS');
Insert into Pessoa (IDPessoa, Nome, Data_Nascimento, Endereco, Cidade, UF)
Values(sqPessoa.nextval, 'Gustavo Kuerten', to_date('10/09/1976', 'dd/mm/yyyy'),
'Praia', 'Florianópolis', 'SC');

Select * from Pessoa;

Select initcap('josé alencar de souza rocha') from dual;

Commit;

