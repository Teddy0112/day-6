import java.util.HashMap;
import java.util.Map;

public class Codec {

    private Map<String, String> map = new HashMap<>();
    private int id = 0;
    private final String BASE_URL = "https://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        id++;
        String shortKey = String.valueOf(id);
        map.put(shortKey, longUrl);

        return BASE_URL + shortKey;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key = shortUrl.substring(shortUrl.lastIndexOf('/') + 1);

        return map.get(key);
    }
}
