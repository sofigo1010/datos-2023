
import java.util.Stack;

public class Calculator {
    private static Calculator instance = null;
    private Stack<Character> pilaOperadores = new Stack<>();
    
    private Calculator() {}
    
    
    /** patron singleton
     * @return Calculator
     */
    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }
    
    /** convierte la expresion infix a postfix
     * @return postfix
     */
    public StringBuilder convertirExpresion(String expresion) {
        pilaOperadores.clear();
        StringBuilder postfix = new StringBuilder();
        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);
            if (Character.isDigit(caracter)) {
                postfix.append(caracter);
            } else if (caracter == '(') {
                pilaOperadores.push(caracter);
            } else if (caracter == ')') {
                while (!pilaOperadores.isEmpty() && pilaOperadores.peek() != '(') {
                    postfix.append(pilaOperadores.pop());
                }
                pilaOperadores.pop(); 
            } else {
                while (!pilaOperadores.isEmpty() && prioridad(pilaOperadores.peek()) >= prioridad(caracter)) {
                    postfix.append(pilaOperadores.pop());
                }
                pilaOperadores.push(caracter);
            }
        }
        while (!pilaOperadores.isEmpty()) {
            postfix.append(pilaOperadores.pop());
        }
        return postfix;
    }
    
    /** 
     * @return el nivel de prioridad del operador
     */
    private int prioridad(char operador) {
        if (operador == '+' || operador == '-') {
            return 1;
        } else if (operador == '*' || operador == '/') {
            return 2;
        } else {
            return 0;
        }
    }
    
    /** evalua la expresion postfix 
     * @return el resultado que ahora se encuentra en el stack
     */
    public int evaluarExpresion(String expresion, Stack<Integer> stack) {
        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int resultado;
                if (c == '+') {
                    resultado = operand1 + operand2;
                } else if (c == '-') {
                    resultado = operand1 - operand2;
                } else if (c == '*') {
                    resultado = operand1 * operand2;
                } else if (c == '/') {
                    if (operand2 == 0) {
                        throw new ArithmeticException("No se puede devidir por cero");
                    }
                    resultado = operand1 / operand2;
                } else {
                    throw new IllegalArgumentException("Operador inválido: " + c);
                }
                stack.push(resultado);
            }
        }
        return stack.pop();
    }
    
}
