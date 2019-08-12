public class Solution {
    public char findTheDifference(String s, String t) {
        // Assume both s and t are not null, but s may be empty
        if (s.isEmpty()) return t.charAt(0);

        Map<Character, Integer> charCount = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0) + 1);
        }

        int j = 0;
        for (; j < t.length(); j++) {
            if (0 == charCount.getOrDefault(t.charAt(j), 0)) {
                break;
            } else {
                charCount.put(t.charAt(j), charCount.get(t.charAt(j)) - 1);
            }
        }

        return t.charAt(j);
    }
}