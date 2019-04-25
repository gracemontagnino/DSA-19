import java.util.HashMap;
public class DiceRollSum {
    //Sub problem N-1
    //Guess what roll do we need to get next?
    //Recurrence Relation recursion on all six sides
    //Memoize if map has key
    //Solve return DP
    // Runtime:O(N)
    // Space: O(N)
    public  static int diceRollSum(int N) {
        HashMap <Integer,Integer> map =new HashMap<>();
        return recursive(N,map);

    }
    public static int recursive(int N,HashMap<Integer,Integer> map) {
        if (N==0) return 1;
        if (N<0) return 0;
        if (map.containsKey(N)){
            return map.get(N);
        }
        int DP=recursive(N-1,map)+recursive(N-2,map)+recursive(N-3,map)+recursive(N-4,map)+recursive(N-5,map)+recursive(N-6,map);
        map.put(N,DP);
        return DP;
        }


    }


