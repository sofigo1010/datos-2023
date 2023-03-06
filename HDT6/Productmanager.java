import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Productmanager {
    
    public Productmanager (){}

    
    /** agrega un producto al carrito
     * @param manager
     * @param name
     * @param category
     * @param amount
     */
    public void agregaralcarrito(Map<Integer, Producto> manager, String name, String category, int amount){
        int indice = manager.size();
        manager.put((indice+1), new Producto(name, category, amount));
    }


    
    /** busca la categoria de un producto
     * @param productos
     * @param nombre
     * @return String
     */
    public String buscarCategoriaPorNombre(Map<Integer, Producto> productos, String nombre) {
        for (Map.Entry<Integer, Producto> entry : productos.entrySet()) {
            Producto producto = entry.getValue();
            if (producto.getNombre().equals(nombre)) {
                return ("\n\nLa categoría del producto "+nombre+" es " + producto.getCategoria());
            }
        }
        return "El producto con nombre '" + nombre + "' no fue encontrado.";
    }


    
    /** regresa el listado de productos ordenados por categoria y orden alfabético del map
     * @param productos
     * @return String
     */
    public String obtenerProductosOrdenadosPorCategoria(Map<Integer, Producto> productos) {
        Map<String, List<Map.Entry<Integer, Producto>>> productosPorCategoria = new HashMap<>();
    
        // Agrupar los productos por categoría
        for (Map.Entry<Integer, Producto> entry : productos.entrySet()) {
            Producto producto = entry.getValue();
            String categoria = producto.getCategoria();
            if (!productosPorCategoria.containsKey(categoria)) {
                productosPorCategoria.put(categoria, new ArrayList<>());
            }
            productosPorCategoria.get(categoria).add(entry);
        }
    
        // Ordenar las categorías alfabéticamente
        List<String> categoriasOrdenadas = new ArrayList<>(productosPorCategoria.keySet());
        Collections.sort(categoriasOrdenadas);
    
        // Crear un StringBuilder para construir el resultado
        StringBuilder sb = new StringBuilder();
    
        // Agregar la información de los productos por categoría al StringBuilder
        for (String categoria : categoriasOrdenadas) {
            sb.append("\n\nCategoría: ").append(categoria).append("\n");
            List<Map.Entry<Integer, Producto>> productosDeCategoria = productosPorCategoria.get(categoria);
            Collections.sort(productosDeCategoria, Comparator.comparing(entry -> entry.getValue().getNombre()));
            for (Map.Entry<Integer, Producto> entry : productosDeCategoria) {
                int codigo = entry.getKey();
                Producto producto = entry.getValue();
                sb.append("Indice: ").append(codigo).append(", Categoría: ").append(producto.getCategoria()).append(", Producto: ").append(producto.getNombre()).append(", Cantidad en lista: ").append(producto.getExistencias()).append("\n");
            }
        }
    
        // Devolver el resultado como un String
        return sb.toString();
    }



    
    /** regresa la lista de los productos sin ordenar
     * @param manager
     * @return String
     */
    public String vertodoslositemsendesorden(Map<Integer, Producto> manager){
        String info = "";
        for (Map.Entry<Integer, Producto> entry : manager.entrySet()) {
            Integer key = entry.getKey();
            Producto value = entry.getValue();
            info += "Indice: " + key+ ", Categoría: " + value.getCategoria() + ", Producto: " + value.getNombre()  + ", Cantidad en lista: " + value.getExistencias() + "\n";
        }
        return info;
    }


}
