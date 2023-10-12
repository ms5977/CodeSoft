package Task3;

import java.util.Scanner;

class ATM
{
    int option;
    int deposite,withdraw,Balance;

    public ATM(int Balance)
    {
        this.Balance=Balance;
    }
    
    public void options(int option)
    {
        Scanner in=new Scanner(System.in);
        
        switch(option)
        {
            case 1:
            System.out.println("Your Current Balance is: "+Balance);
            break;
            
            case 2:
            System.out.println("Enter The Amount You want to Deposite:");
            deposite=in.nextInt();
            Balance=Balance+deposite;
            System.out.println("Congrats!Your Amount has been Successfully Deposited.");
            System.out.println("Your Deposite Amount is:"+deposite);
            System.out.println("Your Available Balance is:" +Balance);
            break;
           
            case 3:
            System.out.println("Enter The Amount you Want To Withdraw");
            withdraw=in.nextInt();
            if(withdraw<=Balance)
            {
                Balance=Balance-withdraw;
                System.out.println("You have successfully withdrawn your money");
                System.out.println("Your Withdrawing Amount is:"+withdraw);
                System.out.println("Your Remaining Balance is:"+Balance);
            }
            else
            {
                System.out.println("Insufficient Balance");
                System.out.println("Please Enter Correct Amount:");
            }
            break;
            case 4:
            System.exit(0);


        }
    
    }
}
public class AtmInterface {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ATM atm = new ATM(10000);

        System.out.println("...................Welcome To The HDFC ATM........................................");
        System.out.println();
        System.out.println();
        
        while (true) { // Continue until the user decides to exit
            System.out.println("Please Choose Your Service");
            System.out.println();
            System.out.println();

            System.out.println("For Check The Balance Press: 1");
            System.out.println("For Deposit Press: 2");
            System.out.println("For Withdrawing Money Press: 3");
            System.out.println("For Exit Press: 4");

            int opt = in.nextInt();
            atm.options(opt);

            // Ask the user if they want to continue
            System.out.println("Do you want to perform another transaction? (1 for Yes, 2 for No)");
            int continueOption = in.nextInt();
            if (continueOption != 1) {
                System.out.println("Thankyou for Using HDFC ATM Service");
                break; // Exit the loop if the user chooses not to continue
            }
        }
    }
}
