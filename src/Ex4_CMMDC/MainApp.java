package Ex4_CMMDC;

import java.util.Random;

public class MainApp
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        int x=rand.nextInt(30)+1;
        int y=rand.nextInt(30)+1;

        System.out.println("x:"+x);
        System.out.println("y:"+y);

        int a=x;
        int b=y;
        while(b!=0)
        {
            int r=a%b;
            a=b;
            b=r;
        }
        System.out.println("CMMDC:"+a);

        int cmmdc=a;
        int cmmmc=(x*y)/cmmdc;
        System.out.println("CMMMC:"+cmmmc);


    }
}
