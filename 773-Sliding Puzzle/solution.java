class Solution {
    public int slidingPuzzle(int[][] board) {
        int[][] neighbors = {{1, 3}, {0, 4, 2}, {1, 5}, {0, 4}, {3, 1, 5}, {4, 2}};
        int m = 2, n = 3;
        String start = "";
        String target = "123450";

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                start += String.valueOf(board[i][j]);
            }
        }

        Queue<String> queue = new LinkedList();
        Set<String> visited = new HashSet();
        queue.offer(start);
        visited.add(start);

        int ans = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String curr = queue.poll();
                if (curr.equals(target)) {
                    return ans;
                }

                int idx = curr.indexOf('0');
                for (int adj : neighbors[idx]) {
                    String newBoard = swap(curr, idx, adj);
                    if (!visited.contains(newBoard)) {
                        queue.offer(newBoard);
                        visited.add(newBoard);
                    }
                }
            }

            ans++;
        }

        return -1;
    }

    private String swap(String s, int i, int j) {
        char[] chs = s.toCharArray();
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
        return new String(chs);
    }
}