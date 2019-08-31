class Solution {
    public int[] sortArrayByParity(int[] A) {
        if (null == A || A.length == 0) {
            return A;
        }

        int[] result = A.clone();

        for (int left = 0, right = A.length - 1; left < right; ) {
            int leftRemainder = result[left] % 2;
            int rightRemainder = result[right] % 2;
            if (leftRemainder == 1) {
                if (rightRemainder == 0) {
                    int temp = result[left];
                    result[left] = result[right];
                    result[right] = temp;
                    left++;
                    right--;
                } else {
                    right--;
                }
            } else {
                left++;
            }
        }

        return result;
    }
}