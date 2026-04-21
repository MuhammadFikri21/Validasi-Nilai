package HtcLabs;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class nilaimhs_array_regex {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> listNama = new ArrayList<>();
        ArrayList<String> listNim = new ArrayList<>();
        ArrayList<Integer> listNilai = new ArrayList<>();
        int pilihan = 0;

        String polaNama = "^[a-zA-Z\\s]{3,}$";
        String polaNim = "^\\d{13}$";
        String polaNilai = "^(100|[1-9]?[0-9])$";

        while (pilihan != 4) {
            System.out.println("\n===== MENU PENGOLAHAN NILAI MAHASISWA =====");
            System.out.println("1. Input Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Hasil Statistik");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            if (pilihan == 1) {
                System.out.println("\n--- Input Data ---");

                String nama;
                while (true) {
                    System.out.print("Masukkan Nama: ");
                    nama = input.nextLine();
                    if (Pattern.matches(polaNama, nama)) {
                        break;
                    }
                    System.out.println("(!) Nama tidak valid (Hanya huruf, min 3).");
                }

                String nim;
                while (true) {
                    System.out.print("Masukkan NIM: ");
                    nim = input.nextLine();
                    if (Pattern.matches(polaNim, nim)) {
                        break;
                    }
                    System.out.println("(!) NIM tidak valid (13 digit angka).");
                }

                String nilaiStr;
                while (true) {
                    System.out.print("Masukkan Nilai (0-100): ");
                    nilaiStr = input.nextLine();
                    if (Pattern.matches(polaNilai, nilaiStr)) {
                        break;
                    }
                    System.out.println("(!) Nilai tidak valid (Input angka 0-100).");
                }

                listNama.add(nama);
                listNim.add(nim);
                listNilai.add(Integer.parseInt(nilaiStr));
                System.out.println("Data berhasil disimpan!");

            } else if (pilihan == 2) {
                if (listNama.isEmpty()) {
                    System.out.println("Belum ada data.");
                } else {
                    System.out.println("\n--------------------------------------------------");
                    System.out.printf("| %-3s | %-15s | %-13s | %-5s |\n", "No", "Nama", "NIM", "Nilai");
                    System.out.println("--------------------------------------------------");
                    for (int i = 0; i < listNama.size(); i++) {
                        System.out.printf("| %-3d | %-15s | %-13s | %-5d |\n",
                                (i + 1), listNama.get(i), listNim.get(i), listNilai.get(i));
                    }
                    System.out.println("--------------------------------------------------");
                }

            } else if (pilihan == 3) {
                if (listNilai.isEmpty()) {
                    System.out.println("Belum ada data untuk dihitung.");
                } else {
                    int sum = 0, max = listNilai.get(0), min = listNilai.get(0);
                    for (int n : listNilai) {
                        sum += n;
                        if (n > max) {
                            max = n;
                        }
                        if (n < min) {
                            min = n;
                        }
                    }
                    double average = (double) sum / listNilai.size();

                    System.out.println("\n========== HASIL STATISTIK ==========");
                    System.out.println("Jumlah Mahasiswa : " + listNilai.size());
                    System.out.println("Nilai Rata-rata  : " + average);
                    System.out.println("Nilai Tertinggi  : " + max);
                    System.out.println("Nilai Terendah   : " + min);
                }
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
