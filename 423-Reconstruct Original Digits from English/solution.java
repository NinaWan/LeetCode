class Solution {
    public String originalDigits(String s) {
        int[] count = new int[10];
        int[] charFreq = new int[26];
        for (char c : s.toCharArray()) {
            charFreq[c - 'a']++;
        }

        count[0] = charFreq['z' - 'a'];
        count[2] = charFreq['w' - 'a'];
        count[6] = charFreq['x' - 'a'];
        count[8] = charFreq['g' - 'a'];
        count[3] = charFreq['h' - 'a'] - count[8];
        count[7] = charFreq['s' - 'a'] - count[6];
        count[5] = charFreq['v' - 'a'] - count[7];
        count[4] = charFreq['f' - 'a'] - count[5];
        count[9] = charFreq['i' - 'a'] - count[5] - count[6] - count[8];
        count[1] = charFreq['o' - 'a'] - count[0] - count[2] - count[4];

        String ans = "";
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                ans += i;
            }
        }

        return ans;
    }
}