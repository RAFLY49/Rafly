import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PengelolaKeuangan {

    public void tambahTransaksi(Transaksi transaksi) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            session.save(transaksi);
            tx.commit();
            System.out.println("Transaksi berhasil ditambahkan.");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<Transaksi> getDaftarTransaksi() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Transaksi> transaksiList = session.createQuery("FROM Transaksi", Transaksi.class).list();
        session.close();
        return transaksiList;
    }
}
