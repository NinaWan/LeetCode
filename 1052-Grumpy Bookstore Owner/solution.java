class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int[] unsatisfied = new int[customers.length];
        int satisfied = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                satisfied += customers[i];
            } else {
                unsatisfied[i] = customers[i];
            }
        }

        int sum = 0;
        int maxSum = 0;
        for (int right = 0; right < unsatisfied.length; right++) {
            if (right < X) {
                sum += unsatisfied[right];
            } else {
                sum += unsatisfied[right] - unsatisfied[right - X];
            }

            maxSum = Math.max(maxSum, sum);
        }

        return satisfied + maxSum;
    }
}