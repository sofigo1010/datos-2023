import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Tomado de referencia del libro Java Structure y el proporcionado por el catedratico
 * @param <E>
 */

 public class BiTree<E extends Comparable<E>> {

    E value;
    BiTree<E> left, right;
    String orden = "";

    /**
    Crea un nuevo árbol binario con el valor dado, y los subárboles dados.
    @param VALUE el valor que se almacena en el nodo actual.
    @param lefty el subárbol izquierdo del nodo actual.
    @param righty el subárbol derecho del nodo actual.
    */
    public BiTree(E VALUE, BiTree<E> lefty, BiTree<E> righty){
        value = VALUE;
        left = lefty;
        right = righty;
    }

    public BiTree(){
        this(null,null,null);
    }

    /** 
     * Verifica si el árbol contiene el elemento dado.
     * @param value el elemento que se busca en el árbol.
     * @return true si el árbol contiene el elemento, false si no lo contiene.
     */
    public boolean contains (E value){
        BiTree<E> a = (locate(this, value));
        if(a.getValue() == null){
            return false;
        }
        if(value.compareTo(a.getValue()) < 0){
            return false;
        }else{
            return true;
        }
    }

    /**
     * Retorna el recorrido inOrder del árbol.
     * @return un string que representa el recorrido inOrder del árbol.
     */
    public String getInOrder(){
        return orden;
    }

    /**
     * Inserta un elemento en el árbol.
     * @param value el elemento que se desea insertar.
     */
    public void insert (E value){
        if (this.value == null) {
            Compare a = (Compare) value;
            this.value = value;
        }
        else{
            BiTree<E> selectedTree = locate(this, value);
            if (selectedTree.getValue() == null)
                selectedTree.setValue(value);
        }
    }

    /**
     * Retorna el elemento del árbol que es igual al elemento dado.
     * @param value el elemento que se busca en el árbol.
     * @return el elemento del árbol que es igual al elemento dado, o null si no se encuentra.
     */
    public E get(E value){
        BiTree<E> possibleLocation = locate(this, value);
        if(value.equals(possibleLocation.getValue())){
            return possibleLocation.getValue();
        }
        else
            return null;
    }

    /**
     * Retorna el nodo del árbol que contiene el elemento dado.
     * @param root el nodo raíz del subárbol que se va a buscar.
     * @param value el elemento que se busca en el árbol.
     * @return el nodo del árbol que contiene el elemento dado, o el nodo donde debería estar si no se encuentra.
     */
    private BiTree<E> locate (BiTree<E> root, E value) {
        E rootValue = root.getValue();
        BiTree<E> selectedTree;
        if(rootValue == null)
            return root;
        if(rootValue.equals(value))
            return root;
        if(value.compareTo(rootValue) < 0)
            selectedTree = root.getLeft();
        else
            selectedTree = root.getRight();

        if(selectedTree.getValue() == null)
            return selectedTree;
        else if (selectedTree.getValue().equals(value))
            return selectedTree;
        else
            return locate(selectedTree, value);
    }

    /**
     * Devuelve el valor almacenado en el nodo actual.
     * @return el valor almacenado en el nodo actual.
     */
    public E getValue(){
        return value;
    }

    /**
     * Establece el valor almacenado en el nodo actual.
     * @param newValue el nuevo valor que se va a establecer en el nodo actual.
     */
    public void setValue(E newValue){
        value = newValue;
    }

    /**
     * Devuelve el subárbol izquierdo del nodo actual.
     * Si el subárbol izquierdo no existe, crea un nuevo árbol binario vacío y lo devuelve.
     * @return el subárbol izquierdo del nodo actual.
     */
    public BiTree<E> getLeft() {
        if (this.left == null) 
            this.left = new BiTree<>();
        return this.left;
    }


    /**
     * Devuelve el subárbol derecho del nodo actual.
     * Si el subárbol derecho no existe, crea un nuevo árbol binario vacío y lo devuelve.
     * @return el subárbol derecho del nodo actual.
     */
    public BiTree<E> getRight() {
        if(this.right == null) // If it is not created, create it.
            this.right = new BiTree<>();
        return right;
    }

    /**
     * Recorre el árbol binario en orden y devuelve un string con los valores ordenados.
     * @param root el nodo raíz del árbol binario que se quiere recorrer en orden.
     */
    public void inOrderTraversal(BiTree<E> root) {
        if (root == null || root.getValue() == null) {
            return;
        }
        inOrderTraversal(root.getLeft());
        orden+=root.getValue();
        inOrderTraversal(root.getRight());
    }

    /** 
     * @param fileRoute
     * @param key
     * @param arbolT
     * @return ArbolBinario<ComparablePalabra<String, String[]>>
     */
    public static BiTree<Compare<String,String[]>> crearArbolTraduccion(String fileRoute, int key, BiTree<Compare<String,String[]>> arbolT){
        FileReader arr;
        BufferedReader reader;
        try {
            arr = new FileReader(fileRoute);
            if (arr.ready()) {
                reader = new BufferedReader(arr); // read the file
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] palabras = line.split(",");
                    Compare<String, String[]> nuevaPalabra = new Compare<>(palabras[key].trim(),palabras);
                    arbolT.insert(new Compare<String, String[]>(palabras[key].trim(),palabras));
                }
                return arbolT;
            } else {
                throw new RuntimeException("File route doesn't exist");
            }
        } catch (Exception e) {
            throw new RuntimeException("Unexpected Error: "+e);
        }
    }
}