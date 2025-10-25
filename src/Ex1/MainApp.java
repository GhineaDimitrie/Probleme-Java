package Ex1;

import java.util.Scanner;

public class MainApp

    {
        public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("Introduceti latimea:");
            int latime=sc.nextInt();
            System.out.println("Introduceti lungimea:");
            int lungime=sc.nextInt();





            int perimetru=2*(latime+lungime);
            int aria=lungime*latime;

            System.out.println("Perimetru:"+perimetru);
            System.out.println("Aria:"+aria);

        }
    }


