class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int result = 0;
        int left = 0;
        int right = k - 1;
        int subSum = 0;

        for (int i = left; i <= right; i++) {
            subSum += arr[i];
        }

        if (subSum / k >= threshold) {
            result++;
        }

        while (right < arr.length - 1) {
            subSum += arr[right + 1];
            subSum -= arr[left];

            if (subSum / k >= threshold) {
                result++;
            }

            right++;
            left++;
        }

        return result;
    }
}