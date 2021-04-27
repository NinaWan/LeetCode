class Solution {
    public double minAreaFreeRect(int[][] points) {
        Map<Double, Map<Point, List<int[][]>>> map = new HashMap();
        double ans = -1;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];

                double r = Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2);
                Map<Point, List<int[][]>> centerMap = map.getOrDefault(r, new HashMap());
                Point center = new Point(p1[0] + p2[0],
                                         p1[1] + p2[1]);
                List<int[][]> pairs = centerMap.getOrDefault(center, new ArrayList());
                int[][] pair = new int[][] {p1, p2};
                pairs.add(pair);
                centerMap.put(center, pairs);
                map.put(r, centerMap);
            }
        }

        for (Map<Point, List<int[][]>> centers : map.values()) {
            for (List<int[][]> pairs : centers.values()) {
                for (int i = 0; i < pairs.size(); i++) {
                    for (int j = i + 1; j < pairs.size(); j++) {
                        double area = rectangleArea(pairs.get(i), pairs.get(j));
                        if (ans == -1 || area < ans) {
                            ans = area;
                        }
                    }
                }
            }
        }

        return ans < 0 ? 0
                       : ans;
    }

    private double rectangleArea(int[][] pair1, int[][] pair2) {
        return distance(pair1[0], pair2[0]) * distance(pair1[1], pair2[0]);
    }

    private double distance(int[] point1, int[] point2) {
        return Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));
    }
}