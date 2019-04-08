/**
 * Solver definition for the 8 Puzzle challenge
 * Construct a tree of board states using A* to find a path to the goal
 */

import java.util.*;

public class Solver {

    public int minMoves = -1;
    private State solutionState;
    private boolean solved = false;
    public List<Board> output = new ArrayList<>();


    /**
     * State class to make the cost calculations simple
     * This class holds a board state and all of its attributes
     */
    private class State {
        // Each state needs to keep track of its cost and the previous state
        private Board board;
        private int moves; // equal to g-cost in A*
        public int cost; // equal to f-cost in A*
        private State prev;

        public State(Board board, int moves, State prev) {
            this.board = board;
            this.moves = moves;
            this.prev = prev;
            cost = moves + board.manhattan();
        }

        @Override
        public boolean equals(Object s) {
            if (s == this) return true;
            if (s == null) return false;
            if (!(s instanceof State)) return false;
            return ((State) s).board.equals(this.board);
        }
    }

    /*
     * Return the root state of a given state
     */
    private List root(State state) {
        if (state.prev != null) {
            root(state);
            output.add(state.board);
        }
        return output;
    }

    /*
     * A* Solver
     * Find a solution to the initial board using A* to generate the state tree
     * and a identify the shortest path to the the goal state
     */

    public Solver(Board initial) {
        HashMap<Board,Integer> visited = new HashMap<>();
        Queue<State> priorityQueue = new PriorityQueue<>(new Comparator<State>() {

            @Override
            public int compare(State o1, State o2) {
                if(o1.cost>o2.cost)return 1;
                if(o1.cost<o2.cost)return -1;
                return 0;
            }});

        State next;

        solutionState = new State(initial, 0 , null);
        priorityQueue.add(solutionState);
        visited.put(solutionState.board,solutionState.moves);

        while(!priorityQueue.isEmpty()){
            State curr = priorityQueue.poll();
            if (curr.board.isGoal()) {
                solutionState = curr;
                solved = true;
                minMoves = curr.moves;

                break;
            }
            for(Board b : curr.board.neighbors()) {
                if(visited.getOrDefault(b,null)==null) {
                    next = new State(b, curr.moves + 1, curr);
                    visited.put(b,next.moves);
                    priorityQueue.add(next);
                }
                else{
                    next = new State(b, curr.moves + 1, curr);
                    if(visited.get(b)>next.moves){
                        visited.put(b,next.moves);
                        priorityQueue.add(next);
                    }
                }
            }

        }
    }
    /*
     * Is the input board a solvable state
     * Research how to check this without exploring all states
     */
    public boolean isSolvable() {
        return solutionState.board.solvable();
    }

    /*
     * Return the sequence of boards in a shortest solution, null if unsolvable
     */
    public Iterable<Board> solution() {
        //Solver(solutionState);
        if (!isSolvable()) {
            return null;
        }
        return root(solutionState);
    }

    public State find(Iterable<State> iter, Board b) {
        for (State s : iter) {
            if (s.board.equals(b)) {
                return s;
            }
        }
        return null;
    }

    /*
     * Debugging space
     */
    public static void main(String[] args) {
        int[][] initState = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Board initial = new Board(initState);

        Solver solver = new Solver(initial);
    }


}
