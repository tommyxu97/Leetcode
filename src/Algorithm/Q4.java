package Algorithm;

public class Q4 {
    public static void main(String[] args) {
        int[] test1 = new int[] {};
        int[] test2 = new int[] {2, 3};
        System.out.println(new Q4().findMedianSortedArrays(test1, test2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] nums = new int[len1 + len2];
        int index = 0, index1 = 0, index2 = 0;
        while (index1 < len1 && index2 < len2) {
            if (nums1[index1] < nums2[index2]) {
                nums[index] = nums1[index1];
                index++; index1++;
            } else {
                nums[index] = nums2[index2];
                index++; index2++;
            }
        }
        if (index1 < len1) {
            for (int i = index1; i < len1; i++) {
                nums[index] = nums1[i]; index++;
            }
        }
        if (index2 < len2) {
            for (int i = index2; i < len2; i++) {
                nums[index] = nums2[i]; index++;
            }
        }
        if (nums.length == 0) {
            return 0;
        } else if (nums.length % 2 == 1) {
            return nums[nums.length / 2];
        } else {
            return (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.0;
        }
    }
}
