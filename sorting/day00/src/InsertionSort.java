
public class InsertionSort extends SortAlgorithm {
    /**
     * Use the insertion sort algorithm to sort the array
     *
     * Best-case runtime: O(N)
     * Worst-case runtime: O(N^2)
     * Average-case runtime: O(N^2)
     *
     * Space-complexity: O(1)
     */
    @Override
    public int[] sort(int[] array) {
        for (int i=1; i<array.length; i++){
            int p=i;
            while (p>0 && array[p-1]>array[p])
            {   swap(array, p, p-1);
                p--;
            }
        }
        return array;
    }
}
