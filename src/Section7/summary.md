# Section 7: Nesne Yönelimli Programlama (OOP) - Bölüm 1

Bu bölümde OOP'nin temel kavramları detaylı şekilde öğrenildi.

## Öğrenilen Konular

### 1. Sınıflar ve Nesneler
- Sınıf tanımlama ve nesne oluşturma
- Instance variables (fields)
- Constructors
- Getter ve Setter metodları
- Encapsulation (Kapsülleme)

### 2. Inheritance (Kalıtım)
- `extends` keyword kullanımı
- Parent-child ilişkisi
- Method overriding
- `super` keyword
- **Örnekler**: Animal → Dog, Fish hiyerarşisi

### 3. Object Sınıfı
- Tüm sınıfların atası
- `toString()` metodu override etme
- `equals()` ve `hashCode()` metodları
- **Örnekler**: Worker → Employee → HourlyEmployee/SalariedEmployee

### 4. POJO (Plain Old Java Object)
- Basit veri taşıyıcı sınıflar
- Record sınıfları (Java 14+)
- Immutable objects
- **Örnekler**: Student, LPAStudent

### 5. String İşlemleri
- String formatting teknikleri
- `StringBuilder` kullanımı ve performans
- String metodları (substring, indexOf, split vb.)
- String immutability

### 6. Pratik Örnekler
- **Geometrik Şekiller**: Circle, Rectangle, Cylinder, Cuboid
- **Banka Uygulaması**: Account, Customer
- **Hesap Makinesi**: SimpleCalculator, ComplexNumber
- **Koordinat Sistemi**: Point sınıfı
- **Ev Dekorasyonu**: Wall, Floor, Carpet

## OOP Prensipleri

### Encapsulation (Kapsülleme)
- Private fields, public methods
- Data hiding
- Controlled access

### Inheritance (Kalıtım)
- Code reusability
- IS-A relationship
- Method overriding

### Polymorphism (Çok Biçimlilik)
- Bir nesnenin birden fazla forma sahip olması
- Method overriding ile gerçekleştirilir

## Önemli Noktalar

- Her zaman private fields kullanın
- Getter/Setter metodlarında validasyon yapın
- Inheritance'ı mantıklı yerlerde kullanın (IS-A ilişkisi)
- Constructor chaining ile kod tekrarını azaltın
- toString() metodunu override etmek debugging'i kolaylaştırır