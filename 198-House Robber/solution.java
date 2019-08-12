public class Solution {
    public int rob(int[] nums) {
        int currentRob = 0;
        int currentNotRob = 0;
        int previousRob = 0;
        int previousNotRob = 0;

        for (int i = 0; i < nums.length; i++) {
            currentRob = previousNotRob + nums[i];
            currentNotRob = Math.max(previousRob, previousNotRob);
            previousRob = currentRob;
            previousNotRob = currentNotRob;
        }

        return Math.max(currentRob, currentNotRob);
    }
}