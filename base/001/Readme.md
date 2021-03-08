# Lambda, stream, e classes anônimas
<!--TOC_BEGIN-->
- [Referências](#referências)
- [Funções lambda](#funções-lambda)
- [Criando como variável](#criando-como-variável)
- [Filtrando e Mapeando](#filtrando-e-mapeando)
    - [Python](#python)
    - [JS](#js)
    - [Java](#java)
- [Mais exemplos em java from deviniciative ref](#mais-exemplos-em-java-from-deviniciative-ref)
    - [Lambda explícitos](#lambda-explícitos)
    - [Lambda Implícitos](#lambda-implícitos)
    - [Mostrando os tipos](#mostrando-os-tipos)
- [Classes anônimas e funções Lambda](#classes-anônimas-e-funções-lambda)
    - [Exemplo do rinaldo.dev sobre o SAM](#exemplo-do-rinaldodev-sobre-o-sam)
- [Mais sobre Streams from infoq](#mais-sobre-streams-from-infoq)
    - [Iniciando uma stream](#iniciando-uma-stream)
    - [Operações de finalização de Stream](#operações-de-finalização-de-stream)
    - [Mais exemplos](#mais-exemplos)
<!--TOC_END-->

## Referências
- [tecsinapse](https://blog.tecsinapse.com.br/stream-api-e-fun%C3%A7%C3%B5es-lambda-no-java-8-9941e8ae95d8)
- [deviniciative](https://deviniciative.wordpress.com/2019/07/02/jdk-11-entendendo-um-pouco-mais-expressoes-lambda/)
- [triadworks](http://blog.triadworks.com.br/lambda-lambda-lambda-java)
- [devmedia](https://www.devmedia.com.br/como-usar-funcoes-lambda-em-java/32826)
- [rinaldo.dev](https://rinaldo.dev/java-8-entenda-facilmente-funcoes-lambda-a-principal-novidade/)
- [infoq](https://www.infoq.com/br/articles/java8-desmistificando-lambdas/)

## Funções lambda
- São funções de primeira ordem
    - Podem ser criadas, armazenadas e passadas por parâmetro como outras variáveis.
- Tem visibilidade diferente das funções normais
    - Tem acesso às variáveis do escopo
- Muito utilizado em padrões de projeto, interface gráfica e métodos funcionais.
- Em Java, ele permite o uso de interface com apenas um método como uma invocação de funções.

## Criando como variável

Javascript
```js
let fn = (x) => x * 3 + 1;
console.log(fn(2)) //7
```

```java
Function<Integer, Integer> function = (x) -> x * 3 + 1;
System.out.print(function.apply(2));
```

## Filtrando e Mapeando
- Dado uma lista de pessoas, faça uma lista com o nome dos que são menores de idade e imprima.

***
### Python
<!--ADD pessoas.py py-->
```py
# pessoas.py
from typing import List

class Pessoa:
    def __init__(self, nome, idade):
        self.nome = nome
        self.idade = idade

pessoas: List[Pessoa] = [Pessoa("David", 15), Pessoa("Carla", 20), 
           Pessoa("Elias", 12), Pessoa("Amora", 10), 
           Pessoa("Celia", 13), Pessoa("Josue", 30)]

# Usando programação interativa
nomes: List[str] = []
for pessoa in pessoas:
    if pessoa.idade < 18: # filtragem
        nomes.append(pessoa.nome) # mapeamento
print(nomes)

# Usando Listas de Compreensão
print([pessoa.nome for pessoa in pessoas if pessoa.idade > 18])
```
<!--ADD_END-->

***
### JS
<!--ADD pessoas.js js-->
```js
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
```
<!--ADD_END-->

***
### Java
<!--ADD Pessoa.java java-->
```java
// Pessoa.java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Pessoa{
    String nome;
    int idade;
    Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public static void main(String[] args) {
        List<Pessoa> pessoas = Arrays.asList(
            new Pessoa("David", 15), new Pessoa("Carla", 20), 
            new Pessoa("Elias", 12), new Pessoa("Amora", 10), 
            new Pessoa("Celia", 13), new Pessoa("Josue", 30));


        // Opção 1
        List<String> nomes = new ArrayList<>();
        for (Pessoa pessoa : pessoas)
            if(pessoa.idade < 18)
                nomes.add(pessoa.nome);
        
        System.out.println(nomes);

        // Opção 2
        nomes = pessoas.stream()
               .filter(pessoa->(pessoa.idade > 18))
               .map(pessoa->(pessoa.nome))
               .collect(Collectors.toList());

        System.out.println(nomes);
    }
}
```
<!--ADD_END-->



## Mais exemplos em java from deviniciative ref
### Lambda explícitos
```java
(Integer idade) -> idade > 10; //Entrada é um inteiro e devolve um booleano
 
(Integer idade) -> idade >10? "Criança" : "Não é Criança"; //Entrada é um inteiro e devolve uma String
 
(Integer idade) -> {System.out.println(idade);}; //Entrega é Inteiro, saída é um void
 
() -> {return Math.random() + "Number";}; //Sem Entrada, e devolve String
 
(String nome, List<Pessoa> list) -> {
    return list.stream()
               .filter(e -> e.getNome().startsWith(nome))
               .map(Pessoa::getIdade)
               .findFirst();
};
// Entrada é uma string e uma lista de Pessoa, e o retorno é um Optional<Integer>            

```
### Lambda Implícitos

```java
(idade) -> idade > 10; 
 
(idade) -> idade >10? "Criança" : "Não é Criança"; 
 
idade -> {System.out.println();}; 
() -> {return Math.random() + "Number";}; 
 
(nome, list) -> {
    return (
        list.stream()
            .filter(e -> e.getNome().startsWith(nome))
            .map(Pessoa::getIdade)
            .findFirst()
    );
};
```

### Mostrando os tipos

Normalmente, você não vai criar e salvar as funções, mas passá-las por parâmetro diretamente. Então não vai precisar definir os tipos para armazená-las.

```java
public class TesteLambda {
 
    Predicate<Integer> predicate = (Integer idade) -> idade > 10;
    Function<Integer, String> function = (Integer idade) -> idade > 10? "Criança" : "Não é Criança";
    Consumer<Integer> consumer = (Integer idade) -> {System.out.println();};
    Supplier<String> supplier = () -> { return Math.random() + "Numero:";};
    BiFunction<String, List<Pessoa>, Optional<Integer>> primeiroElemento = (String nome, List<Pessoa> lista) -> { 
        return (
            lista.stream()
                 .filter(e -> e.getNome().startsWith(nome))
                 .map(Pessoa::getIdade)
                 .findFirst()
        );
    };
}
```

## Classes anônimas e funções Lambda

É possível implementar interfaces ou sobrescrever métodos de classes em novas classes sem precisar criar uma nova classe "nomeada" para isso. Seja o seguinte exemplo.

<!--ADD Anonima.java java-->
```java
// interface Assalariado{
//     public String trabalhar();
// }

// class Operario implements Assalariado{
//     public String trabalhar() {
//         return "vamos pra labuta";
//     }
// }

// public class Anonima{

//     public static void enviarParaJornada(Assalariado trabalhador){
//         System.out.println(trabalhador.trabalhar());
//     }
//     public static void main(String[] args) {
        
//         Assalariado rapido = new Assalariado(){
//             public String trabalhar() {
//                 return "eh pra jah";
//             }
//         };
//         enviarParaJornada(rapido);
        

//         Assalariado soldado = new Operario(){
//             public String trabalhar() {
//                 return super.trabalhar() + " sim Senhor!";
//             }
//         };
//         enviarParaJornada(soldado);  
    
        
//         enviarParaJornada(()->("tô esperando a coragem chegar"));
//     }
    
// }
```
<!--ADD_END-->


### Exemplo do rinaldo.dev sobre o SAM

Imprima o dobro do 7 primeiros números pares. Primeiro utilizando operações funcionais.
```java
public static void main(String[] args) {
	List<Integer> lista = Arrays.asList(1,5,8,7,4,6,3,2,1,8,5,7,4);
	lista.stream()
		.limit(7)
		.filter(e -> e % 2 == 0)
		.map(e -> e * 2)
		.forEach(System.out::println);
}
```

O que o java faz por baixo dos panos:

```java
public static void main(String[] args) {
	List<Integer> lista = Arrays.asList(1, 5, 8, 7, 4, 6, 3, 2, 1, 8, 5, 7, 4);
	Stream<Integer> limit = lista.stream().limit(7);
	// nunca escreva um código assim!
	Stream<Integer> filter = limit.filter(new Predicate<Integer>() {
		@Override
		public boolean test(Integer e) {
			return e % 2 == 0;
		}
	});
	Stream<Integer> map = filter.map(new Function<Integer, Integer>() {
		@Override
		public Integer apply(Integer e) {
			return e * 2;
		}
	});
	map.forEach(new Consumer<Integer>() {
		@Override
		public void accept(Integer t) {
			System.out.println(t);
		}
	});
}
```

## Mais sobre Streams from infoq

### Iniciando uma stream
Há diversas formas de obter um Stream. Muitos métodos estão sendo adicionados a API de Collection (usando a extensão de métodos nas interfaces).

Através de uma List, Set, ou Map.Entry é possível chamar um método de Stream que retorna uma Stream com o conteúdo da coleção.

Um exemplo é o método stream(), ou parallelStream(), que internamente a biblioteca usa o framework de fork/join para decompor as ações em diversas subtarefas.

Existem várias outras maneira de iniciar uma stream.

### Operações de finalização de Stream

Depois de encadearmos todos esses streams, podemos especificar uma operação de finalização para executar as pipeline e todas as operações (sequencialmente ou em paralelo) e produzir os resultados finais (ou efeitos colaterais).

```java
int sum = transactions.stream().
    filter(t -> t.getBuyer().getCity().equals("London")). //Lazy
    mapToInt(Transaction::getPrice). //Lazy
    sum(); //Executa o pipeline
```


### Mais exemplos
Exemplo 1. Converter palavras para maiúsculo:
```java
List<String> output = wordList.stream().
// Mapa de toda a lista de String em maiúsculo.
map(String::toUpperCase).
// Converte o stream para uma lista.
collect(Collectors.toList());
```

Exemplo 2. Procurar as palavras com tamanho par na lista:
```java
List<String> output = wordList.stream().
//Seleciona somente as palavras com tamanho par.
filter(w -> (w.length() % 2 == 0). 
collect(Collectors.toList());
```

Exemplo 3. Contar as linhas de um arquivo:
```java
  long count = bufferedReader.
  // Recebe um stream com linhas individuais. Esse é o novo método do
  // bufferedReader que retorna um stream<string>.
  lines(). 
  // Conta os elementos do stream de entrada.
  count();
```

Exemplo 4. Juntar as linhas 3 e 4 em uma única String:
```java
String output = bufferedReader.lines().
// Pula as duas primeiras linhas.
skip(2).
// limita a stream a apenas as próximas duas linhas.
limit(2).
// Concatena as linhas.
collect(Collectors.joining()); 
```

Exemplo 5. Encontrar o tamanho da linha mais longa em um arquivo:
```java
int longest = reader.lines().
mapToInt(String::length).
// Cria uma novo Stream com o tamanhos das Strings mapeando
// a atual String ao tamanho correspondente.
max().
// Coleta o maior elemento do stream de tamanho (como uma OptionalInt).
getAsInt();
// Atualiza o OptionalInt com um int.
```