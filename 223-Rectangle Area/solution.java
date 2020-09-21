class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if ((A == C && B == D) || (E == G && F == H) || (E >= A && F >= B && G <= C && H <= D) || (E <= A && F <= B && G >= C && H >= D)) {
            return Math.max(Math.abs(D - B) * Math.abs(C - A), Math.abs(H - F) * Math.abs(G - E));
        }

        if (H <= B || E >= C || G <= A || F >= D) {
            return Math.abs(D - B) * Math.abs(C - A) + Math.abs(H - F) * Math.abs(G - E);
        }

        int x1 = Math.max(A, E);
        int y1 = Math.max(B, F);
        int x2 = Math.min(C, G);
        int y2 = Math.min(D, H);

        return Math.abs(D - B) * Math.abs(C - A) + Math.abs(H - F) * Math.abs(G - E) - Math.abs(x2 - x1) * Math.abs(y2 - y1);
    }
}