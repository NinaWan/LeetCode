class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();

        if (candidates == null || candidates.length == 0) {
            return result;
        }

        Arrays.sort(candidates);
        dfs(candidates, 0, target, result, new ArrayList<Integer>());

        return dedup(result);
    }

    public void dfs(int[] candidates, int start, int target, List<List<Integer>> result, List<Integer> tempList) {
        if (start >= candidates.length || target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList(tempList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            if (i != candidates.length - 1) {
                dfs(candidates, i + 1, target - candidates[i], result, tempList);
            } else {
                if (target == candidates[i]) {
                    result.add(new ArrayList(tempList));
                }
            }
            tempList.remove(tempList.size() - 1);
        }
    }

    public List<List<Integer>> dedup(List<List<Integer>> origin) {
        return new HashSet<String>(origin.stream()
                .map(l -> l.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(",")))
                .collect(Collectors.toList())).stream()
                .map(s -> Arrays.asList(s.split(","))
                        .stream()
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}