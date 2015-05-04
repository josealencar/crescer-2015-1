BEGIN
	DECLARE @Nome VarChar(30)

	SET @Nome = 'CWI Software'

	Print @Nome
	Print GETDATE()
END

BEGIN
	DECLARE @vIDCliente int

	Select @vIDCliente = IDCliente
	From Cliente
	Where Nome = 'Mariana Ventura Che'

	Print 'Mariana possui o código ' +
	Cast(@vIDCliente AS VarChar(10))
END

BEGIN
	BEGIN TRY
		Begin Transaction

		Insert into Cidade (IDCidade, Nome, UF)
		Values (1, 'Morro da Pedra', 'RS');

		Commit
	END TRY
	BEGIN CATCH
		Rollback

		Print ERROR_MESSAGE()
	END CATCH
END;

BEGIN
	BEGIN TRY
		Begin Transaction

		Set Identity_Insert Cidade ON;

		Insert into Cidade (IDCidade, Nome, UF)
		Values (1, 'Morro da Pedra', 'RS');

		Set Identity_Insert Cidade OFF;

		Commit
	END TRY
	BEGIN CATCH
		If @@TRANCOUNT > 0 Rollback; --Se existir alguma transacao

		Print ERROR_MESSAGE()
	END CATCH
END;

BEGIN
	DECLARE ListaCidade CURSOR
		Local
		Fast_Forward
		FOR Select Nome, Uf
			From Cidade
			Group by Nome, Uf
			Having COUNT(1) > 1;
	DECLARE @vNome varchar(50),
		@vUF varchar(2)
	OPEN ListaCidade;
	FETCH NEXT FROM ListaCidade INTO @vNome, @vUF
		WHILE (@@FETCH_STATUS=0) BEGIN
			Print @vNome + '/' + @vUF;
			FETCH NEXT FROM ListaCidade INTO @vNome, @vUF
		END
	CLOSE ListaCidade;
	DEALLOCATE ListaCidade;
END;

-- Exercícios
-- Exercício 01
Begin
	Declare @MaisVendido Varchar(100), @Quantidade INT
	
	Select TOP 1 @MaisVendido = Produto.Nome,
		@Quantidade = SUM(PedidoItem.Quantidade)
	From Produto
		INNER JOIN PedidoItem ON PedidoItem.IDProduto = Produto.IDProduto
	Group by Produto.IDProduto, Produto.Nome
	Order By SUM(PedidoItem.Quantidade) DESC

	Print 'Nome do Produto: ' + @MaisVendido
	Print 'Quantidade Vendida: ' + CAST(@Quantidade as Varchar(50))
End;

-- Exercício 02
Begin
	Declare CursorCidadeUFDuplicadas CURSOR
	Local
	Fast_Forward
	FOR Select Nome, UF
		From Cidade
		Where IDCidade IN (Select DISTINCT IDCidade
							From Cliente)
		Group By Nome, UF
		Having COUNT(1) > 1;

	Declare @vNome2 varchar(100),
			@vUF2 varchar(2), @vQtd INT

	OPEN CursorCidadeUFDuplicadas;
	FETCH NEXT FROM CursorCidadeUFDuplicadas INTO @vNome2, @vUF2
	WHILE (@@FETCH_STATUS=0) BEGIN
	Print @vNome2 + '/' + @vUF2;
	FETCH NEXT FROM CursorCidadeUFDuplicadas INTO @vNome2, @vUF2
	END
	CLOSE CursorCidadeUFDuplicadas;
	DEALLOCATE CursorCidadeUFDuplicadas;
End;
-- Resposta do professor
Begin
	Declare CursorCidadeUFDuplicadas CURSOR
	Local
	Fast_Forward
	FOR Select Nome, UF
		From Cidade
		Group By Nome, UF
		Having COUNT(1) > 1;

	Declare @vNome3 varchar(100),
			@vUF3 varchar(2), @vQtd3 INT

	OPEN CursorCidadeUFDuplicadas;
	FETCH NEXT FROM CursorCidadeUFDuplicadas INTO @vNome3, @vUF3
	WHILE (@@FETCH_STATUS=0) BEGIN

	Select @vQtd3 = COUNT(1)
	From Cliente
	Where EXISTS (Select 1
					From Cidade
					Where Cidade.IDCidade = Cliente.IDCidade
					AND Cidade.Nome = @vNome3
					AND Cidade.UF = @vUF3)

	IF @vQtd3 > 0 Print @vNome3 + '/' + @vUF3;
	FETCH NEXT FROM CursorCidadeUFDuplicadas INTO @vNome3, @vUF3
	END
	CLOSE CursorCidadeUFDuplicadas;
	DEALLOCATE CursorCidadeUFDuplicadas;
End;

-- Exercício 03
drop view vwMateriaisMaisUtilizados;

Create View vwMateriaisMaisUtilizados AS
Select TOP 1 WITH TIES
		Material.IDMaterial AS IDMaterial, Material.Descricao AS DescricaoMaterial,
		COUNT(DISTINCT ProdutoMaterial.IDProduto) AS Total
From Material
	INNER JOIN ProdutoMaterial ON ProdutoMaterial.IDMaterial = Material.IDMaterial
	INNER JOIN Produto ON Produto.IDProduto = ProdutoMaterial.IDProduto
Group By Material.IDMaterial, Material.Descricao
Order By Total DESC;

Begin
	Declare @vIDMaterial Int,
	@vDescricaoMaterial varchar(100),
	@vQtdPedidosRealizados int,
	@vTotalVendas decimal(12,2)

	Select @vIDMaterial = IDMaterial, @vDescricaoMaterial = DescricaoMaterial
	From vwMateriaisMaisUtilizados;

	Select @vQtdPedidosRealizados = COUNT(1)
	From Pedido
	Where EXISTS (Select Produto.IDProduto,
							Produto.Nome
					From Produto, PedidoItem
					Where Pedido.IDPedido = PedidoItem.IDPedido
					AND PedidoItem.IDProduto = Produto.IDProduto AND
					EXISTS (Select 1 From ProdutoMaterial
									Where ProdutoMaterial.IDProduto = Produto.IDProduto
									AND ProdutoMaterial.IDMaterial IN
									(Select IDMaterial From vwMateriaisMaisUtilizados)))

	Select @vTotalVendas = SUM(Pedido.ValorPedido)
	From Pedido
	Where DataPedido BETWEEN DATEADD(DAY, -60, GETDATE()) AND GETDATE();

	Print 'ID do material mais utilizado: ' + CAST(@vIDMaterial as varchar) + 
			' Descrição: ' + @vDescricaoMaterial
	Print 'Total de pedidos realizados contendo este material: ' + 
			CAST(@vQtdPedidosRealizados as varchar)
	Print 'Total de venda dos últimos 60 dias: R$' + CAST(@vTotalVendas as varchar)
End;

-- Exercício 04
Create View vwCidadesDuplicadas as
Select Nome, UF
From Cidade
Group By Nome, UF
Having COUNT(1) > 1;
-- Resposta do professor
BEGIN
  SET NOCOUNT ON
  Declare @CidadeDuplicada table 
    (
     IDCidadeMenor  int,
     Nome           varchar(50),
     UF             varchar(2)
     )

  Insert @CidadeDuplicada 
         (IDCidadeMenor, Nome, UF)
     select MIN(IDCidade) MenorID, 
            Nome, 
            UF
     from   Cidade dup
     group  by Nome, UF
     having COUNT(1) > 1

  Select Cliente.IDCliente, Cliente.Nome,  Cidade.IDCidade, Cidade.Nome as Nome_Cidade
    From  Cliente
   inner join Cidade on Cidade.IDCidade = Cliente.IDCidade
   Where exists (Select 1
                 From   @CidadeDuplicada dup
                 Where  dup.Nome          = Cidade.Nome
                 and    dup.UF            = Cidade.UF
                 and    dup.IDCidadeMenor < Cidade.IDCidade)
  order by Nome_Cidade
  --
  SET NOCOUNT OFF  
END