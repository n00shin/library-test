package dao;

        import model.Address;
        import org.hibernate.HibernateException;
        import org.hibernate.Session;
        import org.hibernate.Transaction;
        import java.util.List;

public class AddressDao {

    public void save(Address address){

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.save(address);
            transaction.commit();
        } catch (HibernateException exception) {

            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
    }


    public List<Address> readAll() {
        List<Address>addresses= null;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            addresses = session.createQuery("FROM Address ").list();
            transaction.commit();
        } catch (HibernateException exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
        return addresses;
    }

    public void delete(Long id){

        Transaction transaction = null;
        try (Session session =HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            Address address=session.get(Address.class,id);
            session.delete(address);
            transaction.commit();
        }catch (HibernateException exception){
            if (transaction != null){
                transaction.rollback();
            }
            exception.printStackTrace();
        }
    }


    public void update(Long id){

        Transaction transaction = null;

        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            Address address=session.get(Address.class,id);
            session.update(address);
            transaction.commit();
        }catch (HibernateException exception){
            if (transaction != null){
                transaction.rollback();
            }
            exception.printStackTrace();
        }
    }

}
