package service;

import dao.AddressDao;
import dao.BookDao;
import dao.PersonDao;
import model.Address;
import model.Book;
import model.Person;
import java.util.InputMismatchException;

public class RegisterOperation {

    public void register() throws InputMismatchException, IllegalArgumentException {
        //perform registration of various object:
        byte register;
        String terminate;
        do {
            terminate = "no";
            register = CustomInput.byteInput("choose an option:\n 1.book\n 2.person\n 3.exit");
            switch (register) {
                case 1:
                    bookRegistration();
                    break;
                case 2:
                    personRegistration();
                    break;
                case 3:
                    terminate = Exit.exit();
                    break;
                default:
                    System.out.println("the number entered is invalid! you get out!");
                    terminate = "exit";
            }
        } while (terminate.equals("no"));

    }

    private void bookRegistration() throws InputMismatchException, IllegalArgumentException {
        //register books and save them in a file
        Book book;
        String terminate = "no";
        BookDao bookDao = null;
        while (terminate.equals("no")) {
            book = new Book();
            book.setName(CustomInput.stringInput("please enter information of book:\n name"));
            book.setAuthor(CustomInput.stringInput("Author"));
            book.setSubject(CustomInput.stringInput("subject"));
            if (book.getSubject().equalsIgnoreCase("novel")) {
                book.setGenre(CustomInput.stringInput("genre"));
            }
            byte t = CustomInput.byteInput("type:\n 1.original language\n 2.translated");
            switch (t) {
                case 1:
                    book.setType("original language");
                    book.setLanguage(CustomInput.stringInput("language(english,france,est)"));
                    break;
                case 2:
                    book.setType("translated");
                    book.setTranslator(CustomInput.stringInput("translator"));
                    break;
                default:
                    System.out.println("type is invalid!\n repeat again operation");
                    continue;
            }
            book.setPages((short) CustomInput.intInput("number of pages"));

            byte e = CustomInput.byteInput("do you need to  edit?\n 1.no\n 2.yes");
            switch (e) {
                case 1:
                    bookDao.save(book);
                    terminate = Exit.exit();
                    break;
                case 2:
                    continue;
                default:
                    System.out.println("number entered is wrong\n choose again operation!");
                    terminate = "exit";

            }

        }
    }

    /*
    ----------------------------------------
    register information of persons:
     */
    private void personRegistration() throws InputMismatchException, IllegalArgumentException {

        String terminate = "no";
        Person person;
        PersonDao personDao = null;
        while (terminate.equals("no")) {
            person = new Person();
            person.setName(CustomInput.stringInput("please enter your information:\n name"));
            person.setFamily(CustomInput.stringInput("family"));
            person.setFathersName(CustomInput.stringInput("father's name"));
            person.setGender(Person.Gender.valueOf("gender"));
            person.setDateOfBirth(person.getDateOfBirth());
            person.setNationalCode(CustomInput.stringInput("national code"));
            person.setEducationLevel(CustomInput.stringInput("please enter education level"));
            person.setJob(CustomInput.stringInput("job"));
            person.setAddress(addressRegistration());

            byte p = CustomInput.byteInput("do you want to edit?\n 1.no\n 2.yes");
            switch (p) {
                case 1:
                    personDao.save(person);
                    terminate = Exit.exit();
                    break;
                case 2:
                    continue;
                default:
                    System.out.println("number entered is wrong\n choose again operation!");
                    terminate = Exit.exit();

            }
        }

    }

    /*
     ----------------------------------------------
       get the address from the user
       */
    private Address addressRegistration() throws IllegalArgumentException, InputMismatchException {
        Address address;
        address = new Address();
        String terminate = "no";
        AddressDao addressDao = null;
        while (terminate.equalsIgnoreCase("no")) {
            address.setCountry(CustomInput.stringInput("please enter your address:\ncountry"));
            address.setCity(CustomInput.stringInput("city"));
            address.setStreet(CustomInput.stringInput("street"));
            address.setAlley(CustomInput.stringInput("alley"));
            address.setHouseNumber(CustomInput.byteInput(" hause number"));
            address.setPostalCode(CustomInput.stringInput("postal Code"));
            address.setPhoneNumber(CustomInput.stringInput("phone Number"));
            address.setMobileNumber(CustomInput.stringInput("mobile Number"));
            System.out.println("Email address(optional)");
            byte e = CustomInput.byteInput(" do you want enter Email address?\n 1.yes\n 2.no");
            if (e == 1) {
                address.setEmail(CustomInput.stringInput("Email"));
            }
            byte p = CustomInput.byteInput("do you want to edit?\n 1.no\n 2.yes");
            switch (p) {
                case 1:
                    addressDao.save(address);
                    break;
                case 2:
                    continue;
                default:
                    System.out.println("Your information was not save");
                    terminate = Exit.exit();
            }
        }
        return address;
    }

}
