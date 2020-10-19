package MeituanTest927;

import java.util.Arrays;
import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long sum = 0;
        long l1 = scanner.nextLong(), l2 = scanner.nextLong(), l3 = scanner.nextLong(), cloth = scanner.nextLong();
        long price1 = scanner.nextLong(), price2 = scanner.nextLong(), price3 = scanner.nextLong();
        Sell sell1 = new Sell(price1, l1);
        Sell sell2 = new Sell(price2, l2);
        Sell sell3 = new Sell(price3, l3);
        Sell[] sells = new Sell[] {sell1, sell2, sell3};
        Arrays.sort(sells, (o1, o2) -> (int) (o2.price - o1.price));
        for (Sell sell: sells) {
            if (cloth - sell.num >= 0) {
                sum += sell.price * sell.num;
                cloth -= sell.num;
            } else if (cloth > 0) {
                sum += sell.price * cloth;
                cloth = 0;
            }
        }
        System.out.println(sum);
    }

    static class Sell {
        long price;
        long num;
        Sell(long i, long j) {
            price = i; num = j;
        }
    }
}
