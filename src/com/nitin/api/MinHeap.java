package com.nitin.api;

import com.nitin.model.HeapBase;

public class MinHeap extends HeapBase {

    public MinHeap(int capacity, boolean isMinHeap) {
        super(capacity, isMinHeap);
    }

    @Override
    public void heapify(int index) {
        int minimum = index; // Initialize minimum as root
        int l = 2 * index + 1; // left  = 2 * i + 1
        int r = 2 * index + 2; // right = 2 * i + 2

        // If left child is larger than root
        if ((l < getHeapSize()) &&
                (getHeapArray()[l] < getHeapArray()[minimum])) {
            minimum = l;
        }

        // If right child is larger than minimum so far
        if ((r < getHeapSize()) &&
                (getHeapArray()[r] < getHeapArray()[minimum])) {
            minimum = r;
        }

        // If minimum is not root
        if (minimum != index) {
            swapKeysInHeap(index, minimum);

            // Recursively heapify the affected sub-tree
            // Index is the new min after swap
            if (getHeapArray()[getParentIndex(index)] > getHeapArray()[index]) {
                heapify(getParentIndex(index));
            }
        }
    }

    @Override
    public void insertKey(int key) {
        if (getHeapSize() == getCapacity()) {
            resizeHeapArray();
        }

        incrementHeapSize();
        int index = getHeapSize() - 1;
        getHeapArray()[index] = key;

        if (index != 0 &&
                (getHeapArray()[getParentIndex(index)] > getHeapArray()[index])) {
            heapify(getParentIndex(index));
        }
    }

    @Override
    public void deleteKey(int index) {

    }

    public int getCurrentMin() {
        return getCurrentRootKey();
    }

    public int extractCurrentMin() {
        return 0;
    }
}
