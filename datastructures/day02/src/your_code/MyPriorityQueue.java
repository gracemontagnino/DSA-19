
package your_code;
import java.util.ArrayList;
/**
 * An implementation of a priority Queue
 */
public class MyPriorityQueue {

    ArrayList list = new ArrayList<Integer>();

    public void enqueue(int item) {
        for (int k = 0; k < list.size(); k++) {
            if ( (int)list.get(k) > item) {
                list.add(k, item);
                return;
            }
        }
        list.add(item);
    }
    /**
     * Return and remove the largest item on the queue.
     */
    public int dequeueMax() {
        int x= (int) list.remove(list.size()-1);
        return x;}

}