import java.util.Arrays;

public class Solution {
    public int minMoves(int[] nums) {
        if (nums.length < 2)
            return 0;
        if (nums.length == 2)
            return Math.abs(nums[0] - nums[1]);
        int result = 0;
        Arrays.sort(nums);
        while (nums[0] != nums[nums.length - 1]) {
            for (int i = 0; i < nums.length - 1; i++) {
                nums[i] += 1;
            }
            result += 1;
            Arrays.sort(nums);
        }
        return result;
    }
}