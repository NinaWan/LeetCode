class Solution {
    public int minCharacters(String a, String b) {
        int[] counta = new int[26], countb = new int[26];
        int m = a.length(), n = b.length();

        for (int i = 0; i < m; i++) {
            counta[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            countb[b.charAt(i) - 'a']++;
        }

        int ans = m + n;
        for (int i = 0; i < 26; i++) {
            ans = Math.min(ans, m + n - counta[i] - countb[i]); // condition 3, current i as the only distinct letter
            if (i > 0) {
                counta[i] += counta[i - 1];
                countb[i] += countb[i - 1];
            }
            if (i < 25) {
                // condition 1, current i as the largest letter in a, all letters in a should be less than or equal to i, all letters in
                // b should be larger than i
                // m-counta[i] - count of letters which is larger than i in a
                // countb[i] - count of letters which is less than or equal to i in b
                ans = Math.min(ans, m - counta[i] + countb[i]);
                // condition 2, current i as the largest letter in b, all letters in b should be less than or equal to i, all letters in
                // a should be larger than i
                // n-countb[i] - count of letters which is larger than i in b
                // counta[i] - count of letters which is less than or equal to i in a
                ans = Math.min(ans, n - countb[i] + counta[i]);
            }
        }

        return ans;
    }
}