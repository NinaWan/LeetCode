class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == n - i - 1) {
                res[i] = 0;
                break;
            }
            res[i] = i + 1;
            res[n - i - 1] = -res[i];
        }

        return res;
    }
}