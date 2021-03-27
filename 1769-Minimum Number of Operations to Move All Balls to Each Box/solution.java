class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        int[] right = new int[n];
        int count = boxes.charAt(0) == '1' ? 1
                                           : 0;

        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] + count;
            count += boxes.charAt(i) == '1' ? 1
                                            : 0;
        }

        count = boxes.charAt(n - 1) == '1' ? 1
                                           : 0;

        for (int j = n - 2; j >= 0; j--) {
            right[j] = right[j + 1] + count;
            count += boxes.charAt(j) == '1' ? 1
                                            : 0;
            ans[j] += right[j];
        }

        return ans;
    }
}