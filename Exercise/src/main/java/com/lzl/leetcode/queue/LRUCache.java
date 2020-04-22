package com.lzl.leetcode.queue;

/**
 * @auther: marco.li
 * @date: Created in 2020/3/28
 */

import java.util.Objects;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LRUCache {

    private Entry head;

    private Entry tail;

    private Entry[] array;

    private volatile int size;

    public LRUCache(int capacity) {
        array = new Entry[capacity];
        size = 0;
        head = new Entry();
        tail = new Entry();
    }

    public int get(int key) {
        return key;
    }

    public void put(int key, int value) {
        int hash = hash(key);
        if (hash > array.length - 1) throw new ArrayIndexOutOfBoundsException("out of LRUCache Exception");

        Entry entry = new Entry();
        entry.key = key;
        entry.value = new Node();
        entry.value.value = value;

        // 处理双向链表
        if (Objects.isNull(head)) {
            array[hash] = entry;
            tail = head = entry;
            size++;
        } else {
            Entry existedEntry = getEntry(key);
            if (Objects.nonNull(existedEntry)) {
                Node pre = existedEntry.value.pre;
                Node next = existedEntry.value.next;
                pre.next = next;
                next.pre = pre;
                // GC
                existedEntry.value.pre = null;
                existedEntry.value.next = null;
                size--;
            }
            // 直接覆盖
            array[hash] = entry;

            // 放入链表头部
            Node next = head.value;
            entry.value.next = next;
            next.pre = entry.value;
            head = entry;
            size++;

        }

    }


    private Entry getEntry(int key) {
        return array[hash(key)];
    }

    public int hash(int key) {
        return key;
    }


    class Entry {
        private int key;

        private Node value;

        public Entry() {

        }

        public Entry(int key, Node value) {
            this.key = key;
            this.value = value;
        }
    }

    class Node {
        private Node next;

        private Node pre;

        private int value;

        public Node() {

        }
    }

    public static void main(String[] args) {
        System.out.println("165927228091416694".hashCode() % 8);
    }

}
