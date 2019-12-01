class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> result = new ArrayList();

        if (tomatoSlices == 0 && cheeseSlices == 0) {
            result.add(0);
            result.add(0);
            return result;
        }

        if (tomatoSlices < 2 || tomatoSlices % 2 == 1 || cheeseSlices < 1 || cheeseSlices > tomatoSlices / 2 || cheeseSlices < tomatoSlices / 4) {
            return result;
        }

        if (tomatoSlices / cheeseSlices == 4 && tomatoSlices % cheeseSlices == 0) {
            result.add(cheeseSlices);
            result.add(0);
        }

        if (tomatoSlices / cheeseSlices == 2 && tomatoSlices % cheeseSlices == 0) {
            result.add(0);
            result.add(cheeseSlices);
        }

        for (int i = cheeseSlices; i > 0; i--) {
            if (i * 4 + (cheeseSlices - i) * 2 == tomatoSlices) {
                result.add(i);
                result.add(cheeseSlices - i);
                return result;
            }
        }

        return result;
    }
}