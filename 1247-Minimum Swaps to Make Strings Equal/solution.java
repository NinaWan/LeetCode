class Solution {
    public int minimumSwap(String s1, String s2) {
        int x2y = 0;
        int y2x = 0;

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (c1 == c2) {
                continue;
            }

            if (c1 == 'x' && c2 == 'y') {
                x2y++;
            } else {
                y2x++;
            }
        }

        if ((x2y % 2 + y2x % 2) % 2 != 0) {
            return -1;
        }

        return x2y / 2 + y2x / 2 + x2y % 2 + y2x % 2;
    }
}