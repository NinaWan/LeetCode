class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Map<Integer, Integer> occurrences = new HashMap();
        for (int num : nums) {
            int occurrence = occurrences.getOrDefault(num, 0) + 1;
            if (occurrence == nums.length / 3 + 1) {
                result.add(num);
            }
            occurrences.put(num, occurrence);
        }

        return result;
    }
}