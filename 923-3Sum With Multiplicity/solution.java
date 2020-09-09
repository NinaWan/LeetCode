class Solution {
    public int threeSumMulti(int[] A, int target) {
        long ans = 0;
        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            if (A[i] > target) {
                break;
            }

            ans += twoSum(A, target - A[i], i + 1, A.length - 1);
            ans %= 1e9 + 7;
        }

        return (int) ans;
    }

    private long twoSum(int[] A, int target, int start, int end) {
        int i = start, j = end;
        long ans = 0;

        while (i < j) {
            if (A[i] + A[j] == target) {// need to handle duplicate elements
                long countl = 1, countr = 1;
                while (i + 1 < j && A[i] == A[i + 1]) {
                    countl++;
                    i++;
                }

                while (i + 1 < j && A[j] == A[j - 1]) {
                    countr++;
                    j--;
                }

                ans += A[i] == A[j] ? (countl + 1) * countl / 2 : countl * countr;
                ans %= 1e9 + 7;

                i++;
                j--;
            } else if (A[i] + A[j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return ans;
    }
}