
import java.util.Scanner;
import java.util.ArrayList;

/**
 * The TicTacToe class implements a game of Tic Tac Toe. 
 * @author Rushil Udani
 * @version 1.0
 */
public class TicTacToe {
   public static void main(String[] args) {
      playGame(new UserPlayer('X'), new UserPlayer('O'));
   }
   
   public static void playGame(Player p1, Player p2) {
      TicTacToe game = new TicTacToe();
      while (!game.isOver()) {
         while (game.turn == cross) {
            p1.play(game);
         }
         if (!game.isOver()) {
            while (game.turn == circle) {
               p2.play(game);
            }
         }
      }
      System.out.println("" + game);
      System.out.println("" + game.whoWon() + " Won!");
   }

   /**
    * The identifier for an empty tile, {@code '-'}.
    */
   public final static char empty = '-';
   /**
    * The identifier for a cross tile, {@code 'X'}.
    */
   public final static char cross = 'X';
   /** 
    * The identifier for a circle tile, {@code 'O'}.
    */
   public final static char circle = 'O';
   /**
    * The representation of the board.
    */
   public char[][] board;
   /**
    * Whose turn it is.
    */
   public char turn;
   
   /**
    * Class constructor that creates a default 3x3 TTT board.
    * Each tile begins empty, with the value of {@code empty}.
    */
   public TicTacToe() {
      this.board = new char[][] {{empty, empty, empty},
                                 {empty, empty, empty},
                                 {empty, empty, empty}};
      this.turn = cross;
   }
   
   /**
    * Resets the board to a 3x3 grid of empty tiles.
    */
   public void reset() {
      this.board = new char[][] {{empty, empty, empty},
                                {empty, empty, empty},
                                {empty, empty, empty}};
      this.turn = cross;
   }
   
   /**
    * Plays the next turn at the given position.
    * @param x The x position of the tile to play at.
    * @param y The y position of the tile to play at.
    * @return {@code true} if the player was able to play there, {@code false} otherwise.
    */
   public boolean play(int x, int y) {
      if ( !this.isEmpty(x, y) ) { 
         return false; }
      if ( this.turn == cross ) {
         this.board[x][y] = cross;
         this.turn = circle;
      } else if ( this.turn == circle ) {
         this.board[x][y] = circle;
         this.turn = cross;
      }
      return true;
   }
   
   /**
    * The positions of the remaining empty tiles.
    * @return An ArrayList of positions of tiles, as an {@code int[]} of length 2. 
    */
   public ArrayList<int[]> remaining() {
      ArrayList<int[]> rem = new ArrayList<>();
      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
            if (this.isEmpty(i, j)) { rem.add(new int[] {i, j}); }
         }
      }
      return rem;
   }
   
   /**
    * Returns whether the game is over or not. 
    * @return {@code true} if the game is over by any means, {@code false} otherwise.
    */
   public boolean isOver() {
      return this.crossWon() || this.circleWon() || this.full();
   }
   
   /**
    * Returns the person who won. 
    * @return The person who won, either {@code cross}, {@code circle}, or {@code empty}.
    */
   public char whoWon() {
      if (this.crossWon()) { 
         return cross; } 
      else
         if (this.circleWon()) { 
            return circle; } 
         else
            return empty;
   }
   
   /**
    * Returns whether the cross won.
    * @return {@code true} if the cross won, {@code false} otherwise.
    */
   public boolean crossWon() {
      return checkRows(cross) || checkCols(cross) || checkDiags(cross);
   }
      
   /**
    * Returns whether the circle won.
    * @return {@code true} if the circle won, {@code false} otherwise.
    */
   public boolean circleWon() {
      return checkRows(circle) || checkCols(circle) || checkDiags(circle);
   }
      
   /**
    * Returns whether the board is filled.
    * @return {@code true} if the board is full, {@code false} otherwise.
    */
   public boolean full() {
      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
            if (this.isEmpty(i, j)) { 
               return false; }
         }
      }
      return true;
   }
   
   /**
    * @param winner The player to check against. 
    * @return {@code true} if all the tiles in any row are the same as {@code winner}.
    */
   public boolean checkRows(char winner) {
      for (int i = 0; i < 3; i++) {
         if (winner == board[i][0] &&
             winner == board[i][1] &&
             winner == board[i][2]) {
            return true;
         } // If not, continue
      }
      return false;
   }
   
   /**
    * @param winner The player to check against. 
    * @return {@code true} if all the tiles in any column are the same as {@code winner}.
    */
   public boolean checkCols(char winner) {
      for (int i = 0; i < 3; i++) {
         if (winner == board[0][i] &&
             winner == board[1][i] &&
             winner == board[2][i]) {
            return true;
         } // If not, continue
      }
      return false;
   }
   
   /**
    * @param winner The player to check against. 
    * @return {@code true} if all the tiles in any diagonal are the same as {@code winner}.
    */
   public boolean checkDiags(char winner) {
      if (winner == board[0][0] &&
          winner == board[1][1] &&
          winner == board[2][2]) {
         return true;
      }
      if (winner == board[2][0] &&
          winner == board[1][1] &&
          winner == board[0][2]) {
         return true;
      }
      return false;
   }
   
   /**
    * @param x The x position of the tile to check.
    * @param y The y position of the tile to check.
    * @return {@code true} if the tile is empty, {@code false} otherwise.
    */
   public boolean isEmpty(int x, int y) {
      return this.board[x][y] == empty;
   }
   
   public String toString() {
      String str = "";
      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
            str += board[i][j];
         }
         str += "\n";
      }
      return str;
   }
}