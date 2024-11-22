import java.util.ArrayList;

public class Node {
    private char value; // Valor del nodo
    private ArrayList<Node> hijos; // Hijos del nodo

    public Node(char value) {
        this.value = value;
        this.hijos = new ArrayList<>();
    }

    public char getValue() {
        return value;
    }

    public ArrayList<Node> getHijos() {
        return hijos;
    }

    /**
     * Inserta una palabra en el árbol.
     * 
     * @param palabra Palabra a insertar.
     * @param index   Índice del carácter actual de la palabra.
     */
    public void add(String palabra, int index) {
        if (index >= palabra.length()) {
            return; // Fin de la palabra
        }

        char currentChar = palabra.charAt(index);
        Node child = findOrCreateChild(currentChar);

        // Continuar la inserción con el siguiente carácter
        child.add(palabra, index + 1);
    }

    /**
     * Verifica si una palabra está contenida en el nodo.
     * 
     * @param palabra Palabra a buscar.
     * @param index   Índice del carácter actual de la palabra.
     * @return true si la palabra está contenida, false en caso contrario.
     */
    public boolean contains(String palabra, int index) {
        if (index >= palabra.length()) {
            return true; // Se procesaron todos los caracteres de la palabra
        }

        char currentChar = palabra.charAt(index);
        Node nextNode = nextChild(currentChar);

        if (nextNode == null) {
            return false; // No se encontró el nodo para el carácter actual
        }

        // Continuar la búsqueda en el siguiente nodo
        return nextNode.contains(palabra, index + 1);
    }
    
    /**
     * Busca un hijo con el carácter dado o lo crea si no existe.
     * 
     * @param currentChar Carácter a buscar o crear.
     * @return El nodo hijo correspondiente.
     */
    private Node findOrCreateChild(char currentChar) {
        for (Node child : hijos) {
            if (child.getValue() == currentChar) {
                return child; // Hijo encontrado
            }
        }

        // Si no existe, crear un nuevo nodo hijo
        Node newChild = new Node(currentChar);
        hijos.add(newChild);
        ordenarHijos(); // Mantener los hijos en orden alfabético
        return newChild;
    }

    /**
     * Busca un hijo con el carácter dado.
     * 
     * @param currentChar Carácter a buscar.
     * @return El nodo hijo correspondiente o null si no existe.
     */
    private Node nextChild(char currentChar) {
        for (Node child : hijos) {
            if (child.getValue() == currentChar) {
                return child;
            }
        }
        return null;
    }

    /**
     * Ordena los hijos en orden alfabético.
     */
    private void ordenarHijos() {
        hijos.sort((a, b) -> Character.compare(a.getValue(), b.getValue()));
    }

    /**
     * Imprime el árbol en preorden.
     * 
     * @param prefix Prefijo para mostrar la jerarquía.
     */
    public void printPreOrder(String prefix) {
        System.out.println(prefix + value);
        for (Node child : hijos) {
            child.printPreOrder(prefix + "-");
        }
    }
}

