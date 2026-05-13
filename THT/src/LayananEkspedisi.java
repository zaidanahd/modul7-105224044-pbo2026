public class LayananEkspedisi {
    // Protected agar variabel bisa diakses langsung oleh kelas anak
    protected String nomorResi;
    protected double beratAktualKg, panjang, lebar, tinggi;

    public LayananEkspedisi(String nomorResi, double beratAktualKg, double panjang, double lebar, double tinggi) {
        this.nomorResi = nomorResi;
        this.beratAktualKg = beratAktualKg;
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi; 
    }

    // Metode untuk menghitung berat berdasarkan volume (P x L x T / 6000)
    // Menggunakan Math.max untuk mengambil nilai terbesar antara berat asli vs volumetrik
    public double hitungBeratEfektif() {
         double beratVolumetrik = (panjang * lebar * tinggi) / 6000;
         
        return Math.max(beratAktualKg, beratVolumetrik);
    }

    public void cetakResi(){
         System.out.println("Nomor Resi: " + nomorResi);
         System.out.println("Berat Efektif: " + hitungBeratEfektif() + " Kg");
    }

     public double hitungOngkir() {
        
        return 0.0;
    }
}

class LayananReguler extends LayananEkspedisi{
    public LayananReguler(String nomorResi, double beratAktualKg, double panjang, double lebar, double tinggi){
        super(nomorResi, beratAktualKg, panjang, lebar, tinggi);
    }

    //buat ngeganti cara hitung ongkir khusus reguler
    @Override
    public double hitungOngkir(){
        return hitungBeratEfektif() * 15000;
    }

    //ini bagian overloading dengan menggunakan metode yang sama tapi parameternya beda, pake tambahan fitur member dan jarak 
     public double hitungOngkir(boolean isMember, int jarakKm) {
        double tarifDasar = hitungOngkir();
        if (isMember) {
            tarifDasar -= (0.1 * tarifDasar);// Diskon 10% kalo member
        }
        return tarifDasar + (500 * jarakKm);// Tambahin ongkir per jarak
    }
}

class LayananExpress extends LayananEkspedisi {
    public LayananExpress(String nomorResi, double beratAktualKg, double panjang, double lebar, double tinggi) {
        super(nomorResi, beratAktualKg, panjang, lebar, tinggi); //mengambil parameter dari parentnya menggunakan super
    }
    //overriding untuk tarif express lebih mahal
    @Override
    public double hitungOngkir() {
        return hitungBeratEfektif() * 30000;
    }

    public void klaimAsuransi(double nilaiBarang) {
        if (nilaiBarang > 1000000) { //bagian ini dijalankan kalo barang bernilai lebih dari 1jt
            System.out.println("Klaim Asuransi VIP Rp" + nilaiBarang + " untuk resi " + nomorResi + " sedang diproses prioritas.");
        } else { //Dijalankan kalo nilai barang sama dengan atau di bawah 1 Juta Rupiah.
            System.out.println("Klaim Asuransi Standar diproses dalam 7 hari kerja.");
        }
    }
}

class LayananInternasional extends LayananEkspedisi {
    String negaraTujuan;
    double nilaiBarangUSD;

    public LayananInternasional(String nomorResi, double beratAktualKg, double panjang, double lebar, double tinggi, String negaraTujuan, double nilaiBarangUSD) {
        super(nomorResi, beratAktualKg, panjang, lebar, tinggi);
        this.negaraTujuan = negaraTujuan;
        this.nilaiBarangUSD = nilaiBarangUSD;
    }

    @Override
    public double hitungOngkir() {
        double ongkirDasar = hitungBeratEfektif() * 200000;
        double pajak = (nilaiBarangUSD > 50) ? (0.2 * ongkirDasar) : 0; // kalo nilai barang di atas 50 USD, kena pajak 20%
        return ongkirDasar + pajak;
    }
    //Menampilkan manifest pengiriman luar negeri
    public void cetakManifest() {
        System.out.println("Manifest Internasional ke " + negaraTujuan + " - Deklarasi Nilai: $" + nilaiBarangUSD);
    }
}
