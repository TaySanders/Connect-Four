import java.util.Scanner;

public class ConnectFour {
    public static void main(String[] args) {

        // variables
        // i hope this works
        Scanner scanner = new Scanner(System.in);
        int turn = 0;
        int userColumn;
        int userColumn2;
        int insertRow;

        //  user choice for height and length of board
        System.out.println("What would you like the height of the board to be? ");
        int heightChoice = scanner.nextInt();
        System.out.println("What would you like the length of the board to be? ");
        int lengthChoice = scanner.nextInt();

        // print and initialize empty board
        char[][] board = new char[heightChoice][lengthChoice];
        initializeBoard(board);
        printBoard(board);

        // assign players
        System.out.println("Player 1: x ");
        System.out.println("Player 2: o ");


        while (true) {
            // player 1 turn
            System.out.print("Player 1: Which column would you like to choose? ");
            userColumn = scanner.nextInt();
            turn++;

            // add chip to chosen column
            insertRow = insertChip(board, userColumn, 'x');
            printBoard(board);

            // player 1 wins
            if (checkIfWinner(board, userColumn, insertRow, 'x')) {
                System.out.println("Player 1 won the game!");
                break;
            }
            // tie
            if (turn == heightChoice * lengthChoice) {
                System.out.println("Draw. Nobody wins.");
                break;
            }
            // player 2 turn
            System.out.print("Player 2: Which column would you like to choose? ");
            userColumn2 = scanner.nextInt();
            turn++;

            // add chip to chosen column
            insertRow = insertChip(board, userColumn2, 'o');
            printBoard(board);

            // player 2 wins
            if (checkIfWinner(board, userColumn2, insertRow, 'o')) {
                System.out.println("Player 2 won the game!");
                turn++;
                break;
            }
            // tie
            if (turn == heightChoice * lengthChoice) {
                System.out.println("Draw. Nobody wins.");
                break;
            }
        }
    }

    // print board
    public static void printBoard(char[][] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }

    }

    // set each spot in the array to “-”.
    public static void initializeBoard(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = '-';
            }
        }

    }

    // places the token in the column that the user has chosen.
    public static int insertChip(char[][] array, int col, char chipType) {
        for (int i = 0; i < array.length; i++) {
            if (array[i][col] == '-') {
                array[i][col] = chipType;
                return i;
            }
        }
        return -1;
    }

    // after a token is added, if creates four in a row
    // Will return true if someone won, and false otherwise
    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType) {
        boolean gameOver = false;
        int check = 0;
        // checks in columns for four in a line
        for (int i = 0; i < array.length; i++) {
            if (array[i][col] == chipType) {
                check++;
                if (check == 4) {
                    gameOver = true;
                }
            } else {
                check = 0;
            }
        }
        //  checks in rows for four in a line
        for (int i = 0; i < array[0].length; i++) {
            if (array[row][i] == chipType) {
                check++;
                if (check == 4) {
                    gameOver = true;
                }
            }
            else {
                check = 0;
            }
        }
        return gameOver;
    }
}
