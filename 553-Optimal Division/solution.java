class Solution {
    public String optimalDivision(int[] nums) {
        String ans = String.valueOf(nums[0]);
        if (nums.length == 1) {
            return ans;
        }

        if (nums.length == 2) {
            return ans + "/" + nums[1];
        }

        ans += "/(";

        for (int i = 1; i < nums.length; i++) {
            ans += String.valueOf(nums[i]);
            ans += i == nums.length - 1 ? ")" : "/";
        }

        return ans;
    }
}