class Solution {
    public int subtractProductAndSum(int n) {
        int[] digits = String.valueOf(n).chars().map(Character::getNumericValue).toArray();
        int product = 1;
        int sum = 0;
        for (int digit : digits) {
            product *= digit;
            sum += digit;
        }

        return product - sum;
    }
}