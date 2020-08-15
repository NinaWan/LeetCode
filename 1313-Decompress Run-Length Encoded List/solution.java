class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < nums.length - 1; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                list.add(nums[i + 1]);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}