import java.util.Arrays;

public class Offer45 {

    public static void main(String[] args) {
        Offer45 offer45 = new Offer45();
        System.out.println(offer45.minNumber(new int[]{3,30,34,9,5}));
    }

    public String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strings[i] = String.valueOf(nums[i]);
        Arrays.sort(strings, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strings)
            res.append(s);
        return res.toString();
    }
}
