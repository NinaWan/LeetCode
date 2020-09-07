class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        String ans = "";
        if (!((numerator > 0 && denominator > 0) || (numerator < 0 && denominator < 0))) {
            ans += "-";
        }

        long quotient = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        Map<Long, Integer> map = new HashMap();
        ans += quotient / den;

        quotient = quotient % den;
        if (quotient == 0) {
            return ans;
        } else {
            ans += ".";
            map.put(quotient, ans.length());
        }

        while (quotient != 0) {
            quotient *= 10;
            ans += quotient / den;
            quotient = quotient % den;
            if (map.containsKey(quotient)) {
                ans = ans.substring(0, map.get(quotient)) + "(" + ans.substring(map.get(quotient), ans.length()) + ")";
                return ans;
            } else {
                map.put(quotient, ans.length());
            }
        }

        return ans;
    }
}