class Solution {
    public int maximumPopulation(int[][] logs) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int x = 2049; x >= 1950; x--) {
            int count = 0;
            for (int i = 0; i < logs.length; i++) {
                if (logs[i][0] <= x && x < logs[i][1]) {
                    count++;
                }
            }
            map.put(count, x);
            max = Math.max(max, count);
        }

        return map.get(max);
    }
}