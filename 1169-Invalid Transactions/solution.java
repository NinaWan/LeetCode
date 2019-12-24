class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> result = new ArrayList();
        List<String[]> transList = Arrays.stream(transactions)
                .map(s -> s.split(","))
                .collect(Collectors.toList());
        int[] added = new int[transactions.length];

        for (int i = 0; i < transList.size(); i++) {
            String[] s1 = transList.get(i);
            if (Integer.valueOf(s1[2]) > 1000) {
                if (added[i] == 0) {
                    result.add(transactions[i]);
                    added[i] = 1;
                }
                continue;
            }

            for (int j = 0; j < transList.size(); j++) {
                String[] s2 = transList.get(j);

                if (i == j || !(s1[0].equals(s2[0]))) {
                    continue;
                }

                if (!(s1[3].equals(s2[3])) && Math.abs(Integer.valueOf(s1[1]) - Integer.valueOf(s2[1])) <= 60) {
                    if (added[i] == 0) {
                        result.add(transactions[i]);
                        added[i] = 1;
                    }

                    if (added[j] == 0) {
                        result.add(transactions[j]);
                        added[j] = 1;
                    }
                }
            }
        }

        return result;
    }
}