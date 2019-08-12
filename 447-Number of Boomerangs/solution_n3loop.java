public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        System.out.println(points.length);
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < points.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    double distanceIJ = Math.sqrt(Math.pow((points[i][0] - points[j][0]), 2) + Math.pow((points[i][1] - points[j][1]), 2));
                    double distanceIK = Math.sqrt(Math.pow((points[i][0] - points[k][0]), 2) + Math.pow((points[i][1] - points[k][1]), 2));
                    if (distanceIJ == distanceIK) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}