class Solution {
    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];

        int left = 0, right = A.length - 1, i = A.length - 1;
        while (left <= right && i >= 0) {
            int l = A[left] * A[left];
            int r = A[right] * A[right];

            if (l > r) {
                result[i] = l;
                left++;
            } else {
                result[i] = r;
                right--;
            }

            i--;
        }

        return result;
    }
}