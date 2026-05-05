import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<PerangkatPintar> daftarPerangkat = new ArrayList<>();

        PerangkatPintar lampu = new LampuPintar(); 
        PerangkatPintar aC = new AcPintar();

        daftarPerangkat.add(lampu);
        daftarPerangkat.add(aC);

        System.out.println(" [Menjalankan Kontrol Perangkat] ");
        for (PerangkatPintar perangkat : daftarPerangkat) {
            perangkat.aktifkan();
        }

        for (PerangkatPintar perangkat : daftarPerangkat) {
            if (perangkat instanceof AcPintar) {
            // Melakukan Downcasting yang aman
                AcPintar ac = (AcPintar) perangkat;
                ac.aturSuhu(20);
            }
        }

        PerangkatPintar alat1 = new LampuPintar();

        // Melakukan Downcasting agar metode spesifik LampuPintar bisa diakses
        ((LampuPintar) alat1).aturKecerahan(75, "Putih");


    }
}
//analisis no 3
/*singaktanya ini bisa terjadi karena Polimorfisme. Meski kita 
memberikan label yang sama sebagai "Perangkat Pintar", Java tetep 
liat identitas asli objeknya pas program dijalankan. 
kalau objek aslinya adalah Lampu, maka yang dijalankan adalah 
fungsi Lampu. jika AC, maka fungsi AC yang berjalan. 

Jadi, hasilnya selalu mengikuti perilaku asli masing-masing perangkat, 
bukan label kelompoknya. */

//analisis no 5
/* Error cannot find symbol terjadi karena Java Compiler mengecek ketersediaan 
metode berdasarkan tipe referensi variabel, 
bukan berdasarkan tipe objek aslinya.

1. Variabel alat1 dideklarasikan dengan tipe PerangkatPintar.
2. Di dalam kelas PerangkatPintar, tidak ada metode bernama aturKecerahan.
3. Meskipun objek aslinya adalah LampuPintar, compiler "hanya tahu" 
bahwa alat1 adalah sebuah PerangkatPintar umum. 
*/