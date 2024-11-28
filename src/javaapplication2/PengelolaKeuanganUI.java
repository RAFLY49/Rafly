import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PengelolaKeuanganUI extends JFrame {
    private PengelolaKeuangan pengelola = new PengelolaKeuangan();

    private JLabel lblDeskripsi, lblJumlah, lblTransaksi;
    private JTextField txtDeskripsi, txtJumlah;
    private JButton btnTambahPemasukan, btnTambahPengeluaran, btnLihatTransaksi, btnLihatSaldo;
    private JTextArea txtAreaTransaksi;
    private JScrollPane scrollPane;

    public PengelolaKeuanganUI() {
        setTitle("Aplikasi Pengelola Keuangan Pribadi");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        lblDeskripsi = new JLabel("Deskripsi:");
        lblDeskripsi.setBounds(20, 20, 100, 25);
        add(lblDeskripsi);

        txtDeskripsi = new JTextField();
        txtDeskripsi.setBounds(120, 20, 200, 25);
        add(txtDeskripsi);

        lblJumlah = new JLabel("Jumlah:");
        lblJumlah.setBounds(20, 60, 100, 25);
        add(lblJumlah);

        txtJumlah = new JTextField();
        txtJumlah.setBounds(120, 60, 200, 25);
        add(txtJumlah);

        btnTambahPemasukan = new JButton("Tambah Pemasukan");
        btnTambahPemasukan.setBounds(20, 100, 150, 25);
        add(btnTambahPemasukan);

        btnTambahPengeluaran = new JButton("Tambah Pengeluaran");
        btnTambahPengeluaran.setBounds(180, 100, 150, 25);
        add(btnTambahPengeluaran);

        btnLihatTransaksi = new JButton("Lihat Transaksi");
        btnLihatTransaksi.setBounds(20, 140, 150, 25);
        add(btnLihatTransaksi);

        btnLihatSaldo = new JButton("Lihat Saldo");
        btnLihatSaldo.setBounds(180, 140, 150, 25);
        add(btnLihatSaldo);

        lblTransaksi = new JLabel("Daftar Transaksi:");
        lblTransaksi.setBounds(20, 180, 150, 25);
        add(lblTransaksi);

        txtAreaTransaksi = new JTextArea();
        txtAreaTransaksi.setEditable(false);
        scrollPane = new JScrollPane(txtAreaTransaksi);
        scrollPane.setBounds(20, 210, 340, 120);
        add(scrollPane);

        btnTambahPemasukan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String deskripsi = txtDeskripsi.getText();
                double jumlah = Double.parseDouble(txtJumlah.getText());
                pengelola.tambahTransaksi(deskripsi, jumlah, "Pemasukan");
                JOptionPane.showMessageDialog(null, "Pemasukan berhasil ditambahkan.");
                txtDeskripsi.setText("");
                txtJumlah.setText("");
            }
        });

        btnTambahPengeluaran.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String deskripsi = txtDeskripsi.getText();
                double jumlah = Double.parseDouble(txtJumlah.getText());
                pengelola.tambahTransaksi(deskripsi, jumlah, "Pengeluaran");
                JOptionPane.showMessageDialog(null, "Pengeluaran berhasil ditambahkan.");
                txtDeskripsi.setText("");
                txtJumlah.setText("");
            }
        });

        btnLihatTransaksi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtAreaTransaksi.setText("");
                for (Transaksi transaksi : pengelola.getDaftarTransaksi()) {
                    txtAreaTransaksi.append(transaksi.toString() + "\n");
                }
            }
        });

        btnLihatSaldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Saldo Saat Ini: Rp " + pengelola.getSaldo());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PengelolaKeuanganUI frame = new PengelolaKeuanganUI();
            frame.setVisible(true);
        });
    }
}
