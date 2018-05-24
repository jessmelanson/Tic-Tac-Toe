// TicTacToe.java

/**
 * This program was written as an assignment for Intro to Computer Science with
 * Java I through Harvard Extension School. It also imports TicTacToeBoard.java.
 *
 * @author      Jessica Melanson
 * @version     Last modified 12_13_17
 **/

import java.util.Scanner;
import java.util.Arrays;

public class TicTacToe
{
    public static void main(String[] args)
    {
        playGame();
    }

    /**
     * This method runs the gameplay. It creates a new TicTacToeBoard and gets
     * player names. Then it runs gameplay with a while loop, using conditional
     * logic to switch current player each iteration. Within that loop is a do
     * while loop that executes until the player enters two ints between 1 and
     * 3, the column and row coordinates used to mark a square on the board. At
     * the end of each iteration, it checks if there are no open spaces and, if
     * so, ends the loop and declares a tie. Else it checks if the contents of
     * any row, column, or diagonal is identical, and if so, breaks the loop
     * and declares a winner.
     **/
    public static void playGame()
    {
        TicTacToeBoard gameBoard = new TicTacToeBoard();

        Scanner input = new Scanner(System.in);
        System.out.print("Welcome! Tic-Tac-Toe is a two player game."
                            + "\nEnter player one's name: ");
        String player1 = input.nextLine();
        System.out.print("Enter player two's name: ");
        String player2 = input.nextLine();
        System.out.println("\nPlayers take turns marking a square. Only "
            + "squares not already marked can be picked. Once a player has "
            +"marked three squares in a row, he or she wins! If all squares "
            + "are marked and no three squares are the same, a tied game is "
            + "declared. Have Fun!");

        boolean gameOver = false;
        boolean player1sTurn = true;
        char playerMarker = ' ';
        int openSpaces = 9;
        System.out.println(gameBoard.toString());

        while (!gameOver)
        {
            if (player1sTurn) {
                System.out.println("It is " + player1 + "\'s turn.");
                player1sTurn = false;
                playerMarker = 'X';
            } else {
                System.out.println("It is " + player2 + "\'s turn.");
                player1sTurn = true;
                playerMarker = 'O';
            }

            int row = 0;
            int col = 0;
            boolean validInput = false;

            do
            {
                System.out.print("Pick a row between 1 and 3: ");
                row = input.nextInt();
                System.out.print("Pick a column between 1 and 3: ");
                col = input.nextInt();

                if (row < 1 || row > 3 || col < 1 || col > 3
                    || gameBoard.getSquare(row, col) != ' ') {
                        System.out.println("ILLEGAL CHOICE! TRY AGAIN...");
                } else {
                    gameBoard.setSquare(row, col, playerMarker);
                    validInput = true;
                }
            }
            while (!validInput);

            System.out.println(gameBoard.toString());

            openSpaces--;
            if (openSpaces == 0) {
                System.out.println("Game Over - TIE.");
                gameOver = true;
            } else {
                gameOver = checkIfWinner(gameBoard);
            }
        }

        if (playerMarker == 'X') {
            System.out.println("Game Over - " + player1 + " WINS!!!");
        } else if (gameOver && playerMarker == 'O') {
            System.out.println("Game Over - " + player2 + " WINS!!!");
        }
    }

    /**
     * This method iterates over the rows and columns of the game board to
     * check if all the values in the row/column are identical. If so, it sets
     * the boolean value playerWon to true. If not, then it checks if all the
     * values in the two diagonals of the board are the same, and if so, sets
     * playerWon to true. It then returns the playerWon value.
     *
     * @param   board   TicTacToeBoard that's currently being played on
     * @return          Boolean value of if one of the players won
     **/
    public static boolean checkIfWinner(TicTacToeBoard board)
    {
        boolean playerWon = false;
        char[] rowContents = new char[3];
        char[] colContents = new char[3];

        for (int i = 1; i < rowContents.length; i++)
        {
            rowContents = board.getRow(i);
            colContents = board.getColumn(i);

            if (rowContents[0] != ' ' && rowContents[0] == rowContents[1]
                && rowContents[1] == rowContents[2]) {
                    playerWon = true;
            } else if (colContents[0] != ' ' && colContents[0] == colContents[1]
                && colContents[1] == colContents[2]) {
                    playerWon = true;
            }
        }

        if (board.getSquare(1,1) != ' ' && board.getSquare(1, 1)
            == board.getSquare(2, 2) && board.getSquare(2, 2)
            == board.getSquare(3, 3) ) {
                playerWon = true;
        } else if (board.getSquare(1, 3) != ' ' && board.getSquare(1, 3)
            == board.getSquare(2, 2) && board.getSquare(2, 2)
            == board.getSquare(3, 1) ) {
                playerWon = true;
        }

        return playerWon;
    }
}