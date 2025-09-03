# Soyut Sınıflar & Arayüzler Challenge Açıklaması

Bu proje, Java'da soyut sınıfların, somut sınıfların ve arayüzlerin birlikte nasıl kullanılarak farklı veri yapılarının (Bağlı Liste ve İkili Arama Ağacı) oluşturulabileceğini göstermektedir. Proje, aynı temel bileşenleri kullanarak iki farklı veri saklama ve yönetme mantığının nasıl uygulanabileceğini ortaya koyar.

---

## Dosyaların Amacı ve Metotların Detaylı Açıklaması

### `ListItem` (Soyut Sınıf)
Bu, tüm veri yapılarımız için temel yapı taşıdır. Bir listedeki veya ağaçtaki tek bir öğeyi temsil eder.

- **Neden Soyut?**: Çünkü `ListItem` tek başına bir anlam ifade etmez. Nasıl ilerleyeceği (`next()`), nasıl geriye gideceği (`previous()`) ve diğer öğelerle nasıl karşılaştırıldığı (`compareTo()`) gibi davranışların, onu kullanan alt sınıflar (`Node` gibi) tarafından tanımlanması gerekir. Bu, esnek bir yapı sağlar ve ortak özellikleri tek bir yerde toplar.
- **Alanlar**:
  - `protected Object value`: Öğenin taşıdığı gerçek veri (örneğin bir metin veya sayı).
  - `protected ListItem rightLink`: Sonraki veya sağdaki öğeye olan referans.
  - `protected ListItem leftLink`: Önceki veya soldaki öğeye olan referans.
- **Metotlar**:
  - `abstract ListItem next()`: Bir sonraki öğeyi döndürmesi beklenen soyut metot.
  - `abstract ListItem setNext(ListItem item)`: Bir sonraki öğeyi ayarlaması beklenen soyut metot.
  - `abstract ListItem previous()`: Bir önceki öğeyi döndürmesi beklenen soyut metot.
  - `abstract ListItem setPrevious(ListItem item)`: Bir önceki öğeyi ayarlaması beklenen soyut metot.
  - `abstract int compareTo(ListItem item)`: İki `ListItem` öğesini karşılaştırır. Sıralama mantığının temelidir. Pozitif, negatif veya sıfır değeri döndürerek öğelerin göreceli sırasını belirler.
  - `getValue()` & `setValue()`: Öğenin değerini okumak ve değiştirmek için standart getter/setter metotları.

---

### `Node` (Somut Sınıf)
`ListItem` soyut sınıfını genişletir (extends) ve onun soyut metotlarını uygular.

- **Görevi**: `ListItem`'in soyut davranışlarını somutlaştırır. Bu sınıf, `ListItem`'in teorik yapısını gerçek, kullanılabilir bir nesneye dönüştürür.
- **Metotlar**:
  - `next()`: `rightLink` referansını döndürür.
  - `setNext(ListItem item)`: `rightLink` referansını verilen `item` olarak ayarlar.
  - `previous()`: `leftLink` referansını döndürür.
  - `setPrevious(ListItem item)`: `leftLink` referansını verilen `item` olarak ayarlar.
  - `compareTo(ListItem item)`: İki öğenin `value` alanlarını `String` olarak karşılaştırır. Java'nın `String.compareTo()` metodunu kullanarak alfabetik sıralama yapar. Eğer mevcut öğe parametreden büyükse pozitif, küçükse negatif, eşitse sıfır döndürür.

---

### `NodeList` (Arayüz)
Bir veri koleksiyonunun sahip olması gereken temel işlevleri tanımlayan bir sözleşmedir.

- **Neden Arayüz?**: Çünkü hem `MyLinkedList` hem de `SearchTree` temelde birer liste gibi davranır. İkisinin de öğe ekleme, çıkarma, kök öğeyi getirme ve listeyi dolaşma gibi ortak yetenekleri olmalıdır. Bu arayüz, bu iki farklı sınıfın aynı metot imzalarını kullanmasını zorunlu kılarak tutarlı bir yapı oluşturur. Bu sayede, bu sınıflardan oluşturulan nesneler birbirinin yerine kullanılabilir (polimorfizm).
- **Metotlar**:
  - `getRoot()`: Listenin veya ağacın başlangıç noktasını (kök) döndürür.
  - `addItem(ListItem item)`: Koleksiyona yeni bir öğe ekler.
  - `removeItem(ListItem item)`: Koleksiyondan bir öğeyi siler.
  - `traverse(ListItem root)`: Koleksiyonun tüm elemanlarını gezer ve yazdırır.

---

### `MyLinkedList` (Somut Sınıf)
`NodeList` arayüzünü uygulayan bir çift yönlü bağlı liste.

- **Çalışma Mantığı**:
  - **`addItem(ListItem newItem)`**: 
    1. Liste boşsa (`root == null`), yeni öğeyi `root` olarak ayarlar.
    2. Liste doluysa, `root`'tan başlayarak listeyi gezer.
    3. Her adımda `currentItem.compareTo(newItem)` ile karşılaştırma yapar:
       - **`comparison < 0`**: `newItem` daha büyük. `currentItem`'in bir sonraki elemanı varsa (`next() != null`), bir sonraki elemana geçer. Yoksa, `newItem` listenin sonuna eklenir.
       - **`comparison > 0`**: `newItem` daha küçük. `newItem`, `currentItem`'dan önceye eklenmelidir. `currentItem`'ın bir önceki elemanının (`previous()`) `next`'i `newItem`'a, `newItem`'ın `next`'i de `currentItem`'a bağlanır. Eğer `currentItem` `root` ise, `newItem` yeni `root` olur.
       - **`comparison == 0`**: Öğe zaten listede var. Ekleme yapılmaz ve `false` döner.
  - **`removeItem(ListItem item)`**:
    1. Silinecek öğeyi bulmak için liste `root`'tan başlayarak taranır.
    2. Öğe bulunduğunda (`comparison == 0`), öğenin komşularının bağlantıları güncellenerek öğe aradan çıkarılır. Örneğin, `item.previous().setNext(item.next())`.
    3. Eğer silinen öğe `root` ise, `root` bir sonraki eleman olarak güncellenir.
  - **`traverse(ListItem root)`**: Listenin başından (`root`) başlayarak `next()` metodu ile sona kadar tüm öğelerin değerlerini sırayla yazdırır.

---

### `SearchTree` (Somut Sınıf)
`NodeList` arayüzünü uygulayan bir ikili arama ağacı (Binary Search Tree).

- **Çalışma Mantığı**:
  - **`addItem(ListItem newItem)`**: 
    1. Ağaç boşsa, `newItem` `root` olur.
    2. Doluysa, `root`'tan başlanır.
    3. `compareTo` ile karşılaştırma yapılır:
       - **`comparison < 0`**: `newItem` daha büyük. Sağ alt ağaca (`next()`) gidilir. Gidilecek yer boşsa (`null`), `newItem` oraya eklenir.
       - **`comparison > 0`**: `newItem` daha küçük. Sol alt ağaca (`previous()`) gidilir. Gidilecek yer boşsa, `newItem` oraya eklenir.
       - **`comparison == 0`**: Öğe zaten ağaçta var, eklenmez.
  - **`removeItem(ListItem item)`**:
    1. Önce silinecek öğe ve onun ebeveyni (`parent`) ağaçta bulunur.
    2. Bulunduğunda, `performRemoval()` metodu çağrılır.
  - **`performRemoval(ListItem item, ListItem parent)` (private metot)**:
    Bu metot, silme işleminin karmaşıklığını yönetir. Silinecek öğenin durumuna göre üç senaryo vardır:
    1. **Çocuğu Yoksa**: Ebeveynin ilgili dalı (`left` veya `right`) `null` olarak ayarlanır.
    2. **Tek Çocuğu Varsa**: Silinen öğenin yerine tek çocuğu geçer. Ebeveynin ilgili dalı, silinen öğenin çocuğuna bağlanır.
    3. **İki Çocuğu Varsa**: Bu en karmaşık durumdur. Silinen öğenin sağ alt ağacındaki en küçük öğe (veya sol alt ağacındaki en büyük öğe) bulunur. Bu öğe, silinen öğenin yerine kopyalanır ve ardından kopyalanan öğe kendi eski yerinden silinir.
  - **`traverse(ListItem root)`**: Ağacı "in-order" (sol -> kök -> sağ) kuralına göre özyinelemeli (recursive) olarak gezer. Bu gezinme türü sayesinde, ağaçtaki öğeler her zaman sıralı (alfabetik) bir şekilde yazdırılır. Önce sol alt ağacı (`traverse(root.previous())`), sonra kökün değerini, sonra da sağ alt ağacı (`traverse(root.next())`) yazdırır.

## Özet
Bu yapı, **soyutlama** ve **polimorfizm** (çok biçimlilik) kavramlarını mükemmel bir şekilde örnekler. `NodeList` arayüzü sayesinde, `MyLinkedList` veya `SearchTree` nesnelerini aynı türden bir referansla (örneğin `NodeList list = new MyLinkedList(...)`) kullanabiliriz. Bu, kodun daha esnek, modüler ve yönetilebilir olmasını sağlar.
