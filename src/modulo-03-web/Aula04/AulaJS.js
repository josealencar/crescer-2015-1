alert("Hello World!");
undefined
var s = 12;
undefined
typeof s;
"number"
s = "nome";
"nome"
typeof s;
"string"
s = 12;
12
s + 12;
24
1 + 2 + "3";
"33"
"1" + 2 + 3;
"123"
var y;
undefined
y === undefined;
true
typeof y;
"undefined"
typeof y === undefined;
false
typeof y === "undefined";
true
typeof parseInt("123");
"number"
1 / 0;
Infinity
-1 / 0;
-Infinity
"ahsuash" / "suahsus";
NaN
isNaN("auhsauhs" / "aisjasij");
true
"Jose".length;
4
"Jose".charAt(2);
"s"
"Kelvin Spacey".replace("Spacey", "Bacon");
"Kelvin Bacon"
"Kelvin Spacey".replace("Spacey", "Bacon").toUpperCase();
"KELVIN BACON"

VM820:2 Uncaught SyntaxError: Unexpected token {InjectedScript._evaluateOn @ VM171:883InjectedScript._evaluateAndWrap @ VM171:816InjectedScript.evaluate @ VM171:682
var pessoa = {};
undefined
typeof pessoa;
"object"
pessoa.nome = "Jose";
"Jose"
pessoa
Object {nome: "Jose"}
delete pessoa.nome;
true
pessoa;
Object {}
pessoa.nome = "Jose";
"Jose"
pessoa["nome"];
"Jose"
pessoa.nome;
"Jose"
pessoa.jose esta na aula = true;
VM1106:2 Uncaught SyntaxError: Unexpected identifierInjectedScript._evaluateOn @ VM171:883InjectedScript._evaluateAndWrap @ VM171:816InjectedScript.evaluate @ VM171:682
pessoa["jose esta na aula"] = true;
true
pessoa
Object {nome: "Jose", jose esta na aula: true}
var nomes = [{nome: true} {nome: true}];
VM1225:2 Uncaught SyntaxError: Unexpected token {InjectedScript._evaluateOn @ VM171:883InjectedScript._evaluateAndWrap @ VM171:816InjectedScript.evaluate @ VM171:682
var nomes = [{nome: true}; {nome: true}];
VM1226:2 Uncaught SyntaxError: Unexpected token ;InjectedScript._evaluateOn @ VM171:883InjectedScript._evaluateAndWrap @ VM171:816InjectedScript.evaluate @ VM171:682
var nomes = [{nome: true}, {nome: true}];
undefined
nomes.push({nome:false});
3
nomes.length
3
nomes[100] = {nome:false};
Object {nome: false}
nomes.length
101