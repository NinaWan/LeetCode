class Solution {
    public int tribonacci(int n) {
        int[] temp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                temp[i] = 0;
            }

            if (i == 1 || i == 2) {
                temp[i] = 1;
            }

            if (i >= 3) {
                temp[i] = temp[i - 3] + temp[i - 2] + temp[i - 1];
            }
        }

        return temp[n];
    }
}