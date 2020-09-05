package SwordToOffer;

import java.util.Arrays;

public class Offer17 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Offer17().printNumbers(3)));
    }

    public int[] printNumbers(int n) {
        int len = (int) Math.pow(10, n) - 1;
        int[] res = new int[len];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
