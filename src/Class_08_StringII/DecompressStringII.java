package Class_08_StringII;

/**
 * This one is HARD
 * a1c0b2c4 --> abbcccc
 */
public class DecompressStringII {
    public String decompress(String input) {

        return null;
    }

    /**
     * LaiOffer sol2
     * StringBuilder
     */

    public String decompressII(String input) {
        char[] array = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < array.length ; i++) {
            char ch = array[i++];
            int count = array[i] - '0';
            for(int c = 0; c < count; c++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
