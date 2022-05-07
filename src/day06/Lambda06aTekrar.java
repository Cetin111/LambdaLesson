package day06;

import day01.Lambda01;

import java.util.stream.IntStream;

public class Lambda06aTekrar {
    public static void main(String[] args) {
        System.out.println("TASK 01 amele topla-->  " + toplaAmele(10));
        System.out.println("TASK 01 cincix topla--> " + toplaCincix(10));
        System.out.println("   ***   ");

        System.out.println("TASK 02 -->" + toplaCift(10)); // 2+4+6+8+10=30
        System.out.println("   ***   ");

        System.out.println("TASK 03 -->" + toplaIlkCift(10)); //2+4+6+... +18+20
        System.out.println("   ***   ");

        System.out.println("TASK 04 -->" + ilkxTekTopla(5)); //1+3+5+7+9
        System.out.println("   ***   ");

        System.out.println("TASK 05 -->");
        ikininXKuvveti(5);               //2 4 8 16 32
        System.out.println("\n   ***   ");

        System.out.println("TASK 06 -->");
        sayininIlkXKuvveti(4, 3); //4 16 64
        System.out.println("\n   ***   ");

        System.out.println("TASK 07 -->" + sayininFaktoriyeli(5));//5*4*3*2*1=120
        System.out.println("   ***   ");

        System.out.println("TASK 08 -->"+sayininXinciKuvveti(4,3)); //64
        System.out.println("   ***   ");
        System.out.print("TASK 08 --> ikinci yol :");
        sayininXinciKuvvetiLambda(5,3);

    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program create ediniz.

    //Structured(AMELE) Programming

    public static int toplaAmele(int x) {
        int toplam = 0;
        for (int i = 0; i <= x; i++) {
            toplam += i;
        }
        return toplam;
    }

    //Functional(cincix) Programming
    public static int toplaCincix(int x) {
        return IntStream.  //strem akis, IntStrem integer akis saglar
                range(1, x + 1). //1 den x e kadar (x+1 haric, x dahil oldu) [a,b) int degerler akisa alindi
                sum(); //akisdaki int degerler toplandi
    }


    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int toplaCift(int x) {
        return IntStream.
                rangeClosed(1, x).  //1 den x e kadar x dahil. [a,b]
                        filter(Lambda01::ciftBul). //cift int degerler filtrelendi
                        sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int toplaIlkCift(int x) {
        return IntStream.
                iterate(2, t -> t + 2).  //2 den sonsuza kadar elemanlari 2 artirarak
                // akisa alir ---> 2,4,6,8,10,...
                        filter(Lambda01::ciftBul). //akisdaki ilk x int degeri akisa alir
                        limit(x).sum();
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int ilkxTekTopla(int x) {
        return IntStream.iterate(1, t -> t + 2).limit(x).sum();

    }

    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininXKuvveti(int x) {

        IntStream.
                iterate(2, t -> t * 2).  //2 den sonsua kadar elemanlari 2 ile carparak akisa alir
                limit(x). //akistaki ilk x degeri alir
                forEach(Lambda01::yazdir); //yazdirir
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void sayininIlkXKuvveti(int istenenSayi, int x) {
        IntStream.
                iterate(istenenSayi, t -> t * istenenSayi). //istenen sayiyi alip surekli kendisi ile carp
                limit(x).
                forEach(Lambda01::yazdir);
    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static int sayininFaktoriyeli(int x) {
        return IntStream.rangeClosed(1, x).reduce(1, (t, u) -> (t * u));

    }

    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.
    public static int sayininXinciKuvveti(int istenilenSayi,  int x) {
      return (int) Math.pow(istenilenSayi,x);
    }
    public static void sayininXinciKuvvetiLambda(int istenilenSayi,  int x) {
        IntStream.iterate(istenilenSayi,t->t*istenilenSayi).limit(x).skip(x-1).forEach(Lambda01::yazdir);
    }
}