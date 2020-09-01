class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] aParams = a.split("\\+");
        String[] bParams = b.split("\\+");
        int pa1 = Integer.valueOf(aParams[0]);
        int pa2 = Integer.valueOf(bParams[0]);
        int pb1 = Integer.valueOf(aParams[1].substring(0, aParams[1].length() - 1));
        int pb2 = Integer.valueOf(bParams[1].substring(0, bParams[1].length() - 1));

        String p1 = String.valueOf(pa1 * pa2 - pb1 * pb2);
        String p2 = String.valueOf(pa1 * pb2 + pb1 * pa2);

        return p1 + "+" + p2 + "i";
    }
}