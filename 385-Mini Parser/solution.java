/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * // Constructor initializes an empty nested list.
 * public NestedInteger();
 * <p>
 * // Constructor initializes a single integer.
 * public NestedInteger(int value);
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // Set this NestedInteger to hold a single integer.
 * public void setInteger(int value);
 * <p>
 * // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 * public void add(NestedInteger ni);
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) == '[' && s.charAt(s.length() - 1) == ']') {// nested list
            String elements = s.substring(1, s.length() - 1);
            int opening = 0;
            NestedInteger ni = new NestedInteger();

            String curr = "";
            for (int i = 0; i < elements.length(); i++) {
                char c = elements.charAt(i);
                if (c == ',') {
                    if (opening == 0) {
                        ni.add(deserialize(curr));
                        curr = "";
                    } else {
                        curr += String.valueOf(c);
                    }
                } else {
                    curr += String.valueOf(c);
                    if (c == '[') {
                        opening++;
                    } else if (c == ']') {
                        opening--;
                    }
                }
            }

            if (!curr.isEmpty()) {
                ni.add(deserialize(curr));
            }

            return ni;
        } else {// integer
            return new NestedInteger(Integer.valueOf(s));
        }
    }
}