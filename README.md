# Java Öğrenme Projesi 🚀

Bu proje, Java programlama dilini sıfırdan ileri seviyeye öğrenmek için oluşturulmuş kapsamlı bir eğitim koleksiyonudur. Temel kavramlardan başlayarak, nesne yönelimli programlama, abstract sınıflar ve interface'lere kadar ilerleyen yapılandırılmış örnekler içerir.

## 📚 Proje Durumu

**Mevcut Seviye**: Intermediate (Orta Seviye)  
**Son Tamamlanan Bölüm**: Section 11 - Abstract Classes & Interfaces  
**Aktif Proje**: Library Management System (Kütüphane Yönetim Sistemi)

## 📋 Proje Yapısı

### Section 4: Java Temelleri ✅
Java'nın en temel yapı taşları:
- **Hello.java**: İlk Java programı, değişkenler, koşullu ifadeler (if-else), ternary operatör
- **FirstClass.java**: İlk sınıf tanımlamaları
- **SecondClass.java**: Sınıf yapısının devamı
- 📝 **summary.md**: Bölüm özeti (Türkçe)

### Section 5: Metodlar ve Kontrol Yapıları ✅
Java'da metod kullanımı ve kontrol yapıları:
- **CodeBlocksAndMethods**: Kod blokları ve metod tanımlamaları
- **Keywords**: Java anahtar kelimeleri
- **MethodChallenge**: Metod yazma alıştırmaları
- **MethodOverloading**: Metod aşırı yükleme (overloading) örnekleri
- **SecondsAndMinutesChallenge**: Zaman dönüşüm uygulaması
- **Statements**: Java ifadeleri ve kontrol yapıları
- 📝 **summary.md**: Bölüm özeti (Türkçe)

### Section 6: Kullanıcı Girişi ✅
Kullanıcıdan veri alma teknikleri:
- **Input**: Scanner sınıfı kullanımı
- **area.java**: Alan hesaplama uygulaması
- **example.java, example2.java**: Çeşitli input örnekleri
- 📝 **summary.md**: Bölüm özeti (Türkçe)

### Section 7: Nesne Yönelimli Programlama (OOP) - Part 1 ✅
OOP temel kavramları:
- **Car & Main**: Temel sınıf örneği (getter/setter, encapsulation)
- **Inheritance**: Kalıtım örnekleri
  - Animal → Dog, Fish sınıf hiyerarşisi
  - Worker → Employee → HourlyEmployee, SalariedEmployee
- **POJO**: Plain Old Java Objects (Student, LPAStudent)
- **TheObject**: Object sınıfı ve metodları (equals, toString, hashCode)
- **StringFormatting**: String işlemleri ve StringBuilder
- **example**: Pratik OOP örnekleri
  - SimpleCalculator, Person, Account, Customer
  - Geometrik şekiller (Circle, Rectangle, Cylinder, Cuboid)
  - Point, Wall, Floor, Carpet sınıfları
  - ComplexNumber, Calculator
- 📝 **summary.md**: Bölüm özeti (Türkçe)

### Section 8: Composition (Bileşim) ✅
"Has-a" ilişkisi ve composition pattern:
- **ComputerProject**: Bilgisayar bileşenleri simülasyonu
  - PersonalComputer, ComputerCase, Monitor, Motherboard
  - Product sınıfı ile inheritance kombinasyonu
- **KitchenProject**: Akıllı mutfak uygulaması
  - SmartKitchen ve mutfak aletleri (CoffeeMaker, DishWasher, Refrigerator)
- **Example1**: Yatak odası modelleme projesi
  - Bedroom, Bed, Ceiling, Lamp, Wall sınıfları
- 📝 **summary.md**: Bölüm özeti (Türkçe)

### Section 9: Arrays (Diziler) ✅
Array kullanımı ve işlemleri:
- **Array**: Temel dizi tanımlama ve kullanımı
- **Multi**: Çok boyutlu diziler
- **References**: Referans tipleri ve diziler
- **Using**: Dizi işlemleri ve algoritmalar
  - Challange: Sıralama algoritmaları (SortedArray)
- **VarArgs**: Variable arguments (varargs) kullanımı
  - Challange: VarArgs pratik uygulamaları

### Section 10: Lists ve Collections ✅
Koleksiyon yapıları:
- **ArrayLists**: ArrayList kullanımı ve metodları
  - Dinamik liste yönetimi
  - ArrayList vs Array karşılaştırması
- **LinkedLists**: LinkedList veri yapısı
  - Node bazlı liste implementasyonu
  - Performance karşılaştırmaları
- **Enum**: Enum tanımlama ve kullanımı
  - Enum metodları ve özellikleri
  - Switch-case ile enum kullanımı
- 📝 **Section10-Summary.md**: Bölüm özeti (Türkçe)

### Section 11: Abstract Classes ve Interfaces ✅
İleri seviye OOP konseptleri:
- **Abstract**: Abstract sınıflar
  - Animal abstract class hiyerarşisi
  - Challange1: ProductForSale abstract pattern (Store projesi)
- **Interfaces**: Interface tanımlama ve implementasyon
  - FlightEnabled, Trackable, OrbitEarth interfaces
  - Default ve private metodlar
  - Multiple interface implementation
- **Challange2**: Interface kombinasyonları
- **Challange3**: Kompleks interface senaryoları
- **Challange4**: Abstract class ve interface birlikte kullanımı
- 📝 **Section11_Summary.md**: Detaylı bölüm özeti (Türkçe)

## 🛠️ Kullanım

### IntelliJ IDEA ile Çalıştırma (Önerilen)
1. Projeyi IntelliJ IDEA'da açın
2. İstediğiniz Section'a gidin
3. Main sınıfını bulup sağ tıklayın
4. "Run 'Main.main()'" seçeneğini tıklayın

### Terminal/Komut Satırı ile Çalıştırma
```bash
# Derleme
javac -cp src src/Section{N}/PackageName/ClassName.java

# Çalıştırma
java -cp src Section{N}.PackageName.ClassName

# Örnek: Section 11 Abstract Challenge
javac -cp src src/Section11/Abstract/Challange1/*.java
java -cp src Section11.Abstract.Challange1.Store
```

## 💻 Gereksinimler

- **Java JDK**: 8 veya üzeri
- **IDE**: IntelliJ IDEA (önerilen) veya herhangi bir Java IDE
- **İşletim Sistemi**: Windows, macOS veya Linux

## 📈 Öğrenme Yolu

1. **Temel Seviye** (Section 4-6): Java syntax, metodlar, kullanıcı girişi
2. **OOP Temelleri** (Section 7-8): Sınıflar, kalıtım, composition
3. **Veri Yapıları** (Section 9-10): Arrays, Lists, Collections
4. **İleri OOP** (Section 11): Abstract classes, Interfaces

## 🎯 Gelecek Hedefler

- [ ] Exception Handling & File I/O
- [ ] Generics
- [ ] Stream API & Lambda Expressions
- [ ] Multithreading & Concurrency
- [ ] Design Patterns

Detaylı yol haritası için [Java_Development_Roadmap.md](Java_Development_Roadmap.md) dosyasına bakın.

## 📖 Ek Kaynaklar

- **WARP.md**: Warp AI asistanı için proje kılavuzu
- **Java_Development_Roadmap.md**: Detaylı öğrenme yol haritası
- **Project_1_Library_Management.md**: Aktif proje spesifikasyonu
- **Section Summaries**: Her bölümün Türkçe özeti

## 🤝 Katkıda Bulunma

Bu bir kişisel öğrenme projesidir. Önerileriniz veya geri bildirimleriniz için issue açabilirsiniz.

## 📝 Lisans

Bu proje eğitim amaçlıdır ve açık kaynak olarak paylaşılmaktadır.
