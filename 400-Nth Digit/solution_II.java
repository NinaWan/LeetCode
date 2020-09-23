class Solution {
    public int findNthDigit(int n) {
        int i = 1;
        long count = 9;
        int start = 1;

        while (n > i * count) {
            n -= i * count;
            count *= 10;
            start *= 10;
            i++;
        }

        return Integer.valueOf(String.valueOf(String.valueOf(start + (n - 1) / i).charAt((n - 1) % i)));
    }
}