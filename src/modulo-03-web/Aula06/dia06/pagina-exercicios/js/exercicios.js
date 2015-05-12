//Exercício 01
//Exercício 1A
var moduleCLass = $('.module');

//Exercício 1B
var terceiroMyList = $('#myListItem');
var terceiroCorreto = $('#myList li:nth-child(3)');
var terceiroCorreto = $('#myList :eq(2)');
var terceiroCorreto = $('#myList li').eq(2);

//Exercício 1C
var seletorLabel = $('label[for=q]');
var seletorLabel = $('#search label[for=q]'); // Boas práticas de jQuery - especificar sempre um ID junto ao seletor

//Exercício 1D
var elementosAlt = $('[alt]').size();
var elementosAlt = $('[alt]').length;

//Exercício 1E
var linhasPares = $('#fruits tr:even:not(:first-child)');
var linhasPares = $('#fruits tbody tr:odd');

//Exercício 1F
var contemBe = $('h2:contains(B):contains(e)').length; //Obs.: Apenas B maiúsculo e e minúsculo.

//Exercício 1G
var liVermelho = $('#myList li').filter($('.current')); //Apenas o vermelho
var liVermelho = $('#myList li:not(.current)'); // Correto, todos menos o vermelho
var liVermelho = $('#myList li').not('.current'); 

//Exercício 1H
var ultimosFilhos = $('img:last-child, h3:last-child'); // last-child -> retorna o último filho da img
var ultimosFilhos = $('li:last-of-type img, li:last-of-type h3');
var ultimosFilhos = $('img:last, h3:last');

//Exercício 1I
var letrasApos = $('#myList li').filter($('.current')).nextAll().text().length;
var letrasApos = $('#myList .current ~ li').text().length;

//Exercício 02
//Exercício 2A
var imprimeLogAlt = $('img').filter('[alt]').each(function(){return console.log($(this))}); //Imprime todas as informações da imagem
var imprimeLogAlt = $('img').filter('[alt]').each(function(){return console.log($(this).attr('alt'))}); //Imprime apenas o alt

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


//Exercício 3C
var insereDiv = $('dov.module').last().after($('<div/>').addClass('module').append($('img:eq(0)').clone()));
var insereDiv = $('dov.module:last').after($('<div/>').addClass('module').append($('img:eq(0)').clone()));