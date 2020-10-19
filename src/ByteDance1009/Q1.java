package ByteDance1009;

public class Q1 {
    public static void main(String[] args) {
        int[][] test = new int[4][4];
        for (int i = 0; i < 16; i++) {
            test[i / 4][i % 4] = i;
        }
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.println(test[j][i - j]);
            }
        }
        for (int i = test.length; i < test.length * 2 - 1; i++) {
            for (int j = i - test.length + 1; j < test.length; j++) {
                System.out.println(test[j][i - j]);
            }
        }
    }
}
