package ByteDance.ArrayAndSort;

public class Q10 {
    // 与主题库Q42相同
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        int res = 0;
        int len = height.length;
        int[] maxLeftHeight = new int[len];
        int[] maxRightHeight = new int[len];
        for (int i = 1; i < len; i++) {
            maxLeftHeight[i] = Math.max(maxLeftHeight[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            maxRightHeight[i] = Math.max(maxRightHeight[i + 1], height[i + 1]);
        }
        for (int i = 1; i < len - 1; i++) {
            res += Math.max(Math.min(maxLeftHeight[i], maxRightHeight[i]) - height[i], 0);
        }
        return res;
    }
}
