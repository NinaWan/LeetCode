class Solution {
    public String intToRoman(int num) {
        String result = "";
        int[] integers = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < integers.length; i++) {
            for (int j = 1; j <= num / integers[i]; j++) {
                result += romans[i];
            }

            num = num % integers[i];
        }

        return result;
    }
}