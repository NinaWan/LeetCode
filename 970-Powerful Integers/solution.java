class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> ans = new HashSet();

        for (int i = 0;; i++) {
            double xPro = Math.pow(x, i);
            if (xPro >= bound) {
                break;
            }
            for (int j = 0;; j++) {
                double sum = xPro + Math.pow(y, j);
                if (sum <= bound) {
                    ans.add((int) sum);
                } else {
                    break;
                }
                if (y == 1) {
                    break;
                }
            }
            if (x == 1) {
                break;
            }
        }

        return new ArrayList(ans);
    }
}