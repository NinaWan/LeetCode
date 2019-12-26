class Solution {
    public int maxTurbulenceSize(int[] A) {
        int[] comparison = new int[A.length - 1];
        int result = 1;

        for (int i = 1; i < A.length; i++) {
            int subtraction = A[i] - A[i - 1];
            comparison[i - 1] = subtraction == 0 ? 0 : subtraction < 0 ? -1 : 1;
        }

        for (int i = 0; i < comparison.length; i++) {
            if (comparison[i] == 0) {
                continue;
            }
            int length = 1;
            for (int j = i + 1; j < comparison.length; j++) {
                if (comparison[j] * comparison[j - 1] < 0) {
                    length++;
                    if (j == comparison.length - 1) {
                        result = Math.max(result, length + 1);
                    }
                } else {
                    result = Math.max(result, length + 1);
                    i = j - 1;
                    break;
                }
            }
        }

        return result;
    }
}