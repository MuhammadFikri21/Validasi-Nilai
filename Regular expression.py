import re

def main():
    print("=== Sistem Input Nilai Mahasiswa ===")
    
    try:
        n = int(input("Masukkan jumlah mahasiswa: "))
    except ValueError:
        print("Harus masukkan angka!")
        return

    daftar_nilai = []

    pola_nama = r"^[a-zA-Z\s]{3,}$"
    pola_nim = r"^\d{13}$"
    pola_nilai = r"^(100|[1-9]?[0-9])$"

    for i in range(n):
        print(f"\n--- Data Mahasiswa ke-{i+1} ---")

        while True:
            nama = input("Masukkan Nama: ")
            if re.match(pola_nama, nama):
                break
            print("(!) Nama tidak valid (Hanya huruf, min 3 karakter).")

        while True:
            nim = input("Masukkan NIM: ")
            if re.match(pola_nim, nim):
                break
            print("(!) NIM tidak valid (13 digit angka).")

        while True:
            nilai_str = input("Masukkan Nilai (0-100): ")
            if re.match(pola_nilai, nilai_str):
                nilai_angka = int(nilai_str)
                daftar_nilai.append(nilai_angka)
                break
            print("(!) Nilai tidak valid (Masukkan angka 0-100).")

    if daftar_nilai:
        total = sum(daftar_nilai)
        rata_rata = total / n
        tertinggi = max(daftar_nilai)
        terendah = min(daftar_nilai)

        print("\n" + "="*20)
        print("      HASIL")
        print("="*20)
        print(f"Nilai rata-rata : {rata_rata:.2f}")
        print(f"Nilai tertinggi : {tertinggi}")
        print(f"Nilai terendah  : {terendah}")

if __name__ == "__main__":
    main()