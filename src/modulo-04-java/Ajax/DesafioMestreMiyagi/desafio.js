var nome;
$.ajax({
    url: 'http://karatekid.instaweb.com.br:4567/apresentar?nome=José',
    type: 'POST'/*,
    contentType: 'application/jason',
    dataType: 'json',
    data: JSON.stringify(dados)*/
}).done(function(resposta){
    console.log(resposta);
    console.log(resposta.nome);
    nome = resposta.nome;
    console.log(nome);
    $.ajax({
        url: 'http://karatekid.instaweb.com.br:4567/tarefas?nome='+resposta.nome,
        type: 'GET'/*,
        contentType: 'application/jason',
        dataType: 'json',
        data: JSON.stringify(dados)*/
    }).done(function(resposta){
        console.log(resposta);
    }).done(function(res){ exercicios(res); console.log(res.atividades);});
});

function exercicios(res){
    $.ajax({
        url: 'http://karatekid.instaweb.com.br:4567/tarefas?nome='+nome+res.atividades[0].atividade,
        type: 'POST',
        contentType: 'application/jason',
        dataType: 'json'/*,
        data: JSON.stringify(dados)*/
    }).done(function(res){console.log('0', res)});
    
    $.ajax({
        url: 'http://karatekid.instaweb.com.br:4567/tarefas?nome='+nome+res.atividades[1].atividade,
        type: 'POST',
        contentType: 'application/jason',
        dataType: 'json'/*,
        data: JSON.stringify(dados)*/
    }).done(function(res){console.log('1', res)});
    
    $.ajax({
        url: 'http://karatekid.instaweb.com.br:4567/tarefas?nome='+nome+res.atividades[2].atividade,
        type: 'POST',
        contentType: 'application/jason',
        dataType: 'json'/*,
        data: JSON.stringify(dados)*/
    }).done(function(res){console.log('2', res)});
};