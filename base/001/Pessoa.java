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
