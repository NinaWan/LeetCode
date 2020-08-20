class Solution {
    public int maxDistance(int[] position, int m) {
        TreeSet<Integer> set = new TreeSet();
        for (int p : position) {
            set.add(p);
        }

        int start = 1;
        int end = set.last() - set.first();

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (isValid(mid, set, m)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return isValid(start, set, m) ? start : start - 1;
    }

    private boolean isValid(int force, TreeSet<Integer> position, int m) {
        Integer p = position.first();
        while (m > 1) {
            p = position.ceiling(p + force);
            if (null == p) {
                return false;
            }
            m--;
        }

        return true;
    }
}