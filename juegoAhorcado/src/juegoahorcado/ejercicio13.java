
import java.util.Scanner;

public class ejercicio13 {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        //pide palabra y la pone en minusculas para que no sea case sensitive
        System.out.println("Jugador 1 teclea una palabra:");
        String palabraSecreta = teclado.nextLine().toLowerCase();
        //comprueba que la palabra no tenga numeros y solo sea una palabra sin espacios
        while (!comprobarPalabra(palabraSecreta)){
            System.out.println("La palabra no debe tener numeros ni espacios");
            System.out.println("Teclea una palabra:");
            palabraSecreta = teclado.nextLine().toLowerCase();
        }
        //genera los guiones con el tamaño de la palabra
        String guionesPalabra = generaGuiones(palabraSecreta);
        //cambia las cadenas a un array de caracteres para recorrerlo
        char[] palabraArray = palabraSecreta.toCharArray();
        char[] guionesArray = guionesPalabra.toCharArray();
        int intento =7;
        char letra =' ';
        int tamano = palabraSecreta.length();
        boolean ganar =false;
        boolean acertar =false;
        while (intento>0 && !ganar) {
            //actualiza el array de guiones para que despues de la primera iteracion se haya cambiado el guion por la palabra
            guionesArray = guionesPalabra.toCharArray();
            System.out.printf("Palabra: %s INTENTOS:%d\n",guionesPalabra,intento);
            //Si no es una letra despues de la primera iteracion salta un aviso y pierdes un intento
            if (!Character.isLetter(letra) && intento<7) {
                System.out.println("Debe ser UNA LETRA");
            }
            //se muestra el dibujo cuando fallas, esta en un if para que no se ejecute aunque no muestre nada
            if (intento<7) {
                mostrarAhorcado(intento);
            }
            //pide una letra y la pasa a minuscula para que no case sensitive, usa el charAt para que coga la primera letra de la palabra
            System.out.println("Inserta una letra:");
            letra = teclado.next().toLowerCase().charAt(0);
            //recorre la palabra y si se parece a la letra que pide, este cambia un guion por la letra de la palabra para que si se vuelva a escribir la misma letra lo de como fallo
            for (int j = 0; j < palabraArray.length; j++) {
                if(palabraArray[j] == letra){
                    guionesArray[j] = palabraArray[j];
                    palabraArray[j] ='-';
                    //vuelve el array de char en String para mostrarlo
                    guionesPalabra = String.valueOf(guionesArray);
                    acertar =true;
                    //cada vez que se acierta una letra se cuenta cuantas letras quedan por acertar para que si se han acertado todas hayas ganado
                    tamano--;
                    if (tamano == 0) {
                        ganar = true;
                    }
                } 
            }
             //solo se bajan los intentos si fallas porque si la palabra fuese mas larga de siete de letras perderias aunque acertases todas
            if (!acertar) {
                intento--;
            }
            acertar = false;
        }
        if (ganar) {
            System.out.printf("Has ganado! Te quedaban %d intentos, la palabra era: \"%s\"\n",intento,palabraSecreta);
        }else{
            mostrarAhorcado(intento);
            System.out.printf("Has perdido :( la palabra era: \"%s\"\n",palabraSecreta);
        }                
    }
    //comprueba si la palabra solo tenga letras y no tenga espacios
    static boolean comprobarPalabra(String palabra){
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            if (!Character.isLetter(letra) || Character.isSpaceChar(letra) ) {
                return false;
            }
        }
        return true;
    }
    //genera los guiones dependiendo del tamano de la palabra
    static String generaGuiones(String palabra){
        String guionesPalabra = "";
        for (int i = 0; i < palabra.length(); i++) {
            guionesPalabra += "-";
        }
        return guionesPalabra;
    }
    //muestra el dibujo del ahorcado dependiendo de los fallos
    static void mostrarAhorcado(int intento){
        switch(intento){
            case 0->{
                System.out.println("""
                                   ____ 
                                   |  O
                                   | -|-
                                   | /\\
                                   -----
                                   """);
            }
            case 1 ->{
                System.out.println("""
                                   ____ 
                                   |  O
                                   | -|-
                                   | /
                                   -----
                                   """);
            }
            case 2 ->{
                System.out.println("""
                                   ____ 
                                   |  O
                                   | -|-
                                   | 
                                   -----
                                   """);
            }
            case 3 -> {
                System.out.println("""
                                   ____ 
                                   |  O
                                   | -|
                                   | 
                                   -----
                                   """);
            }
            case 4 -> {
                System.out.println("""
                                   ____ 
                                   |  O
                                   |  |
                                   | 
                                   -----
                                   """);
            }
            case 5 -> {
                System.out.println("""
                                   ____ 
                                   |  O
                                   |  
                                   | 
                                   -----
                                   """);
            }
            case 6 -> {
                System.out.println("""
                                   ____ 
                                   |  
                                   |  
                                   | 
                                   -----
                                   """);
            }
        }
    }
}