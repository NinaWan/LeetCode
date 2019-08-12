public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> resultSet = new HashSet<Integer>();

        // Loop two arrays to find same element
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (num1 == num2) {
                    resultSet.add(num1);
                    break;
                }
            }
        }

        // Transfer to int array
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (Integer num : resultSet) {
            result[index] = num;
            index++;
        }

        return result;
    }
}