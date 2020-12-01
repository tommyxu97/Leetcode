package Algorithm;

public class Q34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[] {-1, -1};
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) end--;
            else if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        // 判断数组中是否存在相应的数字
        if (start >= nums.length || nums[start] != target) return new int[] {-1, -1};
        int index1 = start;
        int index2 = start;
        while (index2 < nums.length && nums[index2] == target) {
            index2++;
        }
        return new int[] {index1, index2 - 1};
    }
}
