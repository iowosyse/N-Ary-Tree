import utilidades.*;

public class Main {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        int opt = -2;

        /*// Insertar palabras
        arbol.add("celebridad");
        arbol.add("raiz");
        arbol.add("ramo");
        arbol.add("rata");
        arbol.add("ranura");
        arbol.add("zionga");
        arbol.add("zapato");
        arbol.add("zapatilla");
        arbol.add("gaby");
        arbol.add("girasol");
        arbol.add("girar");
        arbol.add("garbanzos");
        arbol.add("azucar");
        arbol.add("arido");
        arbol.add("celerina");
        arbol.add("celcius");
        arbol.add("cande");
        arbol.add("naco y estupido");
        arbol.add("cepillin");
        arbol.add("sacate");
        arbol.add("sombria");
        arbol.add("sergio");
        arbol.add("seguridad");
        arbol.add("narciso");
        arbol.add("nanosegundos");
        arbol.add("cepillos"); */


        do {
            System.out.println("1. Insertar\n0. Salir");
            opt = ConsoleReader.readInteger();

            if (opt == 1) {
                System.out.println("Inserte la cadena a insertar");
                String inputString = ConsoleReader.readString();

                arbol.add(inputString);
            } else if (opt == 0) {
                System.out.println("uwu");
            } else {
                System.out.println("No.");
            }
        } while (opt != 0);

        // Imprimir el árbol
        arbol.printPreOrder();
    }
}