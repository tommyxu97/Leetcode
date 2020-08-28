public class Offer53_2 {

    public static void main(String[] args) {
        Offer53_2 offer53_2 = new Offer53_2();
        System.out.println(offer53_2.missingNumber(new int[]{0,1,2,3,4,5,6,8,9,10})); // Expected: 7
    }

    public int missingNumber(int[] nums) {
        int start = 0, end = nums.length - 1, mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] <= mid) start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }
}
