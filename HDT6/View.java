/**
 * @author Sofia Garcia
 * Folder: HDT6
 * Archivo: View.java
 * Fecha: 05/03/2023
 */

import java.util.Scanner;

public class View {
    int respuesta; 
    Scanner sc = new Scanner(System.in);
    String respuesta2;
    
    /** menú inicial para escoger el tipo de mapa a utilizar 
     * 
     * @return int
     */
    public int menumaps (){
        System.out.println("Bienvenido al SuperMercado Enchilada Nicolita!\n\n\nCon qué tipo de Mapa desea visualizar el inventario?\n1.HashMap\n2. TreeMap\n3. LinkedHashMap\nIngrese el número de índice: ");
        respuesta = sc.nextInt();
        return respuesta;
    }
    
    /** Opciones del menu 
     * @return int
     */
    public int menusupermercado(){
        System.out.println("\t\t\t\t\t\tSUPERMERCADO ENCHILADA NICOLITA\n\nQué desea hacer?\n1. Agregar un producto a su carrito de compras\n2. Ver la categoría de un producto\n3. Ver los datos de los productos en su carrito\n4. Ver los datos de los productos en su carrito ordenados por categoría\n5. Ver todos los productos y categorías del inventario\n6. Ver todos los productos y categorías del inventario ordenados por tipo\n7. Salir del programa\n\nIngrese el número de índice");
        respuesta = sc.nextInt();
        return respuesta;
    }

    
    /** ingresar la categoria de un producto que quiere agregar a su carrito de compras
     * @return String
     */
    public String categoriaproductonuevo(){
        System.out.println("Ingresa la categoría del producto");
        respuesta2 = sc.next();
        return respuesta2;
    }

    
    /** ingresar el nombre de un producto que quiere agregar a su carrito de compras
     * @return String
     */
    public String nombreproductnuevo(){
        System.out.println("Ingresa el nombre del producto");
        respuesta2 = sc.next();
        respuesta2 += sc.nextLine();
        return respuesta2;
    }

    
    /** ingresar la cantidad de un producto que quiere agregar a su carrito de compras
     * @return int
     */
    public int cantidadproductonuevo(){
        System.out.println("Ingresa la cantidad del producto que deseas agregar a tu carrito");
        int respuesta = sc.nextInt();
        return respuesta;
    }

    /** 
     * mensaje a imprimir en caso de que no se encuentre el producto que quiere agregar
     */
    public void noencuentro(){
        System.out.println("No se encontró un producto con ese nombre y categoría en el inventario");
    }


    

}
