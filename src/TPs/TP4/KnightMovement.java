package TPs.TP4;

import java.util.Arrays;

public class KnightMovement {
    static int[][] board = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
    };

    static Stack<int[]> firstMoves = findPossibleMoves(board,new int[]{0,0});

    // To calculate possible moves
    static Stack<int[]> findPossibleMoves(int[][] board, int[] pos)
    {
        // All possible moves of a knight
        int X[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int Y[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

        Stack<int[]> stack = new Stack<>();

        // Check if each possible move is valid or not
        for (int i = 0; i < 8; i++) {

            // Position of knight after move
            int x = pos[0] + X[i];
            int y = pos[1] + Y[i];

            // push valid moves into stack
            if (x >= 0 && y >= 0 && x < 8 && y < 8
                    && board[x][y] == 0)
                stack.push(new int[]{x,y});
        }

        // Return number of possible moves
        return stack;
    }

    static void printMoves(int n, int i, Stack<int[]>[] stacks){
        if(n == 1){
            int stackSize = stacks[i].size();
            for (int j = 0; j < stackSize; j++) {
                System.out.println(Arrays.toString(stacks[i].peek()));
                stacks[i].pop();
            }
            System.out.println("nuevo");
            stacks[i-1].pop();
            try {
            System.out.println(Arrays.toString(stacks[i-1].peek()));
            stacks[i] = findPossibleMoves(board, stacks[i-1].peek());
            } catch (NullPointerException e) {
                i--;
                n++;
                System.out.println(Arrays.toString(stacks[i-1].peek()));
                stacks[i-1].pop();
                stacks[i] = findPossibleMoves(board, stacks[i-1].peek());
            }
            printMoves(n, i, stacks);
        }
        else {
            System.out.println(Arrays.toString(stacks[i].peek()));
            stacks[i+1] = findPossibleMoves(board, stacks[i].peek());
            printMoves(n-1, i+1, stacks);
        }
    }

    public static void main(String[] args) {
        Stack<int[]>[] stacks = new Stack[4];
        stacks[0] = findPossibleMoves(board, new int[]{0,0});
        printMoves(4, 0, stacks);
    }
}
