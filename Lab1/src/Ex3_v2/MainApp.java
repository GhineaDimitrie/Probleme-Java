package Ex3_v2;

import java.util.Scanner;

public class MainApp
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a number:");
        int n = sc.nextInt();
        
        for(int i=2;i*i<=n;i++)
        {
            if(n%i==0)
                {

                    System.out.println("The number "+n+" is not prime");
                    break;
                }
            else
            {

                System.out.println(n+" is prime");
            }
        }
    }
}
