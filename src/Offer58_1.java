import java.util.Arrays;

public class Offer58_1 {

    public static void main(String[] args) {
        Offer58_1 offer58_1 = new Offer58_1();
        System.out.println("[" + offer58_1.reverseWords("  hello world!  ") + "]");
    }

    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = s.trim().split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].equals("")) continue;
            if (i > 0) stringBuilder.append(words[i]).append(" ");
            else stringBuilder.append(words[i]);
        }
        return stringBuilder.toString();
    }
}
