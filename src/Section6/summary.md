# Section 6: Kullanıcı Girişi ve Scanner

Bu bölümde kullanıcıdan veri alma ve Scanner sınıfının kullanımı öğrenildi.

## Öğrenilen Konular

### 1. Scanner Sınıfı
- `Scanner` import etme: `import java.util.Scanner;`
- Scanner nesnesi oluşturma: `new Scanner(System.in)`
- Farklı veri tiplerini okuma metodları

### 2. Input Metodları
- `nextLine()`: String okuma
- `nextInt()`: Integer okuma
- `nextDouble()`: Double okuma
- `next()`: Tek kelime okuma

### 3. Input Validasyonu
- Kullanıcı girdilerini kontrol etme
- Try-catch ile hata yönetimi
- `NumberFormatException` yakalama
- Do-while döngüsü ile geçerli girdi alma

### 4. Pratik Uygulamalar
- **Main1.java**: Yaş hesaplama ve validasyon
- **area.java**: Alan hesaplama uygulaması
- **example.java**: Temel input örnekleri
- **example2.java**: Gelişmiş input senaryoları

## Önemli Noktalar

- Scanner'ı kullandıktan sonra `close()` metoduyla kapatmak iyi bir pratiktir
- `nextLine()` kullanırken buffer temizleme sorunlarına dikkat edin
- Input validasyonu her zaman yapılmalı
- Kullanıcıya açık ve anlaşılır mesajlar verilmeli
- Hatalı girdilerde program çökmemeli, kullanıcıya tekrar şans verilmeli