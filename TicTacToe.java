import java.util.Scanner;

public class TicTacToe {
    static char[][] board = { {' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '} };
    
    public static void main(String[] args) {
        char currentPlayer = 'X';
        boolean gameWon = false;
        
        while (!gameWon && !isBoardFull()) {
            printBoard();
            playerMove(currentPlayer);
            gameWon = checkWinner(currentPlayer);
            if (!gameWon) {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
        printBoard();
        System.out.println(gameWon ? "Player " + currentPlayer + " wins!" : "It's a draw!");
    }

    static void printBoard() {
        for (char[] row : board) {
            System.out.println("| " + row[0] + " | " + row[1] + " | " + row[2] + " |");
        }
        System.out.println();
    }

    static void playerMove(char player) {
        Scanner sc = new Scanner(System.in);
        int row, col;
        do {
            System.out.print("Enter row (0-2) and column (0-2) for " + player + ": ");
            row = sc.nextInt();
            col = sc.nextInt();
        } while (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ');
        board[row][col] = player;
    }

    static boolean checkWinner(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    static boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') return false;
            }
        }
        return true;
    }
}