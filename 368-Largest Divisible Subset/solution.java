class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList();
        }

        List<Integer> ans = new ArrayList();
        int[] lds = new int[nums.length];
        int[] pre = new int[nums.length];
        pre[0] = -1;
        lds[0] = 1;
        int max = 1;
        int ldsIndex = 0;

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            pre[i] = -1;
            lds[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && lds[j] + 1 > lds[i]) {
                    pre[i] = j;
                    lds[i] = lds[j] + 1;
                }

                if (lds[i] > max) {
                    max = lds[i];
                    ldsIndex = i;
                }
            }
        }

        while (ldsIndex >= 0) {
            ans.add(nums[ldsIndex]);
            ldsIndex = pre[ldsIndex];
        }

        return ans;
    }
}