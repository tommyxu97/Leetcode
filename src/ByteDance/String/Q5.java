package ByteDance.String;

public class Q5 {

    // 与主题库Q151，剑指Offer58-I相同
    public String reverseWords(String s) {
        StringBuilder stringBuilder =  new StringBuilder();
        s = s.trim();
        String[] splitStr = s.split(" ");
        for (int i = splitStr.length - 1; i >= 0; i--) {
            if (!splitStr[i].equals("")) stringBuilder.append(splitStr[i]).append(" ");
        }
        return stringBuilder.length() > 0? stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString(): "";
    }
}
