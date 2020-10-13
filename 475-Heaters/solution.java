class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int ans = 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);

        for (int i = 0; i < houses.length; i++) {
            int idx = Arrays.binarySearch(heaters, houses[i]);
            idx = idx < 0 ? -(idx + 1) : idx;
            if (idx == 0) {
                ans = Math.max(ans, heaters[0] - houses[i]);
            } else if (idx == heaters.length) {
                ans = Math.max(ans, houses[i] - heaters[heaters.length - 1]);
            } else {
                ans = Math.max(ans, Math.min(heaters[idx] - houses[i], houses[i] - heaters[idx - 1]));
            }
        }

        return ans;
    }
}