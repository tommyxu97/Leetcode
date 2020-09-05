package SwordToOffer;

import java.util.Arrays;

public class Offer21 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Offer21().exchange(new int[]{1, 2, 3, 4, 5, 6, 10, 3, 2, 15, 2})));
    }

    public int[] exchange(int[] nums) {
        if (nums.length == 0) return nums; // 注意空数组
        int i = 0, j = nums.length - 1, temp;
        while (i != j) {
            if (nums[i] % 2 == 0) {
                if (nums[j] % 2 != 0) {
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
                j --;
            } else {
                i ++;
            }
        }
        return nums;
    }
}
