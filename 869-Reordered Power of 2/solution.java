class Solution {
    public boolean reorderedPowerOf2(int N) {
        String n = toSortedString(N);
        int curr = 1;
        for (int i = 0; i < 31; i++) {
            if (toSortedString(curr).equals(n)) {
                return true;
            }
            curr *= 2;
        }

        return false;
    }

    private String toSortedString(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        return String.valueOf(digits);
    }
}