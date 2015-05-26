'use strict'
$(function(){
	$("#btBuscar").click(function(){
		buscar();
	});	
});

function buscar(){
    var parametro = $('#pesquisa').val();
    if(parametro == "Justin Bieber"){
        var sorteio = Math.floor(Math.random() * 10 + 1)
        if(sorteio===5 || sorteio === 10){
            $(function(){
                $.ajax({url: 'https://api.spotify.com/v1/search?q='+ parametro + '&type=artist', type: 'GET'})
                    .done(function(res){artista(res);});
            });
        } else {
            $(function(){
                $.ajax({url: 'https://api.spotify.com/v1/artists/douchebag/albums?limit=50', type: 'GET'})
                    .done(function(res){alert("Caro usuário, devido a um erro "+res.status+", não foi possível pesquisar por " + parametro);})
                .fail(function(res){alert("Caro usuário, devido a um erro "+res.status+", não foi possível pesquisar por " + parametro);});
            });
        }
    } else {
        $(function(){
            $.ajax({url: 'https://api.spotify.com/v1/search?q='+ parametro + '&type=artist', type: 'GET'})
                .done(function(res){artista(res);});
        });
    }
};

/*$(function(){ //http://content.guardianapis.com/search?q=manchester%20united&api-key=test
    $.ajax({url: 'https://api.spotify.com/v1/artists/6mdiAmATAx73kdxrNrnlao/albums?limit=50', type: 'GET'})
        .done(function(res){resultado(res);});
});*/

function artista(res){
    var artista = res.artists.items[0].id;
    $(function(){ //http://content.guardianapis.com/search?q=manchester%20united&api-key=test
        $.ajax({url: 'https://api.spotify.com/v1/artists/'+artista+'/albums?limit=50', type: 'GET'})
            .done(function(res){resultado(res);});
    });
}

function resultado(res) {
    var container = $('.container');
    var albums = $.extend({}, res.items);
		$.each(albums, function(i, umAlbum){
			container.append($('<img/>', {src: umAlbum.images[1].url}));
		})
};