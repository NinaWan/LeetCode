class Solution {
    public int leastOpsExpressTarget(int x, int target) {
        if (x > target) {
            return Math.min(2 * target - 1, 2 * (x - target));
        }

        if (x == target) {
            return 0;
        }

        long sum = x;
        int count = 0;
        while (sum < target) {
            count++;
            sum *= x;
        }

        if (sum == target) {
            return count;
        }

        int sub = sum - target < target ? leastOpsExpressTarget(x, (int) (sum - target)) + count
                                        : Integer.MAX_VALUE;
        int add = leastOpsExpressTarget(x, (int) (target - sum / x)) + count - 1;

        return Math.min(sub, add) + 1;
    }
}