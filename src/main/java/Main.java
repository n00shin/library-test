import dao.*;
import model.*;
import service.*;
import org.hibernate.Session;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        RegisterOperation registerOperation=new RegisterOperation();
        SearchOperation searchOperation=new SearchOperation();

        try {
            byte controller=0;
            while (!(controller==3)){
                byte menu= CustomInput.byteInput("please choose:\n 1.register\n 2.search\n 3.exit");
                switch (menu){
                    case 1:
                        registerOperation.register();
                        break;
                    case 2:
                        searchOperation.search();
                        break;
                    case 3:
                        controller=3;
                        break;
                    default:
                        byte e=CustomInput.byteInput("number entered is invalid\n" +
                                "do you have another request?\n1.yes\n2.no ");
                        switch (e){
                            case 1:
                                continue;
                            case 2:
                                controller=3;
                                break;
                        }
                }
            }

        }catch (InputMismatchException inputMismatchException) {

            System.out.println("you enter wrong phrase");
            inputMismatchException.printStackTrace();

        }catch (IllegalArgumentException illegalArgumentException) {

            illegalArgumentException.getMessage();
            illegalArgumentException.printStackTrace();

        }catch (Exception exception){
            exception.printStackTrace();
        }


       Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // add new Person object
        Person person = new Person();
        person.setName("ali");
        person.setFamily("alavi");
        person.setFathersName("reza");
        person.setGender(Person.Gender.male);
        person.setDateOfBirth(person.getDateOfBirth());
        person.setNationalCode("0123456789");
        person.setEducationLevel("master");
        person.setAddress(person.getAddress());
        person.setDeleted(false);
        PersonDao personDao = new PersonDao();
        personDao.save(person);
        personDao.readAll(person.getId());
        personDao.delete(person.getId());
        session.update(person);
        session.getTransaction().commit();
        HibernateUtil.shutdown();

        // add new Book object
        Book book = new Book();
        book.setName("The Alchemist");
        book.setAuthor("Paulo Coelho");
        book.setType("foreign");
        book.setLanguage("Portuguese");
        book.setSubject("novel");
        book.setGenre("real");
        book.setTranslator("Arash Hejazi");
        book.setPages((short) 156);
        book.setCode(101);
        book.setDeleted(false);
        BookDao bookDao=new BookDao();
        bookDao.save(book);
        bookDao.readAll();
        bookDao.delete(book.getId());
        session.update(book);
        session.getTransaction().commit();
        HibernateUtil.shutdown();

        // add new Address object
        Address address=new Address();
        address.setCountry("Iran");
        address.setCity("Isfahan");
        address.setStreet("mehrdad");
        address.setAlley("bahar");
        address.setHouseNumber((short) 12);
        address.setPostalCode("1236547890");
        address.setPhoneNumber("85236998");
        address.setMobileNumber("09133082703");
        address.setEmail("ali.alavi@gail.com");
        address.setDeleted(false);
        AddressDao addressDao=new AddressDao();
        addressDao.save(address);
        addressDao.readAll();
        addressDao.delete(address.getId());
        session.update(address);
        session.getTransaction().commit();
        HibernateUtil.shutdown();

    }
}