import java.util.*;

class Encrypter {

    private Map<Character, String> encryptMap;
    private Map<String, Integer> decryptMap;

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        encryptMap = new HashMap<>();
        decryptMap = new HashMap<>();

        for (int i = 0; i < keys.length; i++) {
            encryptMap.put(keys[i], values[i]);
        }

        for (String word : dictionary) {
            String encrypted = encrypt(word);
            if (encrypted != null) {
                decryptMap.put(encrypted, decryptMap.getOrDefault(encrypted, 0) + 1);
            }
        }
    }

    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();

        for (char c : word1.toCharArray()) {
            if (!encryptMap.containsKey(c)) {
                return "";
            }
            sb.append(encryptMap.get(c));
        }

        return sb.toString();
    }

    public int decrypt(String word2) {
        return decryptMap.getOrDefault(word2, 0);
    }
}
