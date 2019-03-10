import java.util.ArrayList;

public class Problems {

    public static int leastSum(int[] A) {
        int num1 = 0;
        int num2 = 0;
        int[] totals = new int[];
        for (int i = 0; i < A.length; i++) {
            totals[A[i]]++;
        }
        boolean switc = true;
        int x = 0;
        int k=0;
        for (int j = totals.length - 1; j > 0; j--) {
            while (totals[j] > 0) {
                if ((switc) && totals[j] > 0) {
                    num1 += Math.pow(10, k) * j;
                    totals[j]--;
                    switc = false;
                    x++;

                if (x == 2) {
                    x = 0;
                    k++;
                }
            }
            if ((!switc) & totals[j] > 0) {
                num2 += Math.pow(10, k) * j;
                totals[j]--;
                switc = true;
                x++;

            if (x == 2) {
                x = 0;
                k++;
            }

        }}}


        return num1 +num2;
}


}
