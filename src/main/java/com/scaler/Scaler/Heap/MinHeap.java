package com.scaler.Scaler.Heap;


public class MinHeap {

    HeapElement[] heap;
    int size;

    public MinHeap(int size) {
        this.heap = new HeapElement[size];
        this.size = 0;
    }

    public int[][] solve(int[][] A, int B) {

        MinHeap heap = new MinHeap(A.length);
        for (int[] ints : A) {
            heap.insert(new HeapElement(ints[0], ints[1]));
        }

        int[][] output = new int[B][2];
        int i = 0;
        while (B > 0) {
            HeapElement minEle = heap.getMinimum();
            output[i][0] = minEle.point.x;
            output[i][1] = minEle.point.y;
            B--;
            i++;
        }
        return output;

    }

    public void insert(HeapElement x) {

        // insert x into last position
        if (!isFull()) {
            heap[size] = x;
            size++;

            int i = size - 1;
            while (i > 0) {
                int parentIndex = (i - 1) / 2;
                if (heap[i].distance < heap[parentIndex].distance) {
                    swap(i, parentIndex);
                    i = parentIndex;
                } else {
                    return;
                }
            }
        }
    }

    public HeapElement getMinimum() {
        HeapElement x = null;
        if (!isEmpty()) {
            x = heap[0];
            // swap last element and x
            swap(0, size - 1);
            heap[size - 1] = null;
            size--;

            int i = 0;

            while ((2 * i) + 1 < size) {
                int leftChildIndex = (2 * i) + 1;
                int rightChildIndex = (2 * i) + 2;
                double min = Math.min(heap[leftChildIndex].distance, heap[i].distance);
                if (rightChildIndex < size) {
                    min = Math.min(min, heap[rightChildIndex].distance);
                }

                if (min == heap[i].distance) {
                    break;
                } else if (min == heap[leftChildIndex].distance) {
                    swap(i, leftChildIndex);
                    i = leftChildIndex;
                } else if (rightChildIndex < size && min == heap[rightChildIndex].distance) {
                    swap(i, rightChildIndex);
                    i = rightChildIndex;
                }
            }

        }
        return x;
    }

    public boolean isFull() {
        return this.size == heap.length;
    }

    private void swap(int i, int j) {
        HeapElement temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return size;
    }

    public HeapElement[] getHeap() {
        return this.heap;
    }

    class HeapElement {
        double distance;
        Coordinate point;

        public HeapElement(int x, int y) {
            this.point = new Coordinate(x, y);
            this.distance = Math.sqrt((x * x) + (y * y));
        }
    }

    class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}