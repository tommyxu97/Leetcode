public class Offer44 {

    public static void main(String[] args) {
        Offer44 offer44 = new Offer44();
        System.out.println(offer44.findNthDigit(10001));
    }

    // 找规律
    public int findNthDigit(int n) {
        int digit = 1; long start = 1, count = 9;
        while (n > count) {
            n -= count;
            digit++;
            start = start * 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
