class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (duration == 0 || timeSeries == null || timeSeries.length == 0) {
            return 0;
        }

        int result = 0;
        int preEnd = timeSeries[0] + duration;
        int start = timeSeries[0];
        for (int i = 0; i < timeSeries.length; i++) {
            if (timeSeries[i] > preEnd) {
                result += preEnd - start;
                start = timeSeries[i];
                preEnd = start + duration;
            } else {
                preEnd = Math.max(preEnd, timeSeries[i] + duration);
            }
        }

        return result + preEnd - start;
    }
}