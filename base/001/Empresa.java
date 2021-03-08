interface Assalariado{
    public String trabalhar();
}

class Operario implements Assalariado{
    public String trabalhar() {
        return "vou pra labuta";
    }
}

public class Empresa {
    public static void realizarJornada(Assalariado assalariado){
        System.out.println(assalariado.trabalhar());
    }
    public static void main(String[] args) {
        Operario josue = new Operario();
        Empresa.realizarJornada(josue);

        Empresa.realizarJornada(new Assalariado(){
            public String trabalhar() {
                return "trabalhando ligeirinho";
            }
        });

        Assalariado forte = new Assalariado(){
            public String trabalhar() {
                return "trabalhando de com força";
            }
        };
        Empresa.realizarJornada(forte);

        Empresa.realizarJornada(new Operario(){
            public String trabalhar() {
                return super.trabalhar() + " de forma nova";
            }
        });

        Empresa.realizarJornada(() -> ("Lambida"));
        Empresa.realizarJornada(() -> ("Sou um novo trabalhador"));
    }
}
