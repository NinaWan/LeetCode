class Solution {
    public String thousandSeparator(int n) {
        String ans = "";
        String s = String.valueOf(n);
        int l = s.length();

        for (int i = l - 1; i >= 0; i--) {
            ans = Character.toString(s.charAt(i)) + ans;

            if ((l - i) % 3 == 0 && i != 0) {
                ans = "." + ans;
            }
        }

        return ans;
    }
}