public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            // Sum of current left and right equals target
            if (numbers[left] + numbers[right] == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }

            // Sum of current left and right is greater than target
            if (numbers[left] + numbers[right] > target) right--;

            // Sum of current left and right is less than target
            if (numbers[left] + numbers[right] < target) left++;
        }

        return result;
    }
}