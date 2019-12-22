class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList();

        Set<Integer> set = new HashSet();
        for (int num : arr) {
            set.add(num);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            min = Math.min(min, arr[i + 1] - arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min + arr[i] && set.contains(min + arr[i])) {
                result.add(Arrays.asList(arr[i], min + arr[i]));
            }
        }

        return result;
    }
}