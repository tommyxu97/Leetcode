package ByteDance.String;

public class Q2 {

    // 与主题库Q14相同

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder stringBuilder = new StringBuilder();
        int minLen = Integer.MAX_VALUE;
        for (String str: strs) {
            minLen = Math.min(str.length(), minLen);
        }
        label: for (int i = 0; i < minLen; i++) {
            char temp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != temp) break label;
            }
            stringBuilder.append(temp);
        }
        return stringBuilder.toString();
    }
}
