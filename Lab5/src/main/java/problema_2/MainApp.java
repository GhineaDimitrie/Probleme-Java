package problema_2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws IOException {
        List<PerecheNumere> lista = new ArrayList<PerecheNumere>();

        lista.add(new PerecheNumere(1, 2));
        lista.add(new PerecheNumere(3, 4));
        lista.add(new PerecheNumere(5, 6));

        scriere(lista);

        List<PerecheNumere> listaNoua = citire();
        for (PerecheNumere p : listaNoua) {
            System.out.println(p);
        }


        boolean rezultat2 = sumaIdentica(24, 11);
        System.out.println(rezultat2);

        boolean rezultat3 = numerePare(244554, 34);
        System.out.println(rezultat3);


    }

    static void scriere(List<PerecheNumere> lista) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        File f = new File("src/main/resources/pereche.json");
        mapper.writeValue(f, lista);


    }


    static List<PerecheNumere> citire() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("src/main/resources/pereche.json");
        List<PerecheNumere> lista = mapper.readValue(file, new TypeReference<List<PerecheNumere>>() {
        });
        return lista;

    }


    public static boolean suntConsecutiveFibo(int a, int b) {
        if (a < 0 || b < 0) return false;

        int f1 = 0;
        int f2 = 1;

        while (f2 <= Math.max(a, b)) {
            if ((f1 == a && f2 == b) || (f1 == b && f2 == a)) {
                return true;
            }
            int next = f1 + f2;
            f1 = f2;
            f2 = next;
        }

        return false;
    }


    public static int lcm(int number1, int number2) {
        if (number1 == 0 || number2 == 0) {
            return 0;
        }
        int absNumber1 = Math.abs(number1);
        int absNumber2 = Math.abs(number2);
        int absHigherNumber = Math.max(absNumber1, absNumber2);
        int absLowerNumber = Math.min(absNumber1, absNumber2);
        int lcm = absHigherNumber;
        while (lcm % absLowerNumber != 0) {
            lcm += absHigherNumber;
        }
        return lcm;
    }

    public static boolean sumaIdentica(int a, int b) {


        if (a < 10 || b < 10)
            return false;

        int suma1 = 0, suma2 = 0;


        while (a > 0) {
            int cifra = a % 10;
            suma1 = suma1 + cifra;
            a = a / 10;
        }

        while (b > 0) {
            int cifra = b % 10;
            suma2 = suma2 + cifra;
            b = b / 10;
        }

        return (suma1 == suma2);


    }


    public static boolean numerePare(int a, int b) {


        if (a < 10 || b < 10)
            return false;

        int count1= 0, count2 = 0;


        while (a > 0) {

            int cifra = a % 10;
            if(cifra % 2==0)
            {
                count1++;
            }


            a = a / 10;
        }

        while (b > 0) {

            int cifra = b % 10;
            if(cifra % 2==0) {
                count2++;

            }
            b = b / 10;
        }

        return (count1 == count2);


    }




}
