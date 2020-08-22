class Solution {
    public int minSteps(String s, String t) {
        int result = 0;
        int[] freqS = new int[26];
        int[] freqT = new int[26];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                freqS[s.charAt(i) - 'a']++;
                freqT[t.charAt(i) - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (freqS[i] > freqT[i]) {
                result += freqS[i] - freqT[i];
            }
        }

        return result;
    }
}