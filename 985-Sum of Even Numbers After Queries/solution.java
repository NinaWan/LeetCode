class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] answer = new int[queries.length];
        int sum = 0;
        for (int num : A) {
            if (num % 2 == 0) {
                sum += num;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][1];
            int val = queries[i][0];

            if (A[index] % 2 == 0) {
                sum -= A[index];
            }

            A[index] += val;

            if (A[index] % 2 == 0) {
                sum += A[index];
            }

            answer[i] = sum;
        }

        return answer;
    }
}