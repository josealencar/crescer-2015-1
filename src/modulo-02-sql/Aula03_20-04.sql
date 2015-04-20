Select NomeEmpregado as Nome,
		salario as SalarioMensal,
		(salario*12) as SalarioAnual 
From Empregado
Order By Nome ASC; -- ASC/DESC

Select IDEmpregado, NomeEmpregado
From Empregado
Where Salario between 1000 and 1500;

-----------------------------------------

-- Exerc�cio 1
Select NomeEmpregado, DataAdmissao
From Empregado
Order By DataAdmissao ASC;

-- Exerc�cio 2
Select NomeEmpregado, (Salario*12) as SalarioAnual
From Empregado
Where Cargo='Atendente' and (Salario*12) < 18500;

-- Exerc�cio 3
Select IDCidade
From Cidade
Where Nome = 'UberL�ndia';

-- Exerc�cio 4
Select IDCidade, Nome
From Cidade
Where UF = 'RS';

----------------------------------------------------------

