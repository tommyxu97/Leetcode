package SwordToOffer;

public class Offer53_1 {

    public static void main(String[] args) {
        Offer53_1 offer53_1 = new Offer53_1();
        System.out.println(offer53_1.search(new int[]{5,7,7,8,8,10}, 8));
    }

    // 1ms
    public int search(int[] nums, int target) {
        int index = binarySearch(nums, target);
        if (index == -1) return 0;
        int count = 1;
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] == target) count++;
        }
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] == target) count++;
        }
        return count;
    }

    private int binarySearch(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    // 2ms，helper函数本质找到插入数字的位置，有相同的插在最右边
    public int search2(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    private int helper(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] <= target) start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }
}
