package tugas4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tugas4 {

    Connection conn;
    Statement stmt;
    PreparedStatement pstmt = null;

    String driver = "org.postgresql.Driver";
    String koneksi = "jdbc:postgresql://localhost:5432/PBO4";
    String user = "postgres";
    String password = "5130";
    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    BufferedReader input = new BufferedReader(inputStreamReader);

    public void tambah() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);
            conn.setAutoCommit(false); // Nonaktifkan otomatis commit

            String sql = "INSERT INTO buku VALUES(?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);

            boolean selesai = false;
            while (!selesai) {
                System.out.println("MASUKKAN DATA BUKU ");
                System.out.print("ID Buku : ");
                String id_buku = input.readLine().trim();
                System.out.print("Judul Buku : ");
                String judul_buku = input.readLine().trim();
                System.out.print("Pengarang : ");
                String pengarang = input.readLine().trim();
                System.out.print("Penerbit : ");
                String penerbit = input.readLine().trim();
                System.out.print("Tahun terbit : ");
                String tahun_terbit = input.readLine().trim();

                pstmt.setLong(1, Long.parseLong(id_buku));
                pstmt.setString(2, judul_buku);
                pstmt.setString(3, pengarang);
                pstmt.setString(4, penerbit);
                pstmt.setLong(5, Long.parseLong(tahun_terbit));
                pstmt.executeUpdate();

                System.out.print("Apakah Anda ingin memasukkan data buku lainnya? (iya/tidak): ");
                String pilihan = input.readLine().trim();
                if (!pilihan.equalsIgnoreCase("iya")) {
                    selesai = true; // Ubah ke true agar loop berhenti jika tidak ingin memasukkan data lagi
                }
            }

            conn.commit(); // Commit transaksi setelah sejumlah operasi-insert berhasil
            pstmt.close();
            conn.close();
            System.out.println("Sukses dalam satu transaksi.");
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            System.out.println("Terjadi kesalahan saat melakukan operasi insert dalam loop.");
            ex.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback(); // Batalkan transaksi jika terjadi kesalahan
                }
            } catch (SQLException e) {
                System.out.println("Gagal melakukan rollback transaksi.");
                e.printStackTrace();
            }
        }
    }

    public void tampil() {
        try {
            // TODO code application logi
            Class.forName(driver);
            String sql = "SELECT * FROM buku";
            conn = DriverManager.getConnection(koneksi, user, password);
            stmt = conn.createStatement();

            while (!conn.isClosed()) {
                ResultSet rs;
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    System.out.println(String.valueOf(rs.getObject(1)) + " " + String.valueOf(rs.getObject(2)) + " " + String.valueOf(rs.getObject(3)) + " " + String.valueOf(rs.getObject(4)));
                }
                conn.close();
            }

            stmt.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Tugas4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Tugas4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hapus() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);

            // Prompt the user for the dogtag of the record they want to delete
            System.out.print("Masukkan ID Buku yang akan dihapus : ");
            String dogtagToDelete = input.readLine().trim();

            // Delete the record from the database
            String deleteSql = "DELETE FROM buku WHERE id_buku = ?";
            pstmt = conn.prepareStatement(deleteSql);
            pstmt.setLong(1, Long.parseLong(dogtagToDelete));
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("ID buku " + dogtagToDelete + " Penghapusan berhasil!");
            } else {
                System.out.println("ID buku" + dogtagToDelete + " tidak ada.");
            }

            pstmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(Tugas4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update() {
        try {
            Class.forName(driver);
            String sql = "UPDATE buku SET judul_buku = ?, pengarang =?, penerbit = ?, tahun_terbit=? WHERE id_buku = ?";
            conn = DriverManager.getConnection(koneksi, user, password);
            pstmt = conn.prepareStatement(sql);

            System.out.print("Masukkan ID buku yang akan diupdate: ");
            String id_buku = input.readLine().trim();
            System.out.print("Judul buku baru: ");
            String judulBukuBaru = input.readLine().trim();
            System.out.print("pengarang baru: ");
            String pengarangBaru = input.readLine().trim();
            System.out.print("penerbit baru: ");
            String penerbitBaru = input.readLine().trim();
            System.out.print("Tahun terbit baru: ");
            String tahunTerbitBaru = input.readLine().trim();

            pstmt.setString(1, judulBukuBaru);
        pstmt.setString(2, pengarangBaru);
        pstmt.setString(3, penerbitBaru);
        pstmt.setLong(4, Long.parseLong(tahunTerbitBaru)); // Perhatikan bahwa parameter ke-4 di-set dengan benar
        pstmt.setLong(5, Long.parseLong(id_buku));

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data berhasil diupdate.");
            } else {
                System.out.println("Data tidak ditemukan.");
            }

            pstmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(Tugas4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void menu() {
        System.out.println("\n========= MENU UTAMA =========");
        System.out.println("1. Input Data");
        System.out.println("2. Tampil Data");
        System.out.println("3. Hapus Data");
        System.out.println("4. Update Data");
        System.out.println("0. keluar");
        System.out.print("PILIHAN> ");

        try {
            int pilihan = Integer.parseInt(input.readLine());
            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    tambah();
                    break;
                case 2:
                    tampil();
                    break;
                case 3:
                    hapus();
                    break;
                case 4:
                    update();
                    break;
                default:
                    System.out.println("Pilihan salah!");
            }
        } catch (IOException ex) {
            Logger.getLogger(Tugas4.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        new Tugas4().menu();
    }

}
