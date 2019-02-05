package com.nitin.model;

import java.util.Arrays;

public abstract class HeapBase {

    private int[]   heapArray;
    private int     capacity;
    private int     heapSize;
    private boolean isMinHeap;

    public HeapBase(int capacity, boolean isMinHeap) {
        this.heapSize = 0;
        this.capacity = capacity;
        this.isMinHeap = isMinHeap;
        this.heapArray = new int[capacity];
    }

    public int[] getHeapArray() {
        return heapArray;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public void incrementHeapSize() {
        this.heapSize += 1;
    }

    public boolean isMinHeap() {
        return this.isMinHeap;
    }

    public void resizeHeapArray() {
        this.heapArray = Arrays.copyOf(this.heapArray, 2 * this.capacity);
    }

    public int getCurrentRootKey() {
        return this.heapArray[0];
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public int getParentKey(int index) {
        return this.heapArray[getParentIndex(index)];
    }

    public int getLeftIndex(int index) {
        return 2 * index + 1;
    }

    public int getLeftKey(int index) {
        return this.heapArray[getLeftIndex(index)];
    }

    public int getRightIndex(int index) {
        return 2 * index + 2;
    }

    public int getRightKey(int index) {
        return this.heapArray[getRightIndex(index)];
    }

    public void swapKeysInHeap(int index1, int index2) {
        int temp = this.heapArray[index1];

        this.heapArray[index1] = this.heapArray[index2];
        this.heapArray[index2] = temp;
    }

    public void printArray() {
        for (int i = 0; i < this.heapSize; ++i) {
            System.out.print(this.heapArray[i] + " ");
        }

        System.out.println();
    }

    public abstract void heapify(int index);

    public abstract void insertKey(int key);

    public abstract void deleteKey(int index);

}
