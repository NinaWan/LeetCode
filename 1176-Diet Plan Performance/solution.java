class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        if (null == calories || calories.length == 0) {
            return 0;
        }

        int point = 0;
        int start = 0;
        int end = start + k - 1;

        while (end < calories.length) {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += calories[i];
            }

            if (sum < lower) {
                point--;
            } else if (sum > upper) {
                point++;
            }

            start++;
            end = start + k - 1;
        }

        return point;
    }
}