import java.util.Scanner;
import java.util.InputMismatchException;

public class UserPlayer extends Player<TicTacToe> {
   Scanner sc;
   public UserPlayer(char turn) {
      super(turn);
      this.sc = new Scanner(System.in);
   }
   
   public void play(TicTacToe game) {
      int in;
      int x, y;

      System.out.println("" + game);
      System.out.println("" + turn + "'s turn! Where do you want to play?");
      
      while (true) {
         System.out.print("\t> ");
         if (!sc.hasNext("[012]{2}")) {
            System.out.println("Please enter two integers, \"xy\".");
            sc.nextLine();
            continue;
         }
         in = sc.nextInt();
         x = in / 10;
         y = in % 10;
         if (!game.isEmpty(x, y)) {
            System.out.println("That spot is not empty.");
            continue;
         }
         game.play(x, y);
         break;
      }
   }
}
