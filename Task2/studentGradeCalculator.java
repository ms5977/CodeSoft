package Task2;

import java.util.Scanner;

public class studentGradeCalculator 
{
    public static void main(String[] args) 
    {
        Scanner in=new Scanner(System.in);
        int totalMarks=0;
        float percentage;
        int arr[]=new int[5];
        int totalSubject=arr.length;
        
        System.out.println("Enter The Marks of Your Five Subjects");
        for(int i=0;i<arr.length;i++)
        {
            System.out.println("Subject:"+(i+1));
            arr[i]=in.nextInt();
            totalMarks=totalMarks+arr[i];
        }
        percentage=totalMarks/totalSubject;
        System.out.println("Your Total Marks is:"+totalMarks);
        System.out.println("Your Percentage is:"+percentage);

        if(percentage>90)
        {
            System.out.println("Congratulation You Passed your Exam with A+ Grade");
        }
        else if(percentage>80)
        {
            System.out.println("Congratulation You Passed your Exam with A Grade");
        }
        else if(percentage>70)
        {
            System.out.println("Congratulation You Passed your Exam with B+ Grade");
        }
        else if(percentage>60)
        {
            System.out.println("Congratulation You Passed your Exam with B Grade");
        }
        else if(percentage>50)
        {
            System.out.println("Congratulation You Passed your Exam with C+ Grade");
        }
        else if(percentage >40)
        {
            System.out.println("Congratulation You Passed your Exam with C Grade");
        }
        else
        {
            System.out.println("Sorry!you have failed in the exam");
        }

    }

}
