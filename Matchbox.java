// TODO: Add documentation
// A representation of a matchbox within Menace
// Pairs a given state of the board with th epossible moves, 
// and learns which moves are better through a training process.

import java.util.ArrayList;
import java.util.Random;
import java.util.Optional;

class Matchbox {
   final TicTacToe board;
   static Random rand = new Random();
   ArrayList<int[]> box = new ArrayList<int[]>();
   Optional<int[]> active;
   
   public Matchbox(TicTacToe board) {
      this.board = board;
      active = Optional.empty();
      box.addAll(board.remaining());
      box.addAll(board.remaining());
      box.addAll(board.remaining());
   }
   
   public Optional<int[]> pickPlay() {
      // pick a choice without training this matchbox 
      if (box.isEmpty()) {
         return Optional.empty();
      }
      return Optional.of(box.get(rand.nextInt(box.size())));
   }
   
   public Optional<int[]> pick() {
      if (active.isPresent()) {
         return active;
      }
      if (box.isEmpty()) {
         return Optional.empty();
      }
      int[] choice = box.get(rand.nextInt(box.size()));
      active = Optional.of(choice);
      return active;
   }
   
   public void win() {
      if (active.isPresent()) {
         int[] choice = active.get();
         box.add(choice);
         box.add(choice);
         box.add(choice);
         active = Optional.empty();
      }
   }
   
   public void lose() {
      active = Optional.empty();
   }
   
   public void draw() {
      if (active.isPresent()) {
         int[] choice = active.get();
         box.add(choice);
         active = Optional.empty();
      }
   }
}