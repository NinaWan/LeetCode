public class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int onePre = 2;
        int twoPre = 1;
        int result = 0;
        for (int i = 3; i < n + 1; i++) {
            result = onePre + twoPre;
            int temp = onePre;
            onePre = result;
            twoPre = temp;
        }

        return result;
    }
}