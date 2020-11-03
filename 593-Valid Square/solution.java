class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = {p1,
                     p2,
                     p3,
                     p4};
        Arrays.sort(p, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        double side = distance(p[0], p[1]);
        return side != 0 && distance(p[1], p[3]) == side && distance(p[3], p[2]) == side && distance(p[2], p[0]) == side &&
                distance(p[0], p[3]) == distance(p[1], p[2]);
    }

    private double distance(int[] p1, int[] p2) {
        return Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2);
    }
}