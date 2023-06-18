package tugas;

public class Nilai {
    String kode;
    String nim;
    String nama;
    String matkul;
    int sks;
    double nilai;

    public Nilai(){

    }

    public Nilai(String kode, String nim, String nama, String matkul, int sks, double nilai){
        this.kode = kode;
        this.nim = nim;
        this.nama = nama;
        this.matkul = matkul;
        this.sks = sks;
        this.nilai = nilai;
    }

    @Override
    public String toString() {
        return "Nilai{" + "kode=" + kode + ", nama=" + nama + ", matkul=" + matkul + ", sks=" + sks + ", nilai=" + nilai + '}';
    }
}
