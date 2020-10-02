class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;

        for (int num : nums) {
            int sum = num + 1;
            int count = 0;
            for (int i = (int) Math.sqrt(num); i > 1; i--) {
                if (count > 2) {
                    break;
                }

                if (num % i == 0) {
                    sum += i;
                    sum += i * i == num ? 0 : num / i;
                    count += i * i == num ? 1 : 2;
                }
            }

            if (count == 2) {
                ans += sum;
            }
        }

        return ans;
    }
}