import java.util.*;

class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
    }

    private int result = 0;

    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (a, b) -> b.length() - a.length());

        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode node = root;
            boolean isNew = false;

            for (int i = word.length() - 1; i >= 0; i--) {
                int index = word.charAt(i) - 'a';

                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                    isNew = true;
                }

                node = node.children[index];
            }

            if (isNew) {
                result += word.length() + 1;
            }
        }

        return result;
    }
}
