class MajorityChecker {
    int[] arr;
    Map<Integer, List<Integer>> posMap = new HashMap();

    public MajorityChecker(int[] arr) {
        this.arr = arr;
        for (int i = 0; i < arr.length; i++) {
            if (!posMap.containsKey(arr[i])) {
                posMap.put(arr[i], new ArrayList());
            }
            posMap.get(arr[i]).add(i);
        }
    }

    public int query(int left, int right, int threshold) {
        Random rn = new Random();

        for (int i = 0; i < 20; i++) {
            int randomIndex = rn.nextInt(right - left + 1) + left;

            if (getOccurrence(left, right, arr[randomIndex]) >= threshold) {
                return arr[randomIndex];
            }
        }

        return -1;
    }

    private int getOccurrence(int left, int right, int target) {
        List<Integer> indexes = posMap.get(target);

        int start = 0, end = indexes.size() - 1;
        int i = -1, j = -1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (indexes.get(mid) == left) {
                i = mid;
                break;
            }

            if (indexes.get(mid) < left) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (i == -1) {
            i = start;
        }

        start = 0;
        end = indexes.size() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (indexes.get(mid) == right) {
                j = mid + 1;
                break;
            }

            if (indexes.get(mid) < right) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (j == -1) {
            j = indexes.get(start) > right ? start
                                           : start + 1;
        }

        return j - i;
    }
}

/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr);
 * int param_1 = obj.query(left,right,threshold);
 */