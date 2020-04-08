package TPs.TP3;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

public class Sudoku {
    private int[][] sudokuGrid;

    public Sudoku(int[][] sudokuGrid){
        this.sudokuGrid = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.sudokuGrid[i][j] = sudokuGrid[i][j];
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9},
        };

        Sudoku sudoku = new Sudoku(grid);
        System.out.println("Sudoku to solve:");
        sudoku.showSudoku();

        sudoku.solveSudoku();
        System.out.println("Sudoku solved: ");
        sudoku.showSudoku();
    }

    public boolean solveSudoku() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudokuGrid[i][j] == 0) {
                    for (int numberToAdd = 1; numberToAdd <= 9; numberToAdd++) {
                        if (checkIfNumberCanBeAdded(i, j, numberToAdd)) {
                            sudokuGrid[i][j] = numberToAdd;
                            if (solveSudoku()) {
                                return true;
                            } else {
                                sudokuGrid[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkIfNumberCanBeAdded(int row, int column, int numberToBeAdded) {
        return !checkIfNumberIsInRow(row, numberToBeAdded)  &&  !checkIfNumberIsInColumn(column, numberToBeAdded)  &&  !checkIfNumberIsInTheBox(row, column, numberToBeAdded);
    }

    private boolean checkIfNumberIsInTheBox(int row, int column, int numberToBeAdded) {
        int firstRow = row - row % 3;
        int firstColumn = column - column % 3;

        for (int i = firstRow; i < firstRow + 3; i++)
            for (int j = firstColumn; j < firstColumn + 3; j++)
                if (sudokuGrid[i][j] == numberToBeAdded)
                    return true;
        return false;
    }

    private boolean checkIfNumberIsInRow(int row, int numberToBeAdded) {
        for (int i = 0; i < 9; i++)
            if (sudokuGrid[row][i] == numberToBeAdded)
                return true;
        return false;
    }

    private boolean checkIfNumberIsInColumn(int column, int numberToBeAdded) {
        for (int i = 0; i < 9; i++)
            if (sudokuGrid[i][column] == numberToBeAdded)
                return true;
        return false;
    }

    public void showSudoku() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(" " + sudokuGrid[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}