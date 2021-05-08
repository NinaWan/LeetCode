class Solution {
    public String reformatNumber(String number) {
        String num = number.replaceAll("[-|\\s]", "");
        String ans = "";
        int n = num.length();

        for (int i = 0; i < n;) {
            if (i != 0) {
                ans += "-";
            }

            if (n - i == 4) {
                ans += num.substring(i, i + 2) + "-" + num.substring(i + 2, i + 4);
                i = n;
            } else if (n - i == 2 || n - i == 3) {
                ans += num.substring(i);
                i = n;
            } else {
                ans += num.substring(i, i + 3);
                i += 3;
            }
        }

        return ans;
    }
}