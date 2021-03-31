class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        for (int i = 0; i < sandwiches.length; i++) {
            for (int j = 0; j < students.length; j++) {
                if (students[j] == -1) {
                    continue;
                }

                if (sandwiches[i] == students[j]) {
                    students[j] = sandwiches[i] = -1;
                    break;
                }
            }

            if (sandwiches[i] != -1) {
                return sandwiches.length - i;
            }
        }

        return 0;
    }
}