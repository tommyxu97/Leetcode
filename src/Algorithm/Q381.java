package Algorithm;

import java.util.*;

public class Q381 {

}

class RandomizedCollection {
    private Map<Integer, Set<Integer>> index;
    private List<Integer> nums;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        index = new HashMap<>();
        nums = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        nums.add(val);
        Set<Integer> set = index.getOrDefault(val, new HashSet<>());
        set.add(nums.size() - 1);
        index.put(val, set);
        return set.size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!index.containsKey(val)) {
            return false;
        }
        Iterator<Integer> iterator = index.get(val).iterator();
        int i = iterator.next();
        int lastNum = nums.get(nums.size() - 1);
        if (val == lastNum) {
            index.get(val).remove(nums.size() - 1);
        } else {
            index.get(lastNum).remove(nums.size() - 1);
            nums.set(i, lastNum);
            index.get(lastNum).add(i);
            index.get(val).remove(i);
        }
        if (index.get(val).size() == 0) {
            index.remove(val);
        }
        nums.remove(nums.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        // 使用Math.random()函数
        return nums.get((int) (Math.random() * nums.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */