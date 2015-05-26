var nome;
$.ajax({
    url: 'http://karatekid.instaweb.com.br:4567/apresentar?nome=Jose',
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
    }).done(function(res){ exercicios(res); console.log(res.atividades);});
});

function exercicios(res){
    $.ajax({
        url: 'http://karatekid.instaweb.com.br:4567'+res.atividades[0].atividade+'?nome='+nome,
        type: 'POST'/*,
        contentType: 'application/jason',
        dataType: 'json',
        data: JSON.stringify(dados)*/
    }).done(function(res){console.log('0', res)});
    
    $.ajax({
        url: 'http://karatekid.instaweb.com.br:4567'+res.atividades[1].atividade+'?nome='+nome,
        type: 'POST'/*,
        contentType: 'application/jason',
        dataType: 'json',
        data: JSON.stringify(dados)*/
    }).done(function(res){console.log('1', res)});
    
    $.ajax({
        url: 'http://karatekid.instaweb.com.br:4567'+res.atividades[2].atividade+'?nome='+nome,
        type: 'POST'/*,
        contentType: 'application/jason',
        dataType: 'json',
        data: JSON.stringify(dados)*/
    }).done(function(res){console.log('2', res); acabei();});
};

function acabei(){
    $.ajax({
        url: 'http://karatekid.instaweb.com.br:4567/acabei?nome='+nome,
        type: 'POST'/*,
        contentType: 'application/jason',
        dataType: 'json',
        data: JSON.stringify(dados)*/
    })
};