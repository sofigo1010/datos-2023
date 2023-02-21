/**
 * @author Sofia Garcia
 * Folder: HDT4
 * Archivo: Tests.java
 * Fecha: 21/02/2023
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Tests {

IStack<Double> stack;
IStack<Character> stack2;

    @Test
    public void TestArrayStack(){ 
        stack = StackFactory.CrearStack(1, 0);
        Calculator.getInstance(stack);
        stack.push((double) 1);
        stack.push((double) 2);
        assertEquals(false,stack.isEmpty());
    } 

    @Test
    public void TestVectorStack(){ 
        stack = StackFactory.CrearStack(2, 0);
        Calculator.getInstance(stack);
        stack.push((double) 1);
        stack.push((double) 2);
        assertEquals(false,stack.isEmpty());
    } 

    @Test
    public void TestSimpleListStack(){ 
        stack = StackFactory.CrearStack(3, 1);
        Calculator.getInstance(stack);
        stack.push((double) 1);
        stack.push((double) 2);
        assertEquals(false,stack.isEmpty());
    } 

    @Test
    public void TestDoubleListStack(){ 
        stack = StackFactory.CrearStack(3, 2);
        Calculator.getInstance(stack);
        stack.push((double) 1);
        stack.push((double) 2);
        assertEquals(false,stack.isEmpty());
    } 

    @Test
    public void TestConvertir(){ 
        stack = StackFactory.CrearStack(1, 0);
        Calculator.getInstance(stack);
        stack2 = StackFactory.CrearStack(2, 0);
        String infix = "1+2*8";
        String postfix = Calculator.convertirExpresion(infix, stack2);
        assertEquals("1 2 8 * +", postfix);
    } 

}
