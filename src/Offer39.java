public class Offer39 {

    public static void main(String[] args) {
        Offer39 offer39 = new Offer39();
        System.out.println(offer39.majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }

    public int majorityElement(int[] nums) {
        int x = 0, vote = 0;
        for (int i: nums) {
            if (vote == 0) x = i;
            if (x != i) vote++; else vote--;
        }
        return x;
    }
}
