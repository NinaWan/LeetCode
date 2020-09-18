class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        List<Map<Double, Integer>> freqs = new ArrayList();

        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> freq = new HashMap();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    double dist = Math.sqrt(Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                    freq.put(dist, freq.getOrDefault(dist, 0) + 1);
                }
            }
            freqs.add(freq);
        }

        for (Map<Double, Integer> freq : freqs) {
            for (int count : freq.values()) {
                if (count > 1) {
                    ans += count * (count - 1);
                }
            }
        }

        return ans;
    }
}