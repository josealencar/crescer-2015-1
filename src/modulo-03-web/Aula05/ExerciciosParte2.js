//Lista de Exercícios JS parte 2
//Exercício 01
var brewdog = function(a, b){
    var array1 = a.split('');
    var array2 = b.split('');
    var contador = 0;
    var len = Math.min(array1.length, array2.length);
    for (var i = 0; i < len; i ++){
        var teste1 = array1[i];
        var teste2 = array2[i];
        if (teste1 === teste2){
            contador = contador + 1;
        }
    }
    var retorno = Math.max(array1.length, array2.length) - contador;
    return retorno;
};

//Exercício 02
//Exercício 2A
function Emprestimo(valorTotal, taxaJuros, quantidadeParcelas){
    quantidadeParcelas = quantidadeParcelas || 3;
    
    this.valorTotal = valorTotal;
    this.taxaJuros = taxaJuros;
    this.quantidadeParcelas = quantidadeParcelas;
};

//Exercício 2B
function Emprestimo(valorTotal, taxaJuros, quantidadeParcelas){
    quantidadeParcelas = quantidadeParcelas || 3;
    
    this.valorTotal = valorTotal;
    this.taxaJuros = taxaJuros;
    this.quantidadeParcelas = quantidadeParcelas;
    
    this.valorParcela = function(){
        var valor = valorTotal / ((1 - (Math.pow((1+taxaJuros), -quantidadeParcelas))) / taxaJuros);
        return valor.toFixed(2);
    }
};

//Exercício 2C
function Emprestimo(valorTotal, taxaJuros, quantidadeParcelas){
    //quantidadeParcelas = quantidadeParcelas || 3;
    
    this.valorTotal = valorTotal;
    this.taxaJuros = taxaJuros;
    this.quantidadeParcelas = quantidadeParcelas || 3;
    
    this.valorParcela = function(){
        var valor = this.valorTotal / ((1 - (Math.pow((1+this.taxaJuros), -this.quantidadeParcelas))) / this.taxaJuros);
        return Math.round(valor*100)/100;
    }
    
    this.valorTotalJuros = function(){
        var valor = this.valorParcela() * this.quantidadeParcelas - this.valorTotal;
        return Math.round(valor*100)/100;
    }
};

//Exercício 03
function palindromo(String){
    var ePalindromo = false;
    var palavras = ['iluminatti','ledesma','dante','verdemusgo','bacon'];
    var er = /[@$1234567890©`´~!@#$%^&*()_|+\-=?;:'",.<>\{\}\[\]\\\/]/gi;
    var comparar = String.replace(/\s/gi,'');
    comparar = comparar.replace(er,'');
	comparar = comparar.replace(/[âáàã]/gi,"a");
	comparar = comparar.replace(/[éèê]/gi,"e");
	comparar = comparar.replace(/[íìî]/gi,"i");
	comparar = comparar.replace(/[ôõóò]/gi,"o");
	comparar = comparar.replace(/[úùû]/gi,"u");
	comparar = comparar.replace("ç","c");
    comparar = comparar.toLowerCase();
    var teste = palavras.indexOf(comparar);
    if (teste != -1){
        ePalindromo = true;
    }
    var testar = comparar.split('').reverse().join('');
    if(comparar === testar){
        ePalindromo = true;
    }
    return ePalindromo;
};