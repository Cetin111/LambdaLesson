package day03;

import day01.Lambda01;

import java.util.*;

public class TekrarLambda02 {
    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));
        enKUcukEleman(sayi);
        System.out.println("\n -------------");
        besdenBuyukEnKucuk(sayi);
        System.out.println("\n -------------");
        ciftKareSirali(sayi);
        System.out.println("\n -------------");
        teklerinKaresiTersdenSirala(sayi);
    }

    public static int minElemanIlker(int a, int b) {
       return a<b ? a : b ;
    }

    // Task : List'teki elemanlardan en kucugunu 4 farklı yontem ile print ediniz.
    public static void enKUcukEleman(List<Integer> sayi) {

        //1. yontem Method Reference --> Integer class
        Optional<Integer> minSayi = sayi.stream().reduce(Integer::min);
        System.out.println("minSayi = " + minSayi);  //minSayi = Optional[-5]

        //2. yontem Method Reference --> Math class
        Optional<Integer> minSayi2 = sayi.stream().reduce(Math::min);
        System.out.println("minSayi2 = " + minSayi2);  //minSayi2 = Optional[-5]

        //3. yontem Lambda Expression
        int minSayi3 = sayi.stream().reduce(Integer.MAX_VALUE,(x, y) -> x < y ? x : y);
            //Optional<Integer> minSayi3 = sayi.stream().reduce((x, y) -> x < y ? x : y);
        System.out.println("minSayi3 = " + minSayi3);  //minSayi3 = -5

        //4. yontem Method Reference --> Kendin method create burdan cagir
        Optional<Integer> minSayi4 = sayi.stream().reduce(TekrarLambda02::minElemanIlker);
        System.out.print("minSayi4 = " + minSayi4);   //minSayi4 = Optional[-5]

    }

        // Task : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void besdenBuyukEnKucuk(List<Integer> sayi){
        System.out.print(sayi.stream().filter(t -> t > 5 && t % 2 == 1).reduce(TekrarLambda02::minElemanIlker));
        //Optional[7]

    }

    // Task : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftKareSirali(List<Integer> sayi){
        sayi.stream().   //akisa alindi
                filter(Lambda01::ciftBul).  //cift elemanlar filtrelendi
                map(t-> t*t).sorted().      //karesi alinan elemanlar dogal siralandi
                forEach(Lambda01::yazdir); //4 16 36    yazdirildi

        //sorted() => Doğal düzene göre sıralanmış, bu akışın elemanlarında oluşan bir akış döndürür.
        //Sorted() methodu tekrarlı kullanılırsa en son kullanılan aktif olur.
    }

    // Task : list'in tek  elemanlarinin kareleri ni buykten kucuge  print ediniz.
    public static void teklerinKaresiTersdenSirala(List<Integer> sayi){
        sayi.stream().filter(t-> t%2==1).map(t-> t*t).sorted(Comparator.reverseOrder()).forEach(Lambda01::yazdir);
        //225 121 49 9

    }





}
