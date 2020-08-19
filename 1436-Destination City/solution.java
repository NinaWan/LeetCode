class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> from = new HashSet();

        for (List<String> path : paths) {
            from.add(path.get(0));
        }

        for (List<String> path : paths) {
            if (!from.contains(path.get(1))) {
                return path.get(1);
            }
        }

        return paths.get(0).get(1);
    }
}