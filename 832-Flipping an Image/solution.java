class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        if (null == A) {
            return A;
        }

        int[][] result = new int[A.length][A[0].length];
        // flip horizontally
        for (int row = 0; row < A.length; row++) {
            for (int column = 0; column < A[row].length; column++) {
                result[row][A[row].length - column - 1] = A[row][column] == 0 ? 1
                                                                              : 0;
            }
        }

        return result;
    }
}