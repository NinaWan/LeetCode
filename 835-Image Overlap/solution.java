class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        List<int[]> aOnes = new ArrayList();
        List<int[]> bOnes = new ArrayList();

        // find all locations of one in A and B
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (A[i][j] == 1) {
                    aOnes.add(new int[] {i, j});
                }

                if (B[i][j] == 1) {
                    bOnes.add(new int[] {i, j});
                }
            }
        }

        // for each pair calculate the horiz and vertical distances
        Map<String, Integer> distances = new HashMap();
        for (int[] aPos : aOnes) {
            for (int[] bPos : bOnes) {
                String key = String.valueOf(aPos[0] - bPos[0]) + "," + String.valueOf(aPos[1] - bPos[1]);
                distances.put(key, distances.getOrDefault(key, 0) + 1);
            }
        }

        // find the maxes count
        int result = 0;
        for (int count : distances.values()) {
            result = Math.max(result, count);
        }
        return result;
    }
}