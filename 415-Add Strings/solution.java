class Solution {
    public String addStrings(String num1, String num2) {
        String ans = "";
        int carry = 0;
        int p = 1;
        int n1 = num1.length();
        int n2 = num2.length();
        int n = Math.max(n1, n2);

        while (p <= n) {
            int a = 0;
            int b = 0;

            if (n1 - p >= 0) {
                a = num1.charAt(n1 - p) - '0';
            }

            if (n2 - p >= 0) {
                b = num2.charAt(n2 - p) - '0';
            }

            int sum = a + b + carry;

            carry = sum / 10;
            ans = sum % 10 + ans;

            p++;
        }

        if (carry != 0) {
            ans = carry + ans;
        }

        return ans;
    }
}