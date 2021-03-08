// Pessoa.java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaisExemplos{


    public static void main(String[] args) {
        List<Pessoa> pessoas = Arrays.asList(
            new Pessoa("David", 15), new Pessoa("Carla", 20), 
            new Pessoa("Elias", 12), new Pessoa("Amora", 10), 
            new Pessoa("Celia", 13), new Pessoa("Josue", 30));


        // Os
        pessoas.stream()
               .filter((pessoa)->(pessoa.idade < 18))
               .map((pessoa)->(pessoa.nome))
               .collect(Collectors.toList());

        System.out.println(nomes);
    }
}
