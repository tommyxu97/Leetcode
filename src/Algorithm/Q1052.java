package Algorithm;

public class Q1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int count = 0, res = 0;
        int len = customers.length;
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0) count += customers[i];
        }
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1) count += customers[i];
        }
        res = count;
        for (int i = X; i < len; i++) {
            if (grumpy[i] == 1) count += customers[i];
            if (grumpy[i - X] == 1) count -= customers[i - X];
            res = Math.max(res, count);
        }
        return res;
    }
}
