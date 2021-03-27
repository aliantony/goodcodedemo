package com.antony.arithmetic;

/**
 * 数组实现环形队列
 *      -预留空间法
 */
public class ArrayCircleQueue {
    private int maxSize;
    private int front; // 指向队列的第一个元素，arr[front]就是队列的第一个元素。初始值0
    private int rear;  // 指向队列的最后一个元素的后一个位置，希望空出一个空间作为约定。初始值0
    private int[] arr;

    public ArrayCircleQueue(int size) {
        maxSize = size;
        arr = new int[size];
    }

    /**
     * 只能放maxsize - 1个元素，留一个空位实现环形队列的判断
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void offer(int v) {
        if (isFull()) {
            System.out.println("queue is full!!!");
            return;
        }
        arr[rear] = v;
        rear = (rear + 1) % maxSize;
    }

    public int poll() {
        if (isEmpty()) throw new RuntimeException("queue is empty!!!");
        int res = arr[front];
        front = (front + 1) % maxSize;
        return res;
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("queue is empty");
        return arr[front];
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("queue is empty!!!");
            return;
        }
        System.out.println("Front -> rear");
        for (int i = front; i < front + size(); i++) {
            System.out.print(arr[i % maxSize]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayCircleQueue que = new ArrayCircleQueue(5);
        que.offer(1);
        que.offer(2);
        que.offer(3);
        que.offer(4);
        que.offer(5);
        System.out.println(que.poll());
        System.out.println(que.poll());
        que.offer(6);
        que.offer(7);
        que.show();
    }
}