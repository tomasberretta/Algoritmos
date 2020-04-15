package TPs.TP4;

import java.util.Arrays;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

public class KnightMovement {
    // The board is a 9x9 grid and the knight position is given by an int array with the form [a, b]
    // with a and b between 0-9.

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

    public static void main(String[] args) {
        // Does all possible third moves and shows all possible fourth moves.
        printMoves(3, new int[]{0,0});
    }

    static void printMoves(int n, int[] initialPosition){
        System.out.println("Move: 0 "+ Arrays.toString(initialPosition));
        Stack<int[]>[] stacks = new Stack[n+1];
        Stack<int[]> firstMoves = findPossibleMoves(board, initialPosition);
        stacks[0] = firstMoves;
        showMoves(n,0,n,stacks);
    }

    // Generates possible moves and stacks them, then prints each of them will popping them.
    static void showMoves(int n,int i, int counter, Stack<int[]>[] stacks){
        while(stacks[0].size != 0){
            if(n == 0){
                int stackSize = stacks[i].size;
                System.out.println("Posible Moves: ");
                for (int j = 0; j < stackSize; j++) {
                    System.out.println(Arrays.toString(stacks[i].peek()));
                    stacks[i].pop();
                }
                if(i != 0 ){
                    n++;
                    i--;
                    stacks[i].pop();
                }
                for (int j = 0; j < counter-1; j++) {
                    if (stacks[i].size == 0){
                        n++;
                        i--;
                        stacks[i].pop();
                    }
                }
            }else{
                stacks[i+1] = findPossibleMoves(board, stacks[i].peek());
                int numMov = i+1;
                System.out.println("Move: "+ numMov +" "+ Arrays.toString(stacks[i].peek()));
                showMoves(--n, ++i, counter, stacks);
            }
        }
    }

    // Given an initial position returns a stack with every possible move the knight can make.
    static Stack<int[]> findPossibleMoves(int[][] board, int[] pos)
    {
        int[] X = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int[] Y = { 1, 2, 2, 1, -1, -2, -2, -1 };

        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < 8; i++) {

            int x = pos[0] + X[i];
            int y = pos[1] + Y[i];

            if (x >= 0 && y >= 0 && x < 8 && y < 8
                    && board[x][y] == 0)
                stack.push(new int[]{x,y});
        }
        return stack;
    }
}