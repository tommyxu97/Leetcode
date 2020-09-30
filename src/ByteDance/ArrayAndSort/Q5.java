package ByteDance.ArrayAndSort;

public class Q5 {

    // 与主题库Q215相同
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) return 0;
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int i = left, j = right;
        int num = nums[left];
        while (i < j) {
            while (i < j && nums[j] >= num) j--;
            nums[i] = nums[j];
            while (i < j && nums[i] < num) i++;
            nums[j] = nums[i];
        }
        nums[i] = num;
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }
}
