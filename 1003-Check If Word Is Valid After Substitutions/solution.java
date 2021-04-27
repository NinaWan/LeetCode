class Solution {
    public boolean isValid(String S) {
        Stack<Character> stack = new Stack();

        for (char c : S.toCharArray()) {
            if ((stack.isEmpty() && c == 'a') || (!stack.isEmpty() && c != 'c')) {
                stack.push(c);
            } else if (stack.isEmpty() && c != 'a') {
                return false;
            } else if (c == 'c') {
                if (stack.size() < 2) {
                    return false;
                } else {
                    char b = stack.pop();
                    char a = stack.pop();
                    if (a != 'a' || b != 'b') {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty() ? true
                               : false;
    }
}