import java.util.ArrayList;

public class Arbol {
    private ArrayList<Node> roots; // Lista de raíces del árbol

    public Arbol() {
        this.roots = new ArrayList<>();
    }

    /**
     * Inserta una palabra en el árbol.
     * 
     * @param palabra Palabra a insertar.
     */
    public void add(String palabra) {
        if (palabra == null || palabra.isEmpty()) {
            return; // No se inserta nada si la palabra es vacía
        }

        char firstChar = palabra.charAt(0);
        Node root = findOrCreateRoot(firstChar);

        // Insertar el resto de la palabra en el nodo raíz correspondiente
        root.add(palabra, 1);
    }

    /**
     * Busca una raíz con el carácter dado o la crea si no existe.
     * 
     * @param firstChar Carácter inicial de la palabra.
     * @return Nodo raíz correspondiente.
     */
    private Node findOrCreateRoot(char firstChar) {
        for (Node root : roots) {
            if (root.getValue() == firstChar) {
                return root; // Raíz encontrada
            }
        }

        // Crear una nueva raíz si no existe
        Node newRoot = new Node(firstChar);
        roots.add(newRoot);
        ordenarRaices(); // Mantener las raíces en orden alfabético
        return newRoot;
    }

    /**
     * Ordena las raíces en orden alfabético.
     */
    private void ordenarRaices() {
        roots.sort((a, b) -> Character.compare(a.getValue(), b.getValue()));
    }

    /**
     * Imprime el árbol en preorden.
     */
    public void printPreOrder() {
        if (roots.isEmpty()) {
            System.out.println("El árbol está vacío.");
        } else {
            for (Node root : roots) {
                root.printPreOrder("");
            }
        }
    }
}
