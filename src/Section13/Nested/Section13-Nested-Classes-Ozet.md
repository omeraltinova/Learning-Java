# Section 13: Nested Classes (İç İçe Sınıflar) - Kapsamlı Özet

## 📚 Genel Bakış

Section 13, Java'da **Nested Classes** (İç İçe Sınıflar) konusunu kapsamlı bir şekilde işlemektedir. Bu bölümde farklı türde iç sınıflar, bunların kullanım alanları ve pratik uygulamaları örneklerle anlatılmıştır.

## 🎯 Ana Konular

### 1. **Static Nested Classes (Statik İç Sınıflar)**

#### Temel Kavramlar:
- `Employee.java` dosyasında `EmployeeComparator` sınıfı bir **static nested class** örneğidir
- `public static class EmployeeComparator<T extends Employee>` şeklinde tanımlanır
- Dış sınıfın instance değişkenlerine erişemez, sadece static üyelerine erişebilir
- `new Employee.EmployeeComparator<>()` şeklinde instantiate edilir

#### Pratik Kullanım:
```java
// Static nested class kullanımı
var comparator = new Employee.EmployeeComparator<>("yearStarted");
employees.sort(comparator.reversed());
```

#### Avantajları:
- Dış sınıftan bağımsız çalışabilir
- Memory efficient (dış sınıfın referansını tutmaz)
- Encapsulation sağlar

### 2. **Inner Classes (İç Sınıflar)**

#### Temel Kavramlar:
- `StoreEmployee.java` dosyasında `StoreComparator` sınıfı bir **inner class** örneğidir
- `public class StoreComparator<T extends StoreEmployee>` şeklinde tanımlanır
- Dış sınıfın tüm üyelerine (private dahil) erişebilir
- `new StoreEmployee().new StoreComparator<>()` şeklinde instantiate edilir

#### Pratik Kullanım:
```java
// Inner class kullanımı
var comparator = new StoreEmployee().new StoreComparator<>();
storeEmployees.sort(comparator);
```

#### Avantajları:
- Dış sınıfın state'ine tam erişim
- Tight coupling sağlar
- Helper class'lar için ideal

### 3. **Local Classes (Yerel Sınıflar)**

#### Temel Kavramlar:
- Method içinde tanımlanan sınıflardır
- `Main.java` dosyasında `addPigLatinName()` methodunda `DecoratedEmployee` sınıfı örneğidir
- Sadece tanımlandığı method içinde kullanılabilir
- Enclosing method'un final/effectively final değişkenlerine erişebilir

#### Pratik Örnek:
```java
public static void addPigLatinName(List<? extends StoreEmployee> list) {
    String lastName = "Piggy"; // Effectively final

    class DecoratedEmployee extends StoreEmployee implements Comparable<DecoratedEmployee> {
        private String pigLatinName;
        private Employee originalInstance;

        public DecoratedEmployee(String pigLatinName, Employee originalInstance) {
            this.pigLatinName = pigLatinName + " " + lastName; // lastName'e erişim
            this.originalInstance = originalInstance;
        }
        // ... diğer methodlar
    }
    // Local class kullanımı
    List<DecoratedEmployee> newList = new ArrayList<>(list.size());
}
```

#### Kullanım Alanları:
- Temporary processing için
- Method-specific logic için
- Data transformation işlemleri

### 4. **Anonymous Classes (Anonim Sınıflar)**

#### Temel Kavramlar:
- `RunMethods.java` dosyasında birçok örnek bulunmaktadır
- Interface veya abstract class'ı implement/extend ederken anında tanımlanır
- Tek kullanımlık işlemler için idealdir

#### Pratik Örnekler:
```java
// Anonymous class örneği
var c4 = new Comparator<StoreEmployee>() {
    @Override
    public int compare(StoreEmployee o1, StoreEmployee o2) {
        return o1.getName().compareTo(o2.getName());
    }
};

// Inline anonymous class
sortIt(storeEmployees, new Comparator<StoreEmployee>() {
    @Override
    public int compare(StoreEmployee o1, StoreEmployee o2) {
        return o1.getName().compareTo(o2.getName());
    }
});
```

#### Avantajları:
- Hızlı implementation
- Code conciseness
- Single-use scenarios için perfect

## 🛠 Pratik Uygulamalar

### 1. **Employee Management System**

**Dosyalar:** `Employee.java`, `StoreEmployee.java`, `Main.java`

**Özellikler:**
- Employee sorting (name, year started)
- Store-based grouping
- Pig Latin name transformation
- Multiple comparison strategies

**Öne Çıkan Teknikler:**
```java
// Static nested class ile sorting
employees.sort(new Employee.EmployeeComparator<>("yearStarted").reversed());

// Inner class ile complex sorting
var comparator = new StoreEmployee().new StoreComparator<>();
storeEmployees.sort(comparator);

// Local class ile data decoration
class DecoratedEmployee extends StoreEmployee implements Comparable<DecoratedEmployee>
```

### 2. **Album ve Playlist System**

**Dosyalar:** `Challange/Album.java`, `Song.java`, `Main.java`

**Özellikler:**
- Song management
- Playlist creation
- Track number ve name based search
- Inner class ile encapsulation

**Inner Class Kullanımı:**
```java
public static class SongList {
    private ArrayList<Song> songs;

    private boolean add(Song song) {
        if (findSong(song.getTitle()) != null) {
            return false; // Duplicate prevention
        }
        this.songs.add(song);
        return true;
    }
}
```

### 3. **Burger Ordering System**

**Dosyalar:** `burger/Meal.java`, `Store.java`

**Özellikler:**
- Multi-level nested classes
- Enum integration
- Currency conversion
- Complex object composition

**Nested Structure:**
```java
public class Meal {
    private class Item { ... }           // Inner class
    private class Burger extends Item {  // Inner class extending another inner class
        private enum Extra { ... }       // Enum inside inner class
    }
}
```

### 4. **Advanced Employee Processing**

**Dosyalar:** `Challange2/Main.java`, `Employee.java`

**Özellikler:**
- Record usage
- Local class ile data transformation
- Anonymous comparator
- Date processing

**Local Class Örneği:**
```java
class MyEmployee {
    Employee containedEmployee;
    int yearsWorked;
    String fullName;

    public MyEmployee(Employee containedEmployee) {
        this.containedEmployee = containedEmployee;
        yearsWorked = currentYear - Integer.parseInt(
                containedEmployee.hireDate().split("/")[2]);
        fullName = String.join(" ", containedEmployee.first(), containedEmployee.last());
    }
}
```

## 🎯 Öğrenilen Ana Prensipler

### 1. **Encapsulation ve Access Control**
- Static nested classes: Dış sınıfın static context'ine erişim
- Inner classes: Dış sınıfın tüm üyelerine erişim
- Local classes: Method scope'una sınırlı erişim
- Anonymous classes: Single-purpose implementation

### 2. **Memory Management**
- Static nested classes: Dış sınıf referansı tutmaz
- Inner classes: Implicit dış sınıf referansı tutar
- Local classes: Enclosing method'un context'ini tutar

### 3. **Design Patterns**
- **Helper Classes:** Comparator implementations
- **Builder Pattern:** Meal construction
- **Decorator Pattern:** DecoratedEmployee example
- **Strategy Pattern:** Multiple sorting strategies

### 4. **Best Practices**
- Static nested class kullan eğer dış sınıfa erişim gerekmiyorsa
- Inner class kullan eğer tight coupling gerekiyorsa
- Local class kullan method-specific logic için
- Anonymous class kullan single-use implementations için

## 🔧 Kullanılan Java Features

### Core Language Features:
- **Generics:** `<T extends Employee>`
- **Enums:** `Extra` enum in Burger class
- **Records:** Employee record in Challenge2
- **Switch Expressions:** Price calculation in enums
- **Var keyword:** Type inference
- **Method References:** Sorting operations

### Collections Framework:
- **ArrayList:** Dynamic arrays
- **LinkedList:** Playlist implementation
- **List interface:** Polymorphism
- **Comparator interface:** Custom sorting

### Advanced Features:
- **Lambda Expressions:** (Implicit kullanım)
- **Stream API:** (Potansiyel kullanım alanları)
- **Exception Handling:** IllegalArgumentException
- **String Formatting:** `formatted()` method

## 🎉 Özet

Section 13, Java'da nested classes konusunu teoriden pratiğe kapsamlı bir şekilde ele almaktadır. Dört farklı nested class türü (static nested, inner, local, anonymous) gerçek dünya senaryolarıyla örneklendirilmiştir. Bu bölüm, object-oriented design principles, encapsulation, ve code organization konularında derinlemesine bilgi sağlamaktadır.

**Ana çıkarımlar:**
- Nested classes, code organization ve encapsulation için güçlü araçlardır
- Her nested class türünün kendine özgü kullanım alanları vardır
- Pratik projeler üzerinden öğrenme, konunun pekiştirilmesini sağlar
- Modern Java features ile entegrasyon, kod kalitesini artırır

Bu section, intermediate-advanced Java developers için essential bilgiler içermektedir ve real-world applications geliştirme yetisi kazandırmaktadır.