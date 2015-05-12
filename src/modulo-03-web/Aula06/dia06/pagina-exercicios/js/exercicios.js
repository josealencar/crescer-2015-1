//Exercício 01
//Exercício 1A
var moduleCLass = $('.module');

//Exercício 1B
var terceiroMyList = $('#myListItem');
var terceiroCorreto = $('#myList li:nth-child(3)');

//Exercício 1C
var seletorLabel = $('label[for=q]');

//Exercício 1D
var elementosAlt = $('[alt]').size();

//Exercício 1E
var linhasPares = $('#fruits tr:even:not(:first-child)');

//Exercício 1F
var contemBe = $('h2:contains(B):contains(e)'); //Obs.: Apenas B maiúsculo e e minúsculo.

//Exercício 1G
var liVermelho = $('#myList li').filter($('.current'));

//Exercício 1H
var ultimosFilhos = $('img:last-child, h3:last-child');

//Exercício 1L
var letrasApos = $('#myList li').filter($('.current')).nextAll().text().length;

//Exercício 02
//Exercício 2A
var imprimeLogAlt = $('[alt]').each(function(){return console.log($(this))}); //Imprime todas as informações da imagem
var imprimeLogAlt = $('[alt]').each(function(){return console.log($(this).attr('alt'))}); //Imprime apenas o alt

//Exercício 2B
var inputText = $('input[type=text]').closest('form').addClass('template');
var inputText = $('input').filter($('[type=text]')).closest('form').addClass('template');

//Exercício 2C
var eliminaEAdicionaClass = $('#myList li').filter($('.current')).removeClass('current').next().addClass('current');

//Exercício 2D
var dimitri = $('#specials h2').text('Promoções').nextAll().children().find('[name=day] option:contains(Friday)').text('Dimitri');

//Exercício 2E
var irmaos = $('#slideshow').addClass('current').siblings().addClass('disabled');

//Exercício 03
//Exercício 3A
var adicionaLi = $('#myList li:last').append(function(){return '<li>List item '+(($(this).parent().find('li').size())+1)+'</li>'});
//Ver como utilizar a função 5 vezes.

//Exercício 3B
