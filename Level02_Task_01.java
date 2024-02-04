import java.util.Scanner;

public class Level02_Task_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            playGame();
            System.out.print("Do you want to play again? (y/n): ");
        } while (scanner.next().equalsIgnoreCase("y"));

        System.out.println("Thanks for playing!");
    }

    private static void playGame() {
        char[][] board = {
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' }
        };

        char currentPlayer = '1';
        boolean gameWon = false;

        while (true) {
            displayBoard(board);
            int[] move = getPlayerMove(currentPlayer);

            if (isValidMove(board, move)) {
                board[move[0]][move[1]] = currentPlayer;
                gameWon = checkWin(board, currentPlayer);

                if (gameWon || isBoardFull(board)) {
                    displayBoard(board);
                    if (gameWon) {
                        System.out.println("Player " + currentPlayer + " wins!");
                    } else {
                        System.out.println("It's a draw!");
                    }
                    break;
                }

                currentPlayer = (currentPlayer == '1') ? '2' : '1';
            } else {
                System.out.println("Invalid move! Please try again.");
            }
        }
    }

    private static void displayBoard(char[][] board) {
        System.out.println("-------------");
        for (char[] row : board) {
            System.out.print("| ");
            for (char cell : row) {
                System.out.print(cell + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static int[] getPlayerMove(char player) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Player " + player + ", enter your move (row and column): ");
        int row = scanner.nextInt() - 1;
        int col = scanner.nextInt() - 1;
        return new int[] { row, col };
    }

    private static boolean isValidMove(char[][] board, int[] move) {
        int row = move[0];
        int col = move[1];
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    private static boolean checkWin(char[][] board, char player) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player) ||
                    (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                    (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isBoardFull(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
