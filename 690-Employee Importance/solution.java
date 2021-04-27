/*
 * // Definition for Employee.
 * class Employee {
 * public int id;
 * public int importance;
 * public List<Integer> subordinates;
 * };
 */

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int ans = 0;
        Map<Integer, Integer> values = new HashMap();
        Map<Integer, List<Integer>> subordinates = new HashMap();

        for (Employee employee : employees) {
            values.put(employee.id, employee.importance);
            subordinates.put(employee.id, employee.subordinates);
        }

        Stack<Integer> stack = new Stack();
        stack.push(id);
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            ans += values.get(curr);
            for (int subordinate : subordinates.get(curr)) {
                stack.push(subordinate);
            }
        }

        return ans;
    }
}