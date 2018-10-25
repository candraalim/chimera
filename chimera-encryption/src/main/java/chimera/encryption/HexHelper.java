package chimera.encryption;

import java.util.Arrays;
import java.util.List;

public class HexHelper {

    private static final String[] HEXSTRING;
    private static final List<String> HEXSTRINGLIST;

    static {
        HEXSTRING = new String[256];
        for (int i = 0; i < 256; i++) {
            StringBuilder d = new StringBuilder(2);
            //-- hi
            char ch = Character.forDigit(((byte) i >> 4) & 0x0F, 16);
            d.append(Character.toUpperCase(ch));
            //-- lo
            ch = Character.forDigit((byte) i & 0x0F, 16);
            d.append(Character.toUpperCase(ch));
            HEXSTRING[i] = d.toString();
        }
        HEXSTRINGLIST = Arrays.asList(HEXSTRING);
    }

    public static String toHex(byte[] b) {
        if (b == null) {
            return "";
        }

        StringBuilder d = new StringBuilder(b.length * 2); 
        for (byte aB : b) {
            d.append(HEXSTRING[(int) aB & 0xFF]);
        }

        return d.toString();
    }

    public static byte[] toByte(String hex) {
        hex = hex.toUpperCase();
        byte[] result = new byte[hex.length() / 2];
        for (int i = 0; i < result.length; i++) {
            String hexChar = hex.substring(i * 2, (i * 2) + 2);
            int idx = HEXSTRINGLIST.indexOf(hexChar);
            result[i] = (byte) (idx & 0xFF);
        }
        return result;
    }

    public static String toHex(int n) {
        return Integer.toHexString(n).toUpperCase();
    }

    public static int toInteger(String hex) {
        return Integer.parseInt(hex, 16);
    }

    public static String toHex(long n) {
        return Long.toHexString(n).toUpperCase();
    }

    public static long toLong(String hex) {
        return Long.parseLong(hex, 16);
    }
    
}