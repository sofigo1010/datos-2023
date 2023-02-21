/**
 * @author Sofia Garcia
 * Folder: HDT4
 * Archivo: Controller.java
 * Fecha: 21/02/2023
 */

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    Read reader = new Read();
    View vista = new View();
    int respuesta;
    IStack<Double> stack;
    String infixexpression;
    Calculator caluladora;
    IStack<Character> stackconversor;
    
    /** Menu en el que se implementa toda la logica de la calculadora
     * @throws IOException
     */
    public void MenuCalculadora () throws IOException{
        boolean encendido = true;
        while (encendido == true){
            respuesta = vista.opcionesiniciales();
            if (respuesta ==1){
                String directorio = vista.inicio();
                ArrayList<ArrayList<String>> inicial = reader.leerExpresiones(directorio);
                respuesta = vista.SeleccionTipoStack();
                if (respuesta == 1 || respuesta ==2){
                    stack = StackFactory.CrearStack(respuesta,0);
                    stackconversor = StackFactory.CrearStack(respuesta,0);
                    caluladora = Calculator.getInstance(stack);
                }
                else if (respuesta == 3){
                    int respuesta2 = vista.tipostacklista();
                    stack = StackFactory.CrearStack(respuesta, respuesta2);
                    stackconversor = StackFactory.CrearStack(respuesta,0);
                    caluladora = Calculator.getInstance(stack);
                }
                for (int i = 0; i < inicial.size(); i++){
                    ArrayList<String> express = inicial.get(i);
                    String initialexpression = "";
                    for (int e = 0; e < express.size();e++){
                        initialexpression += express.get(e);
                    }
                    infixexpression = caluladora.convertirExpresion(initialexpression, stackconversor);
                    Double resultado = caluladora.evaluarExpresion(infixexpression);
                    vista.resultado(initialexpression, infixexpression, resultado, i);
                }
            }
            else if (respuesta == 2){
                vista.salida();
                encendido = false;
            }
            else {
                vista.invalido();
            }

        }

    }

    
}
