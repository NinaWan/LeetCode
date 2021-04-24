class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        Map<Integer, Integer> count = new HashMap();
        int ans = 0;

        for (int i = 0, j = 0, k = 0, prefix = 0; j < A.length; j++) {
            int c = count.getOrDefault(A[j], 0);
            if (c == 0) {
                k++;
            }
            count.put(A[j], c + 1);

            if (k > K) {
                count.put(A[i], count.get(A[i]) - 1);
                prefix = 0;
                k--;
                i++;
            }

            while (count.get(A[i]) > 1) {
                count.put(A[i], count.get(A[i]) - 1);
                prefix++;
                i++;
            }

            if (k == K) {
                ans += prefix + 1;
            }
        }

        return ans;
    }
}