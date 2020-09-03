class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freqRn = new int[26];
        int[] freqM = new int[26];

        for (char c : ransomNote.toCharArray()) {
            freqRn[c - 'a']++;
        }

        for (char c : magazine.toCharArray()) {
            freqM[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freqRn[i] > freqM[i]) {
                return false;
            }
        }

        return true;
    }
}