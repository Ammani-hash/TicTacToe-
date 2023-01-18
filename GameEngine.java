import java.util.Scanner;

public class GameEngine {
   public static final char PLAYER_1 = 'r';
   public static final char PLAYER_2 = 'B';

   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      TicTacToeBoard board = new Connect4Board();
      boolean isP1 = false;

      do {
      //inverts the player
         isP1 = !isP1;
         System.out.println(board);
         playerTurn(console, board, isP1);
      } while( !board.isGameOver() );

      System.out.println();
      System.out.println("Good game!");
      System.out.println(board);
	}

	public static void playerTurn(Scanner console, TicTacToeBoard b, boolean isP1) {
		//set player to the person's turn
      //Terinary operateor (short if statement)
		char player = isP1 ? PLAYER_1 : PLAYER_2;

		//ask the user for the spot they want
		System.out.print("\nPlayer " + player + ", where would you like to go? > ");
		int spot = console.nextInt();

		//set that spot to the player's letter (char player)
      b.mark(spot, player);
	}

}
