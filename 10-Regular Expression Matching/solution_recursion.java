class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0, new HashMap());
    }

    public boolean isMatch(String s, int i, String p, int j, Map<String, Boolean> memo) {// if s[i..] matches p[j...]
        if (j == p.length()) {
            return i == s.length();
        }

        if (i == s.length()) {// left part in pattern should be like a*b*...
            if ((p.length() - j) % 2 == 1) {
                return false;
            }

            for (; j < p.length() - 1; j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }

            return true;
        }

        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        boolean res = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {// if s[i] matches p[j]
            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {// can match 0 or more characters
                res = isMatch(s, i, p, j + 2, memo) || isMatch(s, i + 1, p, j, memo);
            } else {
                res = isMatch(s, i + 1, p, j + 1, memo);
            }
        } else {// s[i] not matches p[j]
            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {// only can match 0 characters
                res = isMatch(s, i, p, j + 2, memo);
            } else {
                res = false;
            }
        }

        memo.put(key, res);
        return res;
    }
}