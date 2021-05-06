class Solution {
    public String shortestPalindrome(String s) {
        int[] table = generateKMPTable(s + "#" + new StringBuilder(s).reverse().toString());

        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    }

    private int[] generateKMPTable(String s) {
        int[] res = new int[s.length()];

        for (int i = 1, j = 0; i < res.length;) {
            if (s.charAt(i) == s.charAt(j)) {
                res[i] = ++j;
                i++;
            } else if (j > 0) {
                j = res[j - 1];
            } else {
                j = 0;
                i++;
            }
        }

        return res;
    }
}