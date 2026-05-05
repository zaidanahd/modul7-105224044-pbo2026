import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<MetodePembayaran> dafMetodePembayarans = new ArrayList<>();

        MetodePembayaran nominal = new Ewallet();
        MetodePembayaran nomorHp = new KartuKredit();

        dafMetodePembayarans.add(nominal);
        dafMetodePembayarans.add(nomorHp);

        for (MetodePembayaran p : dafMetodePembayarans) {
            
            p.bayar(100000);

            if (p instanceof Ewallet) {
                Ewallet ew = (Ewallet) p;
                ew.bayar(100000, "081298765432");
            } 
            // Cek jika objek adalah KartuKredit
            else if (p instanceof KartuKredit) {
                KartuKredit kk = (KartuKredit) p;
                kk.verifikasiPIN();
            }
            System.out.println("-----------------------------------");
        }
    }
}

