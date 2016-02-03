import java.util.Scanner;
import java.util.Random;
public class Test
{
   public static void main(String [] args) 
   {
      final int CODE_LENGTH = 4; 
      final int NUM_COLORS = 6;
      
      int white = 2;  //right color wrong spot
      int red = 2; //right color right spot
   
      //initial guess
      int[] guess = new int[CODE_LENGTH];
      guess[0] = 1;
      guess[1] = 2;
      guess[2] = 6;
      guess[3] = 4;
      for (int i = 0; i < guess.length; i++)
      {
          System.out.println(guess[i]);
      }
        
      if ((white == 0) && (red == 0)){
         for(int i = 0; i < guess.length; i++)
         {
              Random rand = new Random();
              int pickedNumber = rand.nextInt(NUM_COLORS) + 1; //rand num between 1 and 6
            
              guess[i] = pickedNumber;
         }
        }
        if ((white == 1) && (red == 3)){
            Random rand = new Random();
            //guess random spot either 0 index or 1 index
            guess[rand.nextInt(CODE_LENGTH)+1] = rand.nextInt(NUM_COLORS) + 1;
            
        
        }
        if ((white == 2) && (red == 2)){
        //guess random spot either 0 index or 1 index
            Random rand = new Random();
            int a=1;
            int b=1;
            while (a==b){
            
             a = rand.nextInt(4);
            System.out.println("a = " + a);
             b = rand.nextInt(4);
            System.out.println("b = " + b);
            }
            System.out.println("guess a: " + guess[a]);
            System.out.println("guess b: " + guess[b]);
            int r = guess[a];
            int s = guess[b];
            System.out.println(r);
            System.out.println(s);
            guess[a] = s;
            guess[b] = r;
        }
        
      
      System.out.println("length of array: " + guess.length);
      for (int i = 0; i < guess.length; i++)
      {
         System.out.println(guess[i]);
      }

   
   
   }
   
}