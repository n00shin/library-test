package service;

import java.util.*;
import dao.BookDao;
import model.Book;


public class SearchOperation {

    public void search() throws InputMismatchException {
        //perform various searches
        String terminate = "no";
        do {
            byte search = CustomInput.byteInput("choose an option:\n 1.book search\n 2.exit\n");
            switch (search) {
                case 1:
                    searchBook();
                    break;
                case 2:
                    terminate = Exit.exit();
                    break;
                default:
                    System.out.println("wrong number!\nyou get out!");
                    terminate = Exit.exit();
            }
            break;

        } while (terminate.equals("no"));

    }

    //**********************************************************************
    //book search based on various indicator:
    private void searchBook() {

        BookDao bookDao = null;
        String terminate;
        List<Book> library = bookDao.readAll();
        do {
            terminate = "no";
            byte option = CustomInput.byteInput("\nsearch by:\n 1.book name \n 2.book Author\n 3.by type\n 4.by genre\n " +
                    "5.by pages\n 6.code\n 7.exit\n");
            switch (option) {
                case 1:
                    searchName(library);
                    break;
                case 2:
                    searchAuthor(library);
                    break;
                case 3:
                    searchType(library);
                    break;
                case 4:
                    searchGenre(library);
                    break;
                case 5:
                    SearchPages(library);
                case 6:
                    searchCode(library);
                    break;
                case 7:
                    terminate = Exit.exit();
                    break;
                default:
                    System.out.println("wrong number");
                    break;
            }

        } while (terminate.equals("no"));

    }

    private void searchName(List<Book> library) throws InputMismatchException, IllegalArgumentException {

        String n = CustomInput.stringInput("please enter the word you want");
        int count1 = 0;
        for (Book a1 : library) {
            if (a1.getName().contains(n)) {
                System.out.print(a1.getName());
                System.out.println("-" + a1.getCode());
                count1++;
            }
        }
        if (count1 == 0) {
            System.out.print("does not exist");
        }
    }

    private void searchAuthor(List<Book> library) throws InputMismatchException, IllegalArgumentException {

        String w = CustomInput.stringInput("please enter the word you want");
        int count2 = 0;
        for (Book a2 : library) {
            if (a2.getAuthor().contains(w)) {
                System.out.print(a2.getName());
                System.out.println("-" + a2.getCode());
                count2++;
            }
        }
        if (count2 == 0) {
            System.out.print("does not exist\n");
        }
    }

    private void searchType(List<Book> library) throws InputMismatchException, IllegalArgumentException {

        String s = CustomInput.stringInput("please enter the word you want");
        int count3 = 0;
        for (Book a3 : library) {
            if (a3.getType().contains(s)) {
                System.out.print(a3.getName());
                System.out.println("-" + a3.getCode());
                count3++;
            }
        }
        if (count3 == 0) {
            System.out.print("does not exist");
        }
    }

    private void searchGenre(List<Book> library) throws InputMismatchException, IllegalArgumentException {

        String g = CustomInput.stringInput("please enter the word you want");
        int count4 = 0;
        for (Book a4 : library) {
            if (a4.getGenre().contains(g)) {
                System.out.print(a4.getName());
                System.out.println("-" + a4.getCode());
                count4++;
            }
        }
        if (count4 == 0) {
            System.out.print("does not exist");
        }
    }

    private void SearchPages(List<Book> library) {
        int pe = CustomInput.byteInput("please choose option:\n 1.more than \n 2.less than\n");
        int count2 = 0;
        int p = CustomInput.intInput("please enter the number you want");
        for (Book a : library) {
            switch (pe) {
                case 1:
                    if (a.getPages() >= p) {
                        System.out.print(a.getName());
                        count2++;
                    }
                    break;
                case 2:
                    if (a.getPages() <= p) {
                        System.out.print(a.getName());
                        count2++;
                    }
                    break;
                default:
                    System.out.println("wrong number");
                    break;
            }
            if (count2 == 0) {
                System.out.println("does not exist");
            }

        }
    }

    private void searchCode(List<Book> library) throws InputMismatchException, IllegalArgumentException {

        int n1 = CustomInput.intInput("please enter the code you want");
        int count7 = 0;
        for (Book a7 : library) {
            if (a7.getCode() == n1) {
                System.out.print(a7.getName());
                System.out.println("-" + a7.getCode());
                count7++;
            }
        }
        if (count7 == 0) {
            System.out.print("does not exist");
        }
    }


}
