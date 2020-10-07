package Algorithm;

public class Q75 {
    public void sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int num: nums) {
            counts[num]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < counts[0]) nums[i] = 0;
            else if (i < counts[0] + counts[1]) nums[i] = 1;
            else nums[i] = 2;
        }
    }
}
