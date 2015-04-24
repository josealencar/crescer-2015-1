Select Associado.Nome as NomeAssociado,
	Cidade.Nome as NomeCidade
From Associado
	INNER JOIN Cidade on Cidade.IDCidade = Associado.IDCidade;

-- Mostra os dados do Associado com o Departamento (Dados que tem departamento registrado)
Select Empregado.IDEmpregado,
	Empregado.NomeEmpregado,
	Departamento.NomeDepartamento
From Empregado
	INNER JOIN Departamento ON
	Departamento.IDDepartamento = Empregado.IDDepartamento;

-- For�a mostrar os registros da primeira tabela que n�o tem dados em comum
Select Empregado.IDEmpregado,
	Empregado.NomeEmpregado,
	Departamento.NomeDepartamento
From Empregado
	LEFT JOIN Departamento ON
	Departamento.IDDepartamento = Empregado.IDDepartamento;

-- For�a mostrar os registros da segunda tabela que n�o tem dados em comum
Select Empregado.IDEmpregado,
	Empregado.NomeEmpregado,
	Departamento.NomeDepartamento
From Empregado
	RIGHT JOIN Departamento ON
	Departamento.IDDepartamento = Empregado.IDDepartamento;

-- Referenciando a mesma tabela (� obrigat�rio uso de apelidos nesse caso)
Select e.IDEmpregado,
	e.NomeEmpregado as NomeEmpregado,
	e.IDGerente,
	g.NomeEmpregado as NomeGerente
From Empregado e
	INNER JOIN Empregado g ON e.IDGerente = g.IDEmpregado;

-- Cross Join
Select a.IDAssociado,
	a.Nome,
	a.IDCidade IDCidadeEmp,
	c.IDCidade,
	c.Nome
From Associado a, Cidade c;

---------------------------------------------------------------------------
Select * from Associado;

Update Associado
Set IDCidade = 32
Where IDAssociado = 3;

----------------------------------------------------------------
-- Exerc�cio 01
Select Empregado.IDEmpregado,
	Empregado.NomeEmpregado,
	Departamento.NomeDepartamento
From Empregado
	INNER JOIN Departamento ON
	Departamento.IDDepartamento = Empregado.IDDepartamento;

-- Exerc�cio 02
Select a.Nome as NomeAssociado,
	c.Nome as NomeCidade
From Associado a
	LEFT JOIN Cidade c ON a.IDCidade = c.IDCidade;

-- Exerc�cio 03
Select c.UF, COUNT(c.Nome)
From Cidade c
Where NOT EXISTS 
	(Select 1 
	From Associado a 
	Where a.IDCidade = c.IDCidade)
Group By c.UF;

-- Exerc�cio 04
Select a.Nome as NomeAssociado,
	c.Nome as NomeCidade,
	Case When c.UF in ('RS', 'SC', 'PR') Then '***'
		else NULL END as RegiaoSUL
From Associado a
	LEFT JOIN Cidade c ON a.IDCidade = c.IDCidade;

-- Exerc�cio 05
Select e.NomeEmpregado as NomeEmpregado,
	g.NomeEmpregado as NomeGerente,
	d.NomeDepartamento as NomeDepartamento
From Empregado e
	INNER JOIN Empregado g ON e.IDGerente = g.IDEmpregado
	INNER JOIN Departamento d on e.IDDepartamento = d.IDDepartamento;

-- Exerc�cio 06
Select * into EmpregadoAux From Empregado;

Update EmpregadoAux
Set Salario = Salario * 1.145
Where IDDepartamento IN (Select IDDepartamento From Departamento Where Localizacao = 'SAO PAULO');

-- Exerc�cio 07
Select (SUM(ex.Salario) - SUM(e.Salario)) as TotalDeReajuste
From Empregado e
	INNER JOIN EmpregadoAux ex ON e.IDEmpregado=ex.IDEmpregado;

-- Exerc�cio 08
Select TOP 1 WITH TIES d.NomeDepartamento, MAX(e.Salario)
From Departamento d
	INNER JOIN Empregado e ON e.IDDepartamento = d.IDDepartamento
Group By d.NomeDepartamento
Order By MAX(e.Salario) DESC;

-- Exerc�cio 09
Select a.Nome as NomeAssociado,
	c.Nome as NomeCidade
From Associado a
	INNER JOIN Cidade c ON a.IDCidade = c.IDCidade
UNION ALL
Select e.NomeEmpregado, d.Localizacao
From Empregado e
	INNER JOIN Departamento d ON e.IDDepartamento = d.IDDepartamento;

-- Exerc�cio 10
Select Nome
From Cidade
Where IDCidade IN (Select IDCidade From Associado);
-- ou
Select c.Nome
From Cidade c
	INNER JOIN Associado a ON a.IDCidade = c.IDCidade;