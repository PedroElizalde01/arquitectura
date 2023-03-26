package TP1.test.exercise2;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import TP1.main.exercise2.AsciiEncoderImpl;

public class AsciiEncoderTest {
    @Test
    public void testAsciiEncode() {
        String binary = "0100000101010111"; //ASCII A = 65 W = 87 
        String expectedAscii = "AW"; 
        String actualAscii = new AsciiEncoderImpl().encode(binary);
        assertEquals(expectedAscii, actualAscii);
    }

    @Test
    public void testAsciiDecode() {
        String ascii = "AB"; //ASCII A = 65 B = 66
        String expectedBinary = "0100000101000010";
        String actualBinary = new AsciiEncoderImpl().decode(ascii);
        assertEquals(expectedBinary, actualBinary);
    }

    @Test
    public void testAsciiEncodeNDecode() {
        String binary = "0100100001000101010011000100110001001111"; //"HELLO" -> ASCII H = 72 E = 69 L = 76 O = 79 BIN = 01001000 01000101 01001100 01001111
        String ascii = new AsciiEncoderImpl().encode(binary);
        String newBinary = new AsciiEncoderImpl().decode(ascii);
        assertEquals(binary, newBinary);
    }
}
