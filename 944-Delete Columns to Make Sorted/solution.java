class Solution {
    public int minDeletionSize(String[] A) {
        if (null == A || A.length == 0) {
            return 0;
        }

        int result = 0;
        int columnNum = A[0].length();
        int rowNum = A.length;

        for (int i = 0; i < columnNum; i++) {
            for (int j = 0; j < rowNum - 1; j++) {
                if (A[j].charAt(i) > A[j + 1].charAt(i)) {
                    result++;
                    break;
                }
            }
        }

        return result;
    }
}