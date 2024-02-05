package org.example;

import org.w3c.dom.Node;

public class MyQueue <T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public MyQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (front == null) {
            return null;
        }
        return front.data;
    }

    public T poll() {
        if (front == null) {
            return null;
        }
        T value = front.data;
        front = front.next;
        size --;

        if (front == null) {
            rear = null;
        }
        return value;
    }
}
