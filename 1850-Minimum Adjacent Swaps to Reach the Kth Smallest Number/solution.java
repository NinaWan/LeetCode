class Solution {
    public int getMinSwaps(String num, int k) {
        char[] kth = num.toCharArray();
        for (int i = 0; i < k; i++) {// find kth smallest worderful integer
            nextPermutation(kth);
        }

        return countAdjacentSwaps(num.toCharArray(), kth);
    }

    private void nextPermutation(char[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                reverse(arr, i);
                for (int j = i; j < arr.length; j++) {
                    if (arr[j] > arr[i - 1]) {
                        swap(arr, i - 1, j);
                        return;
                    }
                }
            }
        }

        // arr is already in descending order
        // reverse(arr, 0);
    }

    private void reverse(char[] arr, int start) {
        for (int i = start, j = arr.length - 1; i < j; i++, j--) {
            swap(arr, i, j);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private int countAdjacentSwaps(char[] num, char[] kth) {
        int res = 0;

        for (int i = 0; i < num.length; i++) {
            int j = i;
            while (j < num.length && num[j] != kth[i]) {
                j++;
            }
            for (; j > i; j--) {
                swap(num, j, j - 1);
                res++;
            }
        }

        return res;
    }
}