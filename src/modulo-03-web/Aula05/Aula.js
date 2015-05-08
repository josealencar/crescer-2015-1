var arr = [1, 2, 3];
var count = arr.reduce(function(a, b) { return a + b;});
count;
var str = ['a', 'b', 'c'];
var uhul = str.reduce(function(a,b) { return a + b; });
uhul;
var obj = {nome: 'Oi', idade: 15};
var obj2 = {nome: 'Oi', idade: 15};
var pessoa = [obj];
pessoa.push(obj2);
/*var soma = pessoa.map(function(i){
                      return i.idade;
                      }).reduce(function(a,b){return a.idade + b.idade;});
soma;*/
var soma = pessoa.map(function(i){
                      return i.idade;
                      }).reduce(function(a,b){return a + b;});
soma;

//Criando classes no JavaScript
function Elfo(nome, flechas){
    this.nome = nome;
    this.flechas = flechas;
};

var legolas = new Elfo("Legolas", 42);

legolas.nome;

function Elfo(nome, flechas){
    this.nome = nome;
    this.flechas = flechas || 42;
    this.experiencia = 0;
    
    this.atirarFLechas = function(){
        this.flechas--;
        this.experiencia++;
    }
};

function Elfo (options) {
    options = options || {};
    
    this.nome = nome;
    this.flechas = flechas || 42;
    this.experiencia = 0;
    
    this.atirarFLechas = function(){
        this.flechas--;
        this.experiencia++;
    }
};