package SwordToOffer;

public class Offer14_2 {

    public static void main(String[] args) {
        System.out.println(new Offer14_2().cuttingRope(1000));
    }

    // 贪心/数学推导
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        long res = 1;
        while(n > 4){
            res *= 3;
            res = res % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }
}
