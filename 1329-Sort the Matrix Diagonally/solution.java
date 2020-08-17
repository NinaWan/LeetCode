class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        Map<Integer, PriorityQueue<Integer>> map = new HashMap();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                PriorityQueue<Integer> queue = map.getOrDefault(key, new PriorityQueue());
                queue.offer(mat[i][j]);
                map.put(key, queue);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = map.get(i - j).poll();
            }
        }

        return result;
    }
}