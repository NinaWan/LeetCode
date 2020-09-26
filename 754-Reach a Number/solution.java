class Solution {
    public int reachNumber(int target) {
        int sum = 0;
        int i = 0;
        int t = Math.abs(target);

        while (sum < t) {
            i++;
            sum += i;
        }

        while ((sum - t) % 2 != 0) {
            i++;
            sum += i;
        }

        return i;
    }
}