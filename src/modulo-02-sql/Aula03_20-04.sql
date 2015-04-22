Select NomeEmpregado as Nome,
		salario as SalarioMensal,
		(salario*12) as SalarioAnual 
From Empregado
Order By Nome ASC; -- ASC/DESC

Select IDEmpregado, NomeEmpregado
From Empregado
Where Salario between 1000 and 1500;

-----------------------------------------

-- Exercício 1
Select NomeEmpregado, DataAdmissao
From Empregado
Order By DataAdmissao ASC;

-- Exercício 2
Select NomeEmpregado, (Salario*12) as SalarioAnual
From Empregado
Where Cargo='Atendente' and (Salario*12) < 18500;

-- Exercício 3
Select IDCidade
From Cidade
Where Nome = 'UberLândia';

-- Exercício 4
Select IDCidade, Nome
From Cidade
Where UF = 'RS';

----------------------------------------------------------

Select COUNT(1) as TotalEmpregados,
	COUNT(Distinct Cargo) as TotalCargos
From Empregado;

Select Distinct Cargo, IDDepartamento From Empregado;

-- Distinct Traz somente um de cada (diferentes)

Select IDDepartamento,
	SUM(Salario) as Soma,
	MAX(Salario) as Maximo,
	MIN(Salario) as Minimo
From Empregado
Group By IDDepartamento;

Select NomeEmpregado,
	(Salario + Comissao) as Total_Sal_A,
	(Salario + (ISNULL(Comissao, 0))) as Total_Sal_B,
	Comissao
From Empregado;

select lower('JOSE');

--------------------------------------------------------------------
-- Exercício 1
Select SUBSTRING(Nome, 1, CHARINDEX(' ', Nome) -1)
From Associado;

-- Exercício 2
Select Nome, datediff(yy, DataNascimento, getdate()) as Idade
From Associado;

-- Exercício 3
Select NomeEmpregado,
	DATEDIFF(MM,
			convert(datetime, DataAdmissao, 103),
			convert(datetime, '31/12/2000', 103)) as Meses_Trabalhados
From Empregado
Where convert(datetime, DataAdmissao, 103) between
	convert(datetime, '01/05/1980', 103) and 
	convert(datetime, '20/01/1982', 103);

-- Exercício 4
Select TOP 1 count(Cargo) as Funcionarios, Cargo
From Empregado
Group By Cargo
Order By Funcionarios DESC;

-- Exercício 5
Select TOP 1 LEN(Nome) Tamanho, Nome
From Associado
Order By Tamanho DESC;

-- Exercício 6
Select Nome,
	DATEADD(year,50,DataNascimento) as Data50,
	datename(dw,DATEADD(year,50,DataNascimento)) as DiaSemana
From Associado;

-- Exercício 7
Select UF, COUNT(Nome) as Cidades
From Cidade
Group by UF;

-- Exercício 8
Select Nome, UF, COUNT(Nome) as Registros
From Cidade
Group By UF, Nome
Having COUNT(Nome) > 1;

-- Exercício 9
Select MAX(IDAssociado)+1 as ProximoRegistro
From Associado;

-- Exercício 10
Select * Into CidadeAux From Cidade;
Select * From CidadeAux Order By Nome ASC;
Truncate Table CidadeAux;

Insert Into CidadeAux(IDCidade, Nome, UF)
Select MIN(IDCidade), Nome, UF From Cidade Where exists(Select Distinct Nome, UF From Cidade)
Group By Nome, UF;

-- Exercício 11
-- Criando Tabela auxiliar para não alterar os valores de forma incorreta
Select * Into CidadeTeste From Cidade;
TRUNCATE Table CidadeTeste;
Insert Into CidadeTeste(IDCidade, Nome, UF)
Select IDCidade, Nome, UF From Cidade;
-- Comandos auxiliares para verificação
Select Nome, COUNT(Nome) From CidadeTeste
Group By UF, Nome Having COUNT(Nome) >1;
Select * From CidadeTeste;
-- Resolução do exercício 11
Declare @ID as int
Declare @Nome as varchar(30)
SET @ID=1
While @ID <= (Select MAX(IDCidade) From CidadeTeste)
BEGIN
SET @Nome = (Select Nome From CidadeTeste Where IDCidade = @ID);
	IF (Select COUNT(Nome) From CidadeTeste Where Nome Like '%' + @Nome) > 1
	Begin
		Update CidadeTeste
		Set Nome = '*' + Nome
		Where IDCidade = @ID;
	End;
SET @ID = @ID + 1;
END;

-- Exercício 12
Select Nome, Case Sexo When 'F' Then 'Feminino' When 'M' then 'Masculino' End Genero
From Associado;

-- Exercício 13
Select NomeEmpregado, Salario,
	Case When Salario < 1164 Then '0%'
		 When Salario < 2326 Then '15%'
		 Else '27,5%'
		 End PercentualDesconto
From Empregado;

-- Exercício 14
-- Comandos auxiliares para verificação
Select Nome, COUNT(Nome) From CidadeTeste
Group By UF, Nome Having COUNT(Nome) >1;
Select * From CidadeTeste;
-- Resolução do exercício 14
Declare @ID14 as int
Declare @Nome14 as varchar(30)
SET @ID14=1
While @ID14 <= (Select MAX(IDCidade) From CidadeTeste)
BEGIN
SET @Nome14 = (Select Nome From CidadeTeste Where IDCidade = @ID14);
	IF @Nome14 IS NULL Begin SET @ID14 = @ID14 + 1 Continue END;
	IF (Select COUNT(Nome) From CidadeTeste Where Nome Like '%' + @Nome14) > 1
	Begin
		Delete
		From CidadeTeste
		Where IDCidade != @ID14 and Nome = @Nome14;
	End;
SET @ID14 = @ID14 + 1;
END;

-- Exercício 15
IF OBJECT_ID('TGR_InserirDuplicados','TR') IS NOT NULL
	DROP TRIGGER TGR_InserirDuplicados;
Go
CREATE TRIGGER TGR_InserirDuplicados
On Cidade
FOR INSERT
AS
Begin
	Declare
	@Nome Varchar(30)

	Select @Nome = Nome FROM inserted;

	IF (Select COUNT(Nome) From Cidade Where Nome=@Nome) > 1
	Begin
	RAISERROR ('Já existe uma Cidade com este nome.', 16, 1)
	ROLLBACK TRANSACTION;
	Return
	END;
END;
GO

Select * From Cidade Where Nome like 'A%' Order By Nome ASC;

Insert into Cidade(IDCidade, Nome, UF)
Values(111, 'Taquara','RS'); -- Cancelou a inserção

Insert into Cidade(IDCidade, Nome, UF)
Values(111, 'Alegrete','RS');