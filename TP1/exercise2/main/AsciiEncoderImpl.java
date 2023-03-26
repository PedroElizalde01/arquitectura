package TP1.exercise2.main;

public class AsciiEncoderImpl implements AsciiEncoder {

    @Override
    public String encode(String binary) {
        StringBuilder result = new StringBuilder();
        int maxLength = binary.length();
        for (int i = 0; i < maxLength; i += 8) {
            int ascii = Integer.parseInt(binary.substring(i, i + 8), 2);
            result.append((char) ascii);
        }
        return result.toString();
    }

    @Override
    public String decode(String ascii) {
        StringBuilder result = new StringBuilder();
        int maxLength = ascii.length();
        for (int i = 0; i < maxLength; i++) {
            int asciiCode = ascii.charAt(i);
            result.append(String.format("%08d", Integer.parseInt(Integer.toBinaryString(asciiCode))));
        }
        return result.toString();
    }
}
