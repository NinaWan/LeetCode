class Solution {
    public int[] sortArrayByParity(int[] A) {
        int left = 0;
        int right = A.length - 1;

        while (left < right) {
            if (A[left] % 2 == 0) {
                left++;
                continue;
            }

            if (A[right] % 2 == 1) {
                right--;
                continue;
            }

            if (A[left] % 2 == 1 && A[right] % 2 == 0) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                right--;
                left++;
            }
        }

        return A;
    }
}