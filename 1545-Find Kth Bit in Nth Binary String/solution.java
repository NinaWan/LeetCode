class Solution {
    public char findKthBit(int n, int k) {
        String[] array = new String[n];
        array[0] = "0";
        String tmp = "1";

        for (int i = 1; i < n; i++) {
            if (i == 1) {
                array[i] = "011";
            } else {
                tmp = array[i - 2] + "0" + tmp;
                array[i] = array[i - 1] + "1" + tmp;
            }
        }

        return array[n - 1].charAt(k - 1);
    }
}