package Algorithm;

import java.util.HashSet;
import java.util.Set;

public class Q947 {
    private int[] parent;
    private int count;

    // 30ms
    public int removeStones(int[][] stones) {
        if (stones == null || stones.length < 2) return 0;
        parent = new int[stones.length];
        count = parent.length;
        for (int i = 0; i < parent.length; i++) parent[i] = i;
        for (int i = 0; i < stones.length; i++) {
            int row = stones[i][0], col = stones[i][1];
            for (int j = i + 1; j < stones.length; j++) {
                if (stones[j][0] == row || stones[j][1] == col) union(i, j);
            }
        }
        return stones.length - count;
    }

    // 5ms
    public int removeStones2(int[][] stones) {
        if (stones == null || stones.length < 2) return 0;
        parent = new int[20000];
        for (int i = 0; i < parent.length; i++) parent[i] = i;
        for (int[] stone: stones) {
            union(stone[0], stone[1] + 10000);
        }
        Set<Integer> seen = new HashSet<>();
        for (int[] stone: stones) {
            seen.add(find(stone[0]));
        }
        return stones.length - seen.size();
    }

    private int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return false;
        } else {
            parent[rootX] = rootY;
            count--;
            return true;
        }
    }
}
