/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas4;

import java.util.Scanner;

// Custom Exception
class ExceptionUmur extends Exception {

    public ExceptionUmur(String tampil) {
        super(tampil);
    }
}

class ExceptionUmurTest {

    // Method untuk cek usia
    public static void cekUmur(int umur) throws ExceptionUmur {
        if (umur < 13) {
            //ngasih pengecualian kalau umur kurang dari 13
            throw new ExceptionUmur("Usia harus mencapai 13 tahun dulu ya!");
        } else {
            System.out.println("Yey, usia sesuai! Silakan melanjutkan");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Masukkan usia Anda: ");
            int umur = scanner.nextInt();

            //manggil method cekUmur untuk memvalidasi usia
            cekUmur(umur);
        } catch (ExceptionUmur peringatan) {
            //menangkap pengecualian dan menampilkan pesan kesalahan
            System.out.println("Waduh, maaf nih usia kamu masih belum sesuai >_< ");
            System.out.println(peringatan.getMessage());
        } finally {
            //finally selalu dijalankan
            System.out.println("Proses validasi selesai.");
        }

        scanner.close();
    }
}
