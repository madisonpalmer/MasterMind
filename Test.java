import java.util.Scanner;
import java.util.Random;
public class Test
{
   public static void main(String [] args) 
   {
      final int CODE_LENGTH = 4; 
      final int NUM_COLORS = 6;
      
      int white = 3;  //right color wrong spot
      int red = 0; //right color right spot
   
      //initial guess
      int[] guess = new int[CODE_LENGTH];
      guess[0] = 1;
      guess[1] = 2;
      guess[2] = 6;
      guess[3] = 4;
      
      generate_guess(white, red, guess);
      
   }   
   
   //this function generates the next guess based off results of previous guess
   public static void generate_guess(int white, int red, int[] guess){
      final int CODE_LENGTH = 4; 
      final int NUM_COLORS = 6;
      
      //print out previous guess for testing purposes
      System.out.println("previous guess: ");
      for (int i = 0; i < guess.length; i++)
      {
          System.out.println(guess[i]);
      }
      
      //no correct colors
      //generate random guess  
      if ((white == 0) && (red == 0)){
         for(int i = 0; i < guess.length; i++)
         {
              Random rand = new Random();
              int color = rand.nextInt(NUM_COLORS) + 1; //rand num between 1 and 6
              guess[i] = color;
         }
      }
      
      //one color correect and in right spot
      if ((white == 0) && (red == 1)){
         Random rand = new Random();
         
         //pick one color to stay in spot
         int index = rand.nextInt(CODE_LENGTH);
         System.out.println("Index to stay: " + index);
         
         //pick three spots in array to put different colors
         //but they cannot = the color that was chosen to stay
         int a = rand.nextInt(CODE_LENGTH);;
         int b = rand.nextInt(CODE_LENGTH);;
         int c = rand.nextInt(CODE_LENGTH);;
         while ((a==b) || (a==c) || (b==c) || (a==index) || (b== index) || (c==index)){
            //System.out.println("*******");
            a = rand.nextInt(CODE_LENGTH);
            //System.out.println("a = " + a);
            b = rand.nextInt(CODE_LENGTH);
            //System.out.println("b = " + b);
            c = rand.nextInt(CODE_LENGTH);
            //System.out.println("c = " + c);
            //System.out.println("*******");
         } 
         
         //put random colors at the indexes chosen above
         guess[a] = rand.nextInt(NUM_COLORS) + 1;
         guess[b] = rand.nextInt(NUM_COLORS) + 1;
         guess[c] = rand.nextInt(NUM_COLORS) + 1;
         
      }
      
      //two colors correct and in right spot
      if ((white == 0) && (red == 2)){
         Random rand = new Random();
         //pick 2 colors to stay
         int index = rand.nextInt(CODE_LENGTH);
         int index2 = rand.nextInt(CODE_LENGTH);
         while (index==index2){
            index = rand.nextInt(CODE_LENGTH);
            index2 = rand.nextInt(CODE_LENGTH);
         }
         //System.out.println("Index1 to stay: " + index);
         //System.out.println("Index2 to stay: " + index2);
         
         //pick 2 random colors to place in the spots that are not occupied 
         int a = rand.nextInt(CODE_LENGTH);
         int b = rand.nextInt(CODE_LENGTH);
         while ((a==b) || (a==index)||(a==index2) || (b== index)||(b==index2)){
            //System.out.println("*******");
            a = rand.nextInt(CODE_LENGTH);
            //System.out.println("a = " + a);
            b = rand.nextInt(CODE_LENGTH);
            //System.out.println("b = " + b);
            //System.out.println("*******");
         } 
         //put 2 random colors in array
         guess[a] = rand.nextInt(NUM_COLORS) + 1;
         guess[b] = rand.nextInt(NUM_COLORS) + 1;
         
      }
      
      //3 colors correct and in right spot
      if ((white == 0) && (red == 3)){
         Random rand = new Random();
         //pick three colors to stay
         int index = rand.nextInt(CODE_LENGTH);
         int index2 = rand.nextInt(CODE_LENGTH);
         int index3 = rand.nextInt(CODE_LENGTH);
         while ((index==index2)||(index==index3)||(index2==index3)){
            index = rand.nextInt(CODE_LENGTH);
            index2 = rand.nextInt(CODE_LENGTH);
            index3 = rand.nextInt(CODE_LENGTH);
         }
         //System.out.println("Index1 to stay: " + index);
         //System.out.println("Index2 to stay: " + index2);
         //System.out.println("Index3 to stay: " + index3);
         
         //pick a random fourth color 
         int a=rand.nextInt(CODE_LENGTH);
         while ((a==index)||(a==index2) || (a== index3)){
            //System.out.println("*******");
            a = rand.nextInt(CODE_LENGTH);
            //System.out.println("a = " + a);            
            //System.out.println("*******");
         } 
         guess[a] = rand.nextInt(NUM_COLORS) + 1;
         
      }
      
      //Computer wins
      if ((white == 0) && (red == 4)){
         System.out.println("Computer wins");
      }
      
      //one color in wrong spot
      if ((white == 1) && (red == 0)){
         //pick color in worng spot and move to different spot
         Random rand = new Random();
         int index = rand.nextInt(CODE_LENGTH);
         int index2 = rand.nextInt(CODE_LENGTH);
         while (index == index2){
            index2 = rand.nextInt(CODE_LENGTH);
         } 
         //System.out.println("Color to keep: " + index);
         //System.out.println("Place to move it: " + index2);
         
         int r = guess[index];
         guess[index2] = r;
         
         // pick three random colors not in spot of index
         int a = rand.nextInt(CODE_LENGTH);
         int b = rand.nextInt(CODE_LENGTH);
         int c = rand.nextInt(CODE_LENGTH);
         while ((a==b)||(a==c)||(b==c)||(a==index2)||(b==index2)||(c == index2)){
            //System.out.println("*******");
            a = rand.nextInt(CODE_LENGTH);
            //System.out.println("a = " + a);
            b = rand.nextInt(CODE_LENGTH);
            //System.out.println("b = " + b);
            c = rand.nextInt(CODE_LENGTH);
            //System.out.println("c = " + c);
            //System.out.println("*******");

         } 
         guess[a] = rand.nextInt(NUM_COLORS) + 1;
         guess[b] = rand.nextInt(NUM_COLORS) + 1;
         guess[c] = rand.nextInt(NUM_COLORS) + 1;

      }
      
      //one color correct in right spot, one color correct in wrong spot
      if ((white == 1) && (red == 1)){
         Random rand = new Random();
         //pick color to stay
         int index = rand.nextInt(CODE_LENGTH);
         //System.out.println("Index to stay: " + index);
         //pick color to move
         int index2 = rand.nextInt(CODE_LENGTH);
         int index3 = rand.nextInt(CODE_LENGTH);
         while ((index2 == index3) || (index2 == index) || (index == index3)){
            index2 = rand.nextInt(CODE_LENGTH);
            index3 = rand.nextInt(CODE_LENGTH);
         } 
         //System.out.println("Color to keep: " + index2);
         //System.out.println("Place to move it: " + index3);
         
         //move color
         int r = guess[index2];
         guess[index3] = r;
         
         //pick two other random colors
         int a = rand.nextInt(CODE_LENGTH);
         int b = rand.nextInt(CODE_LENGTH);
         while ((a==b) || (a==index) || (a==index3)||(b== index) || (b==index3)){
            //System.out.println("*******");
            a = rand.nextInt(CODE_LENGTH);
            //System.out.println("a = " + a);
            b = rand.nextInt(CODE_LENGTH);
            //System.out.println("b = " + b);
            //System.out.println("*******");
         } 
         guess[a] = rand.nextInt(NUM_COLORS) + 1;
         guess[b] = rand.nextInt(NUM_COLORS) + 1;
         
      }
      
      //one color correct in wrong spot, 2 colors correct in right spot
      if ((white == 1) && (red == 2)){
         Random rand = new Random();
         //pick 2 colors to stay
         int index = rand.nextInt(CODE_LENGTH);
         int index2 = rand.nextInt(CODE_LENGTH);
         while (index == index2){
            index = rand.nextInt(CODE_LENGTH);
            index2 = rand.nextInt(CODE_LENGTH);
         }
         //System.out.println("Index to stay: " + index);
         //System.out.println("Index to stay: " + index2);
         
         //pick color to move
         int index3 = rand.nextInt(CODE_LENGTH);
         int index4 = rand.nextInt(CODE_LENGTH);
         while ((index3 == index4) || (index3 == index) || (index3 == index2) || (index4 == index) || (index4 == index2)){
            index3 = rand.nextInt(CODE_LENGTH);
            index4 = rand.nextInt(CODE_LENGTH);
         } 
         //System.out.println("Color to keep: " + index3);
         //System.out.println("Place to move it: " + index4);
         
         int r = guess[index3];
         guess[index4] = r;
         
         //pick random fourth color
         int a = rand.nextInt(CODE_LENGTH);
         while ((a==index) || (a==index2) || (a== index4)){
            //System.out.println("*******");
            a = rand.nextInt(CODE_LENGTH);
            //System.out.println("a = " + a);
            //System.out.println("*******");
         } 
         guess[a] = rand.nextInt(NUM_COLORS) + 1;
         
      }
      
      //this scenario cannot happen
      if ((white == 1) && (red == 3)){
                  
      }
      
      //two colors correct but in worng spots
      if ((white == 2) && (red == 0)){
         Random rand = new Random();
         //pick 1 color to move
         int index = rand.nextInt(CODE_LENGTH);
         int index2 = rand.nextInt(CODE_LENGTH);
         while (index == index2){
            index = rand.nextInt(CODE_LENGTH);
            index2 = rand.nextInt(CODE_LENGTH);
         } 
         //System.out.println("Color to keep: " + index);
         //System.out.println("Place to move it: " + index2);
         
         int r = guess[index];
         guess[index2] = r;
         
         //pick second color to move
         int index3 = rand.nextInt(CODE_LENGTH);
         int index4 = rand.nextInt(CODE_LENGTH);
         while ((index3==index) || (index3 == index4) || (index3==index2) || (index4 == index2)){
            index3 = rand.nextInt(CODE_LENGTH);
            index4 = rand.nextInt(CODE_LENGTH);
         } 
         //System.out.println("Color to keep: " + index3);
         //System.out.println("Place to move it: " + index4);
         
         int s = guess[index3];
         guess[index4] = s;
         
         //pick 2 other random colors
         int a = rand.nextInt(CODE_LENGTH);
         int b = rand.nextInt(CODE_LENGTH);
         while ((a==b) || (a==index2) || (a== index4)){
            //System.out.println("*******");
            a = rand.nextInt(CODE_LENGTH);
            //System.out.println("a = " + a);
            //System.out.println("*******");

         } 
         guess[a] = rand.nextInt(NUM_COLORS) + 1;

      }
      
      //two colors correct but in worng spots, 1 correct color in right spot
      if ((white == 2) && (red == 1)){
         //pick color to stay
         Random rand = new Random();
         int index5 = rand.nextInt(CODE_LENGTH);
         //System.out.println("Index to stay: " + index5);
         
         //pick 1 color to move
         int index = rand.nextInt(CODE_LENGTH);
         int index2 = rand.nextInt(CODE_LENGTH);
         while ((index == index2) || (index == index5) || (index2 == index5)){
            index = rand.nextInt(CODE_LENGTH);
            index2 = rand.nextInt(CODE_LENGTH);
         } 
         //System.out.println("Color to keep: " + index);
         //System.out.println("Place to move it: " + index2);
         
         int r = guess[index];
         guess[index2] = r;
         
         //pick second color to move
         int index3 = rand.nextInt(CODE_LENGTH);
         int index4 = rand.nextInt(CODE_LENGTH);
         while ((index3==index) || (index3 == index5) || (index3 == index4) || (index3==index2) || (index4 == index2) || (index4 == index5)){
            index3 = rand.nextInt(CODE_LENGTH);
            index4 = rand.nextInt(CODE_LENGTH);
         } 
         //System.out.println("Color to keep: " + index3);
         //System.out.println("Place to move it: " + index4);
         
         int s = guess[index3];
         guess[index4] = s;
         
         //pick random fourth color
         int a = rand.nextInt(CODE_LENGTH);
         while ((a==index2) || (a==index4) || (a== index5)){
            //System.out.println("*******");        
            a = rand.nextInt(CODE_LENGTH);
            //System.out.println("a = " + a);      
            //System.out.println("*******");
         } 
         guess[a] = rand.nextInt(NUM_COLORS) + 1;
      }
      
      //2 colors correct in worng spots, 2 colors correct in right spots
      if ((white == 2) && (red == 2)){
         //pick 2 colors to swap places
         Random rand = new Random();
         int a = rand.nextInt(CODE_LENGTH);
         int b = rand.nextInt(CODE_LENGTH);
         while (a==b){
            a = rand.nextInt(CODE_LENGTH);
            //System.out.println("a = " + a);
            b = rand.nextInt(CODE_LENGTH);
            //System.out.println("b = " + b);
         }
         //System.out.println("guess a: " + guess[a]);
         //System.out.println("guess b: " + guess[b]);
         
         //swap
         int r = guess[a];
         int s = guess[b];
         //System.out.println(r);
         //System.out.println(s);
         guess[a] = s;
         guess[b] = r;
      }
      
      //3 colors correct but in wrong spots
      if ((white == 3) && (red == 0)){
         //shuffle all colors in previous guess     
         Random rand = new Random();
         for (int i = guess.length - 1; i > 0; i--){
            int index = rand.nextInt(i + 1);
            int a = guess[index];
            guess[index] = guess[i];
            guess[i] = a;
          }
          
         //change one color randomly
         int a = rand.nextInt(CODE_LENGTH);
         guess[a] = rand.nextInt(NUM_COLORS) + 1;
  
      }
      
      //three colors correct but in wrong spots, 1 color correct in right spot
      if ((white == 3) && (red == 1)){
         Random rand = new Random();
         //rearrange colors from previous guess
          for (int i = guess.length - 1; i > 0; i--)
          {
            int index = rand.nextInt(i + 1);
            int a = guess[index];
            guess[index] = guess[i];
            guess[i] = a;
          }
         
      }
      
      //all correct colors but in wrong spots
      if ((white == 4) && (red == 0)){
         Random rand = new Random();
         //rearrange colors from previous guess
          for (int i = guess.length - 1; i > 0; i--)
          {
            int index = rand.nextInt(i + 1);
            int a = guess[index];
            guess[index] = guess[i];
            guess[i] = a;
          }
       }
      
      
      System.out.println("new guess: ");
      for (int i = 0; i < guess.length; i++)
      {
         System.out.println(guess[i]);
      }
      
   }

   
   
   
   
}