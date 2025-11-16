import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainApp {


    public static void main(String[] args) throws IOException {
        List<Echipament> echipamente = new ArrayList<Echipament>();
        citire_fisier(echipamente);
        System.out.println("Citire fisier realizata cu succes!");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            {
                System.out.println("\n1. Afisarea imprimantelor");
                System.out.println("2. Afisarea copiatoarelor");
                System.out.println("3. Afisarea sistemelor de calcul");
                System.out.println("4. Modificarea starii in care se afla un echipament");
                System.out.println("5. Setarea unui anumit mod de scriere pentru o imprimanta");
                System.out.println("6. Setarea unui format de copiere pentru copiatoare");
                System.out.println("7. Instalarea unui anumit sistem de operare pe un sistem de calcul");
                System.out.println("8. Afisarea echipamentelor vandute");
                System.out.println("9. Serializare");
                System.out.println("0. Iesire");

                System.out.println("Optiunea dvs. este:");

                String opt = br.readLine();
                switch (Integer.parseInt(opt)) {
                    case 1:
                        echipamente
                                .stream()
                                .filter(Imprimante.class::isInstance)
                                .map(Imprimante.class::cast)
                                .forEach(System.out::println);
                        break;
                    case 2:
                        echipamente
                                .stream()
                                .filter(Copiatoare.class::isInstance)
                                .map(Copiatoare.class::cast)
                                .forEach(System.out::println);
                        break;
                    case 3:
                        echipamente
                                .stream()
                                .filter(SistemeCalc.class::isInstance)
                                .map(SistemeCalc.class::cast)
                                .forEach(System.out::println);
                        break;
                    case 4:
                        System.out.println("Dati numele echipamentului caruia doriti sa ii schimbati starea:");
                        String nume = br.readLine();

                        System.out.println("Dati noua stare (achizitionat / expus / vandut):");
                        String stareNoua = br.readLine();

                        for (Echipament e : echipamente) {
                            if (e.getDenumire().equalsIgnoreCase(nume.trim())) {
                                e.setStare(Stare.valueOf((stareNoua).trim()));
                                System.out.println(e.toString());
                            }
                        }
                        break;

                    case 5:
                        System.out.println("Dati numele imprimantei");
                        String numeImprimanta = br.readLine();
                        System.out.println("Setati modul de scriere");
                        String modulScriere = br.readLine();
                        ModTiparire noulModTiparire = ModTiparire.valueOf(modulScriere);
                        for (Echipament e : echipamente) {
                            if (e instanceof Imprimante) {
                                e.getDenumire().equals(numeImprimanta.trim());
                                ((Imprimante) e).setTiparire(noulModTiparire);
                                System.out.println(e.toString());

                            }
                        }
                        break;
                    case 6:
                        System.out.println("Dati numele copiatorului");
                        String numeCopiatorului = br.readLine();
                        System.out.println("Selectati formatul:");
                        String formatNou = br.readLine();
                        FormatCopiere nouFormatCopiere = FormatCopiere.valueOf(formatNou);

                        for (Echipament e : echipamente) {
                            if (e instanceof Copiatoare) {
                                e.getDenumire().equals(numeCopiatorului.trim());
                                ((Copiatoare) e).setFormat(nouFormatCopiere);
                                System.out.println(e.toString());

                            }
                        }
                        break;

                    case 7:
                        System.out.println("Dati numele sistemului");
                        String numeSistem = br.readLine();
                        System.out.println("Selectati sistemul:");
                        String sistemNou = br.readLine();
                        SistemOperare nouSis = SistemOperare.valueOf(sistemNou);

                        for (Echipament e : echipamente) {
                            if (e instanceof SistemeCalc) {
                                e.getDenumire().equals(numeSistem.trim());
                                ((SistemeCalc) e).setSistemOperare(nouSis);
                                System.out.println(e.toString());

                            }
                        }
                        break;

                    case 8:
                        for (Echipament e : echipamente) {
                            if (e.getStare().equals(Stare.vandut))
                                System.out.println(e.toString());
                        }
                    case 9:
                        scriere(echipamente, "echip.bin");
                        List<Echipament> q;
                        q = (List<Echipament>) citeste("echip.bin");
                        for (Echipament e : q)
                            System.out.println(e);


                    case 0:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Optiunea dvs. este gresita!");
                        break;


                }


            }
        } while (true);


    }


    public static void citire_fisier(List<Echipament> echipamente) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\hatzz\\IdeaProjects\\Lab4\\src\\electronice.txt"));
        String linie = br.readLine();
        while (linie != null) {
            String[] parti = linie.split(";");
            if (parti[5].equals("imprimanta")) {
                echipamente.add(new Imprimante(
                        parti[0], Integer.parseInt(parti[1]), Integer.parseInt(parti[2]),
                        ZonaMag.valueOf(parti[3]), Stare.valueOf(parti[4]),
                        Integer.parseInt(parti[6]), parti[7], Integer.parseInt(parti[8]), ModTiparire.valueOf(parti[9].trim())));

            } else if (parti[5].equals("copiator")) {
                echipamente.add(new Copiatoare(parti[0], Integer.parseInt(parti[1]), Integer.parseInt(parti[2]),
                        ZonaMag.valueOf(parti[3]), Stare.valueOf(parti[4]), FormatCopiere.valueOf(parti[7]),
                        Integer.parseInt(parti[6])));

            } else if (parti[5].equals("sistem de calcul")) {
                echipamente.add(new SistemeCalc(parti[0], Integer.parseInt(parti[1]), Integer.parseInt(parti[2]),
                        ZonaMag.valueOf(parti[3]), Stare.valueOf(parti[4]), TipMonitor.valueOf(parti[6]),
                        Double.parseDouble(parti[7]), Integer.parseInt(parti[8]), SistemOperare.valueOf(parti[9])));

            }

            linie = br.readLine();

        }
        br.close();
    }


    static void scriere(Object o, String echip) {
        try {
            FileOutputStream f = new FileOutputStream(echip);
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(o);
            oos.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    static Object citeste(String echip) {
        try {
            FileInputStream f = new FileInputStream(echip);
            ObjectInputStream ois = new ObjectInputStream(f);
            Object o = ois.readObject();
            ois.close();
            f.close();
            return o;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
