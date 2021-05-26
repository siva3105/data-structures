package heap;

public class MaxHeap {
    private Integer[] heap;
    int currentIndexPosition = -1;

    public MaxHeap(int size) {
        this.heap = new Integer[size];
    }

    public void insert(Integer data) {
        if (isFull()) {
            throw new RuntimeException("heap is full");
        }
        heap[++currentIndexPosition] = data;
        heapify(currentIndexPosition);
    }

    private void heapify(int index) {
        int parentIndex = (index - 1) / 2;
        while (index >= 0 && heap[parentIndex] < heap[index]) {
            Integer temp = heap[parentIndex];
            heap[parentIndex] = heap[index];
            heap[index] = temp;
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private boolean isFull() {
        return this.currentIndexPosition == this.heap.length;
    }

    public Integer getMax() {
        return this.heap[0];
    }

    public void remove() {
        Integer removedElement = heap[0];
        System.out.println("removed element is "+removedElement);
        heap[0] = heap[currentIndexPosition--];
        heap[currentIndexPosition + 1] = null;
        int upto = currentIndexPosition;
        int index = 0;
        while (index <= upto) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            if (leftChildIndex <= upto) {
                int childToSwap;
                if (rightChildIndex > upto) {
                    childToSwap = leftChildIndex;
                } else {
                    childToSwap = (heap[rightChildIndex] > heap[leftChildIndex]) ? rightChildIndex : leftChildIndex;
                }
                if (heap[index] < heap[childToSwap]) {
                    Integer temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                    index = childToSwap;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }
}


