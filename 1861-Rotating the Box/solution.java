class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] ans = new char[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], '.');
        }

        for (int j = 0; j < m; j++) {// col of rotated box, row of original box
            for (int i = n - 1, p = n - 1; i >= 0; i--) {// row of rotated box, col of original box
                if (box[m - j - 1][i] == '#') {
                    ans[p--][j] = box[m - j - 1][i];
                } else if (box[m - j - 1][i] == '*') {
                    ans[i][j] = box[m - j - 1][i];
                    p = i - 1;
                }
            }
        }

        return ans;
    }
}