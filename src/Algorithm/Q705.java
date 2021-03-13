package Algorithm;

public class Q705 {

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
class MyHashSet {
    private boolean[] flag;

    /** Initialize your data structure here. */
    public MyHashSet() {
        flag = new boolean[1000001];
    }

    public void add(int key) {
        flag[key] = true;
    }

    public void remove(int key) {
        flag[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return flag[key];
    }
}