package day04;

import day01.Lambda01;

import java.util.*;

public class Tekrar {
    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList("küşleme", "adana", "trileçe", "havucDilim", "buryan",
                "yaglama", "kokareç", "arabAşı", "güveç", "waffle", "welemen", "cacix"));
        sonHrfBkSirala(menu);
        System.out.println("\n -------  ");
        ciftKareleriTekrarsizSirala(menu);
        System.out.println("\n -------  ");
        karakterSayisi7denKucuk(menu);
        System.out.println("\n -------  ");
        wIleBaslayanlar(menu);
        System.out.println("\n -------  ");
        xileBitenEnAzBirEleman(menu);
        System.out.println("\n -------  ");
        karakterSayisiEnBuyukElYazdr(menu);
        System.out.println("\n -------  ");
        sonHarfeSiralaIlkElemanHaricYazdir(menu);


    }

    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    public static void sonHrfBkSirala(List<String> menü) {

        menü.stream().sorted(Comparator.
                comparing(t-> t.toString().
                        charAt(t.toString().length()-1)).
                reversed()).
                forEach(t-> System.out.print(t+" "));
//arabAşı kokareç güveç cacix buryan welemen havucDilim küşleme trileçe waffle adana yaglama
    }

    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,
    // ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz...
    public static void ciftKareleriTekrarsizSirala(List<String> menu){
        menu.stream().
                map(t-> t.length()*t.length()).
                filter(Lambda01::ciftBul).
                sorted(Comparator.reverseOrder()).
                distinct().
                forEach(Lambda01::yazdir);  //100 36

    }


    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
        public static void karakterSayisi7denKucuk(List<String> menu) {
            //amele kod:
            boolean kontrol = menu.stream().allMatch(t -> t.length() <= 7);
            System.out.println("kontrol : " + kontrol);
            if (kontrol) {
                System.out.println("Elemanlarin hepsi 7 yada daha az harfden olusuyor");
            } else
                System.out.println("Elemanlar 7 harfden buyuk.");

            // cincik Kod
            System.out.println("cincik kod:");
            System.out.print(
                    menu.stream().allMatch(t -> t.length() <= 7)?"Elemanlarin hepsi 7 yada daha az harfden olusuyor":
                            "Elemanlar 7 harfden buyuk.");  //Elemanlar 7 harfden buyuk.

            //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
            //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
            //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.
        }

    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
        public static void wIleBaslayanlar(List<String> menu){

        System.out.println( menu.
                stream().
                noneMatch(t -> t.startsWith("w")) ? "w ile baslayan yemek yok" :
                "w ile baslayan yemek var");  //w ile baslayan yemek var
        //w ile baslayan yemekleri listele
        menu.stream().filter(t-> t.startsWith("w")).forEach(t-> System.out.print(t+" "));  //waffle welemen

        }

    // Task : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.
        public static void xileBitenEnAzBirEleman(List<String> menu){
            System.out.println(
                    menu.stream().
                            anyMatch(t -> t.endsWith("x")) ? "x ile biten eleman var" :
                            "xile biten eleman yok");  //x ile biten eleman var

        }


    // Task : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void karakterSayisiEnBuyukElYazdr(List<String> menu){
        System.out.println(menu.stream().
                sorted(Comparator.comparing(t -> t.toString().length()).
                        reversed()).
                findFirst());  //ilk elemani verir.

        //cikti bir variable a assign edilebilir
        Optional<String> enUzunEleman = menu.
                stream().
                sorted(Comparator.comparing(t-> t.toString().length()).
                reversed()).
                findFirst();
        System.out.println(enUzunEleman);

    }



    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç
    // kalan elemanlari print ediniz.

    public static void sonHarfeSiralaIlkElemanHaricYazdir(List<String> menu){

        menu.stream().
                sorted(Comparator.comparing(t-> t.charAt(t.length()-1))).
                skip(1).
                forEach(t-> System.out.print(t+" "));

    }

        //skip(1) => atlama demek. Akışın ilk n elemanını
        // attıktan sonra bu akışın kalan elemanlarından oluşan bir akış return eder.

        // Bu akış n'den daha az öğe içeriyorsa, boş bir akış döndürülür.
        // Bu, durum bilgisi olan bir ara işlemdir.
        //skip(list.size()-1) => List'in uzunluğunun 1 eksiğini yazarsak
        // son elemanı yazdırırız.



}
