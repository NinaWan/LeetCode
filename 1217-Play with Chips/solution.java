class Solution {
    public int minCostToMoveChips(int[] position) {
        int oddCount = 0, evenCount = 0;

        for (int p : position) {
            if (p % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        return Math.min(oddCount, evenCount);
    }
}