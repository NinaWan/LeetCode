class Solution {
    public boolean validTicTacToe(String[] board) {
        Map<Character, List<int[]>> map = new HashMap();
        for (int i = 0; i < 3; i++) {
            String row = board[i];
            for (int j = 0; j < 3; j++) {
                char c = row.charAt(j);
                List<int[]> list = map.getOrDefault(c, new ArrayList());
                list.add(new int[]{i, j});
                map.put(c, list);
            }
        }

        int numOfX = map.getOrDefault('X', new ArrayList()).size();
        int numOfO = map.getOrDefault('O', new ArrayList()).size();
        if (numOfX == numOfO || numOfX == numOfO + 1) {
            boolean isXWin = win(map.get('X'));
            boolean isOWin = win(map.get('O'));
            if ((isXWin && isOWin) || (numOfX == numOfO && isXWin) || (numOfX == numOfO + 1 && isOWin)) {
                return false;
            }

            return true;
        }

        return false;
    }

    private boolean win(List<int[]> points) {
        if (points == null) {
            return false;
        }

        int[] row = new int[3];
        int[] col = new int[3];
        int diag = 0;
        int backDiag = 0;

        for (int[] point : points) {
            row[point[0]]++;
            col[point[1]]++;
            diag += point[0] == point[1] ? 1 : 0;
            backDiag += point[0] + point[1] == 2 ? 1 : 0;
            if (row[point[0]] == 3 || col[point[1]] == 3 || diag == 3 || backDiag == 3) {
                return true;
            }
        }

        return false;
    }
}