class Solution {
    public String generateTheString(int n) {
        String result = "";

        for (int i = 0; i < n; i++) {
            result += "a";
        }

        return n % 2 == 0 ? result.substring(0, n - 1) + "b"
                          : result;
    }
}