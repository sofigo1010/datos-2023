public class Controller {
    View vista = new View();






    BiTree<Compare<String,String[]>> traductor = new BiTree<>();
    int inicial = 0;
    int deseado = 0;
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
            }else{
                textoResultante+="*"+palabra+"* ";
            }
        }
        return textoResultante;
    }
    
}
