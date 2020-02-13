package alg.oa.amazon2020OA.freq0;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous reefs.
Other areas are safe to sail in. There are other explorers trying to find the treasure. So you must figure out a shortest route to the treasure island.

Assume the map area is a two dimensional grid, represented by a matrix of characters. You must start from the top-left
corner of the map and can move one block up, down, left or right at a time. The treasure island is marked as X in a
block of the matrix. X will not be at the top-left corner. Any block with dangerous rocks or reefs will be marked as D.
You must not enter dangerous blocks. You cannot leave the map area. Other areas O are safe to sail in.
The top-left corner is always safe. Output the minimum number of steps to get to the treasure.

start from top left
x - treasury
d - danger
o - safe to sail

Example:

Input:
[['O', 'O', 'O', 'O'],
 ['D', 'O', 'D', 'O'],
 ['O', 'O', 'O', 'O'],
 ['X', 'D', 'D', 'O']]

Output: 5
Explanation: Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps.
 */
public class TreasuryIslandI {
    private final char TREASURY = 'X';
    private final char SAFE = 'O';
    private final char DANGER = 'D';

    public static void main(String[] args) {
        char[][] input = new char[][]{
                new char[]{'O', 'O', 'O', 'O'},
                new char[]{'D', 'O', 'D', 'O'},
                new char[]{'O', 'O', 'O', 'O'},
                new char[]{'X', 'D', 'D', 'O'}
        };

        TreasuryIslandI engine = new TreasuryIslandI();
        System.out.println(engine.minRoute(input));
    }

    public int minRoute(char[][] input) {
        boolean[][] visited = new boolean[input.length][input[0].length];
        Queue<Ptr> queue = new LinkedList<>();
        queue.offer(new Ptr(0, 0));
        visited[0][0] = true;
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Ptr toExpand = queue.poll();
                visited[toExpand.row][toExpand.col] = true;
                if (input[toExpand.row][toExpand.col] == TREASURY) return distance;
                List<Ptr> validNeighbors = getNei(toExpand, visited, input);
                for (Ptr nei : validNeighbors) {
                    queue.offer(nei);
                }
            }
            distance++;
        }
        return -1;
    }

    private List<Ptr> getNei(Ptr ptr, boolean[][] visited, char[][] input) {
        List<Ptr> nei = new ArrayList<>();
        int[] dRow = new int[]{0, 0, 1, -1};
        int[] dCol = new int[]{1, -1, 0, 0};
        for (int i = 0; i < dRow.length; i++) {
            int curRow = ptr.row + dRow[i];
            int curCol = ptr.col + dCol[i];
            if (curRow >= 0 && curRow < visited.length
                    && curCol >= 0 && curCol < visited[0].length
                    && input[curRow][curCol] != DANGER
                    && !visited[curRow][curCol]
            ) {
                nei.add(new Ptr(curRow, curCol));
            }
        }
        return nei;
    }

    static class Ptr {
        int row, col;

        public Ptr(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
