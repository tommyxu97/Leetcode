package SwordToOffer;

public class Offer66 {

    public int[] constructArr(int[] a) {
        if (a.length == 0) return new int[0];
        int[] res = new int[a.length];
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        left[0] = a[0]; right[a.length - 1] = a[a.length - 1];
        for (int i = 1; i < a.length; i++) {
            left[i] = left[i - 1] * a[i];
        }
        for (int i = a.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i];
        }
        res[0] = right[1]; res[a.length - 1] = left[a.length - 2];
        for (int i = 1; i < a.length - 1; i++) {
            res[i] = left[i - 1] * right[i + 1];
        }
        return res;
    }

    // 暴力遍历会超时
    public int[] constructArr2(int[] a) {
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) res[i] = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++){
                if (i != j) res[i] *= a[j];
            }
        }
        return res;
    }
}
