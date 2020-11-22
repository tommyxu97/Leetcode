package Algorithm;

public class Q134 {
    // 模拟, 70ms
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0 || cost.length == 0) return -1;
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            int remainGas = 0;
            for (int j = 0; j < len; j++) {
                remainGas = remainGas + gas[(i + j) % len] - cost[(i + j) % len];
                if (remainGas < 0) break;
                if (j == len - 1) return i;
            }
        }
        return -1;
    }

    // 贪心, 0ms
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int len = gas.length;
        int curSum = 0;
        int minSum = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < len; i++) {
            curSum = curSum + gas[i] - cost[i];
            if (curSum < minSum) {
                minIndex = i;
                minSum = curSum;
            }
        }
        return curSum < 0? -1: (minIndex + 1) % len;
    }
}
