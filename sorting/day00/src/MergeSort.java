import java.util.Arrays;

public class MergeSort extends SortAlgorithm {

    private static final int INSERTION_THRESHOLD = 10;
    InsertionSort insertionsort=new InsertionSort();
    /**
     * This is the recursive step in which you split the array up into
     * a left and a right portion, sort them, and then merge them together.
     * Use Insertion Sort if the length of the array is <= INSERTION_THRESHOLD
     * <p>
     * Best-case runtime: klog(n) (where each element is max k spots off of spot)
     * Worst-case runtime: nlog(n)
     * Average-case runtime: nlog(n)
     * <p>
     * Space-complexity: o(N), O(1) if use a linked list
     */
    @Override
    public int[] sort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        if (array.length <= INSERTION_THRESHOLD) {
            return insertionsort.sort(array);
        }
        int sortedL[] = Arrays.copyOfRange(array, 0, array.length / 2);
        int sortedR[] = Arrays.copyOfRange(array, array.length / 2, array.length);
        int merged_array[] = merge(sort(sortedL), sort(sortedR));
        return merged_array;
    }


    /**
     * Given two sorted arrays a and b, return a new sorted array containing
     * all elements in a and b. A test for this method is provided in `SortTest.java`
     */
    public int[] merge(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        if (a.length == 0) {
            if (b.length == 0) {
                return null;
            }
            merged = b;
        }
        if (b.length == 0) {
            if (a.length == 0) {
                return null;
            }
            merged = a;
        }
        if (1 < a.length && 1 < b.length) {
            while (i < a.length && j < b.length) {
                if (a[i] > b[j]) {
                    merged[k] = b[j];
                    k++;
                    j++;
                } else {
                    merged[k] = a[i];
                    k++;
                    i++;
                }
            }
        }
        while (i < a.length) {
            merged[k++] = a[i++];
        }
        while (j < b.length) {
            merged[k++] = b[j++];
        }
        return merged;
    }
}
