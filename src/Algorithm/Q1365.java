package Algorithm;

public class Q1365 {
    // 16ms
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int temp: nums) {
                if (temp < nums[i]) res[i]++;
            }
        }
        return res;
    }

    // 1ms
    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] count = new int[101];
        int[] res = new int[nums.length];
        int[] lessCount = new int[101];
        for (int num: nums) {
            count[num]++;
        }
        for (int i = 1; i < count.length; i++) {
             lessCount[i] = lessCount[i - 1] + count[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = lessCount[nums[i]];
        }
        return res;
    }
}
