class Solution {
    public boolean isPerfectSquare(int num) {
        int preSquare = 0;
        int preNum = 0;

        while (preSquare < num) {
            int left = num - preSquare - 2 * preNum - 1;
            if (left == 0) {
                return true;
            } else if (left < 0) {
                return false;
            }

            preSquare = preSquare + 2 * preNum + 1;
            preNum++;
        }

        return false;
    }
}