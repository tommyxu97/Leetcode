package BiWeeklyContest.Contest35;

public class Q5503 {

    public int sumOddLengthSubarrays(int[] arr) {
        if (arr.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int len = 1; i + len <= arr.length; len = len + 2) {
                for (int j = i; j < i + len; j++) res += arr[j];
            }
        }
        return res;
    }
}
