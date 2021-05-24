class Solution {
    public int longestSubstring(String s, int k) {
        return longestSubstring(s.toCharArray(), 0, s.length(), k);
    }

    private int longestSubstring(char[] s, int start, int end, int k) {
        if (end - start < k) {// length of whole string is less than k
            return 0;
        }

        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            count[s[i] - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] < k && count[i] > 0) {// chars whose count is less than k
                for (int j = start; j < end; j++) {
                    if (s[j] - 'a' == i) {
                        return Math.max(longestSubstring(s, start, j, k), longestSubstring(s, j + 1, end, k));
                    }
                }
            }
        }

        return end - start;
    }
}