package Section7.OOPpart1.example;

public class Rectangle {
    // Alanlar (fields)
    private double width;
    private double length;

    // Yapıcı metot (constructor)
    public Rectangle(double width, double length) {
        // Genişlik negatifse 0 olarak ayarla
        this.width = (width < 0) ? 0 : width;
        // Uzunluk negatifse 0 olarak ayarla
        this.length = (length < 0) ? 0 : length;
    }

    // Genişlik değerini döndüren metot
    public double getWidth() {
        return width;
    }

    // Uzunluk değerini döndüren metot
    public double getLength() {
        return length;
    }

    // Dikdörtgenin alanını hesaplayıp döndüren metot
    public double getArea() {
        return width * length;
    }
}
