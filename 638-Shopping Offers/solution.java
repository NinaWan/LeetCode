class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int res = directPurchase(price, needs);
        for (List<Integer> offer : special) {
            List<Integer> remains = new ArrayList();
            boolean isValid = true;
            for (int i = 0; i < needs.size(); i++) {
                if (offer.get(i) > needs.get(i)) {
                    isValid = false;
                    break;
                }
                remains.add(needs.get(i) - offer.get(i));
            }

            if (isValid) {
                res = Math.min(res, offer.get(offer.size() - 1) + shoppingOffers(price, special, remains));
            }
        }

        return res;
    }

    private int directPurchase(List<Integer> price, List<Integer> needs) {
        int res = 0;
        for (int i = 0; i < needs.size(); i++) {
            res += price.get(i) * needs.get(i);
        }

        return res;
    }
}