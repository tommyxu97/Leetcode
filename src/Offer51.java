public class Offer51 {

    public static void main(String[] args) {
        Offer51 offer51 = new Offer51();
        System.out.println(offer51.reversePairs(new int[]{7,5,6,4}));
    }

    public int reversePairs(int[] nums) {
        return mergeAndCount(nums, 0, nums.length - 1);
    }

    // 基于归并排序计数
    public int mergeAndCount(int[] nums, int start, int end) {
        if (start >= end) return 0;
        int mid = start + (end - start) / 2;
        int count = mergeAndCount(nums, start, mid) + mergeAndCount(nums, mid + 1, end);

        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            count += nums[i] <= nums[j]? j - (mid + 1): 0;
            temp[k++] = nums[i] <= nums[j]? nums[i++]: nums[j++]; // 这行应该放在第二行
        }
        while (i <= mid) {
            count += j - (mid + 1);
            temp[k++] = nums[i++];
        }
        while (j <= end) {
            temp[k++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, start, end -  start + 1);
        return count;
    }
}
