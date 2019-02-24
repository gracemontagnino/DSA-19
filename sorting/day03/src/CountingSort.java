import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class CountingSort {

    /**
     * Use counting sort to sort non-negative integer array A.
     * Runtime: O(n+k) b/c first half is n and second half is k
     * <p>
     * k: maximum element in array A
     */
    static void countingSort(int[] A) {
        int prev = 0;
        int k = A[0];
        for (int i = 0; i < A.length; i++) {
            if (A[i] > prev) {
                k = A[i];
                prev = A[i];
            }
        }


        int[] counts = new int[k+1];
        for (int e:A)
        {counts[e]++;}
        int i=0;
        for (int j=0; j<k+1; j++){
            while (counts[j]>0)
            {
                A[i]=j;
                counts[j]--;
                i++;
            }
        }
        }

    }
