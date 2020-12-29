package Algorithm;

public class Q330 {
    public int minPatches(int[] nums, int n) {
        long total = 0;
        int count = 0;
        int index = 0;
        while (total < n) {
            if (index < nums.length && nums[index] <= total + 1) {
                total += nums[index++];
            } else {
                total = total + (total + 1);
                count++;
            }
        }
        return count;
    }
}
