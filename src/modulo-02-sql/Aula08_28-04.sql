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
	Print ' Quantidade Vendida: ' + CAST(@Quantidade as Varchar(50))
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
			@vUF2 varchar(2)

	OPEN CursorCidadeUFDuplicadas;
	FETCH NEXT FROM CursorCidadeUFDuplicadas INTO @vNome2, @vUF2
	WHILE (@@FETCH_STATUS=0) BEGIN
	Print @vNome2 + '/' + @vUF2;
	FETCH NEXT FROM CursorCidadeUFDuplicadas INTO @vNome2, @vUF2
	END
	CLOSE CursorCidadeUFDuplicadas;
	DEALLOCATE CursorCidadeUFDuplicadas;
End;

-- Exercício 03
Begin
	
End;