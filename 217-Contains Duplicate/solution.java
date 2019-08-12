public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (null == nums || nums.length == 0) return false;

        HashSet<Integer> hs = new HashSet<Integer>();
        for (int num : nums) {
            if (hs.contains((Integer) num)) return true;
            hs.add((Integer) num);
        }
        return false;
    }
}