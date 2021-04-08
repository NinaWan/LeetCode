class Solution {
    public double averageWaitingTime(int[][] customers) {
        double sum = customers[0][1];
        int time = customers[0][0] + customers[0][1];
        for (int i = 1; i < customers.length; i++) {
            sum += customers[i][1];
            sum += time > customers[i][0] ? time - customers[i][0]
                                          : 0;
            time = Math.max(customers[i][0], time) + customers[i][1];
        }

        return sum / customers.length;
    }
}