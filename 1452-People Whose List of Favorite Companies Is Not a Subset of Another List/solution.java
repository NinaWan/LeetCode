class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> result = new ArrayList();
        List<Set<String>> fc = new ArrayList();
        for (List<String> companies : favoriteCompanies) {
            fc.add(new HashSet(companies));
        }

        for (int i = 0; i < fc.size(); i++) {
            boolean isSubset = false;
            for (int j = 0; j < fc.size(); j++) {
                if (i != j && fc.get(j).containsAll(fc.get(i))) {
                    isSubset = true;
                    break;
                }
            }

            if (!isSubset) {
                result.add(i);
            }
        }

        return result;
    }
}