package tugas;

import java.util.*;

public class MahasiswaMain {
    static List<Mahasiswa> mahasiswas = new ArrayList<>();
    static List<MataKuliah> Matkuls = new ArrayList<>();
    static List<Nilai> nilais = new ArrayList<>();
    


    public void tambahMahasiswa(Mahasiswa... mahasiswa) {
        mahasiswas.addAll(Arrays.asList(mahasiswa));
        
    }

    public void tambahMatkul(MataKuliah... matakuliah) {
        Matkuls.addAll(Arrays.asList(matakuliah));
    }

    public void inputNilai(Nilai... nilai) {
        nilais.addAll(Arrays.asList(nilai));        
    }

    public void hapus(int index) {
        mahasiswas.remove(index);
    }

    public void update(int index, Mahasiswa mhs) {
        mahasiswas.set(index, mhs);
    }

    public void tampilMahasiswa() {
        System.out.println("\nDAFTAR MAHASISWA");
        System.out.println("===============================================");
        System.out.println("NIM\t\tNAMA\t\t\tTELP");
        mahasiswas.stream().forEach(mhs -> System.out.printf("%-16s%-24s%-16s%n", mhs.nim, mhs.nama, mhs.notelp));
    }

    public void tampilMatkul() {
        System.out.println("\nDAFTAR MATA KULIAH");
        System.out.println("===============================================");
        System.out.println("KODE\t\tMATA KULIAH\t\t\t\t\t\tSKS");
        Matkuls.stream().forEach(mk -> System.out.printf("%-16s%-56s%-16s%n", mk.kode, mk.matkul, mk.sks));
    }

    public void tampilNilai() {
        System.out.println("\nDAFTAR NILAI");
        System.out.println("===============================================");
        System.out.printf("%-10s%-25s%-30s%-5s%-5s%n", "NIM", "NAMA", "MATA KULIAH", "SKS", "NILAI");
        nilais.stream().forEach(
                ni -> System.out.printf("%-10s%-25s%-30s%-5s%-5s%n", ni.nim, ni.nama, ni.matkul, ni.sks, ni.nilai));
    }

    public void tampilNilaiSearch(String nim) {
        System.out.println("\nDAFTAR NILAI");
        System.out.println("===============================================");
        System.out.printf("%-10s%-25s%-30s%-5s%-5s%n", "NIM", "NAMA", "MATA KULIAH", "SKS", "NILAI");
        nilais.stream().filter(ni -> ni.nim.equals(nim)).forEach(
                ni -> System.out.printf("%-10s%-25s%-30s%-5s%-5s%n", ni.nim, ni.nama, ni.matkul, ni.sks, ni.nilai));
    }

    // Sorting And Searching Mahasiswa
    int liniearSearch(String nim) {
        for (int i = 0; i < mahasiswas.size(); i++) {
            if (nim.equals(mahasiswas.get(i).nim)) {
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

    public void sortDescendingNilai() {
    Collections.sort(nilais, new Comparator<Nilai>() {
        public int compare(Nilai n1, Nilai n2) {
            return Double.compare(n2.nilai, n1.nilai);
        }
    });
}

    // Search For Matkul
    int liniearSearchMatkul(String kode) {
        for (int i = 0; i < Matkuls.size(); i++) {
            if (kode.equals(Matkuls.get(i).kode)) {
                return i;
            }
        }
        return -1;
    }

    public void inputNilaiRow(String kode, String nim, String nama, String matkul, int sks, double nilai) {

        Nilai mk1 = new Nilai(kode, nim, nama, matkul, sks, nilai);
        MahasiswaMain mm = new MahasiswaMain();

        // Menambahkan Objek Nilai
        mm.inputNilai(mk1);
    }

    

    // Metode lain (tambahMahasiswa, tambahMatkul, inputNilai, dll.) tidak ditampilkan untuk kejelasan    

    public void hapusMahasiswa() {
        if (mahasiswas.isEmpty()) {
            System.out.println("Antrian mahasiswa kosong.");
            return;
        }

        // Menghapus mahasiswa pertama dari antrian (Queue)
        Mahasiswa mahasiswa = mahasiswas.get(0);
        mahasiswas.remove(0);

        // Menghapus nilai yang berkaitan
        hapusNilaiByNIM(mahasiswa.nim);
    }

    public void hapusNilaiByNIM(String nim) {
        if (nilais.isEmpty()) {
            System.out.println("Antrian nilai kosong.");
            return;
        }

        List<Nilai> tempNilais = new ArrayList<>();

        // Menghapus nilai yang terkait dengan NIM yang diberikan
        for (Nilai nilai : nilais) {
            if (!nilai.nim.equals(nim)) {
                tempNilais.add(nilai);
            }
        }

        // Mengganti daftar nilai dengan daftar nilai yang baru
        nilais = tempNilais;
    }

    public static void main(String[] args) {
        Scanner scString = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

        MahasiswaMain mm = new MahasiswaMain();
        // Mahasiswa
        Mahasiswa m1 = new Mahasiswa("20001", "Thalhah", "021xxx");
        Mahasiswa m2 = new Mahasiswa("20002", "Zubair", "021xxx");
        Mahasiswa m3 = new Mahasiswa("20003", "Abdur-Rahman", "021xxx");
        Mahasiswa m4 = new Mahasiswa("20004", "Sa'ad", "021xxx");
        Mahasiswa m5 = new Mahasiswa("20005", "Sa'id", "021xxx");
        Mahasiswa m6 = new Mahasiswa("20006", "Ubaidah", "021xxx");

        // Menambahkan Objek Mahasiswa
        mm.tambahMahasiswa(m1, m2, m3, m4, m5, m6);

        // Mata Kuliah
        MataKuliah mk1 = new MataKuliah("00001", "Internet Of Things", 3);
        MataKuliah mk2 = new MataKuliah("00002", "Algoritma dan Struktur Data", 2);
        MataKuliah mk3 = new MataKuliah("00003", "Algoritma Dan Pemrograman", 3);
        MataKuliah mk4 = new MataKuliah("00004", "Praktikum Algoritma Dan Struktur Data", 3);
        MataKuliah mk5 = new MataKuliah("00005", "Praktikum Algoritma Dan Pemrograman", 3);
        mm.tambahMatkul(mk1, mk2, mk3, mk4, mk5);

        // // Menampilkan List Mahasiswa
        // lm.tampil();
        // // update mahasiswa
        // // lm.update(lm.liniearSearch("201235"), new Mahasiswa("201235", "Akhlema
        // Lela", "021xx2"));
        // lm.update(lm.binarySearch("201235"), new Mahasiswa("201235", "Akhlema Lela",
        // "021xx2"));

        // System.out.println("");
        // lm.tampil();

        

        while (true) {
            System.out.println("\n===============================================");
            System.out.println("SISTEM PENGOLAHAN DATA NILAI MAHASISWA SEMESTER");
            System.out.println("===============================================");
            System.out.println("\n1. Input Nilai");
            System.out.println("2. Tampil Nilai");
            System.out.println("3. Mencari Nilai Mahasiswa");
            System.out.println("4. Urut Data Nilai");
            System.out.println("5. Hapus Mahasiswa Konsep QUEUE");
            System.out.println("6. keluar");
            System.out.println("===============================================");
            System.out.print("pilih : ");
            int pilih = sc.nextInt();

            switch (pilih) {
                case 1:
                    // code block
                    System.out.println("Masukkan Data");
                    System.out.print("Kode\t: ");
                    String kodeInput = scString.nextLine();
                    System.out.print("Nilai\t: ");
                    Double nilaiInput = sc.nextDouble();

                    mm.tampilMahasiswa();
                    System.out.print("Pilih Mahasiswa By Nim : ");
                    String pilihMN = scString.nextLine();
                    mm.tampilMatkul();
                    System.out.print("Pilih MK By Kode : ");
                    String pilihMK = scString.nextLine();

                    Mahasiswa mahasiswa = mahasiswas.get(mm.binarySearch(pilihMN));
                    MataKuliah matkul = Matkuls.get(mm.liniearSearchMatkul(pilihMK));

                    // String kode, String nama, String matkul, int sks, double nilai
                    mm.inputNilaiRow(kodeInput, mahasiswa.nim, mahasiswa.nama, matkul.matkul, matkul.sks, nilaiInput);
                    continue;
                case 2:
                    // code block
                    // code untuk tampil Nilai
                    mm.tampilNilai();
                    continue;
                case 3:
                    // Code mencari nilai mahasiswa
                    mm.tampilNilai();
                    System.out.print("Masukkan Data Mahasiswa[nim] : ");
                    String searchMhs = scString.nextLine();

                    System.out.println();
                    // Nilai nilai = nilais.get(mm.binarySearch(searchMhs));
                    mm.tampilNilaiSearch(searchMhs);
                    continue;
                case 4:
                    // code urut data nilai
                    mm.sortDescendingNilai();
                    mm.tampilNilai();
                    continue;
                case 5:
                    mm.hapusMahasiswa();
                    continue;
                case 6: 
                    System.exit(0);
                

            }
        }

        // sc.close();
        // scString.close();
    }
}
