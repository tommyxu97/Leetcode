package Algorithm;

public class Q283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int index1 = 0, index2 = 0;
        for (index2 = 0; index2 < nums.length; index2++) {
            if (nums[index2] != 0) {
                nums[index1] = nums[index2];
                index1++;
            }
        }
        while (index1 < nums.length) {
            nums[index1] = 0;
            index1++;
        }
    }
}
