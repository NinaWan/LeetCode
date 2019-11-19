public class Solution {
    //    public int[] twoSum(int[] nums, int target) {
//        int[] result = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (target == nums[i] + nums[j]) {
//                    result[0] = i;
//                    result[1] = j;
//                    return result;
//                }
//            }
//        }
//        return result;
//    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> mapping = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if (mapping.containsKey(left)) {
                result[0] = mapping.get(left);
                result[1] = i;
                return result;
            }

            mapping.put(nums[i], i);
        }

        return result;
    }
}