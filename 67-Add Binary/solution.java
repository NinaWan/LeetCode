class Solution {
    public String addBinary(String a, String b) {
        int carryOver = 0;
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        String result = "";

        while (p1 >= 0 || p2 >= 0 || carryOver != 0) {
            if (p1 >= 0) {
                carryOver += Character.getNumericValue(a.charAt(p1));
                p1--;
            }

            if (p2 >= 0) {
                carryOver += Character.getNumericValue(b.charAt(p2));
                p2--;
            }

            result = String.valueOf(carryOver % 2) + result;
            carryOver = carryOver / 2;
        }

        return result;
    }
}