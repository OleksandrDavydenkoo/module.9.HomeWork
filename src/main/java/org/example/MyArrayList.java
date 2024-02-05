package org.example;

public class MyArrayList <T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] array;
    private int size;

    public MyArrayList() {
        this.array = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    public void add(T value) {
        ensureCapacity();
        array[size] = value;
        size++;
    }
    private void ensureCapacity() {
        if (size == array.length) {
            Object[] newArray = new Object[array.length * 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = (T[]) newArray;
        }
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[size - 1] = null;
        size--;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (T) array[index];
    }
}
