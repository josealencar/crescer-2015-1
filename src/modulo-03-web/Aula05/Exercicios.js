//Exercício 01
var chelsea = {
  nome: 'Chelsea Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 5 },
    { desc: 'Continentais', qtd: 1 },
    { desc: 'Mundiais', qtd: 0 }
  ]
};

var arsenal = {
  nome: 'Arsenal Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 13 },
    { desc: 'Continentais', qtd: 0 },
    { desc: 'Mundiais', qtd: 0 }
  ]
};

var liverpool = {
  nome: 'Liverpool Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 18 },
    { desc: 'Continentais', qtd: 5 },
    { desc: 'Mundiais', qtd: 0 }
  ]
};

var manchesterUnited = {
  nome: 'Manchester United Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 20 },
    { desc: 'Continentais', qtd: 3 },
    { desc: 'Mundiais', qtd: 1 }
  ]
};

var clubes = [chelsea, arsenal, liverpool, manchesterUnited];
clubes;

//Exerício 02
//Exercício 2A
var ordenaPorNacionais = function(Array){
    var ordenado = Array.sort(function(a,b){return a.titulos[0].qtd < b.titulos[0].qtd});
    return ordenado;
};
//Exercício 2B
var ordenaPorContinentais = function(Array){
    var ordenado = Array.sort(function(a,b){return a.titulos[1].qtd < b.titulos[1].qtd});
    return ordenado;
};
//Exercício 2C
var ordenaPorMundiais = function(Array){
    var ordenado = Array.sort(function(a,b){return a.titulos[2].qtd < b.titulos[2].qtd});
    return ordenado;
};

//Exercício 03
//Exercício 3A
var somarPorNacionais = function(Array){
    var somatorio = Array.map(function(i){
                      return i.titulos[0].qtd;
                      }).reduce(function(a,b){return a + b;});
    return somatorio;
};
//Exercício 3B
var somarPorContinentais = function(Array){
    var somatorio = Array.map(function(i){
                      return i.titulos[1].qtd;
                      }).reduce(function(a,b){return a + b;});
    return somatorio;
};
//Exercício 3C
var somarPorMundiais = function(Array){
    var somatorio = Array.map(function(i){
                      return i.titulos[2].qtd;
                      }).reduce(function(a,b){return a + b;});
    return somatorio;
};

var somarPorTodosTitulos = function(Array){
    var somatorio = somarPorNacionais(Array) + somarPorContinentais(Array) + somarPorMundiais(Array);
    return somatorio;
};

//Exercício 04
var apenasOsMelhores = function(Array){
    var time = Array.filter(function(i){ return i.titulos[0].qtd > 18});
    return time;
}

//Exercício 05
//Exercício 5A
var apenasOsMelhoresParaJSON = function(Array){
    var time = apenasOsMelhores(Array).map(function(i){ return JSON.stringify(i)});
    return time;
}

// Exercício 5B
var apenasOsMelhoresRecebendoJSON = function(String){
    var retorno = eval("(" + String + ")");
    return retorno;
}