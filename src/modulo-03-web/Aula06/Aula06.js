String.prototype.toBacon = function() { return this + " BACON!!!"; };
"oi".toBacon();

function Elfo (options) {
    options = options || {};
    
    this.nome = nome;
    this.flechas = flechas || 42;
    this.experiencia = 0;
};

Elfo.prototype.atirarFLechas = function(){
    this.flechas--;
    this.experiencia++;
};

'use strict'; //Restringe "bizarrices"