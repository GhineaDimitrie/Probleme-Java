package ex2;

import java.io.*;


public class MainApp
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader br = new BufferedReader(new FileReader("src/ex2/in.txt"));

        String linie =br.readLine();
            int suma=0;
            int count=0;
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;

            while(linie!=null)
            {
                int x =Integer.parseInt(linie.trim());
                suma+=x;
                count++;
                if(x<min) min=x;
                if(x>max) max=x;
                linie=br.readLine();
            }

            double media= (double) suma /count;

            System.out.println("Suma: "+suma);
            System.out.println("Min: "+min);
            System.out.println("Max: "+max);
            System.out.println("Media: "+media);



        PrintWriter pw= new PrintWriter(new FileWriter("src/ex2/out.txt"));


            pw.println("Suma: "+suma);
            pw.println("Min: "+min);
            pw.println("Max: "+max);
            pw.println("Media: "+media);

            pw.close();







    }
}
