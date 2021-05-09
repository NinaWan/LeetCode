class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) {
            return "";
        }

        Set<Character> seen = new HashSet();
        for (char c : s.toCharArray()) {
            seen.add(c);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!seen.contains(Character.toUpperCase(c)) || !seen.contains(Character.toLowerCase(c))) {
                String left = longestNiceSubstring(s.substring(0, i));
                String right = longestNiceSubstring(s.substring(i + 1));
                return left.length() >= right.length() ? left
                                                       : right;
            }
        }

        return s;
    }
}