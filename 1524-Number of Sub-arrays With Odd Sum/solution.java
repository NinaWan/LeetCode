class Solution {
    public int numOfSubarrays(int[] arr) {
        int result = 0;
        int odd = 0;
        int even = 0;
        int sum = 0;

        for (int num : arr) {
            sum += num;
            if (sum % 2 == 1) {
                result += even + 1;
                odd++;
            } else {
                result += odd;
                even++;
            }
            result %= 1e9 + 7;
        }

        return result;
    }
}