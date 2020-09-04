class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int force = 0;
        int[] l2r = new int[n];
        int[] r2l = new int[n];
        String ans = "";

        for (int i = 0; i < n; i++) {
            char c = dominoes.charAt(i);
            if (c == 'R') {
                force = n;
            } else if (c == 'L') {
                force = 0;
            } else if (force > 0) {
                force--;
            }

            l2r[i] = force;
        }

        force = 0;
        for (int i = n - 1; i >= 0; i--) {
            char c = dominoes.charAt(i);
            if (c == 'L') {
                force = 0 - n;
            } else if (c == 'R') {
                force = 0;
            } else if (force < 0) {
                force++;
            }

            r2l[i] = force;
        }

        for (int i = 0; i < n; i++) {
            force = l2r[i] + r2l[i];
            if (force == 0) {
                ans += ".";
            } else if (force > 0) {
                ans += "R";
            } else {
                ans += "L";
            }
        }

        return ans;
    }
}