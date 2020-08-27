class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        int l = S.length();

        for (int i = 1; i <= Math.min(l, 10); i++) {// a fib number has at most 10 digits
            long a = Long.valueOf(S.substring(0, i));// first number
            if ((S.startsWith("0") && a != 0) || a > Integer.MAX_VALUE) {// avoid leading zeros and large numbers
                break;
            }

            for (int j = i + 1; j <= Math.min(l, i + 10); j++) {
                List<Integer> fib = new ArrayList();

                String bs = S.substring(i, j);
                long b = Long.valueOf(bs);// second number
                if (bs.startsWith("0") && b != 0 || b > Integer.MAX_VALUE || a + b > Integer.MAX_VALUE) {
                    break;
                }

                fib.add((int) a);
                fib.add((int) b);

                long next = a + b;
                String exp = String.valueOf(next);
                int k = j + exp.length();
                while (k <= l) {
                    String act = S.substring(k - exp.length(), k);

                    if (!exp.equals(act)) {
                        break;
                    }

                    fib.add((int) next);
                    next = fib.get(fib.size() - 1) + fib.get(fib.size() - 2);
                    exp = String.valueOf(next);
                    if (k == l && fib.size() > 2) {
                        return fib;
                    }
                    k += exp.length();
                }
            }
        }

        return new ArrayList();
    }
}