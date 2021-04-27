class Solution {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);

        int i = 0;
        for (; i < arr.length; i++) {
            int curr = arr[i] * (arr.length - i);
            if (target >= curr) {
                target -= arr[i];
            } else {
                break;
            }
        }

        if (i == arr.length) {
            return arr[arr.length - 1];
        }

        int l = arr.length - i;
        int v = target / l;

        return Math.abs(v * l - target) <= Math.abs((v + 1) * l - target) ? v
                                                                          : v + 1;
    }
}