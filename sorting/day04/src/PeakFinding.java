public class PeakFinding {

    // Return -1 if left is higher, 1 if right is higher, 0 if peak
    private static int peakOneD(int i, int[] nums) {
        if (i > 0 && nums[i] < nums[i - 1])
            return -1;
        if (i < nums.length - 1 && nums[i] < nums[i + 1])
            return 1;
        return 0;
    }

    // Return -1 if left is higher, 1 if right is higher, 0 if peak
    private static int peakX(int x, int y, int[][] nums) {
        if (x > 0 && nums[y][x] < nums[y][x - 1])
            return -1;
        if (x < nums[0].length - 1 && nums[y][x] < nums[y][x + 1])
            return 1;
        return 0;
    }

    // Return -1 if up is higher, 1 if down is higher, 0 if peak
    private static int peakY(int x, int y, int[][] nums) {
        if (y > 0 && nums[y][x] < nums[y - 1][x])
            return -1;
        if (y < nums.length - 1 && nums[y][x] < nums[y + 1][x])
            return 1;
        return 0;
    }

    // These two functions return the index of the highest value along the X or Y axis, with the given
    // value for the other axis. Searches between hi (exclusive) and lo (inclusive)
    private static int maxXIndex(int y, int lo, int hi, int[][] nums) {
        int maxIndex = -1;
        for (int x = lo; x < hi; x++) {
            if (maxIndex == -1 || nums[y][x] > nums[y][maxIndex])
                maxIndex = x;
        }
        return maxIndex;
    }

    private static int maxYIndex(int x, int lo, int hi, int[][] nums) {
        int maxIndex = -1;
        for (int y = lo; y < hi; y++) {
            if (maxIndex == -1 || nums[y][x] > nums[maxIndex][x])
                maxIndex = y;
        }
        return maxIndex;
    }


    public static int findOneDPeak(int[] nums) {//no combine step?
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            int side = peakOneD(mid, nums); //divide
            if (side == 0) return mid;  //base
            if (side == -1) high = mid; //conquer
            if (side == 1) low = mid + 1; //conquer
        }
        return -1;
    }//runtime:O(log(n)) b/c recursively calling it on halves

    public static int[] findTwoDPeak(int[][] nums) {
        boolean swap = true;
        int lx = 0;
        int hx = nums[0].length;
        int ly = 0;
        int hy = nums.length;
        while (lx < hx && ly < hy) {
            if (swap) {//divide
                int midx = (lx + hx) / 2;
                int ymax=maxYIndex(midx,ly,hy,nums);
                int side = peakX(midx, ymax, nums);//divide
                if (side == 0) return new int[] {ymax,midx};//base
                if (side == -1) hx = midx;//conquer
                if (side == 1) lx = midx + 1;//conquer
            }
            else {//divide
                int midy = (ly + hy) / 2;
                int xmax=maxXIndex(midy,lx,hx,nums);
                int side1 = peakY(xmax, midy, nums);//divide
                if (side1 == 0) return new int[]{midy,xmax};//base
                if (side1 == -1) hy = midy;//conquer
                if (side1 == 1) ly = midy + 1;//conquer
            }swap=!swap;//combine
        }


        return null;
    }//runtime:O(nlog(n)) because doing log(n) "max" operations

}
