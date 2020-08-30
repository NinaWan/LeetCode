class Solution {
    public String maskPII(String S) {
        int at = S.indexOf("@");

        if (at != -1) {// email address
            char[] chars = S.substring(0, at).toCharArray();
            String name1 = Character.toString(chars[0]) + "*****" + Character.toString(chars[chars.length - 1]);

            return (name1 + S.substring(at, S.length())).toLowerCase();
        } else {// phone number
            String number = S.replaceAll("[()+-]", "").replaceAll(" ", "");
            int l = number.length();
            String mask = "***-***-" + number.substring(l - 4, l);
            for (int i = 0; i < l - 10; i++) {
                if (i == 0) {
                    mask = "-" + mask;
                }
                mask = "*" + mask;
                if (i == l - 11) {
                    mask = "+" + mask;
                }
            }

            return mask;
        }
    }
}