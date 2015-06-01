function adicionarFavoritos(filme, elemento){
	$.ajax({
	    url: '/adicionaFavoritos?idfilme='+filme,
	    type: 'POST'
	}).done(function(res){console.log(res);
		$(elemento).attr("value", "Remover dos Favoritos").attr("onclick", "removerFavoritos("+filme+",this)");})
	.fail(function(res){console.log(res);});
};

function removerFavoritos(filme, elemento){
	$.ajax({
	    url: '/removeFavoritos?idfilme='+filme,
	    type: 'POST'
	}).done(function(res){console.log(res);
		$(elemento).attr("value", "Adicionar aos Favoritos").attr("onclick", "adicionarFavoritos("+filme+",this)");})
	.fail(function(res){console.log(res);});
}