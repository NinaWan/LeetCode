public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq = new HashMap();
        List<Integer> intersection = new ArrayList();

        for (int num1 : nums1) {
            freq.put(num1, freq.getOrDefault(num1, 0) + 1);
        }
        for (int num2 : nums2) {
            if (freq.getOrDefault(num2, 0) != 0) {
                intersection.add(num2);
                freq.put(num2, freq.get(num2) - 1);
            }
        }

        int[] result = new int[intersection.size()];
        for (int i = 0; i < result.length; i++) result[i] = intersection.get(i);
        return result;
    }
}