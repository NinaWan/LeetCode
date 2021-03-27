class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int p = 0;
        int n = groups.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < groups[i].length;) {
                if (p >= n && nums.length - p < n - i) {
                    return false;
                }

                if (groups[i][j] != nums[p] && j == 0) {
                    p++;
                } else if (groups[i][j] != nums[p]) {
                    p -= j - 1;
                    j = 0;
                } else {
                    j++;
                    p++;
                }
            }
        }

        return true;
    }
}