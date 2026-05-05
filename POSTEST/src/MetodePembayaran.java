public class MetodePembayaran {
    public void bayar(double nominal){
        System.out.println(" Memproses pembayaran umum sebesar Rp" + nominal + "...");
    }
}

class Ewallet extends MetodePembayaran{
    @Override
    public void bayar(double nominal){
        System.out.println(" Memproses pembayaran umum sebesar Rp" + nominal + "...");
    }

    public void bayar(double nominal, String nomorHp){
        System.out.println(" Memotong saldo E-Wallet sebesar Rp" + nominal + " dari nomor" + nomorHp + "...");
    }
}

class KartuKredit extends MetodePembayaran{
     public void bayar(double nominal){
        System.out.println(" Memproses pembayaran umum sebesar Rp" + nominal + "...");
    }

    public void verifikasiPIN(){
        System.out.println(" Memverifikasi PIN Kartu Kredit...BERHASIL!");
    }
}

