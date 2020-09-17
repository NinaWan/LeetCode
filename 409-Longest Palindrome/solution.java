class Solution {
    public int longestPalindrome(String s) {
        int ans = 0;
        int[] freq = new int[52];

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                freq[c - 'a']++;
            } else {
                freq[c - 'A' + 26]++;
            }
        }

        int odd = 0;
        for (int count : freq) {
            if (count % 2 == 0) {
                ans += count;
            } else {
                odd++;
                ans += count - 1;
            }
        }

        return odd == 0 ? ans : ans + 1;
    }
}