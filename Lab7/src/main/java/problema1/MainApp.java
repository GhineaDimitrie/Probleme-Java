package problema1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class MainApp
{
    public static void main(String[] args)
    {
        Map<Integer,Carte>carti=citire();
        System.out.println("Lista carrtilor: ");
        for(Carte c:carti.values())
            {
            System.out.println(c);
            }

        carti.remove(3);

        System.out.println("CARTI UPDATE-----------");

        for(Carte c:carti.values())
        {
            System.out.println(c);
        }


        carti.putIfAbsent(7,new Carte("Dimitrie","Ghinea",1976));
        System.out.println("CARTI UPDATE2------------");
        for(Carte c:carti.values())
        {
            System.out.println(c);
        }

        scriere(carti);

        var cartiYuval =carti.values().stream().filter(y->y.autorul().equalsIgnoreCase("Yuval Noah Harari")).collect(Collectors.toSet());
        System.out.println("CARTI DE YUVAL-------------");
        cartiYuval.forEach(System.out::println);

        System.out.println("\n Carti ordonate dupa titlu------------");
        var ordonat=carti.values().stream().sorted(Comparator.comparing(Carte::titlul)).collect(Collectors.toSet());
        ordonat.forEach(System.out::println);

        Optional<Carte> vechi=carti.values().stream().min(Comparator.comparing(Carte::anul));
        vechi.ifPresent(System.out::println);









    }



    public static void scriere(Map<Integer,Carte> carti) {
        try {
            var mapper=new ObjectMapper();
            var file=new File("src/main/resources/carti.json");
            mapper.writeValue(file,carti);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Integer,Carte> citire() {
        try {
            var  file=new File("src/main/resources/carti.json");
            var mapper=new ObjectMapper();
            var carti = mapper
                    .readValue(file, new TypeReference<Map<Integer,Carte>>(){});
            return carti;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }





}
