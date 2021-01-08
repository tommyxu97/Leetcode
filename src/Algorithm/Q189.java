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

    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++; end--;
        }
    }
}
