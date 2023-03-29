package TP1.exercise2.main;

public class AsciiEncoderImpl implements AsciiEncoder {

    @Override
    public String encode(String binary) {
        String result = "";
        int maxLength = binary.length();
        for (int i = 0; i < maxLength; i += 8) {
            int ascii = Integer.parseInt(binary.substring(i, i + 8), 2);
            result += (char) ascii;
        }
        return result;
    }

    @Override
    public String decode(String ascii) {
        String result = "";
        int maxLength = ascii.length();
        for (int i = 0; i < maxLength; i++) {
            int asciiCode = ascii.charAt(i);
            result += String.format("%08d", Integer.parseInt(Integer.toBinaryString(asciiCode)));
        }
        return result;
    }
}
