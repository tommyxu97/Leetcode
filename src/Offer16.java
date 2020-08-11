public class Offer16 {

    public static void main(String[] args) {
        System.out.println(new Offer16().myPow(2, -10));
    }

    // 快速幂方法
    // TODO 未解决

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double res = 1.0;
        if (n > 0) {
            while (n != 0) {
                res *= x;
                n --;
            }
            return res;
        }
        while (n != 0) {
            res *= x;
            n++;
        }
        return (double) 1/res;
    }
}
