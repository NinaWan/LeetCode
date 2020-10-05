class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int ans = 0;
        int[] args = {-1, 1};

        for (int arg1 : args) {
            for (int arg2 : args) {
                int min = arg1 * arr1[0] + arg2 * arr2[0];
                for (int i = 1; i < arr1.length; i++) {
                    int curr = arg1 * arr1[i] + arg2 * arr2[i] + i;
                    ans = Math.max(ans, curr - min);
                    min = Math.min(min, curr);
                }
            }
        }

        return ans;
    }
}