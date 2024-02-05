package org.example;

public class MyStack  <T> {
    private Node<T> top;
    private int size;

    public static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public MyStack() {
        this.top = null;
        this.size = 0;
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            top = top.next;
        } else {
            Node<T> current = top;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }

        size--;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (top == null) {
            return null;
        }
        return top.data;
    }

    public T pop() {
        if (top == null) {
            return null;
        }
        T value = top.data;
        top = top.next;
        size--;

        return value;
    }
}
