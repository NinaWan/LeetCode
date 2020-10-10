class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid > 0 && mid < arr.length - 1 && arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]) {
                return mid;
            } else if (mid == 0 || (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }
}