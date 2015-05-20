var dados = ({resposta: "4838"});
var a = 0;

$.ajax({
    url: 'http://illuminati.instaweb.com.br:6789/exercicios?token=46caa52376d4',
    type: 'POST',
    contentType: 'application/jason',
    dataType: 'json',
    data: JSON.stringify(dados)
}).done(function(resposta){
    resposta.dados.forEach(function(resultado){var b = resultado; if(b.status === "INCLUIDO"){a = (a + b.data);}; console.log(b.status, b.data, a)})
});


//resposta 5
/*resposta.dados.forEach(function(resultado){var b = parseInt(resultado); if(!(b%3)){a = (a + resultado);}; console.log(a)})*/

//resposta 6
/*resposta.dados.forEach(function(resultado){a = (a + resultado.data); console.log(b.status, b.data, a)*/

//resposta 7
/*resposta.dados.forEach(function(resultado){var b = resultado; if(b.status === "INCLUIDO"){a = (a + b.data);}; console.log(b.status, b.data, a)*/