class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if (name.equals(typed)) {
            return true;
        }

        int n = name.length();
        int t = typed.length();

        if (t < n) {
            return false;
        }

        int pn = 0;
        int pt = 0;
        while (pn < n && pt < t) {
            char cn = name.charAt(pn);
            char ct = typed.charAt(pt);
            int countn = 0;
            int countt = 0;

            if (cn != ct) {
                return false;
            }

            while (pn < n && name.charAt(pn) == cn) {
                countn++;
                pn++;
            }

            while (pt < t && typed.charAt(pt) == cn) {
                countt++;
                pt++;
            }

            if (countt < countn) {
                return false;
            }
        }

        return pt == t && pn == n ? true
                                  : false;
    }
}