/**
 * @author Sofia Garcia
 * Folder: HDT6
 * Archivo: Producto.java
 * Fecha: 05/03/2023
 */


public class Producto {

    private String nombre;
    private String categoria;
    private int existencias; 

    public Producto (String name, String category, int existence){
        nombre = name; 
        categoria = category;
        existencias = existence;
    }

    /** 
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /** 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /** 
     * @return String
     */
    public String getCategoria() {
        return categoria;
    }
    
    /** 
     * @param categoria
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /** 
     * @return int
     */
    public int getExistencias() {
        return existencias;
    }
    
    /** 
     * @param existencias
     */
    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    /** regresa todo ya en orden para poder imprimirlo 
     * @return String
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return ("Nombre del producto: "+nombre + ", Categoría: "+ categoria+", Cantidad en lista: " + existencias);
    }

    public String getIndice() {
        return null;
    } 

    
    
}
