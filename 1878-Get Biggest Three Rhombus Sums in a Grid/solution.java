class Solution {
    public int[] getBiggestThree(int[][] grid) {
        TreeSet<Integer> ans = new TreeSet<Integer>((a, b) -> b - a);
        int m = grid.length, n = grid[0].length;
        int maxLength = (Math.min(m, n) + 1) / 2;

        for (int l = 0; l < maxLength; l++) {
            for (int i = 0; i < m - 2 * l; i++) {
                for (int j = l; j < n - l; j++) {
                    int sum = 0;
                    for (int k = 0; k <= 2 * l; k++) {
                        if (k == 0 || k == 2 * l) {
                            sum += grid[i + k][j];
                        } else if (k <= l) {
                            sum += grid[i + k][j - k] + grid[i + k][j + k];
                        } else {
                            sum += grid[i + k][j - (2 * l - k)] + grid[i + k][j + (2 * l - k)];
                        }
                    }

                    ans.add(sum);
                    if (ans.size() > 3) {
                        ans.pollLast();
                    }
                }
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}