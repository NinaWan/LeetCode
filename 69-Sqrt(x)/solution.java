class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int ans = 1;
        while (x / ans > ans) {
            ans++;
        }

        return x / ans == ans ? ans : ans - 1;
    }
}