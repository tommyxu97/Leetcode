package SwordToOffer;

import java.util.LinkedList;
import java.util.Queue;

class Offer13 {

    public static void main(String[] args) {
        System.out.println(new Offer13().movingCount(50, 35, 20));
    }

    // BFS
    private int count = 0;
    private int[][] visit;
    private Queue<int[]> queue = new LinkedList<>();
    public int movingCount(int m, int n, int k) {
        visit = new int[m][n];
        queue.add(new int[]{0, 0});
        bfs(m ,n ,k);
        return count;
    }
    private void bfs(int m, int n, int k) {
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0]; int y = temp[1];
            if (x < 0 || x > m-1 || y < 0 || y > n-1 || visit[x][y] == 1 || getSum(x, y) > k) continue;
            if (visit[x][y] == 0) count++;
            visit[x][y] = 1;
            queue.add(new int[]{x+1, y});
            queue.add(new int[]{x, y+1});
        }
    }
    private int getSum(int i, int j) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j > 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum;
    }
}