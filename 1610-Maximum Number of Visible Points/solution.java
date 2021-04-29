class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList();
        int count = 0;
        int px = location.get(0), py = location.get(1);

        for (List<Integer> point : points) {
            int dx = point.get(0) - px, dy = point.get(1) - py;
            if (dx == 0 && dy == 0) {
                count++;
            } else {
                angles.add(Math.toDegrees(Math.atan2(dy, dx)));
            }
        }

        Collections.sort(angles);
        List<Double> dump = new ArrayList(angles);
        for (Double a : angles) {
            dump.add(a + 360);
        }
        int ans = count;
        for (int i = 0, j = 0; i < dump.size(); i++) {
            while (j < dump.size() && dump.get(j) - dump.get(i) <= angle) {
                j++;
            }
            ans = Math.max(ans, count + j - i);
        }

        return ans;
    }
}