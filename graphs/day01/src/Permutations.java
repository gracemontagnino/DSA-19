import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Permutations {
//O(V+E) because graph traversal
    public static void namePermutations(LinkedList<Integer> current, Set<Integer> unused, List<List<Integer>> permutations) {
        if (unused.isEmpty())
            permutations.add(new LinkedList<>(current));//base case
        for (int u : new LinkedList<>(unused)) {
            current.addLast(u);
            unused.remove(u);
            namePermutations(current, unused, permutations);
            unused.add(u);//backtracking
            current.removeLast();//backtracking

        }


    }

    public static List<List<Integer>> permutations(List<Integer> A) {
        Set<Integer> unused = new HashSet<>();
//        System.out.print(A);
//        System.out.print(A.get(1));
        List<List<Integer>> permutations = new LinkedList<>();
        for (int j = 0; j <A.size(); j++) {
            //System.out.print (j);
            unused.add(A.get(j));
        }
        namePermutations(new LinkedList<>(), unused, permutations);
        return permutations;

    }
}
