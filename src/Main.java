import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Mesafe (KM): ");
        int mesafe = scanner.nextInt();
        System.out.print("Yaşınız: ");
        int yas = scanner.nextInt();
        System.out.print("Yolculuk tipini seçiniz (1: Tek Yön, 2: Gidiş-Dönüş): ");
        int yolculukTipi = scanner.nextInt();

        // Geçerli veri kontrolü
        if (mesafe <= 0 || yas <= 0 || (yolculukTipi != 1 && yolculukTipi != 2)) {
            System.out.println("Hatalı Veri Girdiniz !");
            return;
        }

        // 100 yaş ve üzeri için uyarı
        if (yas >= 100) {
            System.out.println("Uçağa binmeniz risklidir!");
            return; // Uyarı verildiği için işlem sonlandırılıyor
        }

        // Normal Tutar Hesaplama
        double normalTutar = mesafe * 0.10;

        // Yaş İndirimi
        double yasIndirimi = 0;
        if (yas < 12) {
            yasIndirimi = normalTutar * 0.50; // %50 indirim
        } else if (yas >= 12 && yas <= 24) {
            yasIndirimi = normalTutar * 0.10; // %10 indirim
        } else if (yas >= 65) {
            yasIndirimi = normalTutar * 0.30; // %30 indirim
        }

        // İndirimli Tutar
        double indirimliTutar = normalTutar - yasIndirimi;

        // Gidiş-Dönüş İndirimi
        if (yolculukTipi == 2) {
            indirimliTutar *= 0.80; // %20 indirim
        }

        // Toplam Tutar
        if (yolculukTipi == 2) {
            System.out.println("Toplam Tutar: " + (indirimliTutar * 2) + " TL");
        } else {
            System.out.println("Toplam Tutar: " + indirimliTutar + " TL");
        }
    }
}
