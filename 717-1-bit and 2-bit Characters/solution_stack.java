class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if (null == bits || bits.length == 0) {
            return false;
        }

        Stack<Integer> stack = new Stack();

        for (int i = 0; i < bits.length; i++) {
            int current = bits[i];
            if (!stack.isEmpty()) {
                Integer pre = stack.pop();
                if (pre == 0) {
                    stack.push(current);
                }
            } else {
                stack.push(current);
            }
        }

        return stack.isEmpty() ? false
                               : true;
    }
}