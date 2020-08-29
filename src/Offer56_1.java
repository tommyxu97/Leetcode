import java.util.Arrays;

public class Offer56_1 {

    public static void main(String[] args) {
        Offer56_1 offer56_1 = new Offer56_1();
        System.out.println(Arrays.toString(offer56_1.singleNumbers(new int[]{4, 1, 4, 6}))); // Expected: 1, 6
    }

    public int[] singleNumbers(int[] nums) {
        int x = 0;
        for (int num: nums) {
            x = x ^ num;
        }
        int flag = x & (-x);
        int res = 0;
        for (int num: nums) {
            if ((flag & num) != 0) {
                res = res ^ num;
            }
        }
        return new int[]{res, res ^ x};
    }
}
