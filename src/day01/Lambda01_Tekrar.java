package day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01_Tekrar {
    public static void main(String[] args) {
        /*
        1) Lambda "Functional Programming"-->mathod(action) kullanma pr dili.
                Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
        Lambda  kendi başına tanımlanabilen parametre alıp gönderebilen fonksiyonlardır.
        Lambda’lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
                Java 8 ile gelen bu özellik, Java 8’in en önemli özelliğidir.

        "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
        2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
        3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
        ve hatasiz code yazma acilarindan cok faydalidir.
        4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
        Lambda kullanmak hatasız code kullanmaktır.

                Collections Nedir?
                Çoğu yazılım tek tek öğeler yerine öğelerden oluşan toplulukları depolar ve onlar üzerinde işlem
        yapar. Array’ler onlardan birisidir. Java Collections Framework, arraylerle yapılan işleri daha kolay
        yaptığı gibi, daha fazlasını da yapar.
                Java’da bir koleksiyon (collection - bazen container, ambar diye adlandırılır) nesnelerden oluşan bir
        topluluğu bir arada tutan bir yapıdır. ‘Collections Framework’ ise arayüzler ve onların kurgularından
                (implementations) oluşur.
                */

        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));

        printEtStructured(sayi);
        System.out.print("\n--------------\n");
        printEtFunctional(sayi);
        System.out.print("\n--------------\n");
        printEtFunctional1(sayi);
        System.out.print("\n--------------\n");
        printEtFunctional2(sayi);
        System.out.print("\n--------------\n");
        ciftElemanlariYazdirma(sayi);
        System.out.print("\n--------------\n");
        ciftElemanlariYazdirma2(sayi);


    }

    //Task: Structured Programing kullanarak list elemanlarini ayni satirda aralarinda bosluk olacak sekilde print ediniz
    public static void printEtStructured(List<Integer> sayi) { //main disindayiz o nedenle metod create ettik
        for (Integer each : sayi) {
            System.out.print(each + " ");    //34 22 16 11 35 20 63 21 65 44 66 64 81 38 15
        }

    }


    //Task: Functional Programing kullanarak list elemanlarini ayni satirda aralarinda bosluk olacak sekilde print ediniz

    public static void printEtFunctional(List<Integer> sayi) {
        sayi.stream().forEach(t -> System.out.print(t + " "));  // stream=selale,akis. stream dikey akis yapar
        // listedeki elemanlari dikey siralar akisa sunar.
        //foreach herbir elemani alip aksiyona sokar yani yazdirir.
        //aksiyona lambda experisin denir

    }

    //----------------------------------------------------------

        /*
        stream() : datalari yukaridan asagiya akis sekline getirir. Stream bir interface olduğundan dolayı doğrudan nesne almaz.
        forEach() :datanin parametresine gore her bir elemanı isler
        t-> : Lambda operatoru

              Lambda Expression-->(parameter list) -> {action body}


             Parameter list: Fonksiyonun parametreleri tanımlanır. Hiç parametre geçirmeden boşta olabilir.
             -> Arrow-token: Argüman listesi ile expression gövdesini birbirine bağlamak için kullanılır.
             Body: Expressionları ve statementları içerir.

            Bir kod bloğundan oluşan bir body...
            Bu tip lambda body, block body olarak bilinir. Blok gövdesi, lambda gövdesinin birden çok ifade içermesine izin verir.
            Bu ifadeler parantez içine alınır ve parantezlerden sonra noktalı virgül eklemeniz gerekir.

                () -> {
                 double pi = 3.1415;
                    return pi;
                };

       ahanda trick köşeşinde bugun :   Lambda Expression  yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir

        */

    public static void printEtFunctional1(List<Integer> sayi) {
        sayi.stream().forEach(System.out::print);  //method reference==> System.out yapisinda print methodu refere et
                        //bu aksiyon  task deki ayni satira bosluk ile yazmayi karsilamaz bunun icin
                        //seed(tohum) method creat edilip refere edilmeli
    }
    public static void yazdirMethodu(int a){
        System.out.print(a+" "); //verilen integer degeri ayni satirda bosluk birakarak yazdiran seed(tohum) methodu yapildi
    }

    public static void printEtFunctional2(List<Integer> sayi) {
        sayi.stream().forEach(Lambda01_Tekrar::yazdirMethodu);  //   =====>>>>  kaynak :: method
                                //Kaynak: Basharfinin buyuk olmasindan belli ait oldugu Class ismi,
                                //method: yazdirma methodunu biz create eettik.
    }


    //----------------------------------------------------------
    // Task : structured Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void ciftElemanlariYazdirma(List<Integer> sayi){

        for (Integer each : sayi
             ) {
           if (each%2==0){
               System.out.print(each+" ");
           }
        }
    }

    // Task : fonctional Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void ciftElemanlariYazdirma2(List<Integer> sayi){
        sayi.stream().filter(t-> t %2==0 ).forEach(Lambda01_Tekrar::yazdirMethodu);

    }



}
