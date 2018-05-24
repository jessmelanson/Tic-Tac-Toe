// TicTacToeBoard.java

/**
 * This program was written as an assignment for Intro to Computer Science with
 * Java I through Harvard Extension School. It's used in TicTacToe.java.
 *
 * @author      Jessica Melanson
 * @version     Last modified 12_13_17
 **/

import java.util.Arrays;

public class TicTacToeBoard
{
    private char[][] board;

    /**
     * This constructor method creates an 3 by 3 char array, then fills all
     * elements of the 3 by 3 array with spaces to emulate an empty tic tac toe
     * board.
     **/
    public TicTacToeBoard()
    {
        board = new char[3][3];
        for (int i = 0; i < board.length; i++)
        {
            Arrays.fill(board[i], ' ');
        }
    }

    /**
     * This getter method returns the char value of a square at a specific row
     * and column.
     *
     * @param   row     Int index of row of square to get contents of
     * @param   col     Int index of col of square to get contents of
     * @return          Char of current mark at specific position on board
     **/
    public char getSquare(int row, int col)
    {
        return board[row-1][col-1];
    }

    /**
     * This getter method returns the contents of a specific row on the board.
     *
     * @param   row     Int index of row in array to get
     * @return          Array of chars referring to specific row of board
     **/
    public char[] getRow(int row)
    {
        return board[row-1];
    }

    /**
     * This getter method returns the contents of a specific column on the
     * board.
     *
     * @param   col     Int index of column in array to get
     * @return          Array of chars referring to specific column of board
     **/
    public char[] getColumn(int col)
    {
        char[] column = { board[0][col-1], board[1][col-1], board[2][col-1] };
        return column;
    }

    /**
     * This setter method allows a user to mark a specific position within the
     * 3 by 3 character array with either an X or an O.
     *
     * @param   row     Int index of which row to mark
     * @param   col     Int index of which column to mark
     * @param   marker  Char input of X or O to mark a space
     * @return          Boolean of if square successfully set or not
     **/
    public void setSquare(int row, int col, char marker)
    {
        board[row-1][col-1] = marker;
    }

    /**
     * This method creates an empty String and then iterates through nested for
     * loops to produce a copy of what the current tic tac toe board looks
     * like. The inner loop iterates through the columns within a specific row,
     * and the outer loop iterates through each of the rows.
     *
     * @return      String of what tic tac toe board currently looks like
     **/
    public String toString()
    {
        String boardDisplay = "\nGame board:\n";

        for (int i = 0; i < board.length; i++)
        {
            boardDisplay += "| ";
            for (int j = 0; j < board[i].length; j++)
            {
                boardDisplay += board[i][j] + " ";
            }
            boardDisplay += "|\n";
        }
        return boardDisplay;
    }
}