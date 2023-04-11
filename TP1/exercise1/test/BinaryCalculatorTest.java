package TP1.exercise1.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import TP1.exercise1.main.BinaryCalculator;

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
        String expectedSub = "10101"; //5
        String actualSub = calc.sub(binary1, binary2);
        assertEquals(expectedSub, actualSub);
    }

    @Test
    public void testBinaryMul() {
        String binary1 = "1010";        //10
        String binary2 = "1111";        //15
        String expectedMult = "10010110";//150
        String actualMult = calc.mult(binary1, binary2);
        assertEquals(expectedMult, actualMult);
    }

    @Test
    public void testBinaryToHex() {
        String binary = "10110110"; //182
        String expectedHex = "b6";
        String actualHex = calc.toHex(binary);
        assertEquals(expectedHex, actualHex);
    }

    @Test
    public void testHexToBinary() {
        String hex = "b6"; //182
        String expectedBinary = "10110110";
        String actualBinary = calc.fromHex(hex);
        assertEquals(expectedBinary, actualBinary);
    }


    @Test
    public void testHexToBinaryToHex() {
        String hex = "b6"; //182
        String actualBinary = calc.fromHex(hex);
        String actualHex = calc.toHex(actualBinary);
        assertEquals(hex, actualHex);
    }
}
