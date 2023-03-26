import java.util.Scanner;
/**
 * @author Sofia Garcia
 * Folder: HDT7
 * Archivo: View.java
 * Fecha: 25/03/2023
 */

public class View {
    String answ;
    int answer;
    Scanner sc = new Scanner(System.in);


    
    /** para que escoja si quiere usar el traductor o salir
     * @return int
     */
    public int accion (){
        System.out.println("\n\nBienvenido al traductor enchilada nicolita! Qué desea hacer?\n1) Usar traductor\n2) Salir del programa");
        answer = sc.nextInt();
        return answer;
    }

    /** para recibir la dirección del archivo que contiene las palabras en todos los idiomas
     * @return String
     */
    public String inicioescogerdiccionario (){
        System.out.println("\n\nIngrese la dirección del archivo que contiene el diccionario");
        answ = sc.nextLine();
        
        return answ;
    }

    /** para recibir la dirección del archivo que contiene la oración a traducir
     * @return String
     */
    public String iniciotextoatraducir(){
        System.out.println("\n\nAhora ingrese la dirección del archivo que contiene el texto que desea traducir");
        answ = sc.nextLine();
        answ += sc.next();
        return answ;
    }

    
    /** para seleccionar el idioma en el que esta inicialmente el texto
     * @return int
     */
    public int seleccionaridiomaog(){
        System.out.println("\n\nSeleccione el idioma de su texto original\n1) Ingles\n2) Español\n3) Frances");
        answer = sc.nextInt();
        return answer;
    }

    /** para seleccionar el idioma al que se quiere traducir
     * @return int
     */
    public int seleccionaridiomasiguiente(){
        System.out.println("\n\nSeleccione el idioma al que lo quiere traducir\n1) Ingles\n2) Español\n3) Frances");
        answer = sc.nextInt();
        return answer;
    }
    

    
    /** Para presentar los resultados
     * @param textoinicial
     * @param traducido
     * @param asociaciones
     */
    public void resultados(String textoinicial, String traducido, String asociaciones){
        System.out.println("\n\n\nTexto inicial: " + textoinicial + "\nTexto traducido: " +traducido+ "\n\nAsociaciones del arbol: "+ asociaciones);
    }

    public void mensajededespedida(){
        System.out.println("Hasta luego!");
    }

    public void error(){
        System.out.println("Opcion inválida, intente de nuevo");
    }

}
