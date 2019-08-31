class Solution {
    public int[] sortedSquares(int[] A) {
        if (null == A || A.length == 0) {
            return A;
        }

        int[] result = A.clone();
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) Math.pow(result[i], 2);
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length - i - 1; j++) {
                if (result[j] > result[j + 1]) {
                    int temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }

        return result;
    }
}