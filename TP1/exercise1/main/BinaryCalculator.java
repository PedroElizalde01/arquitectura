package TP1.exercise1.main;

public class BinaryCalculator implements Calculator{

    @Override
    public String sum(String a, String b) {
       String result = "";
       int carry = 0;
       int maxLength = Math.max(a.length(), b.length());

       for (int i = 0; i < maxLength; i++) {
           int bitA = (i < a.length()) ? a.charAt(a.length() - 1 - i) - 48 : 0; // 48 is the ASCII code for 0
           int bitB = (i < b.length()) ? b.charAt(b.length() - 1 - i) - 48 : 0;
           int sum = bitA ^ bitB ^ carry;
           result = (char) (sum + 48) + result ;
           carry = (bitA & bitB) | (bitA & carry) | (bitB & carry);
       }

       if (carry != 0) {
           result = carry + result;
       }

       return result;
    }

    @Override
    public String sub(String a, String b){
        String result = "";
        b = complement(b);
        b = sum(b, "1"); // complemento a 2
        result = sum(a, b);
        return result;
    }

    private String complement(String b) {
        String result = "";
        for (char c : b.toCharArray()) {
            result += (c == '0') ? '1' : '0';
        }
        return result;
    }


    @Override
    public String mult(String a, String b) {
        String result = "";
        int times = Integer.parseInt(b, 2);
        for (int i = 0; i < times; i++) {
            result = sum(result, a);
        }
        return result;
    }
    

    @Override
    public String div(String a, String b) {
        if (b.equals("0")) {
            throw new ArithmeticException("Division by zero");
        }
    
        if (a.equals("0")) {
            return "0";
        }
    
        if (a.equals(b)) {
            return "1";
        }
    
        if (a.length() < b.length() || 
            (a.length() == b.length() && a.compareTo(b) < 0)) {
            return "0";
        }

        String result = "";
        int count = 0;
        while (a.length() >= b.length()) {
            a = sub(a, b);
            count++;
        }
        for (int i = 0; i < count; i++) {
            a = sum(result,a);
        }
        return result;
    }

    @Override
    public String toHex(String binary){
        int decimal = Integer.parseInt(binary, 2);
    
        // Convert integer to hexadecimal string
        String hex = Integer.toHexString(decimal);
        
        return hex;
    }

    @Override
    public String fromHex(String hex) {
        // Convert hexadecimal string to integer
        int decimal = Integer.parseInt(hex, 16);
        
        // Convert integer to binary string
        String binary = Integer.toBinaryString(decimal);
        
        return binary;
    }
    
}