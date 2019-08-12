public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // Null || Empty
        if (null == nums || 0 == nums.length) return 0;

        int max = 0;
        int temp = 0;
        // Loop array
        for (int num : nums) {
            if (num == 0) {
                if (temp > max) {
                    max = temp;
                }
                temp = 0;
            }

            if (num == 1) {
                temp++;
            }
        }

        return max > temp ? max : temp;
    }
}