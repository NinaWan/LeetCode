class Solution {
    public String fractionAddition(String expression) {
        int numerator = 0;
        int denominator = 1;

        List<Character> signs = new ArrayList();
        if (expression.charAt(0) != '-') {
            signs.add('+');
        } else {
            signs.add('-');
            expression = expression.substring(1, expression.length());
        }
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-') {
                signs.add(c);
            }
        }

        String[] fractions = expression.split("\\+|-");
        for (int i = 0; i < fractions.length; i++) {
            String[] temp = fractions[i].split("/");
            int[] fraction = new int[] {Integer.valueOf(temp[0]), Integer.valueOf(temp[1])};
            if (denominator != fraction[1]) {
                numerator *= fraction[1];
                fraction[0] *= denominator;
                denominator = denominator * fraction[1];
            }

            if (signs.get(i) == '-') {
                numerator -= fraction[0];
            } else {
                numerator += fraction[0];
            }

            int gcd = greatestCommonDivisor(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }

        return numerator + "/" + denominator;
    }

    private int greatestCommonDivisor(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}