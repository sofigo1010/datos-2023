
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Tests {

IStack<Double> stack;
Calculator calc = new Calculator(); 

    @Test
    public void Test1(){ 
        Pila.push(1);
        Pila.push(2);
        assertEquals(false, Pila.empty());
    } 

    @Test
    public void Test2(){ 
       assertEquals(false, calc.isOperator("2"));
       assertEquals(true, calc.isOperator("+"));
    } 

    @Test
    public void Test3(){ 
       assertEquals(false, calc.isOperator("2"));
       assertEquals(true, calc.isOperator("+"));
    } 
}
