class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 0;
        Map<Character, Integer> map = new HashMap() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            result += map.get(chars[i]);
            result -= 2 * (i == chars.length - 1 ? 0
                                                 : map.get(chars[i]) < map.get(chars[i + 1]) ? map.get(chars[i])
                                                                                             : 0);
        }

        return result;
    }
}