class Solution {
    private String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
            "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        String ans = "";
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                ans = helper(num % 1000) + thousands[i] + " " + ans;
            }
            num /= 1000;
            i++;
        }

        return ans.trim();
    }

    private String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return lessThan20[num] + " ";
        } else if (num < 100) {
            return tens[num / 10] + " " + helper(num % 10);
        } else {
            return lessThan20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}