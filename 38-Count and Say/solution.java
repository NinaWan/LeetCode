class Solution {
    public String countAndSay(int n) {
        String result = "1";

        for (int i = 2; i <= n; i++) {
            char group = result.charAt(0);
            String temp = "";
            int count = 0;
            for (int m = 0; m < result.length(); m++) {
                if (result.charAt(m) == group) {
                    count++;
                } else {
                    temp += String.valueOf(count) + String.valueOf(group);
                    count = 1;
                    group = result.charAt(m);
                }
                if (m == result.length() - 1) {
                    temp += String.valueOf(count) + String.valueOf(group);
                }
            }
            result = temp;
        }

        return result;
    }
}