function avaliarJS(avaliacao, filme, elemento){
	$.ajax({
	    url: '/avaliar?idfilme='+filme+'&estrelas='+avaliacao,
	    type: 'POST'
	}).done(function(res){sobreEscreveEstrelas(res, elemento); atualizaMedia(filme);})
	.fail(function(res){console.log(res);});
};

function sobreEscreveEstrelas(res, elemento){
	$(elemento).prevAll().attr('src', '/img/estrela1.jpg');
	$(elemento).nextAll().attr('src', '/img/estrela1.jpg');
	$(elemento).attr('src', '/img/estrela1.jpg');
	$(elemento).prevAll().attr('src', '/img/estrelaavaliada.jpg');
	$(elemento).attr('src', '/img/estrelaavaliada.jpg');
};

function atualizaMedia(filme){
	$.ajax({
	    url: '/atualiarMedia?idfilme='+filme,
	    type: 'POST'
	}).done(function(res){trocarImagemMedia(res);}).fail(function(res){console.log(res)});
};

function trocarImagemMedia(res){
	var str = 'media'+res.idfilme;
	if(res.nota === 1) { $('#'+str).attr('src', '/img/avaliacao1estrela.jpg');};
	if(res.nota === 2) { $('#'+str).attr('src', '/img/avaliacao2estrelas.jpg');};
	if(res.nota === 3) { $('#'+str).attr('src', '/img/avaliacao3estrelas.jpg');};
	if(res.nota === 4) { $('#'+str).attr('src', '/img/avaliacao4estrelas.jpg');};
	if(res.nota === 5) { $('#'+str).attr('src', '/img/avaliacao5estrelas.jpg');};
};

function buscaMediaAtual(filme, elemento){
	$.ajax({
	    url: '/atualiarMedia?idfilme='+filme,
	    type: 'POST'
	}).done(function(res){$(elemento).attr('onload', ''); trocarImagemMedia(res);}).fail(function(res){console.log(res)});
};

function minhaAvaliacao(imagem, filme, elemento){
	$.ajax({
	    url: '/minhaAva?idfilme='+filme,
	    type: 'POST'
	}).done(function(res){ $(elemento).attr('onload', ''); if(res.nota === imagem) {sobreEscreveEstrelas(res, elemento);}})
	.fail(function(res){console.log(res);});
};