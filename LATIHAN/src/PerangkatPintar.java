public class PerangkatPintar {
    void aktifkan(){
        System.out.println("Perangkat pintar di aktifkan");
    }
}

class LampuPintar extends PerangkatPintar {

    @Override
    void aktifkan(){
        System.out.println(" Lampu menyala dengan tingkat kecerahan standar");
    }

    void aturKecerahan(int level){
        System.out.println(" Kecerahan lampu diatur ke level [" + level + "]%. ");
    }

    void aturKecerahan(int level, String warna){
        System.out.println(" Kecerahan lampu diatur ke level [" + level + "]% dengan cahaya [" + warna + "]. ");
    }
}

class AcPintar extends PerangkatPintar {
    
    @Override
    void aktifkan() {
        System.out.println(" AC menyala dan mulai membandingkan ruangan. ");
    }

    void aturSuhu(int suhu){
        System.out.println(" suhu ruangan diatur menjadi [" + suhu + "] derajat. ");
    }
}
