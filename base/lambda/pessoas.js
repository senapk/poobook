// pessoas.js
class Pessoa{
    constructor(nome, idade){
        this.nome = nome;
        this.idade = idade;
    }
}

let pessoas = [new Pessoa("David", 15), new Pessoa("Carla", 20), 
               new Pessoa("Elias", 12), new Pessoa("Amora", 10), 
               new Pessoa("Celia", 13), new Pessoa("Josue", 30)]


// Opção 1, mas não recomendado
let nomes = []
for (let i = 0; i < pessoas.length; i++)
    if(pessoas[i].idade < 18)
        nomes.push(pessoas[i].nome);
        
        // Opção 2
nomes = pessoas.filter(pessoa => pessoa.idade < 18)
               .map(pessoa => pessoa.nome)
        
console.log(nomes)
