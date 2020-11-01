class Solution {
    public double trimMean(int[] arr) {
        double sum = 0.0;
        int k = arr.length / 20;

        Arrays.sort(arr);
        for (int i = k; i < arr.length - k; i++) {
            sum += arr[i];
        }

        return sum / (arr.length - 2 * k);
    }
}