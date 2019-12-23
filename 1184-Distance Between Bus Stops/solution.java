class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int min = Math.min(start, destination);
        int max = Math.max(start, destination);

        if (start == destination) {
            return 0;
        }

        int clockwiseSum = 0;
        int sum = 0;

        for (int d : distance) {
            sum += d;
        }

        for (int i = min; i < max; i++) {
            clockwiseSum += distance[i];
        }

        return Math.min(clockwiseSum, sum - clockwiseSum);
    }
}