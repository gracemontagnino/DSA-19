import java.util.Arrays;

public class LongestIncreasingSubsequence {
    //Sub problem Largest Sub sequence @ i
    //Guess Is next number larger?
    //Recurrence Relation max prev and next
    //Memoize if DP!=-1
    //Solve return DP[i]
    // Runtime: A.length*A.length-1=O(n^2)
    // Space: O(N)
    public static int LIS(int[] A) {
        int[] DP= new int [A.length];
        for (int i = 0; i < A.length; i++) {
            DP[i] = -1;
        }
        int ans=0;
        for (int i = 0; i < A.length; i++) {
            ans=Math.max(recursive(DP,A,i),ans);
        }
        return ans;

        }

        public static int recursive(int[] DP, int[] A, int i) {
            if (DP[i]!=-1)return DP[i];
            int ansr=1;
            for(int j=i+1;j<A.length;j++)
            {if(A[j]>A[i]){ansr=Math.max(ansr,1+recursive(DP,A,j));}
               }
            DP[i]=ansr;
            return DP[i];
        }


    }