class Solution {
    public int minSetSize(int[] arr) {
        int result = 0;
        Map<Integer, Integer> freq = new HashMap();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = freq.values().stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        int count = 0;
        for (int l : list) {
            count += l;
            result++;
            if (count >= arr.length / 2) {
                break;
            }
        }

        return result;
    }
}