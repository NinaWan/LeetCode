class Solution {
    public int[] threeEqualParts(int[] arr) {
        int numOfOne = 0;
        for (int a : arr) {
            numOfOne += a;
        }

        if (numOfOne == 0) {// all zeros, return any
            return new int[] {0,
                              2};
        }
        if (numOfOne % 3 != 0) {
            return new int[] {-1,
                              -1};
        }

        int k = numOfOne / 3, count = 0;
        int first = -1, second = -1, third = -1;// start index of the first/second/third parts

        for (int i = 0; i < arr.length; i++) {
            count += arr[i];
            if (first == -1 && count == 1) {
                first = i;
            } else if (second == -1 && count == k + 1) {
                second = i;
            } else if (third == -1 && count == 2 * k + 1) {
                third = i;
            }
        }

        while (third < arr.length && arr[first] == arr[second] && arr[second] == arr[third]) {
            first++;
            second++;
            third++;
        }

        if (third == arr.length) {
            return new int[] {first - 1,
                              second};
        }

        return new int[] {-1,
                          -1};
    }
}