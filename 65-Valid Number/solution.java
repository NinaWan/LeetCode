class Solution {
    public boolean isNumber(String s) {
        if (null == s || s.length() == 0) {
            return false;
        }

        // remove leading and trailing spaces
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }

        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr >= '0' && curr <= '9') {
                numberSeen = true;
                continue;
            }

            if (curr == '.') {
                if (eSeen || pointSeen) {// if this point is after e or a point is already there
                    return false;
                }
                pointSeen = true;
                continue;
            }

            if (curr == '-' || curr == '+') {
                if (i == 0) {
                    continue;
                }

                if (i < s.length() - 1 && s.charAt(i - 1) == 'e' && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    continue;
                }

                return false;
            }

            if (curr == 'e') {
                if (eSeen || !numberSeen || i == s.length() - 1) {
                    return false;
                }
                eSeen = true;
                continue;
            }

            return false;
        }

        return numberSeen;
    }
}