import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Session;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class LaporanKeuangan {

    public static void buatLaporan() {
        try {
            // Mendapatkan data transaksi dari Hibernate
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<Transaksi> transaksiList = session.createQuery("FROM Transaksi", Transaksi.class).list();

            // Memuat template laporan
            InputStream reportStream = LaporanKeuangan.class.getResourceAsStream("/TransaksiReport.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(reportStream);

            // Kompilasi template ke .jasper
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

            // DataSource untuk laporan
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(transaksiList);
            HashMap<String, Object> parameters = new HashMap<>(); // Parameter tambahan (jika diperlukan)

            // Mengisi laporan
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            // Menampilkan laporan
            JasperViewer.viewReport(jasperPrint, false);

            // Menyimpan laporan ke PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, "LaporanTransaksi.pdf");

            System.out.println("Laporan berhasil dibuat!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}