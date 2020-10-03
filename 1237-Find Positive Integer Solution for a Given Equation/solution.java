/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */
class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();

        for (int x = 1; customfunction.f(x, 1) <= z; x++) {
            for (int y = 1; customfunction.f(x, y) <= z; y++) {
                if (customfunction.f(x, y) == z) {
                    result.add(Arrays.asList(x, y));
                }
            }
        }

        return result;
    }
}