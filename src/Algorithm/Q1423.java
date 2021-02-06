package Algorithm;

public class Q1423 {
    public int maxScore(int[] cardPoints, int k) {
        if (cardPoints == null || cardPoints.length == 0) return 0;
        int res = 0, sum = 0, indexL = k - 1, indexR = cardPoints.length - 1;
        for (int i = 0; i < k; i++) sum += cardPoints[i];
        res = sum;
        while (indexL >= 0) {
            sum -= cardPoints[indexL];
            sum += cardPoints[indexR];
            res = Math.max(res, sum);
            indexL--; indexR--;
        }
        return res;
    }
}