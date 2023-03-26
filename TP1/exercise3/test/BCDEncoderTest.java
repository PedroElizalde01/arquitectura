package TP1.exercise3.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import TP1.exercise3.main.BCDEncoderImpl;

public class BCDEncoderTest {
    @Test
    public void testBCDEncode() {
        int a = 123;
        String expectedBCD = "000100100011";
        String actualBCD = new BCDEncoderImpl().encode(a);
        assertEquals(expectedBCD, actualBCD);
    }    

    @Test
    public void testBCDcode() {
        String a = "000100100011";
        int expectedInt = 123;
        int actualInt = new BCDEncoderImpl().decode(a);
        assertEquals(expectedInt, actualInt);
    }    

    @Test
    public void testBCDEncodeNDecode() {
        int a = 123;
        String actualBCD = new BCDEncoderImpl().encode(a);
        int resultInt = new BCDEncoderImpl().decode(actualBCD);
        assertEquals(a, resultInt);
    }    
}
