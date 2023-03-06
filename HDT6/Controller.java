/**
 * @author Sofia Garcia
 * Folder: HDT6
 * Archivo: Controller.java
 * Fecha: 05/03/2023
 */

import java.util.Map;

public class Controller {
    View vista = new View();
    int choice;
    int choice2;
    Read reads = new Read();
    Map<Integer, Producto> inventario;
    Map<Integer, Producto> carritodecompras;
    boolean start = true;
    Productmanager manager = new Productmanager();
    
    public void supermercado(){
        choice = vista.menumaps();
        inventario = MapFactory.crearmapa(choice);
        carritodecompras = MapFactory.crearmapa(choice);
        reads.getinventory(inventario, "ListadoProducto (2).txt");
        while (start == true){
            choice2 = vista.menusupermercado();
            if (choice2 == 1){
                //agregar al carrito
                String nombre = vista.nombreproductnuevo();
                String categoria =vista.categoriaproductonuevo();
                int cantidad = vista.cantidadproductonuevo();
                boolean encontrado = false;
                for (Map.Entry<Integer, Producto> entry : inventario.entrySet()) {
                    Producto producto = entry.getValue();
                    if (producto.getNombre().equals(nombre) && producto.getCategoria().equals(categoria)) {
                        manager.agregaralcarrito(carritodecompras, nombre, categoria, cantidad);
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    vista.noencuentro();;
                }
            }

            else if (choice2 == 2){
                //Ver la categoría de un producto
                String producto = vista.nombreproductnuevo();
                vista.vercategoriaproducto(manager.buscarCategoriaPorNombre(inventario, producto));;
                
            }
            else if (choice2 == 3){
                //ver los productos del carrito
                vista.verproduscarrito(manager.vertodoslositemsendesorden(carritodecompras));
            }
            else if (choice2 == 4){
                //ver los productos del carrito ordenados
                vista.verproduscarrito(manager.obtenerProductosOrdenadosPorCategoria(carritodecompras));
                
            }
            else if (choice2 == 5){
                //ver todos los productos del inventario
                vista.verproductosinventario(manager.vertodoslositemsendesorden(inventario));
                
            }
            else if (choice2 == 6){
                //ver todos los productos del inventario ordenados
                vista.verproductosinventario(manager.obtenerProductosOrdenadosPorCategoria(inventario));
            }
            else if (choice2 == 7){
                //salir
                vista.adios();
                start = false;
    
            }
            else{
                vista.error();
                
            }

        }

    }
}
