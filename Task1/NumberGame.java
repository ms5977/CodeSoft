package Task1;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to the Number Game:");
        System.out.println(
                ".........................Rules of The Game.....................................................");
        System.out.println("1.You Have Only Three Chances to Win this Game.");
        System.out.println("2.For Every Correct Answer you get the points.");
        System.out.println("3.You Can Guess the Number Only from 0 to 100.");

        System.out.println( ".......................Lets Start the Game.......................................................");

        System.out.println();
        System.out.println();

        int points=0;
        System.out.println("Please Guess The Number:");
        for (int i = 0; i < 3; i++) 
        {
            // Instance of Random class
            Random rand = new Random();
            int number = rand.nextInt(101);// Genarate Number from 0 to 100
           
            int userNumber = in.nextInt();

            if (number == userNumber) 
            {
                points++;
                System.out.println("correct");
            } 
            else if (userNumber > number) 
            {
                System.out.println("too High");
            } 
            else 
            {
                System.out.println("too low");
            }
        }

        if(points>0)
        {
            System.out.println("Congratulation! You Get: "+points+" Point ");
        }
        else
        {
            System.out.println("Hard Luck! You Get:"+points+" Point ");
        }    

    }

}
