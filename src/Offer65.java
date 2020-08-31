public class Offer65 {

    public static void main(String[] args) {
        int a = 0b1110001;
        int b = 0b1101111;
        System.out.println(a + ", " + b);
        System.out.println(Integer.toBinaryString(a << 1));
        System.out.println(Integer.toBinaryString((a & b) << 1));
        System.out.println(Integer.toBinaryString(a ^ b));
    }

    // 位运算
    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int temp = (a & b) << 1;  // temp = 进位
            a = a ^ b; // a = 非进位和
            b = temp; // b = 进位
        }
        return a;
    }
}
