package ByteDance.String;

import java.util.Stack;

public class Q6 {

    public static void main(String[] args) {
        System.out.println(new Q6().simplifyPath("///"));
    }

    // 与主题库Q71相同
    public String simplifyPath(String path) {
        Stack<String> pathStack = new Stack<>();
        String[] f = path.split("/");
        for (String s: f) {
            if (s.equals("") || s.equals("/") || s.equals(".")) continue;
            if (s.equals("..")) {
                if (!pathStack.isEmpty()) pathStack.pop();
            } else {
                pathStack.push(s);
            }
        }
        if (pathStack.size() == 0) return "/";
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : pathStack) {
            stringBuilder.append("/").append(s);
        }
        return stringBuilder.toString();
    }
}
