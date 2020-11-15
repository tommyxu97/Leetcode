package Algorithm;

public class Q402 {
    public static void main(String[] args) {
        Q402 q402 = new Q402();
        q402.removeKdigits("123454321", 4);
    }

    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";
        StringBuilder stringBuilder = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            int index = 0;
            // 遍历找到第一个比后面大的数
            for (int j = 1; j < stringBuilder.length() && stringBuilder.charAt(j - 1) <= stringBuilder.charAt(j); j++) {
                index = j;
            }
            stringBuilder.deleteCharAt(index);
            while (stringBuilder.length() > 1 && stringBuilder.charAt(0) == '0') stringBuilder.deleteCharAt(0);
        }
        return stringBuilder.toString();
    }
}
