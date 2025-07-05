# 🎓 Kurs ve Kursiyer Yönetim Sistemi | Course & Trainee Management System

## 📌 Proje Açıklaması | Project Description

**TR:**  
Bu proje, Java dilinde yazılmış basit bir kurs ve kursiyer takip sistemidir. `kursiyer.txt` ve `kurs.txt` dosyalarından verileri okuyarak sistemde kurs ve kursiyer kayıtlarını tutar. Kullanıcı terminal menüsü üzerinden kurs/kursiyer ekleme, arama, silme, listeleme gibi işlemleri gerçekleştirebilir. Ayrıca her kursiyerin almış olduğu kurslara göre ödeyeceği toplam ücret hesaplanır.

**EN:**  
This project is a simple course and trainee management system written in Java. It reads data from `kursiyer.txt` and `kurs.txt` and allows the user to manage courses and trainees via a terminal-based menu. Features include adding, listing, searching, and deleting courses or trainees, as well as calculating the total tuition based on the number of enrolled courses.

---

## 🧩 Sınıf Yapısı | Class Structure

| Sınıf / Sınıf Adı     | Açıklama (TR)                                      | Description (EN)                                       |
|------------------------|---------------------------------------------------|--------------------------------------------------------|
| `Kurs`                | Kursun ID ve adını tutar.                         | Holds course ID and name.                              |
| `Kursiyer`            | Kursiyer bilgilerini ve alınan kursları tutar.    | Holds trainee details and their enrolled courses.      |
| `Hesaplama` (interface) | Ödeme hesaplaması metodunu içerir.                | Interface for payment calculation logic.               |
| `AnaSayfa`            | Programın giriş noktası ve menü yapısı.           | Main class with the menu system and logic.             |

---

## 📂 Veri Dosyaları | Data Files

### `kursiyer.txt` örneği:

```
*5050+Ahmet Ada+23
%1000+Futbol
%1040+Masa Tenisi
```

- `*` satırı kursiyer bilgisini temsil eder: `id + ad soyad + yaş`
- `%` satırları bu kursiyerin aldığı kursları temsil eder: `id + kurs adı`

### `kurs.txt` örneği:

```
1000+Futbol
1010+Basketbol
1020+Voleybol
...
```

- Her satır: `kurs ID + kurs adı` biçimindedir.

---

## 📦 Özellikler | Features

- Kurs ve kursiyer **ekleme, silme, arama ve listeleme**
- Kursiyerlerin aldığı kurs sayısına göre **indirimli ödeme hesaplama**
- Veri giriş ve çıkışları **dosya tabanlı** (`kursiyer.txt`, `kurs.txt`)
- **Object-Oriented Programming (OOP)** ile yapılandırılmıştır

---

## 🖥️ Kullanım | How to Run

### Gerekli:
- Java 8+ yüklü olmalıdır.
- `AnaSayfa.java`, `Kurs.java`, `Kursiyer.java`, `Hesaplama.java`, `kursiyer.txt`, `kurs.txt` aynı dizinde olmalıdır.

### Derleme:

```bash
javac AnaSayfa.java Kursiyer.java Kurs.java Hesaplama.java
```

### Çalıştırma:

```bash
java AnaSayfa
```

### Ana Menü:

```text
1 - KURS EKLE
2 - KURS LISTELE
3 - KURS ARA
4 - KURS SIL
5 - KURSIYER EKLE
6 - KURSIYER ARA
7 - KURSIYER SIL
8 - KURSIYERLERI LISTELE
9 - KURSIYERLERI AYRINTILI LISTELE
10 - KURSIYERIN ODEYECEGI TUTARI HESAPLAMA
11 - CIKIS
```

---

## 💰 Ödeme Hesaplama | Payment Calculation

- 1 kurs → 2000 TL  
- 2 kurs → %20 indirim  
- 3 kurs → %25 indirim  
- 3+ kurs → her kurs için %10 indirim uygulanır

---

## 👨‍💻 Geliştirici | Developer

- **Nurullah Yıldırım**
- Öğrenci No: `22100011045`

---

## 📄 Lisans | License

MIT License

---

## 🎓 Not

Bu proje eğitim amaçlıdır. Java'da OOP prensiplerine göre dosya okuma/yazma ve veri işleme mantığını göstermek amacıyla geliştirilmiştir.

> This project is for educational purposes and demonstrates file I/O and OOP-based data processing in Java.