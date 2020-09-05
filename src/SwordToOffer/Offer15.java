package SwordToOffer;

public class Offer15 {

    public static void main(String[] args) {
        System.out.println(new Offer15().hammingWeight(00000000000000000000000000001011));
    }

    // 位运算
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count ++;
            n &= n - 1;
        }
        return count;
    }

    public int hammingWeight3(int n) {
        return Integer.bitCount(n);
    }
}
