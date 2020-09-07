package WeeklyContest.Contest205;

public class Q5507 {

    public String modifyString(String s) {
        if (s.equals("?")) return "a";
        StringBuilder stringBuilder =  new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                char replace = 'a';
                for (char c = 'a'; c <= 'z'; c++) {
                    if (i == 0 && s.charAt(1) != c) {
                        replace = c; break;
                    } else if (i == s.length() - 1 && stringBuilder.charAt(s.length() - 2) != c) {
                        replace = c; break;
                    } else if (i - 1 >= 0 && stringBuilder.charAt(i - 1) != c && s.charAt(i + 1) != c) {
                        replace = c; break;
                    }
                }
                stringBuilder.append(replace);
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}

