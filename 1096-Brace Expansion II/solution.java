import java.util.stream.Collectors;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Stack<Set<String>> stack = new Stack();
        Set<String> pre = new HashSet();
        Set<String> curr = new HashSet();

        for (char c : expression.toCharArray()) {
            if (Character.isLetter(c)) {// multiply current char with current set
                curr = cartesianProduct(curr, new HashSet(Arrays.asList(String.valueOf(c))));
            } else if (c == '{') {// push into stack
                stack.push(pre);
                stack.push(curr);
                pre = new HashSet();
                curr = new HashSet();
            } else if (c == '}') {// combine and multiply
                pre.addAll(curr);
                curr = cartesianProduct(stack.pop(), pre);
                pre = stack.pop();
            } else if (c == ',') {// combine two sets
                pre.addAll(curr);
                curr.clear();
            }
        }

        pre.addAll(curr);

        return pre.stream().sorted().collect(Collectors.toList());
    }

    private Set<String> cartesianProduct(Set<String> set1, Set<String> set2) {
        if (set1.isEmpty()) {
            return set2;
        } else if (set2.isEmpty()) {
            return set1;
        }

        Set<String> res = new HashSet();
        for (String s1 : set1) {
            for (String s2 : set2) {
                res.add(s1 + s2);
            }
        }

        return res;
    }
}