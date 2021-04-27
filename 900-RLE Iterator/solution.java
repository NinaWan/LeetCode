class RLEIterator {
    int p = 0;
    long subSum = 0;
    long totalSum = 0;
    List<long[]> list = new ArrayList();

    public RLEIterator(int[] A) {
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] == 0) {
                continue;
            }
            totalSum += A[i];
            this.list.add(new long[] {A[i + 1], totalSum});
        }
    }

    public int next(int n) {
        subSum += n;

        if (list.isEmpty() || subSum > totalSum) {
            return -1;
        }

        for (int i = p; i < list.size(); i++) {
            long[] curr = list.get(i);
            p = i;
            if (curr[1] >= subSum) {
                return (int) curr[0];
            }
        }

        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */