package day02;

import day01.Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda02 {
    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));
        ciftKarePrint(sayi);//16 4 36
        System.out.println("\n   ***   ");
        tekKupBirFazlaPrint(sayi);//1332 -124 344 28 3376
        System.out.println("\n   ***   ");
        ciftKarekokPrint( sayi);

    }

        // Task : Functional Programming ile listin cift elemanlarinin  karelerini ayni satirda aralarina bosluk bırakarak print ediniz

    public static void ciftKarePrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).//map()--> Stream içerisindeki elemanları başka tiplere dönüştürmek veya üzerlerinde işlem yapmak (update) için Map kullanılmaktadır.
                forEach(Lambda01::yazdir);


    }
    // Task : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edi

    public static void tekKupBirFazlaPrint(List<Integer> sayi) {
        sayi.
                stream().//sayilar akısa  alındı
                filter(t -> t % 2 != 0).//tek elemnalr fitrelendi
                map(t -> (t * t * t) + 1).//tek elemanları küplerinin 1 fazlasına udate edildi
                forEach(Lambda01::yazdir);//print edildi

    }

    // Task : Functional Programming ile listin cift elemanlarinin   karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKarekokPrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).//meth ref--> double deger return eder
                //forEach(Lambda01::yazdir)--> yazdir() method int.  çalıştığı için map den çıkan dataları çalıştırmaz
                        forEach(t->System.out.print(t+" "));
    }
    // Task : list'in en buyuk elemanini yazdiriniz
}