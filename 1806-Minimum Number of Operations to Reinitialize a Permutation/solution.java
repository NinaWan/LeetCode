class Solution {
    public int reinitializePermutation(int n) {
        int ans = 0;
        int[] arr = new int[n];
        int[] perm = new int[n];

        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }

        while (!isInitialValue(arr)) {
            ans++;
            for (int i = 0; i < n; i++) {
                arr[i] = i % 2 == 0 ? perm[i / 2]
                                    : perm[n / 2 + (i - 1) / 2];
            }
            perm = Arrays.copyOf(arr, n);
        }

        return ans;
    }

    private boolean isInitialValue(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i) {
                return false;
            }
        }

        return true;
    }
}