package alg.util.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONParser {
  private static ObjectMapper mapper;
  static {
    mapper = new ObjectMapper();
  }

  public static String toJson(Object input) {
    try {
      return mapper.writeValueAsString(input);

    } catch (Exception ex) {
      return "N/A";
    }
  }
}
