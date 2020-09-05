package SwordToOffer;

import java.util.Arrays;

public class Offer40 {

    public static void main(String[] args) {
        Offer40 offer40 = new Offer40();
        System.out.println(Arrays.toString(offer40.getLeastNumbers(new int[]{6, 2, 4, 3, 1, 5, 1}, 2)));
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        return Arrays.copyOfRange(arr, 0, k);
    }

    // 快速排序
    private void quickSort(int[] nums, int begin, int end) {
        if (begin < end) {
            int index = partition(nums, begin, end);
            quickSort(nums, begin, index - 1);
            quickSort(nums, index + 1, end);
        }
    }

    private int partition(int[] nums, int begin, int end) {
        int temp = nums[begin];
        int i = begin, j = end;
        while (i < j) {
            while (nums[j] >= temp && i < j) j--;
            nums[i] = nums[j];
            while (nums[i] <= temp && i < j) i++;
            nums[j] = nums[i];
        }
        nums[i] = temp;
        return i;
    }
}
