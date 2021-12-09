package dao;

        import model.Person;
        import model.Book;
        import org.hibernate.HibernateException;
        import org.hibernate.Session;
        import org.hibernate.Transaction;
        import java.util.List;

public class PersonDao {

    public void save(Person person){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.save(person);
            transaction.commit();
        }catch (HibernateException exception){
            if (transaction != null){
                transaction.rollback();
            }
            exception.printStackTrace();
        }
    }

    public List<Person> readAll(Long id){

        Transaction transaction=null;
        List<Person>persons=null;
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            persons = session.createQuery("FROM Person ").list();
            transaction.commit();
        }catch (HibernateException exception){
            if (transaction!=null){
                transaction.rollback();
            }
            exception.printStackTrace();
        }
        return persons;
    }

    public void delete(Long id){

        Transaction transaction=null;
        try (Session session =HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            Person person=session.get(Person.class,id);
            session.delete(person);
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
            Person person=session.get(Person.class,id);
            session.update(person);
            transaction.commit();
        }catch (HibernateException exception){
            if (transaction != null){
                transaction.rollback();
            }
            exception.printStackTrace();
        }
    }

}


