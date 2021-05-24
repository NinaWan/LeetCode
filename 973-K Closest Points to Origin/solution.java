class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int l = 0, r = points.length - 1;

        while (l < r) {
            int mid = quickSelect(points, l, r);
            if (mid == k) {
                break;
            } else if (mid > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return Arrays.copyOfRange(points, 0, k);
    }

    private int quickSelect(int[][] points, int l, int r) {
        int pivot = squareOfDistance(points[l]);
        int[] pivotPoint = points[l];

        while (l < r) {
            while (l < r && squareOfDistance(points[r]) >= pivot) {
                r--;
            }
            points[l] = points[r];
            while (l < r && squareOfDistance(points[l]) <= pivot) {
                l++;
            }
            points[r] = points[l];
        }

        points[l] = pivotPoint;

        return l;
    }

    private int squareOfDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}