Aplikasi Manajemen Buku
  
  Program ini adalah aplikasi sederhana untuk mengelola data buku yang tersimpan di dalam database PostgreSQL. Aplikasi ini menggunakan JDBC untuk terhubung dengan database, dan menawarkan beberapa fitur seperti menambahkan, menampilkan, menghapus, dan mengupdate data buku.
  
Fitur Utamanya adalah Tambah Data Buku: Pengguna dapat menambahkan data buku ke dalam database; Tampilkan Data Buku: Program menampilkan semua data buku yang tersimpan di dalam database; Hapus Data Buku: Pengguna dapat menghapus data buku berdasarkan ID buku; Update Data Buku: Pengguna dapat mengubah data buku yang sudah ada berdasarkan ID buku.

Program Exception
  
  Program ini merupakan implementasi sederhana dalam Java untuk memvalidasi usia pengguna menggunakan Scanner untuk menerima input dari pengguna. Program ini menggunakan custom exception bernama ExceptionUmur untuk menangani kasus di mana usia pengguna kurang dari 13 tahun. Jika usia pengguna tidak memenuhi syarat, program akan memunculkan pesan error dan menampilkan pesan khusus yang disediakan oleh custom exception.
  
Cara Kerja Program: 1. Pengguna diminta untuk memasukkan usia mereka; 2.Program memvalidasi usia yang dimasukkan. Jika usia kurang dari 13 tahun, akan muncul exception yang menampilkan pesan error; 3. Jika usia sudah sesuai (≥ 13 tahun), program akan menampilkan pesan bahwa usia sesuai dan pengguna dapat melanjutkan; 4. Apapun hasilnya, blok finally akan selalu dijalankan untuk menginformasikan bahwa proses validasi telah selesai.
