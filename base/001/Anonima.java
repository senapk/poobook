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