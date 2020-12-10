package Algorithm;

public class Q860 {
    public boolean lemonadeChange(int[] bills) {
        int[] moneyCounts = new int[2];
        for (int money: bills) {
            if (money == 5) {
                moneyCounts[0]++;
            } else if (money == 10) {
                if (moneyCounts[0] == 0) return false;
                else {
                    moneyCounts[0]--;
                    moneyCounts[1]++;
                }
            } else {
                if (moneyCounts[0] >= 1 && moneyCounts[1] >= 1){
                    moneyCounts[0]--; moneyCounts[1]--;
                } else if (moneyCounts[0] >= 3 && moneyCounts[1] == 0) {
                    moneyCounts[0] -= 3;
                } else return false;
            }
        }
        return true;
    }
}
