package Algorithm;

public class Q189 {
    // 使用额外空间
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        int[] newNums = new int[nums.length];
        k = k % nums.length;
        System.arraycopy(nums, nums.length - k, newNums, 0, k);
        System.arraycopy(nums,  0, newNums, k, nums.length - k);
        System.arraycopy(newNums, 0, nums, 0, newNums.length);
    }
}
