'use strict'

$(function(){
	$("#btBuscar").click(function(){
		buscar();
	});	
});

function buscar(){
    var parametro = $('#pesquisa').val();
    $(function(){ //http://content.guardianapis.com/search?q=manchester%20united&api-key=test
        $.ajax({url: 'https://api.spotify.com/v1/search?q='+ parametro + '&type=artist', type: 'GET'})
            .done(function(res){artista(res);});
    });
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