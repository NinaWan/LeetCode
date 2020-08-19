class Solution {
    public int maxScore(String s) {
        int zeros = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') {
                zeros++;
            }
        }

        int result = Integer.MIN_VALUE;
        int lZeros = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                lZeros++;
            }

            result = Math.max(result, lZeros + (s.length() - zeros) - (i + 1 - lZeros));
        }

        return result;
    }
}