class Solution {
    public char findTheDifference(String s, String t) {
        int[] freqS = new int[26];
        int[] freqT = new int[26];

        for (char c : s.toCharArray()) {
            freqS[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            freqT[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freqS[i] != freqT[i]) {
                return (char) ('a' + i);
            }
        }

        return '\0';
    }
}