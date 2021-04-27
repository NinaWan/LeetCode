class Solution {
    public int sumSubarrayMins(int[] A) {
        int result = 0;
        int mod = (int) 1e9 + 7;
        int[] leftDis = new int[A.length];
        int[] rightDis = new int[A.length];
        leftDis[0] = 1;
        rightDis[A.length - 1] = 1;
        Stack<Integer> pleStack = new Stack();
        Stack<Integer> nleStack = new Stack();

        for (int i = 0; i < A.length; i++) {
            int ple = -1;
            int nle = -1;
            // find the previous less element index and calculate the distance
            while (!pleStack.isEmpty() && A[i] < A[pleStack.peek()]) {
                ple = pleStack.pop();
            }
            leftDis[i] = ple == -1 ? 1
                                   : i - ple + leftDis[ple];
            pleStack.push(i);

            // find the next less element index and calculate the distance
            while (!nleStack.isEmpty() && A[A.length - 1 - i] <= A[nleStack.peek()]) {
                nle = nleStack.pop();
            }
            rightDis[A.length - 1 - i] = nle == -1 ? 1
                                                   : nle - (A.length - 1 - i) + rightDis[nle];
            nleStack.push(A.length - 1 - i);
        }

        for (int i = 0; i < A.length; i++) {
            result = (result + ((leftDis[i] * rightDis[i]) % mod * A[i]) % mod) % mod;
        }

        return result;
    }
}