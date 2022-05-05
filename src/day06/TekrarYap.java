package day06;

import java.util.stream.IntStream;

public class TekrarYap {
    public static void main(String[] args) {
        System.out.println("TASK 01 amele topla-->"+toplaAmele(10));
        System.out.println("TASK 01 cincix topla-->"+toplaCincix(10));
        System.out.println("   ***   ");

        System.out.println("TASK 02 -->");
        System.out.println("   ***   ");

        System.out.println("TASK 03 -->");
        System.out.println("   ***   ");

        System.out.println("TASK 04 -->");
        System.out.println("   ***   ");

        System.out.println("TASK 05 -->");
        System.out.println("   ***   ");

        System.out.println("TASK 06 -->");
        System.out.println("   ***   ");

        System.out.println("TASK 07 -->");
        System.out.println("   ***   ");

        System.out.println("TASK 08 -->");
        System.out.println("   ***   ");

    }

        //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program create ediniz.

        //Structured(AMELE) Programming

    public static int toplaAmele(int x) {
        int toplam = 0;
        for (int i = 1; i <= x; i++) {
            toplam += i;
        }
        return toplam;
    }

    //Functional(cincix) Programming
    public static int toplaCincix(int x) {
        return IntStream.
                range(1, x + 1).//1 den x'e kadar(x dahil) int degerler akısa alındı
                        sum();//akısdakş int degerler toplandı
    }

        //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.


        //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.


        //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.


        //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.


        //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.


        //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.


        //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.


}