package model;

import javax.persistence.*;
import java.util.InputMismatchException;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "book name", nullable = false, unique = true)
    private String name;
    @Column(name = "author", nullable = false, unique = true)
    private String Author;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String language;
    @Column(nullable = false)
    private String subject;
    @Column(name = "novel genre")
    private String genre;
    private String translator;
    @Column(name = "page number", nullable = false)
    private short pages;
    @Column(name = " book code", nullable = false, unique = true, length = 7)
    private int code;
    @Column(name = "deleted", nullable = false)
    private boolean Deleted;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id",nullable = false)
    private Person person;


    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("you must fill this field!");
        } else if (Author.length() < 2) {
            throw new IllegalArgumentException("you must enter at least 2 characters!");
        } else {
            this.name = name;
        }
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {

        if (Author.length() == 0) {
            throw new IllegalArgumentException("you must fill this field!");
        } else if (Author.length() < 2) {
            throw new IllegalArgumentException("you must enter at least 2 characters!");
        } else {
            this.Author = Author;
        }

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {

        if (language.length() == 0) {
            throw new IllegalArgumentException("you must fill this field!");
        } else if (language.length() < 3) {
            throw new IllegalArgumentException("you must enter at least 3 characters!");
        } else {
            this.language = language;
        }
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        if (subject.length() == 0) {
            throw new IllegalArgumentException("you must fill this field!");
        } else if (subject.length() < 4) {
            throw new IllegalArgumentException("you must enter at least 4 characters!");
        } else {
            this.subject = subject;
        }
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if (genre.length() == 0) {
            throw new IllegalArgumentException("you must fill this field!");
        } else if (genre.length() < 4) {
            throw new IllegalArgumentException("you must enter at least 4 parameter!");
        } else {
            this.genre = genre;
        }

    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        if (translator.length() == 0) {
            throw new IllegalArgumentException("you must fill this field!");
        } else if (translator.length() < 3) {
            throw new IllegalArgumentException("you must enter at least 3 characters!");
        } else {
            this.translator = translator;
        }
    }

    public short getPages() {
        return pages;
    }

    public void setPages(short pages) throws InputMismatchException, InputMismatchException {

        if (pages <= 4) {
            throw new IllegalArgumentException("number of pages must be greater than 4!");
        } else {
            this.pages = pages;
        }

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {

        if (code < 100) {
            throw new IllegalArgumentException("code of book must be greater than 100!");
        } else {
            this.code = code;
        }
    }

    public boolean isDeleted() {
        return Deleted;
    }

    public void setDeleted(boolean deleted) {
        Deleted = deleted;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Author='" + Author + '\'' +
                ", type='" + type + '\'' +
                ", language='" + language + '\'' +
                ", subject='" + subject + '\'' +
                ", genre='" + genre + '\'' +
                ", translator='" + translator + '\'' +
                ", pages=" + pages +
                ", code=" + code +
                ", Deleted=" + Deleted +
                '}';
    }

   
}
