class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        List<Integer> list = new ArrayList();

        for (int i = 0; i < index.length; i++) {
            list.add(index[i], nums[i]);
        }

        for (int i = 0; i < target.length; i++) {
            target[i] = list.get(i);
        }

        return target;
    }
}