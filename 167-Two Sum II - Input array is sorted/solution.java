class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];

        for (int l = 0, r = numbers.length - 1; l < r;) {
            int sum = numbers[l] + numbers[r];

            if (sum == target) {
                return new int[] {l + 1, r + 1};
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }

        return ans;
    }
}