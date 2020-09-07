package WeeklyContest.Contest205;

public class Q5509 {

    public static void main(String[] args) {
       System.out.println(new Q5509().minCost("abaac", new int[]{1,2,3,4,5}));
    }

    public int minCost(String s, int[] cost) {
        int sum = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) != s.charAt(i - 1)) {
                sum -= max;
                max = 0;
            }
            sum += cost[i];
            max = Math.max(max, cost[i]);
        }
        return sum - max;
    }
}
