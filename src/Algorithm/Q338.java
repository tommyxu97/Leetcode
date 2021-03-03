package Algorithm;

public class Q338 {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            if (i % 2 == 0) {
                res[i] = res[i / 2];
            } else {
                res[i] = res[i / 2] + 1;
            }
        }
        return res;
    }
}
