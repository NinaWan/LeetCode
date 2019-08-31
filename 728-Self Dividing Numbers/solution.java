class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();

        for (int current = left; current <= right; current++) {
            String currentStr = String.valueOf(current);
            boolean flag = true;
            for (int i = 0; i < currentStr.length(); i++) {
                int divider = Integer.valueOf("" + currentStr.charAt(i));
                if (divider == 0 || current % divider != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(current);
            }
        }

        return result;
    }
}