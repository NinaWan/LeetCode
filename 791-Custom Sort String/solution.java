class Solution {
    public String customSortString(String S, String T) {
        int[] freq = new int[26];
        String ans = "";
        for (char c : T.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : S.toCharArray()) {
            while (freq[c - 'a'] != 0) {
                freq[c - 'a']--;
                ans += Character.toString(c);
            }
        }

        for (int i = 0; i < 26; i++) {
            while (freq[i] != 0) {
                freq[i]--;
                ans += Character.toString((char) ('a' + i));
            }
        }

        return ans;
    }
}