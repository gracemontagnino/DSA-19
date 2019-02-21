public class HeapSort extends SortAlgorithm {
    int size;
    int[] heap;

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * (i + 1);
    }

    // Check children, and swap with larger child if necessary.
    // Corrects the position of element indexed i by sinking it.
    // Use either recursion or a loop to then sink the child
    public void sink(int i) {
        int biggest = i;
        if (size> leftChild(i)&&heap[leftChild(i)] > heap[biggest]) {
            biggest = leftChild(i);
        }
        if (size> rightChild(i)&&heap[rightChild(i)] > heap[biggest]) {
            biggest = rightChild(i);
        }
        if (biggest != i) {
            swap(heap, biggest, i);
            sink(biggest);
        }
    }

    // Given the array, build a heap by correcting every non-leaf's position, starting from the bottom, then
    // progressing upward
    public void heapify(int[] array) {
        this.heap = array;
        this.size = array.length;

        for (int i = this.size / 2 - 1; i >= 0; i--) {
            sink(i);
        }
    }

    /**
     * Best-case runtime: nlogn b/c always have to run heapify with is n, and for loop with is n, so thats 2n, then logn for sink b/c tree
     * Worst-case runtime: nlogn
     * Average-case runtime: nlogn
     * <p>
     * Space-complexity:O(1)
     */
    @Override
    public int[] sort(int[] array) {
        heapify(array);

        for (int i = size - 1; i > 0; i--) {
            swap(heap, i, 0);
            size--;
            sink(0);
        }

        return heap;
    }
}
