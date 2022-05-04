package day02;

import day01.Tekrar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Tekrar2 {

    public static void main(String[] args) {

        List<Integer> numara=new ArrayList<>(Arrays.asList(2,5,3,6,4,8,-2,-3));
        ciftlerinKare(numara);
        System.out.println("\n ------");
        ciftKarekokler(numara);
        System.out.println("\n ------");
        enBuyukElm(numara);
        System.out.println("\n ------");
        ciftKareEnBuyuk(numara);
        System.out.println("\n ------");
        elemanlarToplami(numara);

    }




    // Task : Functional Programming ile listin cift elemanlarinin  karelerini ayni satirda aralarina bosluk bırakarak print ediniz

    public static void ciftlerinKare(List<Integer> numara) {
        numara.stream().filter(Tekrar::ciftBull).map(t-> t*t).forEach(Tekrar::yazdir1);
    }
    // Task : Functional Programming ile listin cift elemanlarinin   karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKarekokler(List<Integer> numara) {
        numara.stream().filter(Tekrar::ciftBull).map(t-> Math.sqrt(t)).forEach(t-> System.out.print(t+" "));
    }

    // Task : list'in en buyuk elemanini yazdiriniz

    public static void enBuyukElm(List<Integer> numara) {

         Optional<Integer> makssayi = numara.stream().reduce(Math::max);
        System.out.println(makssayi);
    }

    // Task : List'in cift elemanlarin karelerinin en buyugunu print ediniz


    public static void ciftKareEnBuyuk(List<Integer> numara) {

     Optional<Integer> makssayi2 = numara.stream().filter(Tekrar::ciftBull).map(t-> t*t).reduce(Math::max);
        System.out.println(makssayi2);

    }


    // Task : List'teki tum elemanlarin toplamini yazdiriniz.
    //Lambda Expression...
    private static void elemanlarToplami(List<Integer> numara) {

    }



}
