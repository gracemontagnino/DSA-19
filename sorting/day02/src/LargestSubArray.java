import java.util.HashMap;
import java.util.Map;

public class LargestSubArray {
    //Done with help from leetcode.com
    static int[] largestSubarray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] set={0,0};
        int[] sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=nums[i]*2-1;
            }
        map.put(0,-1);
        for (int i = 0; i < sum.length; i++)
            if (i==0) sum[i]=nums[i];
            else
            sum[i] = nums[i] + sum[i-1];

        for (int i = 0; i < sum.length; i++) {
            if (!map.containsKey(sum[i]))
                {map.put(sum[i], i);}
            int max = i - map.get(sum[i]) - 1;
            if (max > set[1] - set[0])
            {set[0]=map.get(sum[i])+1;
                set[1]=i;}
        }
        return set;
    }

    }



