import java.util.ArrayList;

public class MyArrayList {
    private int size;
    private Cow[] MyArrayList;
    private Cow[] Newelems;

    // Runtime: O(1)
    public MyArrayList() {
        MyArrayList = new Cow[10];
    }

    // Runtime: O(1)
    public MyArrayList(int capacity) {
        MyArrayList = new Cow[capacity];
    }

    // Runtime: O(1)*
    public void add(Cow c) {
        if (size==MyArrayList.length){
            Newelems= new Cow[MyArrayList.length*2];
            System.arraycopy(MyArrayList, 0, Newelems, 0, MyArrayList.length);
            MyArrayList = Newelems;

        }
        MyArrayList[size] = c;
        size++;
    }

    // Runtime: O(1)
    public int size() {
        return size;
    }

    // Runtime: O(1)
    public Object get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        return MyArrayList[index];
    }

    // Runtime: O(N)
    public Cow remove(int index){
        if (index < size) {
            for (int k = index; k < size-1; k++) {
                MyArrayList[k] = MyArrayList[k + 1];
                }

        } else {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }size--;
        return MyArrayList[index];
    }

    // Runtime: O(N)
    public void add(int index, Cow c) {

        if (index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        if (size==MyArrayList.length){
            Newelems= new Cow[MyArrayList.length*2];
            System.arraycopy(MyArrayList, 0, Newelems, 0, MyArrayList.length);
            MyArrayList = Newelems;

        }
        for (int i = size-1; i > index; i--) {
            MyArrayList[i]= MyArrayList[i - 1];

        }
        MyArrayList[index]=c;
        size++;

    }
}