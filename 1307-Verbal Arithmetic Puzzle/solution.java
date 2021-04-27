class Solution {
    public boolean isSolvable(String[] words, String result) {
        int[] pow10 = new int[] {1, 10, 100, 1000, 10000, 100000, 1000000};
        boolean[] leadingChars = new boolean[26];
        Set<Character> charSet = new HashSet();
        int[] count = new int[26];

        for (String word : words) {
            if (word.length() > 1) {
                leadingChars[word.charAt(0) - 'A'] = true;
            }

            char[] wchars = word.toCharArray();
            for (int i = 0; i < wchars.length; i++) {
                char c = wchars[i];
                charSet.add(c);
                count[c - 'A'] += pow10[wchars.length - i - 1];
            }
        }

        if (result.length() > 1) {
            leadingChars[result.charAt(0) - 'A'] = true;
        }
        char[] rchars = result.toCharArray();
        for (int i = 0; i < rchars.length; i++) {
            char c = rchars[i];
            charSet.add(c);
            count[c - 'A'] -= pow10[rchars.length - i - 1];
        }

        return backtracking(new boolean[10], charSet.toArray(new Character[charSet.size()]), leadingChars, 0, 0, count);
    }

    private boolean backtracking(boolean[] digitUsed, Character[] chars, boolean[] leadingChars, int idx, int diff, int[] count) {
        if (idx == chars.length) {
            return diff == 0;
        }

        char c = chars[idx];
        for (int i = 0; i < 10; i++) {
            if (!digitUsed[i] && (i > 0 || !leadingChars[c - 'A'])) {
                digitUsed[i] = true;
                if (backtracking(digitUsed, chars, leadingChars, idx + 1, diff - i * count[c - 'A'], count)) {
                    return true;
                }
                digitUsed[i] = false;
            }
        }

        return false;
    }
}