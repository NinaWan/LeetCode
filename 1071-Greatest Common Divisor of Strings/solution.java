class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int l = Math.min(l1, l2);

        String prefix = "";
        for (int i = l; i >= 1; i--) {
            prefix = str1.substring(0, i);

            if (l1 % i != 0 || l2 % i != 0) {
                continue;
            }

            if (!str2.startsWith(prefix)) {
                return "";
            }

            if (isDividedBy(str1, prefix) && isDividedBy(str2, prefix)) {
                return prefix;
            }
        }

        return "";
    }

    private boolean isDividedBy(String s, String t) {
        String tmp = "";
        for (int i = 1; i <= s.length() / t.length(); i++) {
            tmp += t;
        }

        return tmp.equals(s);
    }
}