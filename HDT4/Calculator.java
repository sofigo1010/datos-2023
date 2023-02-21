/**
 * @author Sofia Garcia
 * Folder: HDT4
 * Archivo: Calculator.java
 * Fecha: 21/02/2023
 */

public class Calculator {
    private static Calculator instance = null;
    private IStack<Double> pila;
    
    private Calculator(IStack<Double> stack) {
        pila = stack;
    }

    
    /** patron singleton
     * @param stack
     * @return Calculator
     */
    public static Calculator getInstance(IStack<Double> stack) {
        if (instance == null) {
            instance = new Calculator(stack);
        }
        return instance;
    }
    
    
    
    /** Convierte una expresion infix a una postfix
     * @param infix
     * @param stack
     * @return String
     */
    public static <T> String convertirExpresion(String infix, IStack<Character> stack) {
        String postfix = "";
        for (char c : infix.toCharArray()) {
            if (Character.isDigit(c)) {
                postfix += c + " ";
            } else if (c == '+' || c == '-') {
                while (!stack.isEmpty() && (stack.peek() == '+' || stack.peek() == '-' || stack.peek() == '*' || stack.peek() == '/')) {
                    postfix += stack.pop() + " ";
                }
                stack.push(c);
            } else if (c == '*' || c == '/') {
                while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                    postfix += stack.pop() + " ";
                }
                stack.push(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.pop() + " ";
                }
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException("Expresión inválida.");
                }
                stack.pop();
            } else {
                throw new IllegalArgumentException("Expresión inválida.");
            }
        }
    
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (c == '(') {
                throw new IllegalArgumentException("Expresión inválida.");
            }
            postfix += c + " ";
        }
    
        return postfix.trim();
    }
    
    
    
    /** Evalua la expresion en postfix y regresa el resultado
     * @param expression
     * @return double
     */
    public double evaluarExpresion(String expression) {
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (token.equals("+")) {
                if (pila.size() < 2) {
                    throw new IllegalArgumentException("Expresión inválida.");
                }
                double b = pila.pop();
                double a = pila.pop();
                pila.push(a + b);
            } else if (token.equals("-")) {
                if (pila.size() < 2) {
                    throw new IllegalArgumentException("Expresión inválida.");
                }
                double b = pila.pop();
                double a = pila.pop();
                pila.push(a - b);
            } else if (token.equals("*")) {
                if (pila.size() < 2) {
                    throw new IllegalArgumentException("Expresión inválida.");
                }
                double b = pila.pop();
                double a = pila.pop();
                pila.push(a * b);
            } else if (token.equals("/")) {
                if (pila.size() < 2) {
                    throw new IllegalArgumentException("Expresión inválida.");
                }
                double b = pila.pop();
                double a = pila.pop();
                if (b == 0) {
                    throw new ArithmeticException("No se puede dividir por cero.");
                }
                pila.push(a / b);
            } else {
                double num = Double.parseDouble(token);
                pila.push(num);
            }
        }
        if (pila.size() != 1) {
            throw new IllegalArgumentException("Expresión inválida.");
        }
        return pila.pop();
    }
    
}
