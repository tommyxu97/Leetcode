package Algorithm;

public class Q11 {
    // 暴力O(n^2)
    public int maxArea(int[] height) {
        if (height.length < 2) return 0;
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
    }

    // 双指针O(n)
    public int maxArea2(int[] height) {
        if (height.length < 2) return 0;
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
