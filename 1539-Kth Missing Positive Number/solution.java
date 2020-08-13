class Solution {
    public int findKthPositive(int[] arr, int k) {
        int num = 1;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != num) {
                k--;
                if (k == 0) {
                    return num;
                }
                num++;
            }

            num += i == arr.length - 1 ? 0 : 1;
        }

        while (k > 0) {
            k--;
            num++;
        }

        return num;
    }
}