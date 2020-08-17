class Solution {
    public int numSub(String s) {
        double result = 0;
        long count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }

            if (s.charAt(i) == '0' || i == s.length() - 1) {
                result = ((count * (count + 1) / 2) % (1e9 + 7) + result) % (1e9 + 7);
                count = 0;
            }
        }

        return (int) result;
    }
}