package model;

import javax.persistence.*;
import java.util.InputMismatchException;


@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String alley;
    @Column(name = "house number", nullable = false)
    private short houseNumber;
    @Column(name = "postal code", nullable = false, length = 10, unique = true)
    private String postalCode;
    @Column(name = "phone number", nullable = false, unique = true)
    private String phoneNumber;
    @Column(name = "mobile number", nullable = false, unique = true)
    private String mobileNumber;
    @Transient
    private String email;
    @Column(name = "deleted", nullable = false)
    private boolean Deleted;



    @OneToOne(mappedBy = "address",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Person person;



    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) throws IllegalArgumentException {
        if (country.length() == 0) {
            throw new IllegalArgumentException("you must fill this field!");
        } else if (country.length() < 2) {
            throw new IllegalArgumentException("you must enter at least 3 parameter!");
        } else {
            this.country = country;
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws IllegalArgumentException {
        if (city.length() == 0) {
            throw new IllegalArgumentException("you must fill this field!");
        } else if

        (city.length() < 2) {
            throw new IllegalArgumentException("you must enter at least 2 parameter!");
        } else {
            this.city = city;
        }
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) throws IllegalArgumentException {
        if (street.length() == 0) {
            throw new IllegalArgumentException("you must fill this field!");
        } else if (street.length() < 2) {
            throw new IllegalArgumentException("you must enter at least 2 parameter!");
        } else {
            this.street = street;
        }
    }

    public String getAlley() {
        return alley;
    }

    public void setAlley(String alley) throws IllegalArgumentException {
        if (alley.length() == 0) {
            throw new IllegalArgumentException("you must fill this field!");
        } else if (
                alley.trim().length() < 2) {
            throw new IllegalArgumentException("you must enter at least 2 characters");
        } else {
            this.alley = alley;
        }
    }

    public short getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(short numberPlates) throws IllegalArgumentException, InputMismatchException {
        if (numberPlates <= 0) {
            throw new IllegalArgumentException("invalid!");
        } else {
            this.houseNumber = houseNumber;
        }
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) throws IllegalArgumentException {
        if (postalCode.length() == 0) {
            throw new IllegalArgumentException("you must fill this field!");
        } else if (postalCode.length() < 10) {
            throw new IllegalArgumentException("you must enter 10 number!");
        } else {
            this.postalCode = postalCode;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws IllegalArgumentException {
        if (phoneNumber.length() == 0) {
            throw new IllegalArgumentException("you must fill this field!");
        } else if (phoneNumber.length() < 8) {
            throw new IllegalArgumentException("you must enter t 8 number!");
        } else {
            this.phoneNumber = phoneNumber;
        }
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) throws IllegalArgumentException {
        if (mobileNumber.length() == 0) {
            throw new IllegalArgumentException("you must fill this field!");
        } else if (mobileNumber.length() < 11) {
            throw new IllegalArgumentException("you must enter  11 number!");
        } else {
            this.mobileNumber = mobileNumber;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws IllegalArgumentException {

        if (!email.contains("@") || email.startsWith(".") || email.length() == 0) {
            throw new IllegalArgumentException("email is invalid!");
        } else {
            this.email = email;
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
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", alley='" + alley + '\'' +
                ", houseNumber=" + houseNumber +
                ", postalCode='" + postalCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email='" + email + '\'' +
                ", Deleted=" + Deleted +
                '}';
    }
}
