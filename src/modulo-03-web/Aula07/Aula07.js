setTimeout(function(){console.log('caiu a ficha!');},2000);

var intervalo = setInterval(function(){console.log('caiu a ficha!');},2000);

var intervalo = setInterval(function(){console.log(new Date());},2000);

clearInterval(intervalo);

$.ajax({url:'/webservice', type: 'GET'}).done(function(response){}).fail(function(error){});