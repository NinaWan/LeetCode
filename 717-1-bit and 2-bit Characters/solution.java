class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1 || bits[bits.length - 2] == 0) {
            return true;
        }

        int i = 0;
        for (; i < bits.length - 1; ) {
            i += bits[i] == 1 ? 2 : 1;
        }

        return i == bits.length - 1 ? true : false;
    }
}