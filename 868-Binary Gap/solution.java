class Solution {
    public int binaryGap(int N) {
        int ans = 0;
        int pre = -1;
        int curr = 1;

        while (N != 0) {
            if (N % 2 == 1) {
                if (pre != -1) {
                    ans = Math.max(ans, curr - pre);
                }
                pre = curr;
            }
            curr++;
            N /= 2;
        }

        return ans;
    }
}