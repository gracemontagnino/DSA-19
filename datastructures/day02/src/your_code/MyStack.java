package your_code;

import ADTs.StackADT;

import java.util.LinkedList;

/**
 * An implementation of the Stack interface.
 */
public class MyStack implements StackADT<Integer> {

    private LinkedList<Integer> ll;
    private LinkedList<Integer> l2;
    public MyStack() {
        ll = new LinkedList<>();
        l2= new LinkedList<>();
    }

    @Override
    public void push(Integer e) {
        ll.addFirst(e);
        if (l2.isEmpty() || e>=l2.peek()){
            l2.push(e);

        }    }

    @Override
    public Integer pop() {
        Integer pop = ll.removeFirst();
        if (pop==l2.peek())
        {l2.removeFirst(); }
        return pop;
    }

    @Override
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    @Override
    public Integer peek() {
        return ll.getFirst();
    }

    public Integer maxElement() {
        return l2.peek();
    }

}

