package model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Person  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String family;
    @Column(name = "father's name", nullable = false)
    private String fathersName;
    @Column(name = "gender", nullable = false)
    private Gender gender;
    @Column(name = " date of birth", nullable = false)
    private Date dateOfBirth;
    @Column(name = "national code", nullable = false, unique = true, length = 10)
    private String nationalCode;
    @Column(name = " education level", nullable = false)
    private String educationLevel;
    @Column(nullable = false)
    private String job;
    @Column(name = "deleted", nullable = false)
    private boolean Deleted;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "Address_id",nullable = false)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_fk")
    private Collection<Book> books = new ArrayList<>();


    public enum Gender {
        male, female
    }

    public Person() {
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

        if (name.length() == 0 ) {
            throw new IllegalArgumentException("you must fill this field!");
        }  else if(name.length() < 3) {
            throw new IllegalArgumentException(" you must enter at least 3 characters!");
        } else {
            this.name = name;
        }
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {

        if (family.length() == 0 ){
            throw new IllegalArgumentException("you must fill this field!");
        }
            else if( family.length() < 3) {
            throw new IllegalArgumentException(" you must enter at least 3 characters!");
        } else {
            this.family = family;
        }
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {

        if (gender != Gender.male & gender != Gender.female) {
            throw new IllegalArgumentException("invalid information!\n");
        } else {
            this.gender = gender;
        }
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        if (fathersName.length() == 0 ){
            throw new IllegalArgumentException("you must fill this field!");
        }
          else if(fathersName.length() < 3) {
            throw new IllegalArgumentException(" you must enter at least 3 characters!");
        } else {
            this.fathersName = fathersName;
        }
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        if (dateOfBirth.equals(0)) {
            throw new IllegalArgumentException(" you must fill this filed!");
        } else {
            this.dateOfBirth = dateOfBirth;
        }
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {

        if (nationalCode.length() == 0 ){
            throw new IllegalArgumentException("you must fill this field!");
        }
        else if(nationalCode.length() != 10) {
            throw new IllegalArgumentException(" you must enter 10 characters!");
        } else {
            this.nationalCode = nationalCode;
        }
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        if (educationLevel.length() == 0 ){
            throw new IllegalArgumentException("you must fill this field!");
        }
        else if (educationLevel.length() < 4) {
            throw new IllegalArgumentException(" you must enter at least 4 characters!");
        } else {
            this.educationLevel = educationLevel;
        }
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        if (job.length() == 0 ){
            throw new IllegalArgumentException("you must fill this field!");
        }
        else if(job.length() < 4) {
            throw new IllegalArgumentException("you must enter at least 4 characters!");
        } else {
            this.job = job;
        }
    }

    public boolean isDeleted() {
        return Deleted;
    }

    public void setDeleted(boolean deleted) {
        Deleted = deleted;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", fathersName='" + fathersName + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", nationalCode='" + nationalCode + '\'' +
                ", educationLevel='" + educationLevel + '\'' +
                ", job='" + job + '\'' +
                ", Deleted=" + Deleted +
                ", address=" + address +
                '}';
    }
}
