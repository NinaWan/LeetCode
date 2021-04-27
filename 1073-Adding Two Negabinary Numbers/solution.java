class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        Stack<Integer> stack = new Stack();
        int i = arr1.length - 1, j = arr2.length - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            carry += i >= 0 ? arr1[i--]
                            : 0;
            carry += j >= 0 ? arr2[j--]
                            : 0;
            stack.push(carry & 1);
            carry = -(carry >> 1);
        }

        while (stack.size() > 1 && stack.peek() == 0) {
            stack.pop();
        }

        int[] ans = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            ans[index++] = stack.pop();
        }

        return ans;
    }
}