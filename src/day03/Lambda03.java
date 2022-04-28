package day03;

import day01.Lambda01;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.*;

public class Lambda03 {
    public static void main(String[] args) {

        List<String> yemek = new ArrayList<>(Arrays.asList("kusleme", "adana", "trilece","trilece","trilece",
                "HavucDilimi", "buryan", "yaglama", "kokorec", "arabasi"));

        alpByukTekrarsiz(yemek);
        System.out.println("\n   ---------   ");
        karakterSayisiTersSirali(yemek);
        System.out.println("\n   ---------   ");
        karakterSayisiSirala(yemek);
        System.out.println("\n   ---------   ");
        sonHarfTersSirala(yemek);

    }


    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
        public static void alpByukTekrarsiz(List<String>yemek){
        yemek.stream().    //akisa girdi
                //map(t-> t.toUpperCase(Locale.ROOT)).  // buyukharfe cevirdi
                map(String::toUpperCase).  //buyukharf
                sorted().  //Alphabetik siralar
                distinct().  //tekrarsiz hale getirdi
                forEach(t-> System.out.print(t+" "));  //ADANA ARABASİ BURYAN HAVUCDİLİMİ KOKOREC KUSLEME TRİLECE YAGLAMA

        }


//distinct() => Bu method tekrarlı elemanları sadece bir kere akisa sokar. Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
// Sıralı akışlar için, farklı elemanın seçimi sabittir (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
// Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.



// Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void karakterSayisiTersSirali(List<String>yemek){
        yemek.stream().
               // map(t-> t.length()).
                map(String::length).
                sorted(Comparator.reverseOrder()). //buyukten kucuge siraladi
                distinct().
               // forEach(t-> System.out.print(t+" "));
                forEach(Lambda01::yazdir);   //11 7 6 5

    }


    // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..

    public static void karakterSayisiSirala(List<String>yemek){
        yemek.stream().
                sorted(Comparator.
                comparing(String::length)).  //karakter sayisinin kucukten buyuge gore sirala
                forEach(t-> System.out.print(t+" "));
        //adana buryan kusleme trilece trilece trilece yaglama kokorec arabasi HavucDilimi
    }


// Task : list elemanlarinin son harfine gore ters sirali print ediniz.
public static void sonHarfTersSirala(List<String>yemek){
        yemek.stream().   //akisa soktuk
                sorted(Comparator.
                        comparing(t-> t.toString().  //string de null deger olabilir diye to string yazarak hiclige ceviriyoruz
                                charAt(t.toString().length()-1)).  //son harfi aldik
                reversed()).  //tersten siralama
                forEach(t-> System.out.print(t+" "));
        //buryan HavucDilimi arabasi kusleme trilece trilece trilece kokorec adana yaglama
}




// Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..
// Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
// Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
// Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
// Task : Karakter sayisi en buyuk elemani yazdiriniz.
// Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.






}



