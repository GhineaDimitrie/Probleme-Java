import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainApp {
    public static void main(String[] args) {
        List<Angajat> angajat = new ArrayList<>();
        angajat.add(new Angajat("Dimitrios", "sef", LocalDate.of(2024, 4, 23), 1000));
        angajat.add(new Angajat("Ximi", "bou", LocalDate.now(), 933));
        angajat.add(new Angajat("petre", "director", LocalDate.now(), 9563));
        angajat.add(new Angajat("balulesc", "sef", LocalDate.now(), 34));
        angajat.add(new Angajat("alex", "director", LocalDate.now(), 9233));

        scriere(angajat);
        List<Angajat> angajatClona = citire();
        //cerinta 1
        angajatClona.forEach(System.out::println);
        //cerinta 2
        System.out.println("Angajati cu salariu > 2500: ");
        angajatClona.stream().filter(s -> s.getSalariul() > 2500).forEach(System.out::println);
        System.out.println();
        //cerinta 3
        int anCurent = LocalDate.now().getYear();
        int anulTrecut = anCurent - 1;
        var listaAprilie = angajatClona.stream()
                .filter(a -> a.getData_angajarii().getYear() == anulTrecut)
                .filter(a -> a.getData_angajarii().getMonthValue() == 4)
                .filter(a -> {
                    var p = a.getPostul().toLowerCase();
                    return p.contains("sef") || p.contains("director");
                })
                .collect(Collectors.toList());

        listaAprilie.forEach(System.out::println);


        //cerinta 4

        System.out.println("\n4. Angajatii care nu sunt la conducere, ordonati descresc dupa salariu");

        angajatClona
                .stream()
                .filter(a ->
                        {
                            var p = a.getPostul() == null ? "" : a.getPostul().toLowerCase(Locale.ROOT);
                            return !(p.contains("director") || p.contains("sef"));
                        }
                )
                .sorted(Comparator.comparing(Angajat::getSalariul).reversed())
                .forEach(System.out::println);

        //cerinta 5
        System.out.println("\n5. Numele angajatiilor scrise cu majuscule");
        var numeMajuscule = angajatClona.stream().map(a -> a.getNumele() == null ? " " : a.getNumele().toUpperCase(Locale.ROOT));
        numeMajuscule.forEach(System.out::println);

        //cerinta 6
        System.out.println("\n6. Salarii mai mici de 3000 RON");

        angajatClona.stream().filter(a -> a.getSalariul() < 3000).map(Angajat::getSalariul).forEach(System.out::println);



















    }


    public static void scriere(List<Angajat> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            File file = new File("src/main/resources/angajati2.json");
            mapper.writeValue(file, lista);
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Angajat> citire() {
        try {
            File file = new File("src/main/resources/angajati2.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<Angajat> angajati = mapper
                    .readValue(file, new TypeReference<List<Angajat>>() {
                    });
            return angajati;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}




