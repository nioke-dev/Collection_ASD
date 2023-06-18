package tugas;

import java.util.*;

public class MahasiswaMain {
    static List<Mahasiswa> mahasiswas = new ArrayList<>();
    static List<MataKuliah> Matkuls = new ArrayList<>();
    static List<Nilai> nilais = new ArrayList<>();


    public void tambahMahasiswa(Mahasiswa... mahasiswa){
        mahasiswas.addAll(Arrays.asList(mahasiswa));
    }

    public void tambahMatkul(MataKuliah... matakuliah){
        Matkuls.addAll(Arrays.asList(matakuliah));
    }

    public void inputNilai(Nilai... nilai){
        nilais.addAll(Arrays.asList(nilai));
    }

    

    public void hapus(int index){
        mahasiswas.remove(index);
    }

    public void update(int index, Mahasiswa mhs){
        mahasiswas.set(index, mhs);
    }

    public void tampilMahasiswa(){
        System.out.println("DAFTAR MAHASISWA");
        System.out.println("===============================================");        
        System.out.println("NIM\t\tNAMA\t\t\tTELP");
        mahasiswas.stream().forEach(mhs -> 
            System.out.printf("%-16s%-24s%-16s%n", mhs.nim, mhs.nama, mhs.notelp)    
        );
    }

    public void tampilMatkul(){
        System.out.println("DAFTAR MATA KULIAH");
        System.out.println("===============================================");        
        System.out.println("KODE\t\tMATA KULIAH\t\t\t\t\t\tSKS");
        Matkuls.stream().forEach(mk -> 
            System.out.printf("%-16s%-56s%-16s%n", mk.kode, mk.matkul, mk.sks)    
        );
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

    public void inputNilaiRow(String kode, String nama, String matkul, int sks, double nilai){
        
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
        
                    

//         // Menampilkan List Mahasiswa
//         lm.tampil();
//         // update mahasiswa
// //        lm.update(lm.liniearSearch("201235"), new Mahasiswa("201235", "Akhlema Lela", "021xx2"));
//         lm.update(lm.binarySearch("201235"), new Mahasiswa("201235", "Akhlema Lela", "021xx2"));

//         System.out.println("");
//         lm.tampil();

        System.out.println("===============================================");
        System.out.println("SISTEM PENGOLAHAN DATA NILAI MAHASISWA SEMESTER");
        System.out.println("===============================================");
        System.out.println("\n1. Input Nilai");
        System.out.println("2. Tampil Nilai");
        System.out.println("3. Mencari Nilai Mahasiswa");
        System.out.println("4. Urut Data Nilai");
        System.out.println("5. keluar");
        System.out.println("===============================================");
        System.out.print("pilih : ");
        int pilih = sc.nextInt();


        switch (pilih){
            case 1 :
                //code block
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
                System.out.println(mahasiswa.nim);
                

            case 2 :
                //code block
                System.out.println();
        }
        
        sc.close();
        scString.close();
    }
}
