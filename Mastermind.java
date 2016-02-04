import java.util.*;
public class Mastermind {

   public static void main (String[] args) {
    
        new Mastermind();
        
   }
    
   public Mastermind () {
      Scanner scanner = new Scanner(System.in);
      boolean validInput = false;
      int numRounds = 0;
      while (validInput == false) {
         System.out.print("Input number of rounds(1-10): ");
         numRounds = Integer.parseInt(scanner.nextLine());
         if (numRounds > 0 && numRounds < 11) {
            validInput = true;
         }
      }
      boolean playerFirst = false;
      validInput = false;
      while (validInput == false) {
         System.out.print("Input 0 for computer to go first or 1 for player to go first: ");
         int playerFirstNumber = Integer.parseInt(scanner.nextLine());
         if (playerFirstNumber == 0) {
            validInput = true;
            playerFirst = false;
         }
         if (playerFirstNumber == 1) {
            validInput = true;
            playerFirst = true;
         }
      }
      for (int i = 0; i < numRounds; i++) {
         if (playerFirst == true) {
            playerRound();
            computerRound();
         } else {
            computerRound();
            playerRound();
         }
      }
   }
   
   public void playerRound () {
      
   }
   
   public void computerRound () {
      
   }

}