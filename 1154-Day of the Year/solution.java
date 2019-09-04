class Solution {
    public int dayOfYear(String date) {
        int[] dayCount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int result = Integer.valueOf(date.substring(8, 10));
        int year = Integer.valueOf(date.substring(0, 4));
        int month = Integer.valueOf(date.substring(5, 7));
        boolean isLeapYear = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);

        for (int i = 0; i < month - 1; i++) {
            result += dayCount[i];
            if (isLeapYear && i == 1) {
                result += 1;
            }
        }

        return result;
    }
}