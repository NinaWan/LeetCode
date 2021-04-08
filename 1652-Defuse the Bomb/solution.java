class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        int n = code.length;

        for (int i = 0; i < n; i++) {
            if (k == 0) {
                ans[i] = 0;
            } else if (k > 0) {
                for (int j = i + 1; j <= i + k; j++) {
                    ans[i] += code[j % n];
                }
            } else {
                for (int m = i + k; m < i; m++) {
                    ans[i] += code[(m + n) % n];
                }
            }
        }

        return ans;
    }
}