function adicionarFavoritos(filme, elemento){
	$.ajax({
	    url: '/adicionaFavoritos?idfilme='+filme,
	    type: 'POST'
	}).done(function(res){console.log(res);
		$(elemento).attr("value", "Remover dos Favoritos").attr("onclick", "removerFavoritos("+filme+",this)");})
	.fail(function(res){});
};

function removerFavoritos(filme, elemento){
	$.ajax({
	    url: '/removeFavoritos?idfilme='+filme,
	    type: 'POST'
	}).done(function(res){console.log(res);
		$(elemento).attr("value", "Adicionar aos Favoritos").attr("onclick", "adicionarFavoritos("+filme+",this)");})
	.fail(function(res){});
};

function carregaStatusBotoes(){
	var botoes = $('[type=button]');
	$.each(botoes, function(botao){
		$(botoes[botao]).click();
	});
};

function recuperaStatus(filme, elemento){
	$.ajax({
		url: '/verFavoritos?idfilme='+filme,
		type: 'POST'
	}).done(function(res){ atualizaValueButton(res, filme, elemento);})
	.fail(function(res){});
};

function atualizaValueButton(res, filme, elemento){
	if(res === "adicionarFavoritos"){
		$(elemento).attr("value", "Adicionar aos Favoritos");
	} else {
		$(elemento).attr("value", "Remover dos Favoritos");
	}
	$(elemento).attr("onclick", res+"("+filme+",this)");
};