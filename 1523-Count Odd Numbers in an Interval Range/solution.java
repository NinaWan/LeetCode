class Solution {
    public int countOdds(int low, int high) {
        if ((high - low + 1) % 2 == 0) {
            return (high - low + 1) / 2;
        }

        return low % 2 == 0 && high % 2 == 0 ? (high - low) / 2
                                             : (high - low) / 2 + 1;
    }
}