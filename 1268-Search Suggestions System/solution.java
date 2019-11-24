class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList();

        Arrays.sort(products);

        for (int i = 0; i < searchWord.length(); i++) {
            List<String> tempList = new ArrayList();
            String prefix = searchWord.substring(0, i + 1);
            for (int j = 0; j < products.length; j++) {
                if (tempList.size() == 3) {
                    break;
                }

                if (products[j].startsWith(prefix)) {
                    tempList.add(products[j]);
                } else if (tempList.size() != 0) {
                    break;
                }
            }
            result.add(tempList);
        }

        return result;
    }
}