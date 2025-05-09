import java.util.Random;
import java.util.Scanner;

public class MineSweeper {

    private static char[][] visibleBoard;
    private static char[][] hiddenBoard;
    private static int boardSize;
    private static int bombCount;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playing = true;

        System.out.println("=== Welcome to Minesweeper! ===");

        while (playing) {
            setupGame(scanner);
            playGame(scanner);
            playing = askToPlayAgain(scanner);
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static void setupGame(Scanner scanner) {
        while (true) {
            System.out.print("Enter board size (1-10): ");
            boardSize = scanner.nextInt();
            System.out.print("Enter number of bombs (1-30): ");
            bombCount = scanner.nextInt();

            if (boardSize < 1 || boardSize > 10 || bombCount < 1 || bombCount > 30 || bombCount >= boardSize * boardSize) {
                System.out.println("Invalid input. Please try again.");
            } else {
                break;
            }
        }

        visibleBoard = new char[boardSize][boardSize];
        hiddenBoard = new char[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                visibleBoard[i][j] = 'x';
                hiddenBoard[i][j] = '0';
            }
        }

        placeBombs();
    }

    private static void placeBombs() {
        Random rand = new Random();
        int bombsPlaced = 0;

        while (bombsPlaced < bombCount) {
            int x = rand.nextInt(boardSize);
            int y = rand.nextInt(boardSize);

            if (hiddenBoard[x][y] != 'B') {
                hiddenBoard[x][y] = 'B';
                bombsPlaced++;
            }
        }
    }

    private static void playGame(Scanner scanner) {
        boolean gameOver = false;

        while (!gameOver) {
            printVisibleBoard();

            System.out.print("Enter X coordinate (0 to " + (boardSize - 1) + "): ");
            int x = scanner.nextInt();
            System.out.print("Enter Y coordinate (0 to " + (boardSize - 1) + "): ");
            int y = scanner.nextInt();

            if (x < 0 || x >= boardSize || y < 0 || y >= boardSize) {
                System.out.println("Invalid coordinates. Try again.");
                continue;
            }

            if (hiddenBoard[x][y] == 'B') {
                System.out.println("BOOM! You hit a bomb. Game Over.");
                revealAllBombs();
                printVisibleBoard();
                gameOver = true;
            } else {
                int adjacentBombs = countAdjacentBombs(x, y);
                visibleBoard[x][y] = (char) (adjacentBombs + '0');
                if (checkWin()) {
                    System.out.println("Congratulations! You cleared the board!");
                    printVisibleBoard();
                    gameOver = true;
                }
            }
        }
    }

    private static void printVisibleBoard() {
        System.out.println("\nVisible Board:");
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(visibleBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int countAdjacentBombs(int x, int y) {
        int count = 0;

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int newX = x + dx;
                int newY = y + dy;

                if (newX >= 0 && newX < boardSize && newY >= 0 && newY < boardSize) {
                    if (hiddenBoard[newX][newY] == 'B') {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static void revealAllBombs() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (hiddenBoard[i][j] == 'B') {
                    visibleBoard[i][j] = 'B';
                }
            }
        }
    }

    private static boolean checkWin() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (visibleBoard[i][j] == 'x' && hiddenBoard[i][j] != 'B') {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean askToPlayAgain(Scanner scanner) {
        System.out.print("Play again? (y/n): ");
        String answer = scanner.next();
        return answer.equalsIgnoreCase("y");
    }
}