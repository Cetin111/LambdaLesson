package day03;

import day01.Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TekrarLambda03 {
    public static void main(String[] args) {


        List<String> menu = new ArrayList<>(Arrays.asList("Kuru", "Adana", "Sutlac", "HavucDilimi", "Iskender", "Kuru"));

        alpBuyukTekrarsiz(menu);
        System.out.println("\n ---------");
        karakterSayiTersSirali(menu);
        System.out.println("\n ---------");
        karakterSayisinaGoreSirala(menu);
        System.out.println("\n ---------");
        sonHarfTersden(menu);

    }

// Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alpBuyukTekrarsiz(List<String> menu){
        menu.stream().  //akisa girdi
                    //map(t-> t.toUpperCase(Locale.ROOT)).
                map(String::toUpperCase).   //buyuk harf update edildi
                sorted().   // alphabetik dogal siraladi
                distinct(). //benzersiz, tekrarsiz hale getirdik
                forEach(t-> System.out.print(t+" ")); //ADANA HAVUCDILIMI ISKENDER KURU SUTLAC


    }


    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void karakterSayiTersSirali(List<String> menu){
        menu.stream().
                map(String::length). //akistaki elemanlar uzunluiklarina update dildi
                sorted(Comparator.reverseOrder()).  //ters sira yapildi
                distinct(). //benzersiz yapildi
                forEach(Lambda01::yazdir);  //11 8 6 5 4

    }
    // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void karakterSayisinaGoreSirala(List<String> menu){

        menu.stream().sorted(Comparator.comparing(String::length)).forEach(t-> System.out.print(t+" "));
        //Kuru Kuru Adana Sutlac Iskender HavucDilimi

    }



    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    public static void sonHarfTersden(List<String> menu){
        menu.stream().sorted(Comparator.comparing(t-> t.toString().charAt(t.toString().length()-1)).reversed()).forEach(t-> System.out.print(t+" "));
        //Kuru Kuru Iskender HavucDilimi Sutlac Adana

    }


}