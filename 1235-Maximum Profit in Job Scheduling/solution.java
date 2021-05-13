class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = endTime.length;
        Integer[] indexes = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        Arrays.sort(indexes, (a, b) -> endTime[a] - endTime[b]);

        TreeMap<Integer, Integer> dp = new TreeMap();
        dp.put(0, 0);
        for (int index : indexes) {
            int currProfit = dp.floorEntry(startTime[index]).getValue() + profit[index];
            if (currProfit > dp.lastEntry().getValue()) {
                dp.put(endTime[index], currProfit);
            }
        }

        return dp.lastEntry().getValue();
    }
}