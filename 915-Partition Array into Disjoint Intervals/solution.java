class Solution {
    public int partitionDisjoint(int[] A) {
        int[] max = new int[A.length];
        int[] min = Arrays.copyOf(A, A.length);
        max[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            max[i] = Math.max(max[i - 1], A[i]);
            min[A.length - 1 - i] = Math.min(min[A.length - i], A[A.length - 1 - i]);
        }

        for (int i = 0; i < A.length - 1; i++) {
            if (max[i] <= min[i + 1]) {
                return i + 1;
            }
        }

        return A.length;
    }
}