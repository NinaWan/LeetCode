class Solution {
    public int findSpecialInteger(int[] arr) {
        int index1 = findFirstIndex(arr, arr[Math.max(0, arr.length / 4 - 1)], 0, Math.max(0, arr.length / 4 - 1));
        if (arr[index1] == arr[index1 + arr.length / 4]) {
            return arr[index1];
        }

        int index2 = findFirstIndex(arr, arr[Math.max(0, arr.length / 2 - 1)], 0, Math.max(0, arr.length / 2 - 1));
        if (arr[index2] == arr[index2 + arr.length / 4]) {
            return arr[index2];
        }

        int index3 = findFirstIndex(arr, arr[Math.max(0, arr.length * 3 / 4 - 1)], 0, Math.max(0, arr.length * 3 / 4 - 1));
        if (arr[index3] == arr[index3 + arr.length / 4]) {
            return arr[index3];
        }

        return arr[arr.length - 1];
    }

    public int findFirstIndex(int[] arr, int target, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                end = mid;
                continue;
            }

            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return arr[start] == target ? start : end;
    }
}