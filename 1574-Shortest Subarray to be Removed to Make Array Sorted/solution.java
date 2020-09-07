class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < arr.length - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }
        if (left == arr.length - 1) {// already non-descending
            return 0;
        }

        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }

        if (arr[left] <= arr[right]) {// not overlapped
            return right - left - 1;
        }

        int ans = Math.min(arr.length - left - 1, right);

        for (int i = left; i >= 0; i--) {
            for (int j = right; j < arr.length; j++) {
                if (arr[i] <= arr[j]) {
                    ans = Math.min(ans, j - i - 1);
                    break;
                }
            }
        }

        return ans;
    }
}