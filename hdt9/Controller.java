/**
 * @author Sofia Garcia
 * Folder: HDT7
 * Archivo: Controller.java
 * Fecha: 21/04/2023
 */

public class Controller {

    View vista = new View();
    boolean translate = true;
    Tree<String, String> tree;
    int opcion = 0;
    String textoatraducir;

    public void translator (){
        String diccionario = vista.archivopalabras();
        String archivoatraducir = vista.archivotextoatraducir();
        String tipodearbol = vista.tipotree();
        tree = TreeFactory.createTree(tipodearbol);
        textoatraducir = Read.leerTexto(archivoatraducir);
        Read.crearArbolTraduccion(diccionario, tree);
        vista.imprimir(translate(textoatraducir));
    }

    /**
    Este método recibe un texto y dos índices de idioma (inicial y deseado), y devuelve
    el texto traducido 
    @param traduce el texto a traducir
    @param result el índice del idioma deseado para la traducción
    @return el texto traducido al idioma deseado
    */
    public String translate(String traduce){
        String result = "";
        String[] textoCortado = traduce.split(" ");
        for (int i = 0; i < textoCortado.length; i ++){
            if (tree.search(textoCortado[i]) != null){
                result += tree.search(textoCortado[i])+ " ";
            }
            else {
                result += " *"+textoCortado[i]+"* ";
            }
        }
        return result;
    }

    
}
