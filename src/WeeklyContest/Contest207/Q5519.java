package WeeklyContest.Contest207;

public class Q5519 {

    public String reorderSpaces(String text) {
        int wordCount = 0;
        int spaceCount = 0;
        String[] words = text.trim().split("\\s+");
        wordCount = words.length;
        for (char c: text.toCharArray()) {
            if (c == ' ') spaceCount++;
        }
        int spaceNew = wordCount == 1? 0: spaceCount / (wordCount - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            stringBuilder.append(words[i]);
            if (i != words.length - 1) {
                for (int j = 0; j < spaceNew; j++) {
                    stringBuilder.append(' ');
                }
            }
        }
        for (int i = 0; i < (wordCount == 1? spaceCount: spaceCount % (wordCount - 1)); i++) {
            stringBuilder.append(' ');
        }
        return stringBuilder.toString();
    }
}
