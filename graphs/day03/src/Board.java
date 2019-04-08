import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.abs;

/**
 * Board definition for the 8 Puzzle challenge
 */

public class Board {
    public int hashCode(){
        int hash=0;
        for (int t=0;t<tiles.length;t++){
            for (int p=0;p<tiles.length;p++){
                hash=hash*10 +tiles[t][p];
            }
        }return hash;
    }
    private int n;
    public int[][] tiles;

    private int[][] goal = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};

    /*
     * Set the global board size and tile state
     */
    public Board(int[][] b) {
        tiles=new int [b.length][b.length];
        n=b.length;
        for(int h=0;h<n;h++){
            for(int g=0;g<n;g++){
                tiles[h][g]=b[h][g];
            }
        }
        //tiles = b;
        n = b.length;
    }

    /*
     * Size of the board 
     (equal to 3 for 8 puzzle, 4 for 15 puzzle, 5 for 24 puzzle, etc)
     */
    private int size() {
        return n;
    }

    /*
     * Sum of the manhattan distances between the tiles and the goal
     */
    public int manhattan() {
        int total = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                int val = tiles[x][y];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (val == goal[i][j] && val != 0) {
                            total += abs(x - i) + abs(y - j);
                            //System.out.println(total);
                        }
                    }

                }
            }
        }
        return total;
    }

    /*
     * Compare the current state to the goal state
     */
    public boolean isGoal() {
        boolean goals = false;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (goal[x][y] != tiles[x][y]) {
                    return false;
                }

            }
        }
        return true;

    }

    /*
     * Returns true if the board is solvable
     * Research how to check this without exploring all states
     */
    public boolean solvable() {
        int inv = 0;
        int index=0;
        int[] iter=new int[tiles.length*tiles.length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                iter[index]=(tiles[i][j]);
                index++;
                }
            }

        for (int x=0;x<iter.length;x++){
            if ((iter[x])!=0){
                   int y=x+1;
                   while(y<iter.length){
                       if (iter[x]>iter[y] && iter[x]>0 && iter[y]>0){inv++;}
                       y++;
                   }
                }
            }return (inv%2==0);

    }

    /*
     * Return all neighboring boards in the state tree
     */
    public Iterable<Board> neighbors() {

        ArrayList<Board> inter = new ArrayList<>();
        Board z = new Board(tiles);
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (tiles[x][y] == 0) {
                    Board newboard;
                    if (x != n - 1) {
                        newboard=new Board(tiles);
                        newboard.tiles[x][y] = tiles[x + 1][y];
                        newboard.tiles[x + 1][y] = 0;
                        inter.add(newboard);
                    }
                    if (y != n - 1) {
                        newboard=new Board(tiles);
                        newboard.tiles[x][y] = tiles[x][y + 1];
                        newboard.tiles[x][y + 1] = 0;
                        inter.add(newboard);
                    }
                    if (x != 0) {
                        newboard=new Board(tiles);
                        newboard.tiles[x][y] = tiles[x - 1][y];
                        newboard.tiles[x - 1][y] = 0;
                        inter.add(newboard);
                    }
                    if (y != 0) {
                        newboard=new Board(tiles);
                        newboard.tiles[x][y] = tiles[x][y - 1];
                        newboard.tiles[x][y - 1] = 0;
                        inter.add(newboard);
                    }
                }

            }
        }
        return inter;
    }

    /*
     * Check if this board equals a given board state
     */
    @Override
    public boolean equals(Object x) {
        // Check if the board equals an input Board object
        if (x == this) return true;
        if (x == null) return false;
        if (!(x instanceof Board)) return false;
        // Check if the same size
        Board y = (Board) x;
        if (y.tiles.length != n || y.tiles[0].length != n) {
            return false;
        }
        // Check if the same tile configuration
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (this.tiles[i][j] != y.tiles[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // DEBUG - Your solution can include whatever output you find useful
        int[][] initState = {{1, 2, 3}, {4, 0, 6}, {7, 8, 5}};
        Board board = new Board(initState);

        System.out.println("Size: " + board.size());
        System.out.println("Solvable: " + board.solvable());
        System.out.println("Manhattan: " + board.manhattan());
        System.out.println("Is goal: " + board.isGoal());
        System.out.println("Neighbors:");
        Iterable<Board> it = board.neighbors();
    }
}
