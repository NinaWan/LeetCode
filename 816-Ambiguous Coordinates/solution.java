class Solution {
    public List<String> ambiguousCoordinates(String S) {
        Set<String> ans = new HashSet();

        String s = S.substring(1, S.length() - 1);
        int n = s.length();

        for (int i = 1; i < n; i++) {// position of comma
            String num1 = s.substring(0, i);
            String num2 = s.substring(i, n);
            if ((i > 1 && Integer.valueOf(num1) == 0) || (i < n - 1 && Integer.valueOf(num2) == 0)) {
                continue;
            }

            int l1 = num1.length();
            int l2 = num2.length();
            String dec1 = num1;
            String dec2 = num2;
            for (int x = 1; x <= l1; x++) {// position of decimal point for number 1
                if (l1 != 1) {
                    String d1l = num1.substring(0, x);
                    String d1r = num1.substring(x, l1);
                    if ((x > 1 && Integer.valueOf(d1l.substring(0, 1)) == 0) ||
                            (x <= l1 - 1 && Integer.valueOf(d1r.substring(d1r.length() - 1, d1r.length())) == 0)) {
                        continue;
                    }

                    if (x != l1) {
                        dec1 = d1l + "." + d1r;
                    } else {
                        dec1 = num1;
                    }
                }

                for (int y = 1; y <= l2; y++) {// position of decimal point for number 2
                    if (l2 != 1) {
                        String d2l = num2.substring(0, y);
                        String d2r = num2.substring(y, l2);
                        if ((y > 1 && Integer.valueOf(d2l.substring(0, 1)) == 0) ||
                                (y <= l2 - 1 && Integer.valueOf(d2r.substring(d2r.length() - 1, d2r.length())) == 0)) {
                            continue;
                        }

                        if (y != l2) {
                            dec2 = d2l + "." + d2r;
                        } else {
                            dec2 = num2;
                        }
                    }
                    ans.add("(" + dec1 + ", " + dec2 + ")");
                }
            }
        }

        return new ArrayList(ans);
    }
}