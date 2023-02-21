/**
 * @author Sofia Garcia
 * Folder: HDT4
 * Archivo: View.java
 * Fecha: 21/02/2023
 */

import java.util.Scanner;

public class View {
    int respuesta;
    int respuesta2;
    String respuesta1;
    Scanner sc = new Scanner(System.in);

    /** 
     * @return int
     */
    public int opcionesiniciales(){
        System.out.println("Bienvenid@ a la calculadora infixposx!\nQue deseas hacer?\n1. Seguir a la calculadora\n2. Salir del programa");
        respuesta = sc.nextInt();
        return respuesta;
    }
    
    /** metodo para poder accesar el archivo con las ecuaciones infix
     * @return String
     */
    public String inicio (){
        System.out.println("Ingresa la direccion del archivo que deseas utilizar para la calculadora\n");
        respuesta1 = sc.next();
        return respuesta1;
    }

    
    /** Para seleccionar el tipo de stack que quiere utilizar 
     * @return int
     */
    public int SeleccionTipoStack (){
        System.out.println("Que tipo de Stack deseas utilizar para resolver tu operacion?\n1. Arraylist Stack \n2. Vector Stack\n3. Listas");
        respuesta = sc.nextInt();
        return respuesta;
    }

    
    /** Si escoge lista, le pregunta que tipo de lista quiere
     * @return int
     */
    public int tipostacklista(){
        System.out.println("Que tipo de lista quieres? \n1. Simplemente encadenada \n2. Doblemente encadenada");
        respuesta = sc.nextInt();
        return respuesta;
    }

    /** 
     * Mensaje de despedida
     */
    public void salida(){
        System.out.println("Hasta luego!");
    }

    /** 
     * Mensaje de respuesta invalida
     */
    public void invalido(){
        System.out.println("Opcion invalida");
    }

    
    /** imprime la expresion original en infix, luego la expresion al ser convertida a postfix y luego el resultado de la ecuacion
     * @param original
     * @param postfix
     * @param valor
     * @param indice
     */
    public void resultado (String original, String postfix, Double valor, int indice){
        indice += 1;
        System.out.println(indice + ". Expresion original: "+ original+ "\nExpresion en postfix: "+ postfix + "\nResultado: "+ valor+"\n\n");

    }

}
