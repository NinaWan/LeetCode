class Solution {
    public boolean detectCapitalUse(String word) {
        int upper = 0;
        int lower = 0;
        for (char c : word.toCharArray()) {
            if (c <= 'z' && c >= 'a') {
                lower++;
            } else {
                upper++;
            }
        }

        return upper == 0 || lower == 0 || (upper == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z');
    }
}