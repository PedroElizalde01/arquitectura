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
    StringBuilder result = new StringBuilder();
    int borrow = 0;
    int maxLength = Math.max(a.length(), b.length());

    for (int i = 0; i < maxLength; i++) {
        int bitA = (i < a.length()) ? a.charAt(a.length() - 1 - i) - '0' : 0;
        int bitB = (i < b.length()) ? b.charAt(b.length() - 1 - i) - '0' : 0;
        int diff = bitA - bitB - borrow;
        
        if (diff < 0) {
            diff += 2;
            borrow = 1;
        } else {
            borrow = 0;
        }
        
        result.append(diff);
    }
    
    // Remove leading zeros from the result
    while (result.length() > 1 && result.charAt(result.length() - 1) == '0') {
        result.deleteCharAt(result.length() - 1);
    }
    
    if (borrow == 1) {
        // b is greater than a, so the result is negative
        result.insert(0, '-');
    }
    
    return result.reverse().toString();
}

    @Override
    public String mult(String a, String b) {
        StringBuilder result = new StringBuilder();
        int maxLength = a.length() + b.length();
        int[] product = new int[maxLength];
        
        // Multiply each bit of b with a and store the result in product array
        for (int i = b.length() - 1; i >= 0; i--) {
            int bitB = b.charAt(i) - '0';
            for (int j = a.length() - 1; j >= 0; j--) {
                int bitA = a.charAt(j) - '0';
                int prod = bitA * bitB;
                int sum = prod + product[i + j + 1];
                product[i + j + 1] = sum % 2;
                product[i + j] += sum / 2;
            }
        }
        
        // Convert the product array to a string
        for (int i = 0; i < maxLength; i++) {
            result.append(product[i]);
        }
        
        // Remove leading zeros from the result
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        
        return result.toString();
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
    
        StringBuilder quotientBuilder = new StringBuilder();
        StringBuilder remainderBuilder = new StringBuilder(a.substring(0, b.length()));
        int i = b.length();
    
        while (i <= a.length()) {
            int cmp = remainderBuilder.toString().compareTo(b);
            int quotientDigit = cmp < 0 ? 0 : 1;
    
            quotientBuilder.append(quotientDigit);
    
            if (cmp < 0) {
                i++;
            } else {
                String subtracted = subtract(remainderBuilder.toString(), b);
                remainderBuilder.delete(0, remainderBuilder.length());
                remainderBuilder.append(subtracted);
    
                if (i < a.length()) {
                    remainderBuilder.append(a.charAt(i));
                    i++;
                }
            }
        }
    
        return quotientBuilder.toString();
    }
    
    private static String subtract(String a, String b) {
        StringBuilder resultBuilder = new StringBuilder();
        int borrow = 0;
    
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0; i--, j--) {
            int diff = a.charAt(i) - '0' - borrow;
    
            if (j >= 0) {
                diff -= b.charAt(j) - '0';
            }
    
            if (diff < 0) {
                diff += 2;
                borrow = 1;
            } else {
                borrow = 0;
            }
    
            resultBuilder.append(diff);
        }
    
        return resultBuilder.reverse().toString().replaceFirst("^0+(?!$)", "");
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