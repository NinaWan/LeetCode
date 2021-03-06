class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        if (null == arr || arr.length == 0) {
            return result;
        }

        int start = 0, end = arr.length - 1;

        while (end - start + 1 > k) {
            if (arr[end] - x >= x - arr[start]) {
                end--;
            } else {
                start++;
            }
        }

        for (int i = start; i <= end; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}