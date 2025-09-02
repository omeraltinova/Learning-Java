# Section 11: Abstract Classes and Interfaces - Detaylı Özet

## İçindekiler
1. [Abstract Classes (Soyut Sınıflar)](#abstract-classes)
2. [Interfaces (Arayüzler)](#interfaces)
3. [Interface vs Abstract Class Karşılaştırması](#interface-vs-abstract-class)
4. [Kod Örnekleri ve Açıklamalar](#kod-örnekleri)
5. [Önemli Kavramlar](#önemli-kavramlar)

---

## Abstract Classes (Soyut Sınıflar)

### Temel Kavramlar
- **Abstract class**: Doğrudan instantiate edilemeyen sınıflardır
- **Abstract method**: Sadece imzası bulunan, implementasyonu olmayan metodlardır
- Alt sınıflar tüm abstract metodları override etmek zorundadır

### Kod Yapısı (Abstract/Animal.java:21-39)
```java
public abstract class Animal {
    protected String type;
    private String size;
    private double weight;

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public abstract void move(String speed);
    public abstract void makeNoise();

    public final String getExplicitType(){
        return getClass().getSimpleName() + " (" + type + ") ";
    }
}
```

### Abstract Class Özellikleri
- Constructor'a sahip olabilir
- Instance variable'lar tanımlayabilir
- Concrete (somut) metodlar içerebilir
- Final metodlar tanımlayabilir
- Access modifier'lar kullanabilir

---

## Interfaces (Arayüzler)

### Interface Tanımları

#### 1. FlightEnabled Interface (Animal.java:100-117)
```java
interface FlightEnabled{
    double MILES_TO_KILOMETERS = 1.60934;
    double KILOMETERS_TO_MILES = 0.621371;
    
    public abstract void takeOff();
    abstract void land();
    void fly();

    default FlightStages transition(FlightStages stage){
        FlightStages nextStage = stage.getNextStage();
        System.out.println("Transitioning from " + stage + " to " + nextStage);
        return nextStage;
    }
}
```

#### 2. Trackable Interface (Animal.java:119-122)
```java
interface Trackable{
    void track();
}
```

#### 3. OrbitEarth Interface (Animal.java:77-98)
```java
interface OrbitEarth extends FlightEnabled{
    void argieveOrbit();

    private static void log(String description){
        var today = new java.util.Date();
        System.out.println(today + ":  " + description);
    }

    private void logStage(FlightStages stage,String description){
        description = stage + ": " + description;
        log(description);
    }

    @Override
    default FlightStages transition(FlightStages stage) {
        FlightStages nextStage = FlightEnabled.super.transition(stage);
        logStage(stage,"Beginning Transition to " + nextStage);
        return nextStage;
    }
}
```

### Interface Özellikleri

#### Constant'lar (Sabitler)
- Tüm değişkenler otomatik olarak `public static final`
- Interface içinde tanımlanan değerler sabit değerlerdir
- Örnek: `MILES_TO_KILOMETERS = 1.60934`

#### Abstract Metodlar
- Varsayılan olarak tüm metodlar `public abstract`
- Implementasyon içermezler
- Alt sınıflar tarafından override edilmek zorundadır

#### Default Metodlar (Java 8+)
- Interface içinde implementasyona sahip metodlar
- Alt sınıflar tarafından override edilebilir (zorunlu değil)
- `default` anahtar kelimesi ile tanımlanır

#### Private Metodlar (Java 9+)
- Interface içinde sadece o interface tarafından kullanılabilir
- Default metodlar tarafından çağrılabilir
- Code reuse sağlar

#### Static Metodlar
- Interface adı ile çağrılabilir
- Override edilemez

---

## Interface Implementasyonları

### 1. Multiple Interface Implementation
#### Bird Class (Bird.java:3)
```java
public class Bird extends Animal implements FlightEnabled,Trackable{
    @Override
    public void move() {
        System.out.println("Flaps wings");
    }

    @Override
    public void takeOff() {
        System.out.println(getClass().getSimpleName() + " is taking off");
    }

    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + "'s coordinates recorded");
    }
    // ... diğer metodlar
}
```

### 2. Interface Extension
#### OrbitEarth extends FlightEnabled
- Interface'ler birbirini extend edebilir
- Alt interface, üst interface'in tüm metodlarını miras alır
- Default metodları override edebilir

### 3. Enum ile Interface Implementation
#### FlightStages Enum (Animal.java:3-17)
```java
enum FlightStages implements Trackable {
    GROUNDED,LAUNCH,CRUISE,DATA_COLLECTION;

    @Override
    public void track() {
        if(this!=GROUNDED){
            System.out.println("Monitoring " + this);
        }
    }

    public FlightStages getNextStage(){
        FlightStages[] allStages = values();
        return allStages[(ordinal() + 1) % allStages.length];
    }
}
```

### 4. Record ile Interface Implementation
#### DragonFly Record (Animal.java:19-35)
```java
record DragonFly(String name,String type) implements FlightEnabled{
    @Override
    public void takeOff() { }
    
    @Override
    public void land() { }
    
    @Override
    public void fly() { }
}
```

---

## Interface vs Abstract Class Karşılaştırması

| Özellik | Interface | Abstract Class |
|---------|-----------|----------------|
| **Multiple Inheritance** | ✅ Birden fazla implement edilebilir | ❌ Sadece bir tane extend edilebilir |
| **Constructor** | ❌ Olamaz | ✅ Olabilir |
| **Instance Variables** | ❌ Sadece constants | ✅ Her türlü field |
| **Access Modifiers** | 🔸 Metodlar public | ✅ Her türlü access modifier |
| **Default Implementation** | ✅ Default metodlar (Java 8+) | ✅ Concrete metodlar |
| **Static Methods** | ✅ Java 8+ | ✅ Her zaman |
| **Private Methods** | ✅ Java 9+ | ✅ Her zaman |

---

## Polymorphism ve Type Safety

### Reference Types
```java
Bird bird = new Bird();
Animal animal = bird;          // Inheritance
FlightEnabled flier = bird;    // Interface reference
Trackable tracked = bird;      // Interface reference
```

### instanceof Pattern Matching
```java
private static void inFlight(FlightEnabled flier){
    flier.takeOff();
    flier.fly();
    if(flier instanceof Trackable tracked){  // Pattern matching
        tracked.track();
    }
    flier.land();
}
```

---

## Önemli Kavramlar

### 1. Contract (Sözleşme)
- Interface'ler bir contract tanımlar
- Implementing class'lar bu contract'ı yerine getirmek zorundadır
- API tasarımında önemli rol oynar

### 2. Loose Coupling
- Interface'ler loose coupling sağlar
- Implementation detayları gizlenir
- Kodun esnekliğini artırır

### 3. Composition over Inheritance
- Multiple interface implementation
- Functionality'nin compose edilmesi
- Daha esnek tasarım

### 4. Default Methods Benefits
- Backward compatibility
- Interface evolution
- Common functionality sharing

### 5. Functional Interface Hazırlığı
- Single abstract method (SAM)
- Lambda expressions için temel
- Functional programming paradigması

---

## Pratik Kullanım Örnekleri

### Collections ile Interface Usage
```java
LinkedList<FlightEnabled> fliers = new LinkedList<>();
List<FlightEnabled> betterflies = new ArrayList<>();
```

### Method Parameters
```java
private static void triggerFliers(List<FlightEnabled> fliers){
    for(var flier : fliers){
        flier.takeOff();
    }
}
```

### Constants Usage
```java
double milesTraveled = kmsTraveled * FlightEnabled.KILOMETERS_TO_MILES;
```

---

## Öğrenilen Ana Prensipler

1. **Interface Segregation**: Küçük, özelleşmiş interface'ler tercih edilir
2. **Dependency Inversion**: Concrete class'lara değil, interface'lere depend olmak
3. **Open/Closed Principle**: Extension'a açık, modification'a kapalı
4. **Programming to Interface**: Implementation değil, interface'e program yazmak

Bu yapılar, Java'da güçlü, esnek ve maintainable kod yazmanın temelini oluşturur.