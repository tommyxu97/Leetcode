package Algorithm;

public class Q738 {
    public int monotoneIncreasingDigits(int N) {
        char[] chars = String.valueOf(N).toCharArray();
        int index = chars.length;
        for (int i = chars.length - 1; i >= 1; i--){
            if (chars[i - 1] > chars[i]) {
                index = i;
                chars[i - 1]--;
            }
        }
        for (int i = index; i < chars.length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
