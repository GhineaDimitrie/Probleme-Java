package Ex1;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainApp
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new FileReader("src/Ex1/judete_in.txt"));
        ArrayList<String> judete=new ArrayList<>();
        String linie=br.readLine();
        while(linie!=null)
        {
            judete.add(linie.trim());
            linie=br.readLine();
        }
        br.close();

        String[] arr= judete.toArray(new String[0]); //face conversia de la lista de array la array de string
        Arrays.sort(arr,String.CASE_INSENSITIVE_ORDER);//sortare alfabetica

        Scanner sc=new Scanner(System.in);
        System.out.println("Introduceti un judet:");
        String target=sc.nextLine().trim();

        int index=Arrays.binarySearch(arr,target,String.CASE_INSENSITIVE_ORDER);

        if(index>=0)
        {
            System.out.println("Judetul a fost gasit pe pozitia:"+index);//pozitia din array

        } else
            System.out.println("Judetul nu exista in fisier!");






    }
}
