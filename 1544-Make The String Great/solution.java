class Solution {
    public String makeGood(String s) {
        String result = "";
        Stack<Character> stack = new Stack();

        for (Character c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                Character top = stack.peek();
                if (Math.abs(top - c) == 'a' - 'A') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }

        return result;
    }
}