# Section 8: Composition (Bileşim)

Bu bölümde OOP'nin önemli kavramlarından biri olan Composition öğrenildi.

## Öğrenilen Konular

### 1. Composition Nedir?
- HAS-A ilişkisi (Inheritance'da IS-A)
- Bir sınıfın başka sınıfları field olarak kullanması
- Daha esnek yapı sağlar
- "Favor composition over inheritance" prensibi

### 2. Composition vs Inheritance
- **Inheritance**: "IS-A" (Bir köpek bir hayvandır)
- **Composition**: "HAS-A" (Bir bilgisayar bir monitöre sahiptir)
- Composition daha az bağımlılık yaratır
- Runtime'da davranış değiştirme imkanı

### 3. Projeler

#### Computer Project
- **PersonalComputer**: Ana sınıf
- **Bileşenler**:
  - ComputerCase (Kasa)
  - Monitor (Ekran)
  - Motherboard (Anakart)
- **Product**: Ortak base class
- Encapsulation ile bileşenlere erişim kontrolü

#### Smart Kitchen Project
- **SmartKitchen**: Ana sınıf
- Akıllı mutfak aletlerinin yönetimi
- Her aletin kendi özellikleri ve metodları
- Merkezi kontrol sistemi

#### Bedroom Project
- **Bedroom**: Ana sınıf
- **Bileşenler**:
  - Bed (Yatak)
  - Ceiling (Tavan)
  - Lamp (Lamba)
  - Wall (Duvar)
- Her bileşenin kendi davranışları

## Composition Avantajları

1. **Esneklik**: Runtime'da bileşenler değiştirilebilir
2. **Modülerlik**: Her bileşen bağımsız geliştirilebilir
3. **Test Edilebilirlik**: Bileşenler ayrı ayrı test edilebilir
4. **Kod Tekrarını Azaltma**: Bileşenler farklı sınıflarda kullanılabilir
5. **Loose Coupling**: Gevşek bağlantı

## Önemli Noktalar

- Composition, inheritance'a göre daha esnek bir yaklaşımdır
- Her bileşen kendi sorumluluğuna sahip olmalı
- Ana sınıf, bileşenleri koordine etmeli
- Private fields ve public metodlar ile encapsulation sağlanmalı
- Null kontrolü yapılmalı
- Builder pattern ile complex nesneler oluşturulabilir