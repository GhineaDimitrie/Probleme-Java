import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainApp
{
    public static void main(String[] args) throws IOException
    {
        List<Echipament>echipamente=new ArrayList<>();

        Loader.fromFile("electronice.txt",echipamente);

        int nI=0, nC=0, nS=0;

        for (Echipament e : echipamente)
        {
            if (e instanceof Imprimante) nI++;
            else if (e instanceof Copiatoare) nC++;
            else if (e instanceof SistemeCalc) nS++;
        }

        System.out.println("Total="+echipamente.size()+" | Imprimante=" + nI + " Copiatoare=" + nC + " Sisteme=" + nS);









    }

}
