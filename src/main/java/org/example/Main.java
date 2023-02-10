package org.example;
import java.util.Scanner;
import java.util.logging.Logger;
public class Main {

    static Scanner input = new Scanner(System.in);
    static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    static char player = 'O';
    public static void main(String[] args) {
        Logger l = Logger.getLogger("com.api.jar");

        int count=0;

        while (count!=9) {

            count++;
            l.info("Current board: ");
            printBoard();
            l.info("Player " + player + " turn. Enter row and column: ");
            int row = input.nextInt() - 1;
            int col = input.nextInt() - 1;
            if (!isValidMove(row, col)) {
                l.info("Invalid move. Try again.");
                continue;
            }
            board[row][col] = player;
            if (isWinningMove(row, col)) {
                l.info("Match Over \n Player " + player + " wins!");
                break;
            }

            player = (player == 'O') ? 'X' : 'O';
        }
        if(count==9){
            l.info("draw");
        }
        input.close();
    }
    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }
    static boolean isWinningMove(int row, int col) {
        return (board[0][col] == player && board[1][col] == player && board[2][col] == player) ||
                (board[row][0] == player && board[row][1] == player && board[row][2] == player) ||
                (row == col && board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (row + col == 2 && board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }
    static void printBoard() {
        Logger l = Logger.getLogger("com.api.jar");

        l.info("  1 2 3");
        for (int i = 0; i < 3; i++) {
            l.info(i + 1 + " ");
            for (int j = 0; j < 3; j++) {
                l.info(board[i][j] + " ");
            }
            l.info("\n");
        }
    }
}