class Solution {
    public int numDupDigitsAtMostN(int N) {
        int count = 0;// count of number without repeated digit
        List<Integer> digits = new ArrayList();
        for (int x = N + 1; x > 0; x /= 10) {
            digits.add(0, x % 10);
        }

        int n = digits.size();
        for (int i = 1; i < n; i++) {
            count += 9 * permutation(9, i - 1);
        }

        Set<Integer> seen = new HashSet();
        for (int i = 0; i < n; i++) {// each digit in N
            for (int j = i == 0 ? 1
                                : 0; j < digits.get(i); j++) {// each number less than current digit, exclude zero for the first digit
                if (!seen.contains(j)) {// if not appears before
                    count += permutation(9 - i, n - i - 1);// permutation of the [i+1, n-1] digits
                }
            }
            if (seen.contains(digits.get(i))) {// N itself has repeated digits, could not keep both
                break;
            }
            seen.add(digits.get(i));
        }

        return N - count;
    }

    private int permutation(int m, int n) {
        return n == 0 ? 1
                      : permutation(m, n - 1) * (m - n + 1);
    }
}