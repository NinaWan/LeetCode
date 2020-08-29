class Solution {
    public String reverseStr(String s, int k) {
        String ans = "";

        for (int i = 0; i < s.length(); i += 2 * k) {
            int inc = 0;
            String a = "";
            String b = "";
            for (; i + inc < s.length() && inc < k; inc++) {
                a = String.valueOf(s.charAt(i + inc)) + a;
            }

            for (; i + 2 * k - inc < s.length() && inc > 0; inc--) {
                b += String.valueOf(s.charAt(i + 2 * k - inc));
            }

            ans += a + b;
        }

        return ans;
    }
}