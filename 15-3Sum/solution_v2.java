class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            for (List<Integer> tuplet : twoSum(nums, -nums[i], i + 1)) {
                List<Integer> triplet = new ArrayList();
                triplet.add(nums[i]);
                triplet.addAll(tuplet);
                ans.add(triplet);
                while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }

        return ans;
    }

    private List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList();

        for (int i = start, j = nums.length - 1; i < j;) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                int left = nums[i], right = nums[j];
                res.add(Arrays.asList(left, right));
                while (i < j && nums[i] == left) {
                    i++;
                }
                while (i < j && nums[j] == right) {
                    j--;
                }
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }

        return res;
    }
}