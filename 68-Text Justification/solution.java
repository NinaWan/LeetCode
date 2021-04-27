class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList();
        String currLine = words[0];

        if (words.length == 1) {
            justifyLastLine(currLine, maxWidth, result);
        }

        int wordCount = 1;
        for (int i = 1; i < words.length; i++) {
            if (currLine.length() + words[i].length() + 1 <= maxWidth) {
                currLine += " " + words[i];
                wordCount++;
            } else {
                justifyNonLastLine(currLine, maxWidth, result, wordCount);

                currLine = words[i];
                wordCount = 1;
            }

            if (i == words.length - 1) {
                justifyLastLine(currLine, maxWidth, result);
            }
        }

        return result;
    }

    private void justifyLastLine(String currLine, int maxWidth, List<String> result) {
        int spaceCount = maxWidth - currLine.length();
        // pad extra spaces for last line
        for (int i = 0; i < spaceCount; i++) {
            currLine += " ";
        }
        result.add(currLine);
    }

    private void justifyNonLastLine(String currLine, int maxWidth, List<String> result, int wordCount) {
        String[] words = currLine.split(" ");

        if (words.length == 1) {
            int spaceCount = maxWidth - words[0].length();
            for (int i = 0; i < spaceCount; i++) {
                words[0] += " ";
            }
        } else {
            int totalSpace = maxWidth - currLine.length();
            int largerSpaceCount = totalSpace % (wordCount - 1);
            int eachSpace = totalSpace / (wordCount - 1);
            for (int i = 0; i < words.length - 1; i++) {
                String extraSpace = " ";

                for (int j = 0; j < eachSpace; j++) {
                    extraSpace += " ";
                }
                extraSpace += i + 1 > largerSpaceCount ? ""
                                                       : " ";

                words[i] += extraSpace;
            }
        }

        result.add(Arrays.stream(words).collect(Collectors.joining()));
    }
}