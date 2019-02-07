import java.util.List;
import java.util.Stack;

public class Problems {

    public static class Node {
        int val;
        Node next;

        Node(int d) {
            this.val = d;
            next = null;
        }
    }

    public static List<Integer> removeKDigits(int[] A, int k) {
        Stack<Integer> stack = new Stack();
        int curr_k = 0;

        for (int number : A) {

            while (!stack.empty() && stack.peek() > number && curr_k < k) {

                stack.pop();
                curr_k++;
            }
            if (stack.size() < A.length - k) {
                stack.add(number);
            }


        }
        return stack;
    }

        /*while (A.length != 0) {
            int min = 10;
            int index = 0;
            for (int i = 0; i < A.length - (A.length - k); i++) {
                if (A[i] < min) {
                    min = A[i];
                    index = i;
                }
                sol.add(min);
                A = Arrays.copyOfRange(A, index, A.length - k);
                System.out.print(A);

            }
        }
        return sol;

    }*/



        /*int[] myArray = new int[A.length];
        for (int i = 0; i < A.length-1; i++) {
            A[i] = A[i] * 10 + ((A.length) - i);

            if (myArray==null) {
                myArray[0] = A[i];
            }
            if (myArray.length < 2) {
                if (myArray[0] > A[i]) {
                    myArray[1] = myArray[0];
                    myArray[0] = A[i];
                } else {
                    myArray[1]=A[i];
                }
            }
            if (myArray.length > 2) {
                if (myArray[i] > A[i]) {
                    myArray[i+1] = myArray[i];
                    myArray[i]=A[i];

                } else {
                    myArray[i+1]=A[i];

                }

            }
               }
        for (int i = 0; i < myArray.length; i++){System.out.println(myArray[i]);}
            return l;}}

        /*System.out.println(A);
        int newNum=A[0];
        int pos=0;
        for (int i = 0; i < A.length - k; i++)
        {for (int j=pos; j<A.length-k+i;j++){
            if (A[j]<newNum){
                newNum=A[j];
                pos=j;
            }
            l.add(newNum);
        }

        }
        System.out.println(l);
        return l;*/
//}

    public static boolean isPalindrome(Node n) {
        int Length = 0;
        Node length_test = n;
        while (length_test != null) {
            length_test = length_test.next;
            Length++;
        }
        if (Length < 2) {
            return true;
        }
        if (Length == 2) {
            if (n.val == n.next.val) {
                return true;
            } else {
                return false;
            }
        }

        Node reverse = null;
        int count = 0;
        while (count < Length / 2) {// Reversing a singly linked list with just a head: https://www.quora.com/How-can-we-reverse-a-singly-linked-list-using-only-one-pass-through-the-list
            Node nxt = n.next;
            n.next = reverse;
            reverse = n;
            n = nxt;
            count++;
//                System.out.print(n);
        }
        if (Length % 2 != 0) {
            n = n.next;

        }

        for (int i = 0; i < (Length - 1) / 2; i++) {
            while (n != null && reverse != null) {

                if (n.val != reverse.val) {
                    return false;
                }
                n = n.next;
                reverse = reverse.next;
            }
        }
        return true;

    }


    public static String infixToPostfix(String s) {
        String result= "";
        Stack stack=new Stack();
        for (int i=0; i<s.length();i++)
        {
            if (s.charAt(i)!='('&& s.charAt(i)!=')'&& s.charAt(i)!=' '){
                if (s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'||s.charAt(i)=='/')
                    {stack.push(s.charAt(i));}
                else  {result=result+s.charAt(i)+' ';} }
            if (s.charAt(i)==')'){
                result=result+stack.pop()+' ';
            }
        }return result.trim();
    }
}


