class Solution {
    public int countTriplets(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }

        int result = 0;
        int[] preXOR = new int[arr.length];

        // initialize preXOR
        preXOR[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            preXOR[i] = preXOR[i - 1] ^ arr[i];
            if (preXOR[i] == 0) {
                result += i;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 2; j < arr.length; j++) {
                if ((preXOR[i] ^ preXOR[j]) == 0) {
                    result += j - i - 1;
                }
            }
        }

        return result;
    }
}