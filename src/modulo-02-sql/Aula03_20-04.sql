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

