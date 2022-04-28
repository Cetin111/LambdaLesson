package day02;

import day01.Lambda01;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda2Tekrar {
    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(-8, 5, 2, 0, -10, 11, 14));
        ciftKare(sayi);
        System.out.println("\n--------------");
        tekKup(sayi);
        System.out.println("\n--------------");
        ciftKarekok(sayi);
        System.out.println("\n--------------");
        enBuyukEleman(sayi);
        System.out.println("\n--------------");
        ciftKarteMaxBul(sayi);
        System.out.println("\n--------------");
        elemanlariTopla(sayi);
        System.out.println("\n--------------");
        ciftlerCarpim(sayi);

    }




    // Task : Functional Programming ile listin cift elemanlarinin
    // karelerini ayni satirda aralarina bosluk bırakarak print ediniz
    public static void ciftKare(List<Integer> sayi) {
        sayi.stream().filter(t -> t % 2 == 0).map(t -> t * t).forEach(Lambda01::yazdir);
        //64 4 0 100 196
    }



    // Task : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini
    // ayni satirda aralarina bosluk birakarak print edi
    public static void tekKup(List<Integer>sayi){
        sayi.stream().filter(t-> t%2!=0).map(t-> (t*t*t)+1).forEach(Lambda01::yazdir);
        //126 1332
    }



    // Task : Functional Programming ile listin cift elemanlarinin karekoklerini
    // ayni satirda aralarina bosluk birakarak yazdiriniz  !!! negatif ciftleri almasin!!!
    public static void ciftKarekok(List<Integer>sayi){
        sayi.stream().filter(Lambda01::ciftBul).filter(t-> t>0).map(Math::sqrt).forEach(t-> System.out.print(t+" "));
        //1.4142135623730951 3.7416573867739413

   //map integer oldugu icin yazdir() ile yazdiramadik. expression yaptik sout ile yazdirdik
    }



    // Task : list'in en buyuk elemanini yazdiriniz
    //public static void
    public static void enBuyukEleman(List<Integer> sayi){
        //sayi.stream().reduce(Math::max);  //yazdiramadik... bir variable a atayacagiz
        Optional<Integer> maxSayi = sayi.stream().reduce(Math::max);  //Optional[14]
        // int maxSayi = ... yaptik sonra kendisi import gibi bir seyle bu hale getirdi.
        System.out.println(maxSayi);

        //!!!!!!!   reduce() ve Yazdir() terminal islemerdir, bunlaridan sonra herhangi birsey baglayamayiz
                        // yani baska bir method ekleyemeyiz o yuzden reduce den sonra yazdir() yapamadik

    }

    // Task : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftKarteMaxBul(List<Integer> sayi) {
       Optional<Integer> sayi2 = sayi.stream().filter(Lambda01::ciftBul).map(t-> t*t).reduce(Math::max); //Math methodu kulandik. bu daha buyuk bir method
        System.out.println(sayi2);   //Optional[196]

        Optional<Integer> sayi3 = sayi.stream().filter(Lambda01::ciftBul).map(t-> t*t).reduce(Integer::max); //integer methodu daha ahizli,
        System.out.println(sayi2);   //Optional[196]
    }


    // Task : List'teki tum elemanlarin toplamini yazdiriniz.
    //Lambda Expression...
    public static void elemanlariTopla(List<Integer> sayi){
        Optional<Integer> toplam = sayi.stream().reduce(Integer::sum); //method reference
        System.out.println("Method Ref: "+ toplam);  //Method Ref: Optional[14]
        //baslangic degeri yok null verebilir o yuzden optional istedi.

        int toplam2 = sayi.stream().reduce(0, (a, b) -> a + b);  //Lambda expression
        System.out.println("Lambda expression : "+ toplam2);  //Lambda expression : 14
        //baslangic degeri 0 null verme ihtimali yok. optional istemedi
    }


    // Task : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void ciftlerCarpim (List<Integer>sayi){

        System.out.println("Lambda experession : " +
                sayi.stream().
                filter(Lambda01::ciftBul).
                reduce(1,(a,b)-> a*b));  //Lambda experition : 0


        System.out.println("Method Ref:" +
                sayi.stream().filter(Lambda01::ciftBul).
                        reduce(Math::multiplyExact));  //Method Ref:Optional[0]
    }








    }





