package edu.uta.courses.web;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by me on 10.2.2015.
 */
public class UserCreateForm {

    private Long userId;

    @NotNull(message="Please select username")
    @Length(min=4, max=10, message="Username should be between 4 - 10 characters.")
    private String userName;

    @NotNull(message="Please select password")
    @Length(min=4, max=64, message="Password should be between 4 - 64 characters.")
    private String password1;

    @NotNull(message="Please give password again")
    @Length(min=4, max=64, message="Password should be between 4 - 64 characters.")
    private String password2;

    @NotNull(message="Please give your first name")
    private String firstName;

    @NotNull(message="Please give your last name")
    private String lastName;

    @NotNull(message="Please give your email")
    private String email;

    @NotEmpty(message="Please give your country")
    private String country;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

}
