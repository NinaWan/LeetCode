class Solution {
    public int secondHighest(String s) {
        int[] ans = {-1, -1};

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int d = c - '0';
                if (d > ans[0]) {
                    ans[1] = ans[0];
                    ans[0] = d;
                } else if (d < ans[0] && d > ans[1]) {
                    ans[1] = d;
                }
            }
        }

        return ans[1];
    }
}