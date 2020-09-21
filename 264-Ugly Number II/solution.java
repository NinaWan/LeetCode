class Solution {
    public int nthUglyNumber(int n) {
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;

        for (int i = 1; i < n; i++) {
            int num1 = 2 * uglyNums[p2];
            int num2 = 3 * uglyNums[p3];
            int num3 = 5 * uglyNums[p5];
            uglyNums[i] = Math.min(num1, Math.min(num2, num3));

            if (uglyNums[i] == num1) {
                p2++;
            }
            if (uglyNums[i] == num2) {
                p3++;
            }
            if (uglyNums[i] == num3) {
                p5++;
            }
        }

        return uglyNums[n - 1];
    }
}