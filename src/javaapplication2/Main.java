import java.util.Date;

public class Main {
    public static void main(String[] args) {
        PengelolaKeuangan pengelolaKeuangan = new PengelolaKeuangan();

        // Tambahkan transaksi baru
        Transaksi transaksi = new Transaksi();
        transaksi.setJenisTransaksi("Pemasukan");
        transaksi.setJumlah(150000.00);
        transaksi.setTanggal(new Date());
        pengelolaKeuangan.tambahTransaksi(transaksi);

        // Buat laporan transaksi
        LaporanKeuangan.buatLaporan();
    }
}