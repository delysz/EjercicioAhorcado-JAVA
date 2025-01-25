package juegoahorcado;

import java.util.Arrays;
import java.util.Scanner;

/*Ejercicio 13. Juego del ahorcado. Las reglas son las siguientes:
a) Un primer jugador teclea una palabra 
b) Se muestran tantos guiones como letras tenga la palabra secreta 
c) Otro jugador intenta acertar, letra a letra, la palabra secreta. 
d) Cada acierto muestra la letra en su lugar y las letras no acertadas seguirán siendo guiones. 
e) El jugador solo tiene 7 intentos 
f) La partida terminará al acertar todas las letras o cuando se agoten todos los intentos.*/

public class ahorcado {
    public static void main(String[] args) {
    int contador = 7;
    Scanner sc = new Scanner(System.in);
    boolean finDelJuego = false;
    System.out.println("Jugador 1, introduce una palabra que sera la que forme parte del juego");
    String palabra = sc.nextLine();
    palabra=palabra.toUpperCase();

        for (int i = 0; i < 33; i++) { // Establezco un for para borrar la pantalla y 
        System.out.println();           //que el jugador 2 no pueda ver la palabra escrita por el jugador 1
        }
        
    char [] arrayDeLetras = palabra.toCharArray();
    char [] arrayDeGuiones = new char [arrayDeLetras.length];
        for (int i = 0; i < arrayDeLetras.length ; i++) {
            arrayDeGuiones[i] = '-';
        }
    
    System.out.println("Jugador 2, es tu turno. Intenta adivinar la palabra del jugador 1");
        while (finDelJuego == false) {
            System.out.print("Tienes " +contador+ " intentos y la palabra es : ");
            System.out.println(arrayDeGuiones);
            System.out.println("Introduce una letra");
            char letra;
            letra = sc.next().charAt(0);
            
            if (Character.isLetter(letra)==false) {
                do {
                    System.out.println("Por favor introduce unicamente una letra");
                    letra = sc.next().charAt(0);
                }
                while (Character.isLetter(letra)==false);
            }
            
            letra=Character.toUpperCase(letra);
            boolean hayAcierto = false;
                for (int i = 0; i < arrayDeLetras.length; i++) {              
                    if (arrayDeLetras[i]==letra) {
                        arrayDeGuiones[i] = letra;
                        hayAcierto=true;
                        if (Arrays.equals(arrayDeLetras, arrayDeGuiones)) {
                            finDelJuego= true;
                            System.out.println("¡¡Enhorabuena, has ganado!! La palabra era : "+palabra);
                            }
                    }
                }
                
                if(hayAcierto==false){
                    contador--;
                    System.out.println("LETRA FALLADA");
                    if (contador==0) {
                        finDelJuego= true;
                        System.out.println("Lo siento, has perdido");
                    }
                }
        }
    }
}