package ByteDance.DataStructure;

import java.util.HashMap;

public class Q2 {
    // 与主题库Q146，面试题16.25相同
}

class LRUCache {

    private HashMap<Integer, DoubleLinkedNode> cache = new HashMap<>();
    private int capacity = 0;
    private DoubleLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DoubleLinkedNode(-1, -1);
        tail = new DoubleLinkedNode(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DoubleLinkedNode node = cache.get(key);
            moveToFirst(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DoubleLinkedNode node = cache.get(key);
            node.value = value;
            moveToFirst(node);
        } else {
            if (cache.size() == capacity) {
                DoubleLinkedNode old = removeLast();
                cache.remove(old.key);
            }
            DoubleLinkedNode node = new DoubleLinkedNode(key, value);
            cache.put(key, node);
            addFirst(node);
        }
    }

    private void addFirst(DoubleLinkedNode node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    private void moveToFirst(DoubleLinkedNode node) {
        remove(node);
        addFirst(node);
    }

    private void remove(DoubleLinkedNode node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    private DoubleLinkedNode removeLast() {
        DoubleLinkedNode node = tail.pre;
        remove(node);
        return node;
    }

    static class DoubleLinkedNode {
        int key;
        int value;
        DoubleLinkedNode pre;
        DoubleLinkedNode next;
        public DoubleLinkedNode() {}
        public DoubleLinkedNode(int k, int v) {
            key = k; value = v;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */