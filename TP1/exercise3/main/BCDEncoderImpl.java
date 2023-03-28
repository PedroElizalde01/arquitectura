package TP1.exercise3.main;

import java.util.HashMap;

public class BCDEncoderImpl implements BCDEncoder {

    private static final HashMap<Integer, String> bcdMap = new HashMap<Integer, String>() {{
        put(0, "0000");
        put(1, "0001");
        put(2, "0010");
        put(3, "0011");
        put(4, "0100");
        put(5, "0101");
        put(6, "0110");
        put(7, "0111");
        put(8, "1000");
        put(9, "1001");
    }};

    @Override
    public String encode(int a) {
        String result = "";
        while(a > 0){
            int b = a % 10;
            a = a / 10;
            result = bcdMap.get(b) + result;
        }
        return result;
    }

    @Override
    public int decode(String a) {
        int result = 0;
        while (a.length() > 0) {
            int current = Integer.parseInt(a.substring(0,4),2);
            result = result * 10 + current;
            a = a.substring(4);
        }
        return result;
    }
}
