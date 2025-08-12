# Section 8: Composition, Encapsulation ve Polymorphism

Bu bölümde OOP'nin önemli kavramlarından olan Composition, Encapsulation ve Polymorphism konuları öğrenildi.

## Öğrenilen Konular

### 1. Composition (Bileşim)
- HAS-A ilişkisi (Inheritance'da IS-A)
- Bir sınıfın başka sınıfları field olarak kullanması
- Daha esnek yapı sağlar
- "Favor composition over inheritance" prensibi

### 2. Encapsulation (Kapsülleme)
- Private fields, public methods
- Data hiding (Veri gizleme)
- Controlled access (Kontrollü erişim)
- Validation mantığı ekleme imkanı

### 3. Composition vs Inheritance
- **Inheritance**: "IS-A" (Bir köpek bir hayvandır)
- **Composition**: "HAS-A" (Bir bilgisayar bir monitöre sahiptir)
- Composition daha az bağımlılık yaratır
- Runtime'da davranış değiştirme imkanı

### 4. Projeler

#### Computer Project
- **PersonalComputer**: Ana sınıf
- **Bileşenler**:
  - ComputerCase (Kasa)
  - Monitor (Ekran)
  - Motherboard (Anakart)
- **Product**: Ortak base class
- Encapsulation ile bileşenlere erişim kontrolü
- powerUp() metodu ile merkezi kontrol

#### Smart Kitchen Project
- **SmartKitchen**: Ana sınıf
- **Bileşenler**:
  - CoffeeMaker (Kahve makinesi)
  - DishWasher (Bulaşık makinesi)
  - Refrigerator (Buzdolabı)
- Her aletin hasWorkToDo state'i
- setKitchenState() ile toplu kontrol
- doKitchenWork() ile otomatik işlem

#### Bedroom Project (Example1)
- **Bedroom**: Ana sınıf
- **Bileşenler**:
  - Bed (Yatak)
  - Ceiling (Tavan)
  - Lamp (Lamba)
  - Wall (4 duvar nesnesi)
- makeBed() ve turnOn() davranışları
- Composition chain: Bedroom -> Lamp -> turnOn()

#### Polymorphism Examples

##### Movie Project
- **Movie**: Base sınıf
- **Alt sınıflar**:
  - Adventure (Macera filmi)
  - Comedy (Komedi filmi)
  - ScienceFiction (Bilim kurgu filmi)
- **Factory Method**: getMovie() ile tip bazlı nesne yaratma
- **Method Overriding**: Her film tipi kendine özel watchMovie() davranışı
- **Runtime Polymorphism**: Aynı referans farklı davranışlar

##### Car Project (Polymorphism)
- **Car**: Base sınıf
- **Alt sınıflar**:
  - GasPoweredCar (Benzinli araç)
  - ElectricCar (Elektrikli araç) 
  - HybridCar (Hibrit araç)
- **Method Overriding**: 
  - startEngine(): Her araç tipi farklı başlatma
  - runEngine(): Her araç tipi farklı çalışma davranışı
- **Hibrit Araç Özellikleri**:
  - Hem batarya hem de silindir bilgisi
  - "Hybrid -> X kWh battery + Y cylinders are starting up!"
  - "Hybrid -> switch X kWh battery + Y km/L usage"

#### Encapsulation Examples
- **Player vs EnhancedPlayer**: 
  - Player: Public fields (kötü pratik)
  - EnhancedPlayer: Private fields, validation, kontrollü erişim
- **Printer**: 
  - Toner seviyesi kontrolü
  - Duplex (çift taraflı) yazdırma
  - Sayfa sayacı

## Composition Avantajları

1. **Esneklik**: Runtime'da bileşenler değiştirilebilir
2. **Modülerlik**: Her bileşen bağımsız geliştirilebilir
3. **Test Edilebilirlik**: Bileşenler ayrı ayrı test edilebilir
4. **Kod Tekrarını Azaltma**: Bileşenler farklı sınıflarda kullanılabilir
5. **Loose Coupling**: Gevşek bağlantı

## Encapsulation Avantajları

1. **Veri Güvenliği**: Direkt erişim engellenir
2. **Validation**: Geçersiz değerler önlenir
3. **Bakım Kolaylığı**: İç implementasyon değişebilir
4. **Debugging**: Tek erişim noktası
5. **Invariant Korunması**: Nesne her zaman geçerli durumda

## Polymorphism Avantajları

1. **Esneklik**: Aynı kod farklı tiplerle çalışabilir
2. **Genişletilebilirlik**: Yeni tipler kolayca eklenebilir
3. **Maintenance**: Tek yerden kontrol
4. **Code Reusability**: Ortak davranışlar base class'ta
5. **Runtime Decision**: Çalışma anında karar verme

## OOP Prensiplerinin Birlikte Kullanımı

### Inheritance + Encapsulation + Polymorphism
- **Inheritance**: Code reuse ve hierarşi
- **Encapsulation**: Data protection ve validation
- **Polymorphism**: Flexible behavior
- **Composition**: Alternative to inheritance

### Best Practices

#### Composition için:
- Her bileşen tek bir sorumluluğa sahip olmalı (Single Responsibility)
- Ana sınıf bileşenleri koordine etmeli
- Null kontrolü yapılmalı
- Builder pattern complex nesneler için düşünülmeli

#### Encapsulation için:
- Tüm field'lar private olmalı
- Getter/Setter'larda validation yapılmalı
- Immutable nesneler tercih edilmeli
- Method isimleri anlamlı olmalı
- Internal state dışarı sızdırılmamalı

### Polymorphism için:
- Method overriding dikkatli yapılmalı
- Base class metodları protected olabilir
- Factory pattern complex object creation için
- instanceof kullanımından kaçınılmalı
- Switch expressions modern yaklaşım

## Düzeltilen Hatalar
1. **EnhancedPlayer.java**: 
   - health > 100 durumunda healthPercentage atanmıyordu
   - FullName değişkeni Java konvansiyonlarına uygun fullName yapıldı
2. **SmartKitchen.java**: 
   - "Brewing cafee" yazım hatası "Brewing coffee" olarak düzeltildi

## Önemli Noktalar

- Composition, inheritance'a göre daha esnek bir yaklaşımdır
- Encapsulation ile nesne tutarlılığı garanti edilir
- Her iki konsept beraber kullanıldığında güçlü OOP tasarımı elde edilir
- "Tell, Don't Ask" prensibi uygulanmalı
- Law of Demeter (minimum bilgi prensibi) göz önünde bulundurulmalı