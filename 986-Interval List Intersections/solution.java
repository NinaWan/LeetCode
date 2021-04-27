class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> intersections = new ArrayList();

        for (int i = 0, j = 0; i < A.length && j < B.length;) {
            int[] inter = new int[2];

            if (A[i][1] < B[j][0]) {
                i++;
            } else if (B[j][1] < A[i][0]) {
                j++;
            } else {
                inter[0] = Math.max(A[i][0], B[j][0]);
                inter[1] = Math.min(A[i][1], B[j][1]);
                intersections.add(inter);
                if (B[j][1] <= A[i][1]) {
                    j++;
                } else {
                    i++;
                }
            }
        }

        int[][] ans = new int[intersections.size()][2];
        for (int i = 0; i < intersections.size(); i++) {
            ans[i] = intersections.get(i);
        }

        return ans;
    }
}