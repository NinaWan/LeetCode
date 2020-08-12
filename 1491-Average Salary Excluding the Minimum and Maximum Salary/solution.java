class Solution {
    public double average(int[] salary) {
        double sum = 0;
        double min = Double.MAX_VALUE;
        double max = 0;

        for (int s : salary) {
            sum += s;
            min = Math.min(min, s);
            max = Math.max(max, s);
        }

        return (sum - min - max) / (salary.length - 2);
    }
}