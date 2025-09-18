# Section 14 - Lambda İfadeleri Kapsamlı Özet

## 🤔 Lambda İfadeleri Nedir?

**Lambda İfadeleri**, Java 8 ile birlikte gelen ve **functional programming** paradigmasını destekleyen önemli bir özelliktir. Lambda ifadeleri, kısaca **anonim fonksiyonlar** olarak düşünülebilir.

### Temel Tanım
```java
// Geleneksel yöntem (Anonymous Inner Class)
Comparator<String> comparator = new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }
};

// Lambda ifadesi ile aynı işlem
Comparator<String> lambdaComparator = (s1, s2) -> s1.compareTo(s2);
```

### Lambda İfadesinin Avantajları
- **Daha az kod:** Boilerplate kod miktarını önemli ölçüde azaltır
- **Okunabilirlik:** Kodun amacı daha net anlaşılır
- **Fonksiyonel yaklaşım:** Matematik fonksiyonlarına benzer şekilde yazılır
- **Type inference:** Tip çıkarımı otomatik yapılır

### Lambda Söz Dizimi (Syntax)
```java
(parametreler) -> { işlemler }

// Örnekler:
() -> System.out.println("Merhaba")           // Parametresiz
x -> x * 2                                    // Tek parametre (parantez opsiyonel)
(x, y) -> x + y                              // Çoklu parametre
(String s) -> s.toUpperCase()                // Tip belirtili
x -> {                                       // Çok satırlı işlem
    System.out.println(x);
    return x * 2;
}
```

### Functional Interface Kavramı
Lambda ifadeleri sadece **functional interface**'ler ile kullanılabilir:
- Tam olarak **bir tane abstract method** içeren interface'ler
- `@FunctionalInterface` anotasyonu ile işaretlenebilir (opsiyonel)
- Örnek: `Runnable`, `Comparator`, `Consumer`, `Function`

```java
@FunctionalInterface
public interface MathOperation {
    int operate(int a, int b);  // Tek abstract method
}

// Kullanım:
MathOperation addition = (a, b) -> a + b;
MathOperation multiplication = (a, b) -> a * b;
```

### Neden Lambda Kullanmalıyız?
1. **Kod kısalığı:** 10+ satırlık kod 1 satıra iniyor
2. **Performans:** JVM optimizasyonları
3. **Stream API uyumu:** Koleksiyonlarla güçlü işlemler
4. **Modern Java:** Güncel Java development standartları
5. **Paralel işleme:** Multi-threading için ideal

---

## 📚 Genel Bakış

Section 14, Java'da **Lambda İfadeleri** konusunu kapsamlı bir şekilde ele alır. Bu bölümde lambda ifadelerinin temellerinden başlayarak method referansları ve fonksiyon zincirleme tekniklerine kadar ileri seviye konular işlenir.

---

## 🗂️ Konu Başlıkları ve İçerikleri

### 1. **Temel Lambda İfadeleri** (`/Lambda/Main.java`)

**Amaç:** Lambda ifadelerinin temel kavramlarını ve Comparator interface'i ile kullanımını öğretir.

**İçerik:**
- **Person Record:** `firstName` ve `lastName` alanları olan basit bir record sınıfı
- **Anonymous Inner Class vs Lambda:** Geleneksel anonim inner class ile lambda ifadesinin karşılaştırması
- **Comparator Kullanımı:**
  - Temel lastname karşılaştırması: `(o1, o2) -> o1.lastName.compareTo(o2.lastName)`
  - Özel EnhancedComparator interface'i ile çok seviyeli sıralama

**Önemli Kavramlar:**
- Lambda ifadelerinin söz dizimi
- Functional interface kavramı
- Anonymous class'lardan lambda'ya geçiş

---

### 2. **Lambda İfadeleri ve Functional Interface'ler** (`/Lambda/Expressions/`)

#### 2.1 **Operation Interface** (`Operation.java`)
```java
@FunctionalInterface
public interface Operation<T>{
    T operate(T value1,T value2);
}
```
- Generic functional interface örneği
- `@FunctionalInterface` anotasyonunun kullanımı

#### 2.2 **Kapsamlı Lambda Kullanımı** (`Main.java`)

**Ana Konular:**
- **forEach() ile Lambda:** Liste elemanlarını yazdırma
- **Variable Capture:** Local değişkenlerin lambda içinde kullanımı
- **Generic Lambda Fonksiyonlar:** `calculator()` metodunda type safety
- **Yerleşik Functional Interface'ler:**
  - `BiConsumer<Double,Double>`: İki parametre alan, değer döndürmeyen
  - `BinaryOperator<T>`: İki aynı tip parametre alan, aynı tip döndüren
  - `Supplier<Integer>`: Parametre almayan, değer döndüren

**Pratik Örnekler:**
- GPS koordinatları işleme
- Dizileri lambda ile manipüle etme (`Arrays.setAll()`)
- Rastgele değer üretme
- Liste filtreleme (`removeIf()`, `replaceAll()`)

---

### 3. **Challenge 1 - Functional Interface Pratikleri** (`/Lambda/Expressions/Challange/Main.java`)

**Öğrenilen Konular:**
- **Consumer Interface:**
  - Anonymous class implementasyonu
  - Lambda expression dönüşümü
  - forEach() ile birlikte kullanım
- **UnaryOperator Interface:** String manipulation için
- **Supplier Interface:** Parametre almadan değer üretme
- **Function Interface:** Tip dönüşümü için

**Kod Örnekleri:**
```java
// Consumer - String'i kelimelere böler
Consumer<String> printWords = sentence -> {
    String[] parts = sentence.split(" ");
    Arrays.asList(parts).forEach(s -> System.out.println(s));
};

// UnaryOperator - Her ikinci karakteri alır
UnaryOperator<String> everySecondChar = source -> {
    StringBuilder returnVal = new StringBuilder();
    for (int i = 0; i < source.length(); i++) {
        if (i % 2 == 1) {
            returnVal.append(source.charAt(i));
        }
    }
    return returnVal.toString();
};
```

---

### 4. **Challenge 2 - Dizi Manipülasyonu** (`/Lambda/Challange2/Main.java`)

**Amaç:** Arrays ve List'lerle lambda ifadelerinin pratik kullanımı

**İşlem Adımları:**
1. **Büyük Harfe Çevirme:** `Arrays.setAll(names, i-> names[i].toUpperCase())`
2. **Rastgele Orta İsim Ekleme:** `replaceAll(s -> s += " " + getRandomChar('A', 'D') + ".")`
3. **Ters İsim Ekleme:** `replaceAll(s -> s += " " + getReversedName(s.split(" ")[0]))`
4. **Filtreleme:** İlk isim = son isim olanları kaldırma

**Yardımcı Metodlar:**
- `getRandomChar()`: Belirli aralıkta rastgele karakter üretir
- `getReversedName()`: String'i ters çevirir

---

### 5. **Method References** (`/Lambda/MethodRefereces/Main.java`)

**Amaç:** Lambda ifadelerinin daha kısa yazımı olan method reference'larını öğretir

**Method Reference Türleri:**
1. **Static Method Reference:** `Integer::sum`, `Double::sum`
2. **Instance Method Reference:** `String::concat`, `String::toUpperCase`
3. **Constructor Reference:** `PlainOld::new`
4. **Array Constructor Reference:** Dizi oluşturma için

**Önemli Örnekler:**
```java
// Constructor reference
Supplier<PlainOld> reference1 = PlainOld::new;

// Static method reference
calculator(Integer::sum, 10, 25);

// Instance method reference
Function<String, Boolean> f0 = String::isEmpty;

// Transform method ile zincirleme
result = "hello".transform(String::toUpperCase)
                .transform(String::toLowerCase);
```

**PlainOld Sınıfı:**
- Static ID counter ile object tracking
- Constructor reference örnekleri için kullanılır

---

### 6. **Challenge 3 - Gelişmiş Method References** (`/Lambda/Challange3/Main.java`)

**Amaç:** Method reference'ların farklı türlerini ve UnaryOperator listesini kullanmayı öğretir

**Person Record:**
```java
private record Person(String first){
    public String last(String s){
        return first + " " + s.substring(0,s.indexOf(" "));
    }
}
```

**UnaryOperator Listesi:**
```java
List<UnaryOperator<String>> list = new ArrayList<>(List.of(
    String::toUpperCase,                    // Static method reference
    s -> s += " " + getRandomChar('A', 'D') + ".",  // Lambda expression
    s -> s += " " + reverse(s,0,s.indexOf(" ")),    // Lambda with method call
    Main::reverse,                          // Static method reference
    String::new,                            // Constructor reference
    String::valueOf,                        // Static method reference
    tim::last,                              // Instance method reference
    (new Person("MARY"))::last              // Instance method reference (new object)
));
```

**Özel Metodlar:**
- `reverse()`: String'in belirli kısmını ters çevirir
- `applyChanges()`: Tüm operatörleri sırayla uygular

---

### 7. **Function Chaining (Fonksiyon Zincirleme)** (`/Lambda/Chaining/Main.java`)

**Amaç:** Lambda ifadelerini zincirleme teknikleri ile birleştirmeyi öğretir

#### 7.1 **Function Chaining Teknikleri**

**andThen() Kullanımı:**
```java
Function<String,String> uCase = String::toUpperCase;
Function<String,String> lastName = s -> s.concat(" Buchalka");
Function<String,String> uCaseLastName = uCase.andThen(lastName);
// Önce uCase, sonra lastName çalışır
```

**compose() Kullanımı:**
```java
uCaseLastName = uCase.compose(lastName);
// Önce lastName, sonra uCase çalışır (andThen'in tersi)
```

**Çoklu Zincirleme:**
```java
Function<String, Integer> f2 = uCase
    .andThen(s -> s.concat(" Buchalka"))    // String ekleme
    .andThen(s -> s.split(" "))             // Array'e bölme
    .andThen(s-> String.join(", ",s))       // Virgülle birleştirme
    .andThen(String::length);               // Uzunluk hesaplama
```

#### 7.2 **Consumer Chaining**
```java
Consumer<String> s0 = s -> System.out.print(s.charAt(0));
Consumer<String> s1 = System.out::println;
Arrays.asList(names).forEach(s0
    .andThen(s -> System.out.print(" - "))
    .andThen(s1));
```

#### 7.3 **Predicate Chaining**

**Mantıksal Operatörler:**
- `or()`: VEYA mantığı
- `and()`: VE mantığı
- `negate()`: DEĞİL mantığı

```java
Predicate<String> p1 = s -> s.equals("TIM");
Predicate<String> p2 = s -> s.equalsIgnoreCase("Tim");
Predicate<String> combined1 = p1.or(p2);       // p1 VEYA p2
Predicate<String> combined2 = p3.and(p4);      // p3 VE p4
Predicate<String> combined3 = p3.and(p4).negate(); // (p3 VE p4) DEĞİL
```

#### 7.4 **Comparator Chaining**

**Sıralama Teknikleri:**
```java
// Basit sıralama
list.sort(Comparator.comparing(Person::lastName));

// Çoklu sıralama
list.sort(Comparator.comparing(Person::lastName)
    .thenComparing(Person::firstName));

// Ters sıralama
list.sort(Comparator.comparing(Person::lastName)
    .thenComparing(Person::firstName).reversed());
```

---

## 🎯 Öğrenilen Temel Kavramlar

### 1. **Functional Interface'ler**
- `Consumer<T>`: Parametre alır, değer döndürmez
- `Supplier<T>`: Parametre almaz, değer döndürür
- `Function<T,R>`: Parametre alır, farklı tip döndürür
- `UnaryOperator<T>`: Parametre alır, aynı tip döndürür
- `BinaryOperator<T>`: İki parametre alır, aynı tip döndürür
- `Predicate<T>`: Parametre alır, boolean döndürür
- `BiConsumer<T,U>`: İki parametre alır, değer döndürmez

### 2. **Method Reference Türleri**
- **Static Method:** `ClassName::methodName`
- **Instance Method:** `object::methodName`
- **Constructor:** `ClassName::new`
- **Array Constructor:** `Type[]::new`

### 3. **Chaining Teknikleri**
- **Function:** `andThen()`, `compose()`
- **Consumer:** `andThen()`
- **Predicate:** `and()`, `or()`, `negate()`
- **Comparator:** `thenComparing()`, `reversed()`

### 4. **Pratik Kullanım Alanları**
- Liste işlemleri (`forEach`, `removeIf`, `replaceAll`)
- Dizi manipülasyonu (`Arrays.setAll`)
- String işlemleri (`transform`)
- Sıralama ve filtreleme
- Veri dönüşümü

---

## 💡 Önemli Notlar

1. **Lambda ifadeleri** kod okunabilirliğini artırır ve boilerplate kod miktarını azaltır
2. **Method references** lambda ifadelerinden daha kısa ve okunabilir olabilir
3. **Function chaining** karmaşık işlemleri adım adım yapmaya olanak sağlar
4. **Type inference** sayesinde çoğu durumda tip belirtmeye gerek yoktur
5. **Variable capture** için değişkenlerin effectively final olması gerekir

---

## 🔧 Pratik Alıştırmalar

Bu bölümde yer alan challenge'lar:
1. **Challenge 1:** Basic functional interfaces usage
2. **Challenge 2:** Array and List manipulation with lambdas
3. **Challenge 3:** Advanced method references and UnaryOperator lists

Her challenge farklı seviyelerde lambda usage patterns'i öğretir ve gerçek dünya senaryolarına hazırlık sağlar.

---

*Bu özet, Section 14'ün tüm dosyalarının detaylı analizi sonucu hazırlanmıştır. Java Lambda İfadeleri konusunda kapsamlı bir başvuru kaynağı olarak kullanılabilir.*