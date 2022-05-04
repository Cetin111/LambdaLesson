package day05;

import day04.Universite;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {
    /*
    TASK :
    fields --> Universite (String)
               bolum (String)
               ogrcSayisi (int)
               notOrt (int)
               olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
     */
    public static void main(String[] args) {
        Universite bogazici = new Universite("bogazici", "matematik", 571, 93);
        Universite itu = new Universite("istanbul teknik", "matematik", 622, 81);
        Universite istanbul = new Universite("istanbul", "hukuk", 1453, 71);
        Universite marmara = new Universite("marmara", "bilgisayar muh", 1071, 77);
        Universite ytu = new Universite("yıldız teknik", "gemi", 333, 74);
        List<Universite> unv = new ArrayList<>(Arrays.asList(bogazici, itu, istanbul, marmara, ytu));
        System.out.print(notOrt74BykUnv(unv));
        System.out.println("\n---------");
        System.out.print("110 dan cokmu : " + ogrenciSayisi110Cokmu(unv));
        System.out.println("\n---------");
        System.out.print("mat bolumu varmi : " +matBolumVarmi(unv));
        System.out.println("\n---------");
        System.out.print("buyukten kucuge ogrenci say : \n"+ ogrSayisiBdenKucuge(unv));
        System.out.println("\n---------");
        ogrSayisiBdenKucugeVoid(unv);
        System.out.println("\n---------");
        notOrtSiralaIlk3uYazdir(unv);
        System.out.println("\n---------");
        System.out.print(ogrSayEnAzIkinciUnv(unv));
        System.out.println("\n---------");
        System.out.print(notOrt63denBuyukOgrSayilariTop(unv));
        System.out.println("\n---------");
        System.out.print(notOrt63denBuyukOgrSayilariTopToInt(unv));
        System.out.println("\n---------");
        System.out.print(ogrSayisi333denBuyukOrt(unv));
        System.out.println("\n---------");
        System.out.print(matematikBolumSayisi(unv));
        System.out.println("\n---------");
        System.out.print(ogrSay571denBuyukUnvEnBuyukNotu(unv));
        System.out.println("\n---------");
        System.out.print(ogrSay1071denAzOlanUnvEnKucukNot(unv));

    }
    //task 01--> notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
    public static boolean notOrt74BykUnv(List<Universite> unv ){
        return  unv.
                stream().
                allMatch(t->t.getNotOrt()>74);
    }
    //task 02-->ogrc sayilarinin   110 den az olmadigini  kontrol eden pr create ediniz.
    public static boolean ogrenciSayisi110Cokmu(List<Universite> unv){
       return unv.stream().allMatch(t-> t.getOgrSayisi()>110);

    }
    //task 03-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean matBolumVarmi(List<Universite> unv){
         return unv.stream().anyMatch(t-> t.getBolum().toLowerCase().contains("mat"));

    }

    //task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<Universite> ogrSayisiBdenKucuge(List<Universite> unv){
       return unv.stream().
               sorted(Comparator.comparing(Universite::getOgrSayisi).
               reversed()).
               collect(Collectors.toList());

    }
        // void ile return type kullanmadan:
        public static void ogrSayisiBdenKucugeVoid(List<Universite> unv){
            System.out.println(unv.stream().
                    sorted(Comparator.comparing(Universite::getOgrSayisi).
                            reversed()). //buyukten kucuge akis yaptik ama liste atmadik
                    collect(Collectors.toList()));  //collect() akistaki elemanlari itenen sarta gore toplar.
                                                    // Collectors.toList() collect te toplanan elemanlari liste cevirir.

        }


    //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.
    public static void notOrtSiralaIlk3uYazdir(List<Universite> unv){
        System.out.println(unv.
                stream().  //akisa alindi
                sorted(Comparator.comparing(Universite::getNotOrt).  //not ort gore siraladik
                reversed()). //siralamayi buyukten kucuge cevirdik
                limit(3). //akisin ilk u alindi
                collect(Collectors.toList())); //akisdaki ilk uc eleman alinip, listelendi

    }

    //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.
    public static List<Universite> ogrSayEnAzIkinciUnv(List<Universite> unv){
        return unv.
                stream().
                sorted(Comparator.comparing(Universite::getOgrSayisi)).
                limit(2). //akisdaki ilk iki unv aldik akisi kestik
                skip(1). // ilk universiteyi atladik.
                collect(Collectors.toList()); // liste attik
    }

    //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz
    public static int notOrt63denBuyukOgrSayilariTop(List<Universite> unv){
        return unv.
                stream().
                filter(t-> t.getNotOrt()>63).
                map(t-> t.getOgrSayisi()).
                reduce(0,(t,u)->t+u);
                //reduce(Integer::sum);    //buda olur
                //reduce(Math::addExact);   //buda olur

    }

        //mapTiInt() kullanarak, daha pratik yapilabilir
        public static int notOrt63denBuyukOgrSayilariTopToInt(List<Universite> unv){
            return unv.
                    stream(). //akis
                    filter(t-> t.getNotOrt()>63).  //63 den buyuk olanlar
                    mapToInt(t-> t.getOgrSayisi()). //akisdaki elemanlarin data type ini int yaptik
                                                    // ogr.sayilarinin alip int wrappere atti yani artik sadece int ler var elimizde
                    sum(); //int degerleri toplar

        }

    //task 08--> Ogrenci sayisi 333'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.
public static OptionalDouble ogrSayisi333denBuyukOrt(List<Universite> unv){
        return unv.
                stream().
                filter(t-> t.getOgrSayisi()>333).
                mapToDouble(t-> t.getNotOrt()).  //akisdaki elemanlarin data type ini double yaptik
                average(); //akisdaki elemanlarin ortalamasi alindi

}

    //task 09-->"matematik" bolumlerinin sayisini  print ediniz.
    public static int matematikBolumSayisi(List<Universite> unv){
        return (int) unv.
                stream().
                filter(t-> t.getBolum().
                        contains("mat")).
                count();  //akisdaki eleman sayisi
                         //count() un data type i long oldugu icin int kabul etmedi, casting yaptik.
                        //yada return type ini long yapabilirdik
    }


    //task 10-->Ogrenci sayilari 571'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz
    public static OptionalInt ogrSay571denBuyukUnvEnBuyukNotu(List<Universite> unv){

        return unv.
                stream().  //akis
                filter(t-> t.getOgrSayisi()>571).  //akis filtrelendi
                mapToInt(t-> t.getNotOrt()).  // akisdaki objeleri notOrt akisi olarak update edildi
                max(); //akisin en buyuk degerini return eder
    }




    //task 11-->Ogrenci sayilari 1071'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static OptionalInt ogrSay1071denAzOlanUnvEnKucukNot(List<Universite> unv){
        return unv.stream().filter(t-> t.getOgrSayisi()<1071).mapToInt(t-> t.getNotOrt()).min();

    }





}
