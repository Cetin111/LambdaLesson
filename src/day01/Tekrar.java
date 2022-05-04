package day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tekrar {
    public static void main(String[] args) {

        List<Integer> sayilar = new ArrayList<>(Arrays.asList(11, 25, 10, 3, 2, 4, -5, -6, 4, 7, 36,35));

        listYazdir(sayilar);
        System.out.println("\n -------------- ");
        syazdir(sayilar);
        System.out.println("\n -------------- ");
        ciftYazdir(sayilar);
        System.out.println("\n -------------- ");
        cift34denKucuk(sayilar);
        System.out.println("\n -------------- ");
        s34denBuyukVeyaCift(sayilar);
        System.out.println("\n -------------- ");
    }

    public static void yazdir1(int a) {
        System.out.print(a + " ");
    }

    //Task : "Structured Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.
    private static void listYazdir(List<Integer> sayilar) {

        for (Integer s : sayilar
        ) {
            System.out.print(s + " ");
        }


    }

//Task : "fonctional Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.

    public static void syazdir(List<Integer> sayilar) {

        sayilar.stream().forEach(t -> System.out.print(t + " "));

    }

    public static boolean ciftBull(int a) {
        return a % 2 == 0;
    }

    //Task : functional Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void ciftYazdir(List<Integer> sayilar) {
        sayilar.stream().filter(Tekrar::ciftBull).forEach(Tekrar::yazdir1);
    }

    //Task : functional Programming ile list elemanlarinin 34 den kucuk cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void cift34denKucuk(List<Integer> sayilar) {

        sayilar.stream().   //akisa aldii
                filter(Tekrar::ciftBull).  //Lambda ref
                filter(t -> t < 34). //Lambda exp
                forEach(Tekrar::yazdir1); //LAmbda ref
    }
//Task : functional Programming ile list elemanlarinin 34 den buyk veya cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void s34denBuyukVeyaCift(List<Integer> sayilar){

        sayilar.stream().filter(t-> t > 34 || t%2==0).forEach(Tekrar::yazdir1);

    }

}
