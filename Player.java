public abstract class Player<G> {
   public final char turn;
   
   public Player(char turn) {
      this.turn = turn;
   }
   
   public abstract void play(G game);
}