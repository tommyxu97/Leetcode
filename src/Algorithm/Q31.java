package Algorithm;

public class Q31 {
    public static void main(String[] args) {
        Q31 q31 = new Q31();
        q31.nextPermutation(new int[] {3, 2, 1});
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int index = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i])  {
                index = i; break;
            }
        }
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        for (int i = nums.length - 1; i >= index; i--) {
            if (nums[i] > nums[index - 1]) {
                swap(nums, index - 1, i); break;
            }
        }
        reverse(nums, index, nums.length - 1);
    }

    private void reverse(int[] arr, int start, int end) {
        for (int i = start; i <= (start + end) / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[end + start - i];
            arr[end + start - i] = temp;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
