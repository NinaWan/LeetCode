class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        int[] daysOfMonth = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayOfWeek = new String[] {"Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday"};
        int daySum = 0;

        for (int y = 1971; y < year; y++) {
            daySum += isLunaYear(y) ? 366
                                    : 365;
        }

        for (int m = 1; m < month; m++) {
            daySum += daysOfMonth[m - 1];
            if (m == 2 && isLunaYear(year)) {
                daySum += 1;
            }
        }

        daySum += day;

        return dayOfWeek[daySum % 7];
    }

    private boolean isLunaYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}