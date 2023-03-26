package main;

public class BinaryCalculator implements Calculator{
    @Override
    public String sum(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int maxLength = Math.max(lenA, lenB);
        StringBuilder sb = new StringBuilder(maxLength);
        int carry = 0;
        int sum;

        for (int i = 0; i < maxLength; i++) {
            int bitA = (i < lenA) ? (a.charAt(lenA - 1 - i) - '0') : 0;
            int bitB = (i < lenB) ? (b.charAt(lenB - 1 - i) - '0') : 0;
            sum = (bitA ^ bitB) ^ carry;
            carry = ((bitA & bitB) | ((bitA ^ bitB) & carry)) << 1;
            sb.append((char) (sum + '0'));
        }

        if (carry != 0) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }

    @Override
    public String sub(String a, String b){
        int maxLength = Math.max(a.length(), b.length());
        char[] result = new char[maxLength];
        int borrow = 0;

        for (int i = 0; i < maxLength; i++) {
            int bitA = i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
            int bitB = i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
            int diff = bitA - bitB - borrow;

            if (diff < 0) {
                diff += 2;
                borrow = 1;
            } else {
                borrow = 0;
            }

            result[maxLength - 1 - i] = (char) (diff + '0');
        }
        /* int maxLength = Math.max(a.length(), b.length());
        StringBuilder result = new StringBuilder();
        int borrow = 0;
        for (int i = 0; i < maxLength; i++) {
            int digit1 = getDigit(a, i);
            int digit2 = getDigit(b, i);
            int diff = digit1 - digit2 - borrow;
            if (diff < 0) {
                diff += 2;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.append(diff);
        }
        return result.reverse().toString(); */
        // Remove leading zeros
        int i = 0;
        while (i < maxLength - 1 && result[i] == '0') {
            i++;
        }

        return new String(result, i, maxLength - i);
    }
    
    @Override
    public String mult(String a, String b){
        int length1 = a.length();
        int length2 = b.length();
        int[] result = new int[length1 + length2];
        for (int i = length1 - 1; i >= 0; i--) {
            int carry = 0;
            int digit1 = getDigit(a, i);
            for (int j = length2 - 1; j >= 0; j--) {
                int digit2 = getDigit(b, j);
                int sum = digit1 * digit2 + result[i + j + 1] + carry;
                result[i + j + 1] = sum % 2;
                carry = sum / 2;
            }
            result[i] += carry;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    @Override
    public String div(String a, String b){
    int numberA = binaryToInt(a);
        int numberB = binaryToInt(b);
        int total = numberA / numberB;
        return intToBinary(total);
    }

    @Override
    public String toHex(String binary){
        return "pp";
    }

    @Override
    public String fromHex(String hex){
return "pp";
    }

    private static int getDigit(String binary, int position) {
        if (position < binary.length()) {
            return binary.charAt(binary.length() - position - 1) - '0';
        } else {
            return 0;
        }
    }

    private static int binaryToInt(String binary) {
        int result = 0;
        for (int i = binary.length() - 1, j = 0; i >= 0; i--, j++) {
            int digit = binary.charAt(i) - '0';
            result += digit * Math.pow(2, j);
        }
        return result;
    }

    private static String intToBinary(int num) {
        StringBuilder binary = new StringBuilder();
        while (num > 0) {
            int digit = num % 2;
            binary.insert(0, digit);
            num /= 2;
        }
        return binary.toString();
    }
}