package Ex2;

import java.io.*;

public class MainApp
{
    public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new FileReader("src/Ex2/cantec_in.txt"));//initializez buffer
            PrintWriter pw = new PrintWriter(new FileWriter("cantec_out.txt"));//initializez printer
            String linie=br.readLine();//citesc prima linie

         while(linie!=null)
         {
                String [] cuvinte=linie.trim().split("\\s+");//extrag cuvintele din linie cu trim +split
                int nrCuvinte=linie.trim().isEmpty()?0:cuvinte.length;//calculez nr Cuvinte
                int nrVocale=0;//initializez nrVocale
                String vocale = "aeiouăâîAEIOUĂÂÎ";//string care stocheaza toate vocalele

                for (char c : linie.toCharArray())//verific caracter cu caracter daca e vocala
                {
                     if (vocale.indexOf(c) != -1)
                     {
                         nrVocale++;
                     }

                }

                pw.println(linie + " | cuvinte=" + nrCuvinte + " | vocale=" + nrVocale);//scriu in fiser

                linie=br.readLine();//trec la urmatoarea linie

         }






    }
}
