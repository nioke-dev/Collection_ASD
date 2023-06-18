package percobaan;

import java.util.*;

public class ListMahasiswa {
    List<Mahasiswa> mahasiswas = new ArrayList<>();

    public void tambah(Mahasiswa... mahasiswa){
        mahasiswas.addAll(Arrays.asList(mahasiswa));
    }

    public void hapus(int index){
        mahasiswas.remove(index);
    }

    public void update(int index, Mahasiswa mhs){
        mahasiswas.set(index, mhs);
    }

    public void tampil(){
        mahasiswas.stream().forEach(mhs -> {
            System.out.println("" + mhs.toString());
        });
    }

    int liniearSearch(String nim){
        for (int i = 0; i < mahasiswas.size(); i++){
            if (nim.equals(mahasiswas.get(i).nim)){
                return i;
            }
        }
        return -1;
    }

    int binarySearch(String nim) {
        sortAscending();
        List<String> nimList = new ArrayList<>();
        for (Mahasiswa mhs : mahasiswas) {
            nimList.add(mhs.nim);
        }
        return Collections.binarySearch(nimList, nim);
    }

    public void sortAscending() {
        Collections.sort(mahasiswas, new Comparator<Mahasiswa>() {
            public int compare(Mahasiswa m1, Mahasiswa m2) {
                return m1.nim.compareTo(m2.nim);
            }
        });
    }

    public void sortDescending() {
        Collections.sort(mahasiswas, new Comparator<Mahasiswa>() {
            public int compare(Mahasiswa m1, Mahasiswa m2) {
                return m2.nim.compareTo(m1.nim);
            }
        });
    }
    public static void main(String[] args) {
        ListMahasiswa lm = new ListMahasiswa();
        Mahasiswa m1 = new Mahasiswa("201235", "Akhleema", "021xx2");
        Mahasiswa m2 = new Mahasiswa("201236", "Shannum", "021xx3");
        Mahasiswa m = new Mahasiswa("201234", "Noureen", "021xx1");

        // Menambahkan Objek Mahasiswa
        lm.tambah(m1, m2, m);
        // Menampilkan List Mahasiswa
        lm.tampil();
        // update mahasiswa
//        lm.update(lm.liniearSearch("201235"), new Mahasiswa("201235", "Akhlema Lela", "021xx2"));
        lm.update(lm.binarySearch("201235"), new Mahasiswa("201235", "Akhlema Lela", "021xx2"));

        System.out.println("");
        lm.tampil();
    }
}

