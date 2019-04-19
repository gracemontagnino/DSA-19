import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class CoinsOnAClock {

    public static List<char[]> coinsOnAClock(int pennies, int nickels, int dimes, int hoursInDay) {
        List<char[]>result=new ArrayList<>();
        Map<Character,Integer>coinVals=new HashMap<>();
        coinVals.put('p',1);
        coinVals.put('n',5);
        coinVals.put('d',10);
        Map<Character, Integer> leftToCount=new HashMap<>();
        leftToCount.put('p',pennies);
        leftToCount.put('n',nickels);
        leftToCount.put('d',dimes);
        char[]clock=new char[hoursInDay];

        for (int j=0;j<clock.length;j++){
            clock[j]='.';

        }
        findStuff(clock,0,leftToCount,coinVals,result);
        return result;
    }
    public static void findStuff(char[] clock,int i, Map<Character, Integer> leftToCount, Map<Character, Integer>coinVals, List<char[]>solutions){
        boolean done=true;
        for (int v : leftToCount.values())
            if (v != 0)
                done = false;

        if (done){
            char[]copy=new char[clock.length];
            System.arraycopy(clock,0,copy,0,clock.length);
            solutions.add(copy);
            return;
        }
        if(clock[i]!='.'){
            return;
        }
        for (Map.Entry<Character, Integer> vali : leftToCount.entrySet()){
            if (vali.getValue()>0){
                int coin=coinVals.get(vali.getKey());
                clock[i]=vali.getKey();
                int nxt=(i+coin) % clock.length;
                vali.setValue(vali.getValue()-1);
                findStuff(clock,nxt,leftToCount,coinVals,solutions);
                clock[i]='.';
                vali.setValue(vali.getValue()+1);
                         }

        }
    }
    }
