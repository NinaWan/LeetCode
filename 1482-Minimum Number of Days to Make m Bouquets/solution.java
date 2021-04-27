class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m > bloomDay.length || (bloomDay.length / k) < m) {
            return -1;
        }

        int maxBloomDay = 0;
        int minBloomDay = Integer.MAX_VALUE;

        for (int day : bloomDay) {
            maxBloomDay = Math.max(maxBloomDay, day);
            minBloomDay = Math.min(minBloomDay, day);
        }

        int start = minBloomDay, end = maxBloomDay;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (hasEnoughBouquets(bloomDay, m, k, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return hasEnoughBouquets(bloomDay, m, k, start) ? start
                                                        : -1;
    }

    private boolean hasEnoughBouquets(int[] bloomDay, int m, int k, int days) {
        int adj = 0;
        int bouquets = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= days) {
                adj++;
            } else {
                adj = 0;
            }

            if (adj == k) {
                bouquets++;
                adj = 0;
            }

            if (bouquets == m) {
                return true;
            }
        }

        return false;
    }
}