class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        List<Integer> uglyNums = new ArrayList();
        uglyNums.add(1);
        Map<Integer, Integer> primeMap = new HashMap();
        for (int prime : primes) {
            primeMap.put(prime, 0);
        }

        if (primeMap.containsKey(1)) {
            return n;
        }

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            List<Integer> list = new ArrayList();
            for (int prime : primes) {
                int curr = prime * uglyNums.get(primeMap.get(prime));
                if (curr == min) {
                    list.add(prime);
                } else if (curr < min) {
                    min = curr;
                    list.clear();
                    list.add(prime);
                }
            }
            for (int p : list) {
                primeMap.put(p, primeMap.get(p) + 1);
            }
            uglyNums.add(min);
        }

        return uglyNums.get(uglyNums.size() - 1);
    }
}