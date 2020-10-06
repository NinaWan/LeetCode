class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList();

        int left = 0, right = arr.length - 1;
        int idx = -1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                idx = mid;
                break;
            } else if (arr[mid] > x) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (idx == -1) {
            idx = Math.abs(arr[left] - x) <= Math.abs(arr[right] - x) ? left : right;
        }

        ans.add(arr[idx]);
        int l = idx - 1, r = idx + 1;
        while (ans.size() < k) {
            if (l < 0) {
                ans.add(arr[r]);
                r++;
                continue;
            }

            if (r >= arr.length) {
                ans.add(arr[l]);
                l--;
                continue;
            }

            if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                ans.add(arr[l]);
                l--;
            } else {
                ans.add(arr[r]);
                r++;
            }
        }

        Collections.sort(ans);
        return ans;
    }
}