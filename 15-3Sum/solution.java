import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList();
        }

        List<List<Integer>> result = new ArrayList();

        // sort first
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        // walk through sorted list
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            Integer element2 = null;
            Integer element3 = null;
            while (start < end) {
                if (nums[i] + nums[start] + nums[end] == 0) {
                    if (element2 != null && element2.intValue() == nums[start] && element3 != null && element3.intValue() == nums[end]) {
                        start++;
                        end--;
                        continue;
                    }
                    result.add(Arrays.asList(Integer.valueOf(nums[i]), Integer.valueOf(nums[start]), Integer.valueOf(nums[end])));
                    element2 = nums[start];
                    element3 = nums[end];
                    start++;
                    end--;
                } else {
                    if (nums[i] + nums[start] + nums[end] > 0) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }

        return result;
    }
}