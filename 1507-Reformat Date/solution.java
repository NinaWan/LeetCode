class Solution {
    public String reformatDate(String date) {
        String[] parts = date.split(" ");
        Map<String, String> months = new HashMap() {{
            put("Jan", "01");
            put("Feb", "02");
            put("Mar", "03");
            put("Apr", "04");
            put("May", "05");
            put("Jun", "06");
            put("Jul", "07");
            put("Aug", "08");
            put("Sep", "09");
            put("Oct", "10");
            put("Nov", "11");
            put("Dec", "12");
        }};

        String day = parts[0].substring(0, parts[0].length() - 2);
        day = (day.length() < 2 ? "0" : "") + day;

        return Integer.valueOf(parts[2]) + "-" + months.get(parts[1]) + "-" + day;
    }
}