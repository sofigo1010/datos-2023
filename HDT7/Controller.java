/**
 * @author Sofia Garcia
 * Folder: HDT7
 * Archivo: Controller.java
 * Fecha: 25/03/2023
 */

public class Controller {
    View vista = new View();
    boolean translate = true;
    BiTree<Compare<String,String[]>> traductor = new BiTree<>();
    int inicial = 0;
    int deseado = 0;
    int opcion = 0;


    public void translator (){
        while (translate == true){
            opcion = vista.accion();
            
            if (opcion == 1){
                String diccionario = vista.inicioescogerdiccionario();
                String textoatraducir = vista.iniciotextoatraducir();
                int posicionKey = vista.seleccionaridiomaog() - 1;
                int posicionvalor = vista.seleccionaridiomasiguiente() -1;
                if (posicionKey >= 0 && posicionKey <= 2 ){
                    if (posicionvalor >= 0 && posicionvalor <= 2){
                        traductor = Read.crearArbolTraduccion(diccionario,posicionKey, traductor);
                        String textoinicial = Read.leerTexto(textoatraducir);
                        String traducido = traducirTexto(textoinicial, posicionKey, posicionvalor);
                        traductor.inOrderTraversal(traductor);
                        String asociacionesdelarbol = traductor.getInOrder();
                        vista.resultados(textoinicial, traducido, asociacionesdelarbol);
                    }
                }
                else{
                    vista.error();
                }

            }
            else if (opcion == 2){
                vista.mensajededespedida();
                translate = false;
                break;
            }
            else{
                vista.error();
            }
        
        }
    }
    
    /**
    Este método recibe un texto y dos índices de idioma (inicial y deseado), y devuelve
    el texto traducido al idioma deseado, utilizando un árbol binario de búsqueda que almacena
    las palabras y sus traducciones.
    @param texto el texto a traducir
    @param inicial el índice del idioma inicial del texto
    @param deseado el índice del idioma deseado para la traducción
    @return el texto traducido al idioma deseado
    */
    public String traducirTexto(String texto, int inicial, int deseado){
        String textoResultante = "";
        String[] textoCortado = texto.split(" ");
        for(String palabra:textoCortado){
            Compare nodePalabra = new Compare<>(palabra);
            if(traductor.contains(nodePalabra)){
                String[] valores = (String[]) traductor.get(nodePalabra).getValue();
                textoResultante+= valores[deseado]+" ";
                continue;
            }else{
                textoResultante+="*"+palabra+"* ";
            }
        }
        return textoResultante;
    }

}