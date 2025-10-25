package Ex3_v1_Div_NrPrim;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a number:");
        int n = sc.nextInt();
        int count = 0;

        System.out.println("The Divisors of the number you entered are:");

        for (int i = 1; i <=n; i++)
        {
            if (n % i == 0)
            {
                System.out.println(i);
                count++;
            }
        }
        if (count == 2) System.out.println("The number is prime");


    }
}
