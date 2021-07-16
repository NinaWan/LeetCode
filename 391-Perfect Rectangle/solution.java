class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int X1 = Integer.MAX_VALUE, Y1 = Integer.MAX_VALUE;// left bottom
        int X2 = Integer.MIN_VALUE, Y2 = Integer.MIN_VALUE;// right top
        int actArea = 0, expArea = 0;

        Map<Integer, Set<Integer>> points = new HashMap();

        for (int[] rect : rectangles) {
            int x1 = rect[0], y1 = rect[1], x2 = rect[2], y2 = rect[3];
            X1 = Math.min(X1, x1);
            Y1 = Math.min(Y1, y1);
            X2 = Math.max(X2, x2);
            Y2 = Math.max(Y2, y2);

            actArea += (x2 - x1) * (y2 - y1);

            for (int x : Arrays.asList(x1, x2)) {
                for (int y : Arrays.asList(y1, y2)) {
                    checkPoint(points, x, y);
                }
            }
        }

        expArea = (X2 - X1) * (Y2 - Y1);

        if (actArea != expArea) {
            return false;
        }

        int count = 0;
        for (Set<Integer> set : points.values()) {
            count += set.size();
        }

        if (count != 4) {
            return false;
        }

        // check four points
        return existsIn(points, X1, Y1) && existsIn(points, X1, Y2) && existsIn(points, X2, Y1) && existsIn(points, X2, Y2);
    }

    private void checkPoint(Map<Integer, Set<Integer>> points, int x, int y) {
        if (points.containsKey(x) && points.get(x).contains(y)) {
            // remove point
            points.get(x).remove(y);
            if (points.get(x).isEmpty()) {
                points.remove(x);
            }
        } else {// add point
            points.computeIfAbsent(x, a -> new HashSet()).add(y);
        }
    }

    private boolean existsIn(Map<Integer, Set<Integer>> points, int x, int y) {
        if (!points.containsKey(x) || !points.get(x).contains(y)) {
            return false;
        }

        return true;
    }
}