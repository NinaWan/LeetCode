public class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                this.nums[i] = nums[i];
            } else {
                this.nums[i] = nums[i] + this.nums[i - 1];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i > 0) {
            return nums[j] - nums[i - 1];
        } else {
            return nums[j];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */