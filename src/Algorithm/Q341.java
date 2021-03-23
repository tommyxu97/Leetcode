package Algorithm;

import java.util.*;

public class Q341 {

}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
class NestedIterator implements Iterator<Integer> {
    private List<Integer> list;
    private int index = -1;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = new ArrayList<>();
        add(nestedList);
    }

    private void add(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger: nestedList) {
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                add(nestedInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        if (index + 1 < list.size()) {
            return list.get(++index);
        }
        return -1;
    }

    @Override
    public boolean hasNext() {
        return index + 1 < list.size();
    }
}

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}