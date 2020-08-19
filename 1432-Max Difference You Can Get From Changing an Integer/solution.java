class Solution {
    public int maxDiff(int num) {
        int max = num;
        int min = num;

        for (char x = '0'; x <= '9'; x++) {
            for (char y = '0'; y <= '9'; y++) {
                String s = String.valueOf(num).replace(x, y);
                if (!s.startsWith("0")) {
                    max = Math.max(max, Integer.valueOf(s));
                    min = Math.min(min, Integer.valueOf(s));
                }
            }
        }

        return max - min;
    }
}