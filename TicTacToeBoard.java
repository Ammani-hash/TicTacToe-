public class TicTacToeBoard {
   //protected means that any subclass of these classes can use any of the variables in these
   //classes but no other class can
   protected char[][] board;
   protected int marked;

   public TicTacToeBoard() {
      board = new char[3][3]; //row, cols
      marked = 0;
      // TODO: Generate {{'1','2','3'}, {'4','5','6'}, {'7','8','9'}};

      
      for(int r = 0; r < 3; r++) {
         for(int c = 0; c < 3; c++) {
            board[r][c] = ("" + ((r * 3) + c + 1)).charAt(0);
         }
      }
   }
   
   //mark the selected spot with the character
   public boolean mark(int spot, char player) {
      char cSpot = (char)(48 + spot); //ASCII 49 = '1'
      
      //counts number of rows
      for(int r = 0; r < board.length; r++) {
         //counts number of columns
         for(int c = 0; board[r].length < 3; c++) {
            if(board[r][c] == cSpot) {
               board[r][c] = player;
               marked++;
               return true;
            }
         }
      }
      return false;
   }

   public boolean isFull() {
      return marked == board.length * board[0].length;
      
   }

   public boolean checkWinner() {
             //rows
      return (board[0][0] == board[0][1] && board[0][1] == board[0][2]) || 
             (board[1][0] == board[1][1] && board[1][1] == board[1][2]) ||
             (board[2][0] == board[2][1] && board[2][1] == board[2][2]) ||
             //cols
             (board[0][0] == board[1][0] && board[1][0] == board[2][0]) ||
             (board[0][1] == board[1][1] && board[1][1] == board[2][1]) ||
             (board[0][2] == board[1][2] && board[1][2] == board[2][2]) ||
             //diagonals
             (board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
             (board[2][0] == board[1][1] && board[1][1] == board[0][2]);
   }

   public boolean isGameOver() {
      return isFull() || checkWinner();
   }

   public String toString() {
      return board[0][0] + " | " + board[0][1] + " | " + board[0][2] + "\n" +
             board[1][0] + " | " + board[1][1] + " | " + board[1][2] + "\n" +
             board[1][0] + " | " + board[2][1] + " | " + board[2][2] + "\n" ;
      
	}

}
