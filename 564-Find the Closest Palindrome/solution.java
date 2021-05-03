class Solution {
    public String nearestPalindromic(String n) {
        if (n.equals("1")) {
            return "0";
        }

        String a = mirroring(n);
        long diffa = Math.abs(Long.valueOf(a) - Long.valueOf(n));
        diffa = diffa == 0 ? Integer.MAX_VALUE
                           : diffa;

        int r = n.length() % 2 == 0 ? n.length() / 2
                                    : n.length() / 2 + 1;
        long leftHalf = Long.valueOf(n.substring(0, r));
        String rightHalf = n.substring(r);
        String b = mirroring(String.valueOf(leftHalf + 1) + rightHalf);
        long diffb = Math.abs(Long.valueOf(b) - Long.valueOf(n));

        int i = (n.length() - 1) / 2;
        StringBuilder s = new StringBuilder(n);
        while (i >= 0 && s.charAt(i) == '0') {
            s.replace(i, i + 1, "9");
            i--;
        }
        if (i == 0 && s.charAt(0) == '1') {
            s.delete(0, 1);
            int mid = (s.length() - 1) / 2;
            s.replace(mid, mid + 1, "9");
        } else {
            s.replace(i, i + 1, "" + (char) (s.charAt(i) - 1));
        }
        String c = mirroring(s.toString());
        long diffc = Math.abs(Long.valueOf(c) - Long.valueOf(n));

        if (diffc <= diffa && diffc <= diffb) {
            return c;
        } else if (diffa <= diffb) {
            return a;
        } else {
            return b;
        }
    }

    private String mirroring(String s) {
        int mid = s.length() / 2;
        String res = s.substring(0, mid);

        return res + (s.length() % 2 == 0 ? ""
                                          : s.charAt(mid)) +
                new StringBuilder(res).reverse().toString();
    }
}