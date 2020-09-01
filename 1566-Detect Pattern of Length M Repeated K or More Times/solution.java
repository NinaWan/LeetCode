class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        if (m * k > arr.length) {
            return false;
        }

        for (int l = 0; l + m * k <= arr.length; l++) {
            boolean isValid = true;
            for (int i = l; i < m + l && isValid; i++) {
                int curr = arr[i];
                for (int j = 1; j < k; j++) {
                    if (arr[i + m * j] != curr) {
                        isValid = false;
                        break;
                    }
                }
            }

            if (isValid) {
                return true;
            }
        }

        return false;
    }
}