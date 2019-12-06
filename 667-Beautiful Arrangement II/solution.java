class Solution {
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];

        for (int i = 1; i <= n - k; i++) {
            result[i - 1] = i;
        }

        int low = n - k + 1;
        int high = n;
        int flag = 0;
        for (int i = n - k; i < n; i++) {
            if (flag % 2 == 0) {
                result[i] = high;
                high--;
            } else {
                result[i] = low;
                low++;
            }
            flag++;
        }

        return result;
    }
}