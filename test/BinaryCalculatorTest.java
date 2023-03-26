package test;

import main.BinaryCalculator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BinaryCalculatorTest {
    BinaryCalculator calc = new BinaryCalculator();

    @Test
    public void testBinarySum() {
        String binary1 = "1010";        //10
        String binary2 = "1111";        //15
        String expectedSum = "11001";   //25
        String actualSum = calc.sum(binary1, binary2);
        assertEquals(expectedSum, actualSum);
    }
    
    @Test
    public void testBinarySub() {
        String binary1 = "1111";    //15
        String binary2 = "1010";    //10
        String expectedSum = "101"; //5
        String actualSum = calc.sub(binary1, binary2);
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testBinaryMul() {
        String binary1 = "1010";        //10
        String binary2 = "1111";        //15
        String expectedSum = "10010110";//150
        String actualSum = calc.mult(binary1, binary2);
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testBinaryDiv() {
        String binary1 = "1000000"; //64
        String binary2 = "100000";  //32
        String expectedSum = "10";  //2
        String actualSum = calc.div(binary1, binary2);
        assertEquals(expectedSum, actualSum);
    }
}
