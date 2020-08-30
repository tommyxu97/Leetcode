public class Offer56_2 {

    public static void main(String[] args) {
        System.out.println(new Offer56_2().singleNumber(new int[]{1,1,1,6,7,8,6,7,8,6,7,8,9,3,4,3,4,3,4,10,10,10})); //9
    }

    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int num: nums) {
            for (int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
}
