class Solution {
    public int minimumBoxes(int n) {
        int sum = 0;
        int curr = 0, diff = 0;
        while (sum < n) {
            diff++;
            curr += diff;
            sum += curr;
        }

        if (sum == n) {
            return curr;
        }

        sum -= curr;
        curr -= diff;
        diff = 0;

        while (sum < n) {
            diff++;
            sum += diff;
        }

        return curr + diff;
    }
}