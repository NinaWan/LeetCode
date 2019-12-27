class Solution {
    public int minFlipsMonoIncr(String S) {
        int result = Integer.MAX_VALUE;
        int[] sum = new int[S.length() + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] += sum[i - 1] + (S.charAt(i - 1) - '0');
        }

        for (int i = 0; i < sum.length; i++) {
            int left = sum[i];// number of ones on the left side
            int right = sum.length - 1 - i - (sum[sum.length - 1] - sum[i]);// number of zeros on the right side
            result = Math.min(result, left + right);
        }

        return result;
    }
}