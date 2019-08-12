public class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Map sMap = initializeMap();
        Stack stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (stack.empty() || !sMap.containsKey(current)) {
                stack.push(current);
            } else {
                char top = (Character) stack.peek();
                if (top == (char) sMap.get(current)) {
                    stack.pop();
                } else {
                    stack.push(current);
                }
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    private HashMap<Character, Character> initializeMap() {
        HashMap map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        return map;
    }
}