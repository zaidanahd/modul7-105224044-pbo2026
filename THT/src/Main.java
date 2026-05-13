import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //List tipe Bapak (LayananEkspedisi) bisa nampung semua jenis Anak
        ArrayList<LayananEkspedisi> listLayanan = new ArrayList<>();

        // Upcasting dengan memasukkan data ke ArrayList
        listLayanan.add(new LayananReguler("REG-11", 2, 50, 50, 50));
        listLayanan.add(new LayananExpress("EXP-22", 5, 10, 10, 10));
        listLayanan.add(new LayananInternasional("INT-33", 3, 20, 20, 20, "Korea", 100));

        double totalPendapatanPerusahaan = 0.0; //variabel total pendapatan perusahaan untuk hitung pendapatan dari ongkir tiap paket

        //perulangan untuk mencetak resi tiap paket 
        for (LayananEkspedisi layanan : listLayanan) {
            layanan.cetakResi();//guna memanggil fungsi cetak resi 
            totalPendapatanPerusahaan += layanan.hitungOngkir();

            // Downcasting kalau memenuhi syarat percabangan
             if (layanan instanceof LayananReguler) {
                LayananReguler reg = (LayananReguler) layanan;
                System.out.println("Harga Member (Jarak 25km): Rp" + reg.hitungOngkir(true, 25));
            } else if (layanan instanceof LayananExpress) {
                ((LayananExpress) layanan).klaimAsuransi(1500000);
            } else if (layanan instanceof LayananInternasional) {
                ((LayananInternasional) layanan).cetakManifest();
            }
        }

        System.out.println("Total pendapatan perusahaan sebesar : Rp" + totalPendapatanPerusahaan);
    }
}
