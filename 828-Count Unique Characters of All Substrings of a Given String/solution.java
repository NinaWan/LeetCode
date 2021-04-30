class Solution {
    public int uniqueLetterString(String s) {
        long ans = 0;
        int mod = (int) 1e9 + 7;
        int[][] index = new int[26][2];

        for (int i = 0; i < 26; i++) {
            Arrays.fill(index[i], -1);
        }

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'A';
            ans = (ans + (index[c][1] - index[c][0]) * (i - index[c][1]) % mod) % mod;
            index[c] = new int[] {index[c][1], i};
        }

        for (int i = 0; i < 26; i++) {
            ans = (ans + (index[i][1] - index[i][0]) * (s.length() - index[i][1]) % mod) % mod;
        }

        return (int) ans;
    }
}