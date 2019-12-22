class Solution {
    public int maxChunksToSorted(int[] arr) {
        int result = 1;
        int[] min = new int[arr.length];
        min[arr.length - 1] = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            min[i] = Math.min(min[i + 1], arr[i]);
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max <= min[i]) {
                result++;
            }
            max = Math.max(max, arr[i]);
        }

        return result;
    }
}