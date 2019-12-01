class Solution {
    public String tictactoe(int[][] moves) {
        int cliA = 0, rcliA = 0, cliB = 0, rcliB = 0;
        int[] rA = new int[3], cA = new int[3], rB = new int[3], cB = new int[3];

        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) { // A plays
                if (moves[i][0] == moves[i][1]) {
                    cliA++;
                }

                if (moves[i][0] == 2 - moves[i][1]) {
                    rcliA++;
                }

                rA[moves[i][0]]++;
                cA[moves[i][1]]++;

                if (cliA == 3 || rcliA == 3 || rA[moves[i][0]] == 3 || cA[moves[i][1]] == 3) {
                    return "A";
                }
            } else { // B plays
                if (moves[i][0] == moves[i][1]) {
                    cliB++;
                }

                if (moves[i][0] == 2 - moves[i][1]) {
                    rcliB++;
                }

                rB[moves[i][0]]++;
                cB[moves[i][1]]++;

                if (cliB == 3 || rcliB == 3 || rB[moves[i][0]] == 3 || cB[moves[i][1]] == 3) {
                    return "B";
                }
            }
        }

        if (moves.length == 9) {
            return "Draw";
        }

        return "Pending";
    }
}