class Solution {
    public boolean backspaceCompare(String S, String T) {
        int backA = 0;
        int backB = 0;
        int i = S.length() - 1, j = T.length() - 1;
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (backA != 0 || S.charAt(i) == '#')) {
                if (S.charAt(i) == '#') {
                    backA++;
                } else {
                    backA--;
                }
                i--;
            }

            while (j >= 0 && (backB != 0 || T.charAt(j) == '#')) {
                if (T.charAt(j) == '#') {
                    backB++;
                } else {
                    backB--;
                }
                j--;
            }

            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }

                i--;
                j--;
            }

            if (i < 0 && j >= 0 && T.charAt(j) != '#') {
                return false;
            }

            if (j < 0 && i >= 0 && S.charAt(i) != '#') {
                return false;
            }
        }

        return i == -1 && j == -1;
    }
}