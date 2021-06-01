class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        if (n - 1 > hour) {
            return -1;
        }

        int low = 1, high = (int) 1e9;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isValid(dist, mid, hour)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return isValid(dist, low, hour) ? low
                                        : -1;
    }

    private boolean isValid(int[] dist, int speed, double hour) {
        double sum = 0.0;
        for (int i = 0; i < dist.length; i++) {
            if (i == dist.length - 1) {
                sum += (double) dist[i] / speed;
            } else {
                sum += dist[i] % speed == 0 ? dist[i] / speed
                                            : dist[i] / speed + 1;
            }
        }

        return sum <= hour;
    }
}