package fr.digicar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    /** The identifier of the user. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /** The user gender. */
    @Column(name = "gender")
    private String gender;

    /** The user first name. */
    @Column(name = "first_name")
    private String firstName;

    /** The user last name. */
    @Column(name = "last_name")
    private String lastName;

    /** The user last name */
    @Column(name = "email")
    private String email;

    /** The user password. */
    @Column(name = "password")
    private String password;

    /** The user password confirmation. Only used for password confirmation on password change. */
    @Transient
    private String passwordConfirm;

    /** The user main address line. */
    @Column(name = "address_line_1")
    private String addressLine1;

    /** The user complementary address line. */
    @Column(name = "address_line_2")
    private String addressLine2;

    /** The user zip code. */
    @Column(name = "zip_code")
    private String zipCode;

    /** The user city. */
    @Column(name = "city")
    private String city;

    /** The user phone number. */
    @Column(name = "phone_number")
    private String phoneNumber;

    /** The user birth date. */
    @Column(name = "birthdate")
    private Date birthdate;

    /** The user birth date in string format. Only used to get input from JSP form. */
    @Transient
    private String birthdateString;

    /** The sign up date of the client. */
    @Column(name = "signup_date")
    private Date signUpDate;

    public int getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getBirthdateString() {
        return birthdateString;
    }

    public Date getSignUpDate() {
        return signUpDate;
    }

    public UserStatus getStatus() {
        return status;
    }

    /** The status of the client. */

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private UserStatus status;

}
