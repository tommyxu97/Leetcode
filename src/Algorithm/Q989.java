package Algorithm;

import java.util.LinkedList;
import java.util.List;

public class Q989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> res = new LinkedList<>();
        int index = A.length - 1;
        boolean flag = false;
        while (index >= 0 || K > 0) {
            int temp = (index >= 0? A[index] + K % 10: K % 10) + (flag? 1: 0);
            flag = temp >= 10;
            res.addFirst(temp % 10);
            index--;
            K /= 10;
        }
        if (flag) res.addFirst(1);
        return res;
    }
}
