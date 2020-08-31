public class Offer64 {

    // 利用&&判断时前面为false会停止执行后面的语句的短路性质
    public int sumNums(int n) {
        boolean temp = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
