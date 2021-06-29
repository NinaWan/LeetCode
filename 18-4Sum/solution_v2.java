class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, target, 4, 0);
    }

    private List<List<Integer>> nSum(int[] nums, int target, int n, int start) {
        List<List<Integer>> res = new ArrayList();

        if (n < 2) {
            return res;
        }

        if (n == 2) {
            for (int i = start, j = nums.length - 1; i < j;) {
                int left = nums[i], right = nums[j], sum = left + right;
                if (sum == target) {
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
        } else {
            for (int i = start; i < nums.length - n + 1; i++) {
                for (List<Integer> sub : nSum(nums, target - nums[i], n - 1, i + 1)) {
                    List<Integer> tmp = new ArrayList();
                    tmp.add(nums[i]);
                    tmp.addAll(sub);
                    res.add(tmp);
                    while (i < nums.length - n + 1 && nums[i] == nums[i + 1]) {
                        i++;
                    }
                }
            }
        }

        return res;
    }
}