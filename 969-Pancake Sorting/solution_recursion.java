class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new ArrayList();
        pancakeSort(arr, arr.length, ans);
        return ans;
    }

    private void pancakeSort(int[] arr, int n, List<Integer> res) {
        if (n == 1) {
            return;
        }

        int maxCake = arr[0];
        int maxCakeIndex = 0;
        for (int i = 0; i < n; i++) {// find max cake
            if (maxCake < arr[i]) {
                maxCake = arr[i];
                maxCakeIndex = i;
            }
        }

        reverse(arr, 0, maxCakeIndex);// flip max cake to top
        res.add(maxCakeIndex + 1);
        reverse(arr, 0, n - 1);// flip max cake to bottom
        res.add(n);

        pancakeSort(arr, n - 1, res);
    }

    private void reverse(int[] arr, int i, int j) {
        for (; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}