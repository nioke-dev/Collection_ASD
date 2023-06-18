package tugas;

public class MataKuliah {
    String kode;
    String matkul;
    int sks;

    // public MataKuliah(){

    // }

    public MataKuliah(String kode, String matkul, int sks){
        this.kode = kode;
        this.matkul = matkul;
        this.sks = sks;
    }

    @Override
    public String toString() {
        return "Mata Kuliah{" + "Kode=" + kode + ", Mata Kuliah=" + matkul + ", SKS=" + sks + '}';
    }
}
