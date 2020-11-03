public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList();

        if (num < 11) {
            for (int i = 0; i <= (num > 4 ? 4
                                          : num); i++) {
                List<String> hours = new ArrayList();
                List<String> mins = new ArrayList();

                generateHours(i, hours, 0, 0);
                generateMins(num - i, mins, 0, 0);

                for (String hour : hours) {
                    for (String min : mins) {
                        if (Integer.valueOf(hour) > 11 || Integer.valueOf(min) > 59)
                            continue;
                        result.add(hour + ":" + min);
                    }
                }
            }
        }

        return result;
    }

    private void generateHours(int num, List<String> hours, int start, int sum) {
        if (num == 0) {
            hours.add(String.valueOf(sum));
            return;
        }

        // Backtracking
        for (int i = start; i < 4; i++) {
            generateHours(num - 1, hours, i + 1, sum + (int) Math.pow(2, i));
        }

    }

    private void generateMins(int num, List<String> mins, int start, int sum) {
        if (num == 0) {
            if (sum < 10) {
                mins.add("0" + String.valueOf(sum));
            } else {
                mins.add(String.valueOf(sum));
            }
            return;
        }

        // Backtracking
        for (int i = start; i < 6; i++) {
            generateMins(num - 1, mins, i + 1, sum + (int) Math.pow(2, i));
        }

    }
}