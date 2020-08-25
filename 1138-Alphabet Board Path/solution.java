class Solution {
    public String alphabetBoardPath(String target) {
        String result = "";
        int pi = 0;
        int pj = 0;

        for (char c : target.toCharArray()) {
            int i = (c - 'a') / 5;
            int j = (c - 'a') % 5;

            if (pi != i || pj != j) {
                char ud = i > pi ? 'D' : 'U';
                char lr = j > pj ? 'R' : 'L';

                if (pi * 5 + pj == 25) { // from z to other character
                    for (int m = 0; m < Math.abs(i - pi); m++) {
                        result += ud;
                    }

                    for (int n = 0; n < Math.abs(j - pj); n++) {
                        result += lr;
                    }
                } else {
                    for (int n = 0; n < Math.abs(j - pj); n++) {
                        result += lr;
                    }

                    for (int m = 0; m < Math.abs(i - pi); m++) {
                        result += ud;
                    }
                }

            }

            result += '!';
            pi = i;
            pj = j;
        }

        return result;
    }
}