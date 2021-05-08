class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        List<Integer> list = new ArrayList();

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                list.add(i);
            }

            if (list.size() > 2) {
                return false;
            }
        }

        if (list.size() == 1 ||
                list.size() == 2 && (s1.charAt(list.get(0)) != s2.charAt(list.get(1)) || s1.charAt(list.get(1)) != s2.charAt(list.get(0)))) {
            return false;
        }

        return true;
    }
}