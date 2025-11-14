import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class Loader
{
    private Loader() {}

    public static void fromFile(String path, List<Echipament> out) throws IOException {
        List<Echipament> echipamente=new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("src/electronice.txt"));


        String linie=br.readLine();
        int ln=0;
        while(linie!=null)
        {
            ln++;
            linie=linie.trim();

        }

        String[] t=linie.split(";");

        String tip=t[0].toUpperCase();
        String den=t[1].toUpperCase();
        int nr_inv=Integer.parseInt(t[2]);
        ZonaMag zonaMag=ZonaMag.valueOf(t[3].toUpperCase());
        Stare stare=Stare.valueOf(t[4].toUpperCase());
        int pret=Integer.parseInt(t[5]);

        switch(tip)
        {
            case "IMPRIMANTA":
                int ppm=Integer.parseInt(t[6]);
                int rezolutie=Integer.parseInt(t[7]);
                int p_car=Integer.parseInt(t[8]);
                ModTiparire modTiparire=ModTiparire.valueOf(t[9].toUpperCase());
                out.add(new Imprimante(den, nr_inv, pret,zonaMag,stare,ppm,rezolutie,p_car,modTiparire));

            case "COPIATOR":
                FormatCopiere formatCopiere=FormatCopiere.valueOf(t[6].toUpperCase());
                int p_ton=Integer.parseInt(t[7]);
                out.add(new Copiatoare(den,nr_inv,pret,zonaMag,stare,formatCopiere,p_ton));

            case "SISTEM":
                TipMonitor tipMonitor=TipMonitor.valueOf(t[6].toUpperCase());
                int vit_proc=Integer.parseInt(t[7]);
                int c_hdd=Integer.parseInt(t[8]);
                SistemOperare sistemOperare=SistemOperare.valueOf(t[9].toUpperCase());
                out.add(new SistemeCalc(den,nr_inv,pret,zonaMag,stare,tipMonitor,vit_proc,c_hdd,sistemOperare));


            default: throw new IllegalArgumentException("Linia"+ln+"Tip necunoscut"+tip+"'");
        }


    }










}
