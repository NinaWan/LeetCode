/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start + 1 < end) {
            int mid = mid = start + (end - start) / 2;

            if (!isBadVersion(mid - 1) && isBadVersion(mid)) {
                return mid;
            }

            if (!isBadVersion(mid - 1) && !isBadVersion(mid)) {
                start = mid;
            }

            if (isBadVersion(mid - 1) && isBadVersion(mid)) {
                end = mid;
            }
        }

        if (!isBadVersion(start - 1) && isBadVersion(start)) {
            return start;
        }

        if (!isBadVersion(end - 1) && isBadVersion(end)) {
            return end;
        }

        return -1;
    }
}