# Aplikasi Pendataan Buku dengan Fitur CRUD ⚡
Aplikasi ini merupakan program Java yang digunakan untuk mengelola data buku dalam database PostgreSQL. Aplikasi ini memungkinkan pengguna untuk menambah, menampilkan, menghapus, dan memperbarui data buku yang tersimpan di database.
## Features 📚
1. ➕ [Insert (Create)](https://github.com/Ifaa513/PBO4CRUD/blob/main/Tugas4.java)
Pengguna dapat memasukkan data buku baru berupa ID buku, judul buku, pengarang, penerbit, dan tahun terbit. Setelah memilih pilihan "tidak" pada pertanyaan ""Apakah Anda ingin memasukkan data buku lainnya?" maka data yang telah diinput akan disimpan ke dalam tabel buku di database PostgreSQL.
2. 🔎 [Tampil (Read)](https://github.com/Ifaa513/PBO4CRUD/blob/main/Tugas4.java)
Fungsi tampil() digunakan untuk menampilkan seluruh data buku yang ada di dalam tabel buku.
3. 🔄 [Update](https://github.com/Ifaa513/PBO4CRUD/blob/main/Tugas4.java)
Pengguna dapat memperbarui informasi buku, baik judul, pengarang, penerbit, dan tahun terbit berdasarkan ID buku yang telah dipilih.
4. 🗑️ [Delete](https://github.com/Ifaa513/PBO4CRUD/blob/main/Tugas4.java)
Pengguna dapat menghapus data buku berdasarkan ID buku yang telah dimasukkan.
## Cara Kerja 🤖
### 1. Koneksi ke Database 🔗
Program ini menggunakan JDBC untuk menghubungkan dengan database PostgreSQL, dimana driver PostgreSQL (org.postgresql.Driver) menghubungkan aplikasi dengan database bernama PBO4.
### 2. Operasi CRUD ✨
Dengan operasi CRUD setiap perubahan data baik penambahan, penghapusan, dan pembaruan dilakukan dalam satu transaksi, dalam program ini komit otomatis dinonaktifkan untuk mencegah kehilangan data saat terjadi kesalahan.
### 3. BufferedReader 👀
BufferedReader digunakan untuk mengumpulkan data yang telah diinputkan pengguna, dimana dengan ini, program dapat mengambil input yang dimasukkan secara interaktif dari konsol.
## Cara Kerja
Cara Menjalankan Program:
1. Memastikan PostgreSQL terinstal dan berjalan di komputer.
2. Buat database bernama PBO4 dan tabel buku dengan struktur yang sesuai.
3. Jalankan program menggunakan IDE Java atau terminal.
4. Program akan meminta input dari pengguna untuk menjalankan berbagai operasi seperti tambah, tampil, hapus, atau update data buku.

# Exception Program 🚀
