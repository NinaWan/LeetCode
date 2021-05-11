/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peek = findPeek(mountainArr, n);
        int left = findInLeft(mountainArr, 0, peek, target);

        return left != -1 ? left
                          : findInRight(mountainArr, peek, n - 1, target);
    }

    private int findPeek(MountainArray mountainArr, int n) {
        int low = 0, high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int value = mountainArr.get(mid);
            if (mid > 0 && mid < n - 1 && mountainArr.get(mid - 1) < value && mountainArr.get(mid + 1) < value) {
                return mid;
            } else if (mid == 0 || mountainArr.get(mid - 1) < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private int findInLeft(MountainArray mountainArr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = mountainArr.get(mid);
            if (value == target) {
                return mid;
            } else if (value < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private int findInRight(MountainArray mountainArr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = mountainArr.get(mid);
            if (value == target) {
                return mid;
            } else if (value < target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}