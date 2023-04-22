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
