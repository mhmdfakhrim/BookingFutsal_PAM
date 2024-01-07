# Final Project Pengembangan Aplikasi Mobil 2024
## Project Name
### BookingFutsal
## Project Description
#### Aplikasi ini dirancang untuk user yang ingin menyewa lapangan futsal, sehingga para user tidak perlu lagi ke tempat langsung untuk menyewa lapangan futsal. Aplikasi ini dikembangkan dengan Firebase sebagai backend service nya menggunakan 2 fitur Firebase yaitu; 1. Cloud Firestore sebagai database untuk menyimpan data pemesanan. 2. Authentication untuk mengautentikasi pengguna ke aplikasi BookingFutsal. Fungsi lebih rinci dapat dilihat dalam use case diagram dibawah ini.
## Use Case
![Use Case BookingFutsal](https://github.com/mhmdfakhrim/BookingFutsal_PAM/assets/106448800/069bf00f-8f36-4e1c-a632-f5e541af9785)
- Signup (Daftar Akun): Pengguna dapat mendaftarkan akun agar bisa mengakses fungsi aplikasi BookingFutsal
- Login (Masuk Aplikasi): Pengguna yang sudah mempunyai akun dapat masuk ke aplikasi menggunakan email dan password yang sudah di daftarkan sebelumnya.
- Logout (Keluar Aplikasi): Pengguna dapat mengeluarkan akun dari aplikasi.
- Pesan Lapangan: Pengguna masuk ke halaman pemesanan yang berisi form pemesanan untuk diisi.
- Mengisi Form Pemesanan: Pengguna dapat mengisi form yang terdiri dari nomor pemesanan, nama, alamat, telpon, tanggal, pilih lapangan, jam bermain, dan jam masuk lapangan.
- Konfirmasi Pemesanan: Pengguna dapat mengkonfirmasi pemesanan yang sudah diisi sebelumnya agar tersimpan di database.
- Cek Pemesanan: Pengguna dapat mengecek pemesanan yang sudah dikonfirmasi sebelumnya.
- Mengecek Pemesanan: Pengguna dapat melihat pemesanan dengan mengisi nomor pemesanannya dan dapat melihat pemesanan secara detail.
- Edit Pemesanan: Pengguna dapat mengedit pemesanan informasi atau detail pemesanan.
- Batalkan Pemesanan: Pengguna dapat membatalkan pemesanan dan data akan dihapus dari database.
## Pembagian Tugas
- Muhammad Fachri Mubaroq: Tampilan Login, Tampilan Signup, ViewModel, Navigasi
- Ryanda Pratama Putra Wibisono: Tampilan Pesan Lapangan, Tampilan Cek Pemesanan, Tampilan Halaman Home, Logout
