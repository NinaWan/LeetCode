class Solution {
    public int findMinMoves(int[] machines) {
        int sum = 0, n = machines.length;
        for (int machine : machines) {
            sum += machine;
        }

        if (sum % n != 0) {
            return -1;
        }

        int ans = 0, target = sum / n, diff = 0;
        for (int machine : machines) {
            diff += machine - target;
            ans = Math.max(ans, Math.max(Math.abs(diff), machine - target));
        }

        return ans;
    }
}