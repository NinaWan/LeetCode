class Solution {
    public int compress(char[] chars) {
        int p = 0;
        int count = 0;
        char pre = chars[0];

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == pre) {
                count++;
            } else {
                if (count == 1) {
                    chars[p++] = pre;
                } else {
                    for (char c : (String.valueOf(pre) + String.valueOf(count)).toCharArray()) {
                        chars[p++] = c;
                    }
                }
                pre = chars[i];
                count = 1;
            }

            if (i == chars.length - 1) {
                if (count == 1) {
                    chars[p++] = pre;
                } else {
                    for (char c : (String.valueOf(pre) + String.valueOf(count)).toCharArray()) {
                        chars[p++] = c;
                    }
                }
            }
        }

        return p;
    }
}