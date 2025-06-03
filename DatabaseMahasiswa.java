
import java.util.ArrayList;
import java.util.Scanner;

class Mahasiswa {
    String nim;
    String nama;
    String jurusan;

    Mahasiswa(String nim, String nama, String jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
    }
}

public class DatabaseMahasiswa {
    static ArrayList<Mahasiswa> mahasiswaList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("\nMenu Operasi Database Mahasiswa");
            System.out.println("1. Tampilkan Data Mahasiswa");
            System.out.println("2. Input Data Mahasiswa");
            System.out.println("3. Cari Data Mahasiswa");
            System.out.println("4. Ubah Data Mahasiswa");
            System.out.println("5. Hapus Data Mahasiswa");
            System.out.println("6. Exit");
            System.out.print("Pilih menu (1-6): ");
            pilihan = Integer.parseInt(scanner.nextLine());

            switch (pilihan) {
                case 1 -> tampilkanData();
                case 2 -> inputData();
                case 3 -> cariData();
                case 4 -> ubahData();
                case 5 -> hapusData();
                case 6 -> System.out.println("Terima kasih. Program selesai.");
                default -> System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        } while (pilihan != 6);
    }

    static void tampilkanData() {
        if (mahasiswaList.isEmpty()) {
            System.out.println("Data mahasiswa kosong.");
        } else {
            System.out.println("\nDaftar Mahasiswa:");
            for (int i = 0; i < mahasiswaList.size(); i++) {
                Mahasiswa mhs = mahasiswaList.get(i);
                System.out.printf("%d. NIM: %s, Nama: %s, Jurusan: %s\n", i + 1, mhs.nim, mhs.nama, mhs.jurusan);
            }
        }
    }

    static void inputData() {
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Jurusan: ");
        String jurusan = scanner.nextLine();

        mahasiswaList.add(new Mahasiswa(nim, nama, jurusan));
        System.out.println("Data mahasiswa berhasil ditambahkan.");
    }

    static void cariData() {
        System.out.print("Masukkan NIM atau Nama yang dicari: ");
        String keyword = scanner.nextLine().toLowerCase();
        boolean ditemukan = false;

        for (Mahasiswa mhs : mahasiswaList) {
            if (mhs.nim.toLowerCase().contains(keyword) || mhs.nama.toLowerCase().contains(keyword)) {
                System.out.printf("Ditemukan: NIM: %s, Nama: %s, Jurusan: %s\n", mhs.nim, mhs.nama, mhs.jurusan);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Data tidak ditemukan.");
        }
    }

    static void ubahData() {
        System.out.print("Masukkan NIM mahasiswa yang akan diubah: ");
        String nim = scanner.nextLine();

        for (Mahasiswa mhs : mahasiswaList) {
            if (mhs.nim.equals(nim)) {
                System.out.println("Data ditemukan. Masukkan data baru.");
                System.out.print("Nama baru: ");
                mhs.nama = scanner.nextLine();
                System.out.print("Jurusan baru: ");
                mhs.jurusan = scanner.nextLine();
                System.out.println("Data berhasil diubah.");
                return;
            }
        }

        System.out.println("Data dengan NIM tersebut tidak ditemukan.");
    }

    static void hapusData() {
        System.out.print("Masukkan NIM mahasiswa yang akan dihapus: ");
        String nim = scanner.nextLine();

        for (int i = 0; i < mahasiswaList.size(); i++) {
            if (mahasiswaList.get(i).nim.equals(nim)) {
                mahasiswaList.remove(i);
                System.out.println("Data berhasil dihapus.");
                return;
            }
        }

        System.out.println("Data dengan NIM tersebut tidak ditemukan.");
    }
}
