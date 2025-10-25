package Ex5_Fibonacci;

import java.util.Random;

public class MainApp
{
    public static void main(String[] args)
    {
        Random rand=new Random();
        int x=rand.nextInt(21);
        System.out.println("Numar generat:"+x);

        if (esteFibonacci(x)) {
            System.out.println(x + " apartine sirului Fibonacci");
        } else {
            System.out.println(x + " NU apartine sirului Fibonacci");
        }



    }

    static boolean esteFibonacci(int x)
    {
        if(x==0||x==1)
            return true;

        int a=0;
        int b=1;
        int c=a+b;
        while(c<=x)
        {
            if(c==x) return true;

            a=b;
            b=c;
            c=a+b;
        }
        return false;

    }
}
