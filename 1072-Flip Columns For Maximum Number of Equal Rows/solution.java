class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int ans = 0;
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < matrix.length; i++) {
            String row = "";
            String flip = "";
            for (int j = 0; j < matrix[i].length; j++) {
                row += matrix[i][j];
                flip += 1 - matrix[i][j];
            }

            if (map.containsKey(flip)) {
                map.put(flip, map.get(flip) + 1);
            } else {
                map.put(row, map.getOrDefault(row, 0) + 1);
            }
        }

        for (int count : map.values()) {
            ans = Math.max(ans, count);
        }

        return ans;
    }
}