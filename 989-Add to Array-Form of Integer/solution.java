class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList();

        for (int num : A) {
            result.add(num);
        }

        int carryOver = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            if (K == 0 && carryOver == 0) {
                break;
            }

            int sum = A[i] + K % 10 + carryOver;
            result.set(i, sum % 10);
            carryOver = sum / 10;
            K = K / 10;

            if (i == 0) {
                K = carryOver + K;
                while (K != 0) {
                    result.add(0, K % 10);
                    K = K / 10;
                }
            }
        }

        return result;
    }
}