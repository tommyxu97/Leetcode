package Algorithm;

public class Q978 {
    public int maxTurbulenceSize(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int res = 1;
        int start = 0;
        boolean flag = true;
        for (int i = 1; i < arr.length; i++) {
            if (i - start == 1 && arr[i] != arr[i - 1]) flag = arr[i] > arr[i - 1];
            else {
                if (arr[i] == arr[i - 1]) {
                    res = Math.max(res, i - start);
                    start = i;
                } else if (flag == arr[i] > arr[i - 1]) {
                    res = Math.max(res, i - start);
                    start = i - 1;
                    flag = arr[i] > arr[i - 1];
                } else {
                    flag = !flag;
                }
            }
        }
        res = Math.max(res, arr.length - start);
        return res;
    }
}
