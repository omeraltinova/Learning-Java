package Section14.Lambda.Chaining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

// Lambda Fonksiyon Zincirleme (Function Chaining) örneği
public class Main {

    public static void main(String[] args) {
        // Temel değişken tanımlama
        String name = "Tim";
        // Temel Function örneği - String'i büyük harfe çevirir
        Function<String,String> uCase = String::toUpperCase;
        System.out.println(uCase.apply(name)); // Çıktı: TIM

        // İkinci fonksiyon - soyad ekler
        Function<String,String> lastName = s -> s.concat(" Buchalka");
        // andThen() kullanarak fonksiyonları zincirler: önce büyük harf, sonra soyad
        Function<String,String> uCaseLastName = uCase.andThen(lastName);
        System.out.println(uCaseLastName.apply(name)); // Çıktı: TIM Buchalka

        // compose() kullanım - andThen()'in tersine çalışır: önce lastName, sonra uCase
        uCaseLastName = uCase.compose(lastName);
        System.out.println(uCaseLastName.apply(name)); // Çıktı: TIM BUCHALKA

        // Çoklu zincirleme - dönüş tipini değiştirir (String -> String[])
        Function<String, String[]> f0 = uCase
                .andThen(s -> s.concat(" Buchalka"))  // 1. Soyad ekle
                .andThen(s -> s.split(" "));          // 2. Boşluğa göre böl
        System.out.println(Arrays.toString(f0.apply(name))); // Çıktı: [TIM, Buchalka]

        // Daha karmaşık zincirleme - soyad, isim formatına dönüştürür
        Function<String, String> f1 = uCase
                .andThen(s -> s.concat(" Buchalka"))              // 1. Soyad ekle
                .andThen(s -> s.split(" "))                       // 2. Array'e böl
                .andThen(s -> s[1].toUpperCase() + ", " + s[0]);   // 3. "SOYAD, İsim" formatı

        System.out.println(f1.apply(name)); // Çıktı: BUCHALKA, TIM


        // En karmaşık zincirleme - sonunda Integer döner
        Function<String, Integer> f2 = uCase
                .andThen(s -> s.concat(" Buchalka"))        // 1. Soyad ekle
                .andThen(s -> s.split(" "))               // 2. Array'e böl  
                .andThen(s-> String.join(", ",s))         // 3. Virgülle birleştir
                .andThen(String::length);                 // 4. String uzunluğunu al

        System.out.println(f2.apply(name)); // Çıktı: 13 ("TIM, Buchalka" uzunluğu)

        // Consumer zincirleme örneği - işlem yapar ama değer döndürmez
        String[] names = {"Ann", "Bob", "Carol"};
        Consumer<String> s0 = s -> System.out.print(s.charAt(0)); // İlk harfi yazdır
        Consumer<String> s1 = System.out::println;                // Satır sonu
        Arrays.asList(names).forEach(s0                           // Her isim için:
                .andThen(s -> System.out.print(" - "))             // 1. İlk harf
                .andThen(s1));                                     // 2. " - " ekle
                                                                   // 3. Satır sonu
        // Çıktı: A - Ann (yeni satır) B - Bob (yeni satır) C - Carol (yeni satır)

        // Predicate örnekleri - boolean değer döndüren fonksiyonlar
        Predicate<String> p1 = s -> s.equals("TIM");                    // Tam eşleşme kontrol eder
        Predicate<String> p2 = s -> s.equalsIgnoreCase("Tim");          // Büyük/küçük harf görmezden gelerek kontrol
        Predicate<String> p3 = s -> s.startsWith("T");                  // "T" ile başlayıp başlamadığını kontrol
        Predicate<String> p4 = s -> s.endsWith("e");                    // "e" ile bitip bitmediğini kontrol

        // Predicate zincirleme - or() kullanarak VEYA mantığı
        Predicate<String> combined1 = p1.or(p2);                       // p1 VEYA p2 true ise true döner
        System.out.println("combined1 = " + combined1.test(name));     // Çıktı: combined1 = false (Tim ≠ TIM ve Tim ≠ tim)


        // Predicate zincirleme - and() kullanarak VE mantığı
        Predicate<String> combined2 = p3.and(p4);                      // p3 VE p4 ikisi de true ise true döner
        System.out.println("combined2 = " + combined2.test(name));     // Çıktı: combined2 = false (Tim "T" ile başlar ama "e" ile bitmez)

        // Predicate zincirleme - negate() kullanarak TERS mantık
        Predicate<String> combined3 = p3.and(p4).negate();             // (p3 VE p4)'ün tersini alır
        System.out.println("combined3 = " + combined3.test(name));     // Çıktı: combined3 = true (false'un tersi = true)

        // Person record tanımlaması ve liste örneği
        record Person(String firstName, String lastName) {}

        List<Person> list = new ArrayList<>(Arrays.asList(
                new Person("Zeynep", "Kara"),    // Aynı soyad - z ile başlar
                new Person("Ali", "Kara"),       // Aynı soyad - a ile başlar  
                new Person("Can", "Yılmaz"),     // Aynı soyad - c ile başlar
                new Person("Arda", "Yılmaz")     // Aynı soyad - a ile başlar
        ));

        // Liste sıralama örnekleri
        System.out.println("---------------------------------------------");
        
        // Lambda expression ile sıralama - lastName'e göre alfabetik sıralama
        list.sort((o1,o2) -> o1.lastName.compareTo(o2.lastName));        // Lambda ile karşılaştırma
        list.forEach(System.out::println);                               // Her elemanı yazdır
        
        System.out.println("---------------------------------------------");
        
        // Method reference ile sıralama - sadece soyada göre sıralama
        list.sort(Comparator.comparing(Person::lastName));               // Method reference ile karşılaştırma
        list.forEach(System.out::println);                               // Her elemanı yazdır
        
        System.out.println("---------------------------------------------");
        
        // Çoklu sıralama - thenComparing() ile ikincil sıralama
        list.sort(Comparator.comparing(Person::lastName)                 // 1. Önce soyada göre sırala
                        .thenComparing(Person::firstName));              // 2. Aynı soyad varsa isme göre sırala
        list.forEach(System.out::println);                               // Sonuç: Kara,Ali -> Kara,Zeynep -> Yılmaz,Arda -> Yılmaz,Can

        System.out.println("---------------------------------------------");
        
        // Ters sıralama - reversed() ile tüm sıralamanın tersini alır
        list.sort(Comparator.comparing(Person::lastName)                 // 1. Önce soyada göre sırala
                .thenComparing(Person::firstName).reversed());           // 2. Aynı soyad varsa isme göre sırala, sonra TERS ÇEVİR
        list.forEach(System.out::println);                               // Sonuç: Yılmaz,Can -> Yılmaz,Arda -> Kara,Zeynep -> Kara,Ali
    }
}
