class Solution {
    public boolean isRationalEqual(String s, String t) {
        Fraction sf = convert(s);
        Fraction tf = convert(t);

        return sf.numerator == tf.numerator && sf.denominator == tf.denominator;
    }

    private Fraction convert(String s) {
        Fraction fraction = new Fraction(0,
                                         1);
        String[] parts = s.split("[.()]");
        int nrLength = 0;// length of NonRepeatingPart

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if (part.isEmpty()) {
                continue;
            }

            long value = Long.valueOf(part);

            if (i == 0) {// IntegerPart
                fraction = new Fraction(value,
                                        1);
            } else if (i == 1) {// NonRepeatingPart
                nrLength = part.length();
                fraction.add(new Fraction(value,
                                          (long) Math.pow(10, nrLength)));
            } else {// RepeatingPart
                fraction.add(new Fraction(value,
                                          ((long) Math.pow(10, part.length()) - 1) * ((long) Math.pow(10, nrLength))));
            }
        }

        return fraction;
    }

    private class Fraction {
        private long numerator = 0, denominator = 0;

        public Fraction(long numerator,
                        long denominator) {
            long g = gcd(numerator, denominator);
            this.numerator = numerator / g;
            this.denominator = denominator / g;
        }

        public void add(Fraction that) {
            long n = this.numerator * that.denominator + this.denominator * that.numerator;
            long d = this.denominator * that.denominator;
            long g = gcd(n, d);
            this.numerator = n / g;
            this.denominator = d / g;
        }

        private long gcd(long a, long b) {
            while (b != 0) {
                long tmp = b;
                b = a % b;
                a = tmp;
            }

            return a;
        }
    }
}