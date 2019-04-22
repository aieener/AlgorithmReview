package Class_08_StringII;

/**
 * This one is HARD
 * a1c0b2c4 --> abbcccc
 * reviewd the simple StringBuilder version on April 15
 */
public class DecompressStringII {
  public String decompress(String input) {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < input.length(); i++) {
      char curChar = input.charAt(i);
      int count = input.charAt(i + 1) - '0';
      for(int j = 0; j < count; j++) {
        sb.append(curChar);
      }
      i++;
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    String input = "a1c0b2c5";
    System.out.println(new DecompressStringII().decompress(input));
  }
}
