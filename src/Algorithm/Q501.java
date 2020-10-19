package Algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class Q501 {

    private Map<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        inOrderTraverse(root);
        Map<Integer, Integer> sorted = map
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
        int count = -1;
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: sorted.entrySet()) {
            if (count == -1) count = entry.getValue();
            else {
                if (entry.getValue() == count) res.add(entry.getKey());
                else break;
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public void inOrderTraverse(TreeNode node) {
        if (node == null) return;
        inOrderTraverse(node.left);
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        inOrderTraverse(node.right);
    }
}
