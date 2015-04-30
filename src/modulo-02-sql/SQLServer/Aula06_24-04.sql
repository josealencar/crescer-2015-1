-- Exercício 01
Select Distinct Situacao
From Produto
Order By Situacao ASC;
-- Resposta Professor
Select COUNT(DISTINCT Situacao) as Total_Valores
From Produto;

-- Exercício 02
Select * From Cliente;

Select IDCliente, Nome, RazaoSocial
From Cliente
Where Nome LIKE '%LTDA' OR RazaoSocial LIKE '%LTDA';
-- Resposta Professor
Select IDCliente, Nome, RazaoSocial
From Cliente
Where Nome LIKE '%LTDA%' OR RazaoSocial LIKE '%LTDA%';

-- Exercício 03
Select * from Produto;

Insert Into Produto(Nome, DataCadastro, PrecoCusto, PrecoVenda, Situacao)
Values ('Galocha Maragato', GETDATE(), 35.67, 77.95, 'A');

-- Exercício 04
Select Produto.IDProduto, Produto.Nome
From Produto
Where NOT EXISTS(Select 1 From PedidoItem
				Where Produto.IDProduto = PedidoItem.IDProduto
				AND EXISTS(Select 1 From Pedido
							Where Pedido.IDPedido = PedidoItem.IDPedido))
Order By Produto.IDProduto;
-- Resposta Professor
Select IDProduto, Nome
From Produto
Where NOT EXISTS (Select 1 From PedidoItem Where PedidoItem.IDProduto = Produto.IDProduto);

Create Index IX_PedidoItem_Produto ON PedidoItem (IDProduto);

-- Exercício 05
Select TOP 1 WITH TIES UF as CidadeComMaisClientes,
	(Select TOP 1 WITH TIES UF
	From Cidade
		INNER JOIN Cliente ON Cidade.IDCidade = Cliente.IDCidade
	Group by UF
	Order By COUNT(Cliente.IDCliente) ASC)  as CidadeComMenosClientes
From Cidade
	INNER JOIN Cliente ON Cidade.IDCidade = Cliente.IDCidade
Group By UF
Order By COUNT(Cliente.IDCliente) DESC;
-- Resposta do professor
Create View vwEstados as
	Select Cidade.UF, COUNT(Cliente.IDCliente) as ClientesPorUF
	From Cidade
		INNER JOIN Cliente ON Cliente.IDCidade = Cidade.IDCidade
	Group By Cidade.UF;

Select * from vwEstados
Where ClientesPorUF = (Select MIN(ClientesPorUF) From vwEstados)
	OR ClientesPorUF = (Select MAX(ClientesPorUF) From vwEstados);

-- Exercício 06
Select DISTINCT Cidade.Nome as NomeCidade
From Cidade
	INNER JOIN Cliente ON Cidade.IDCidade = Cliente.IDCidade
	INNER JOIN Pedido ON Cliente.IDCliente = Pedido.IDCliente
Order By Cidade.Nome ASC;
-- Resposta do Professor
Select COUNT(DISTINCT Nome) as TotalCidades
From Cidade
Where EXISTS (Select 1 From Cliente
				INNER JOIN Pedido ON Pedido.IDCliente = Cliente.IDCliente
			Where Cliente.IDCidade = Cidade.IDCidade);

-- Exercício 07
Select Produto.IDProduto as IDProduto, Produto.Nome as NomeDoProduto
From Produto
Where NOT EXISTS (Select ProdutoMaterial.IDProduto
					From ProdutoMaterial
					Where ProdutoMaterial.IDProduto = Produto.IDProduto);

-- Exercício 08
Select Produto.IDProduto As IDProduto,
	Produto.Nome as NomeProduto,
	Produto.PrecoCusto as CustoProduto,
	SUM(ProdutoMaterial.Quantidade*Material.PrecoCusto) as CustoMaterial
From Produto
	INNER JOIN ProdutoMaterial ON Produto.IDProduto = ProdutoMaterial.IDProduto
	INNER JOIN Material ON ProdutoMaterial.IDMaterial = Material.IDMaterial
Group By Produto.IDProduto, Produto.Nome, Produto.PrecoCusto;
-- Resposta Professor

Create Function busca_precoCusto_Material (@IDProduto INT)
	Returns Decimal(9,2) as
Begin
	Declare @preco_custo Decimal(9,2)

	Select @preco_custo = SUM(ma.PrecoCusto * ISNULL(pm.Quantidade, 1))
	From ProdutoMaterial pm
		INNER JOIN Material ma ON pm.IDMaterial = ma.IDMaterial
	Where pm.IDProduto = @IDProduto;

	Return @preco_custo
End;

Select IDProduto, Nome, PrecoCusto, dbo.busca_precoCusto_Material(IDProduto) as CustoMaterial
From Produto;


-- Exercício 09
Select * INTO ProdutoAUX From Produto;

Update ProdutoAUX Set PrecoCusto = (Select 
								ISNULL(SUM(ProdutoMaterial.Quantidade*Material.PrecoCusto),0)
								From ProdutoMaterial
									INNER JOIN Material ON ProdutoMaterial.IDMaterial
																= Material.IDMaterial
								Where ProdutoAUX.IDProduto = ProdutoMaterial.IDProduto);
-- Verificando
Select ProdutoAUX.IDProduto As IDProduto,
	ProdutoAUX.Nome as NomeProduto,
	ProdutoAUX.PrecoCusto as CustoProduto,
	SUM(ProdutoMaterial.Quantidade*Material.PrecoCusto) as CustoMaterial
From ProdutoAUX
	INNER JOIN ProdutoMaterial ON ProdutoAUX.IDProduto = ProdutoMaterial.IDProduto
	INNER JOIN Material ON ProdutoMaterial.IDMaterial = Material.IDMaterial
Group By ProdutoAUX.IDProduto, ProdutoAUX.Nome, ProdutoAUX.PrecoCusto;

-- Exercício 10
Select Nome as NomeCliente
From Cliente
Group By Nome
Having COUNT(1) > 2
Order By Nome ASC;

-- Exercício 11
Select TOP 1 WITH TIES SUBSTRING(Nome, 1, CHARINDEX(' ', Nome) -1) as PrimeiroNomeMaisPopular
From Cliente
Group By SUBSTRING(Nome, 1, CHARINDEX(' ', Nome) -1)
Order By COUNT(1) DESC;

-- Exercício 12
Select TOP 1 WITH TIES Produto.IDProduto as IDProduto,
		Produto.Nome as NomeProduto,
		SUM(PedidoItem.Quantidade) as QuantidadeVendida
From Produto
	INNER JOIN PedidoItem ON PedidoItem.IDProduto = Produto.IDProduto
Group By Produto.IDProduto, Produto.Nome
Order By SUM(PedidoItem.Quantidade) DESC;