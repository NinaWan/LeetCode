class Solution {
    public void duplicateZeros(int[] arr) {
        int dupCount = 0;
        int zeroCount = 0;
        for (int i = 0; i < arr.length; i++) {
            zeroCount += arr[i] == 0 ? 1 : 0;
            dupCount += arr[i] == 0 ? 1 : 0;

            if (i + dupCount + 1 >= arr.length) {
                if (i + dupCount + 1 > arr.length) {
                    dupCount--;
                }
                break;
            }
        }

        int p = arr.length - 1;
        for (int i = arr.length - 1 - dupCount; i >= 0; i--) {
            arr[p] = arr[i];

            if (arr[i] == 0) {
                if (zeroCount == dupCount) {
                    arr[--p] = 0;
                } else {
                    zeroCount--;
                }
            }

            p--;
        }
    }
}