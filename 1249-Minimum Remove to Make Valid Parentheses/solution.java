class Solution {
    public String minRemoveToMakeValid(String s) {
        String result = "";
        int opening = 0;
        int closing = 0;
        Stack<Character> stack = new Stack();

        for (char c : s.toCharArray()) {
            opening += c == '(' ? 1 : 0;
            closing += c == ')' ? 1 : 0;

            if (opening >= closing) {
                stack.push(c);
            } else {
                closing--;
            }
        }

        opening = 0;
        closing = 0;
        while (!stack.isEmpty()) {
            Character c = stack.pop();
            opening += c == '(' ? 1 : 0;
            closing += c == ')' ? 1 : 0;
            if (closing >= opening) {
                result = c + result;
            } else {
                opening--;
            }
        }

        return result;
    }
}