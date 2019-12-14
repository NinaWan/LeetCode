class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int end = 0;
        int start = 0;
        for (int weight : weights) {
            end += weight;
            start = Math.max(start, weight);
        }

        while (start < end) {
            int mid = start + (end - start) / 2;
            int daysNeeded = calculateDaysNeeded(weights, mid);
            if (daysNeeded > D) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }

    private int calculateDaysNeeded(int[] weights, int capacity) {
        int daysNeeded = 0;
        int currLoading = 0;
        for (int weight : weights) {
            currLoading += weight;
            if (currLoading > capacity) {
                daysNeeded++;
                currLoading = weight;
            }
        }
        return daysNeeded + 1;
    }
}