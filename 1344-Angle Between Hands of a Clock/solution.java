class Solution {
    public double angleClock(int hour, int minutes) {
        double minuteRatio = minutes == 0 ? 0 : (double) minutes / 60;
        double hourRatio = hour == 12 && minutes == 0 ? 0 : (double) (hour + minuteRatio) / 12;
        double diff = Math.abs(hourRatio - minuteRatio);

        return 360 * Math.min(diff, 1 - diff);
    }
}