class Solution {
    TreeMap<Integer, Integer> treeMap;
    int[][] rects;
    Random random;
    int count;

    public Solution(int[][] rects) {
        this.treeMap = new TreeMap();
        this.random = new Random();
        this.count = 0;
        this.rects = rects;
        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            count += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            treeMap.put(count, i);
        }
    }

    public int[] pick() {
        int randomCount = this.random.nextInt(this.count) + 1;
        Map.Entry<Integer, Integer> entry = treeMap.ceilingEntry(randomCount);
        int[] rect = this.rects[entry.getValue()];
        int subCount = entry.getKey();

        int x = rect[0] + (subCount - randomCount) % (rect[2] - rect[0] + 1);
        int y = rect[1] + (subCount - randomCount) / (rect[2] - rect[0] + 1);

        return new int[] {x, y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */