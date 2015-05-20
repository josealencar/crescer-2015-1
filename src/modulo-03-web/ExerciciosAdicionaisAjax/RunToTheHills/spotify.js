$(function(){ //http://content.guardianapis.com/search?q=manchester%20united&api-key=test
    $.ajax({url: 'https://api.spotify.com/v1/artists/6mdiAmATAx73kdxrNrnlao/albums?limit=50', type: 'GET'})
        .done(function(res){resultado(res);});
});

function resultado(res) {
    var container = $('.container');
    albums = $.extend({}, res.items);
		$.each(albums, function(i, umAlbum){
			container.append($('<img/>', {src: umAlbum.images[1].url}));
		})
};