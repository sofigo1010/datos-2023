/**
 * @author Sofia Garcia
 * Folder: HDT7
 * Archivo: View.java
 * Fecha: 21/04/2023
 */


import java.util.Scanner;

public class View {
    String archivo = "";
    Scanner sc = new Scanner(System.in);

    
    /** 
     * @return String
     */
    public String archivopalabras(){
        System.out.println("\nIngrese la ruta del archivo de su diccionario");
        archivo = sc.nextLine();
        return archivo;
    }

    /** 
     * @return String
     */
    public String archivotextoatraducir(){
        System.out.println("\nIngrese la ruta del archivo que contiene el texto que desea traducir");
        archivo = sc.nextLine();
        return archivo;
    }

    /** 
     * @return String
     */
    public String tipotree(){
        System.out.println("\n\nIngrese si desea utilizar:\n1. RedBlack Tree\n2. AVL Tree\n(ingrese el numero de indice)");
        int choice = sc.nextInt();
        if (choice == 1){
            archivo = "avl";
        }
        else if (choice == 2){
            archivo = "rbt";
        }
        else{
            System.out.println("opcion invalida");
        }
        return archivo;
    }

    public void imprimir (String textotraducido){
        System.out.println("\n\n\nTexto traducido: "+textotraducido);
    }
}
