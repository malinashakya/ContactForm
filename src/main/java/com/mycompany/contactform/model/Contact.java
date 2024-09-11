/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactform.model;

/**
 *
 * @author malina
 */
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "contact_info")
public class Contact implements Serializable {

    public Contact() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @Size(min = 2, max = 20, message = "name should be at least 2 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "name should be a valid string")
    @NotEmpty(message = "name cannot be empty")
    private String name;

    @Column(name = "address", nullable = false)
    @NotEmpty(message = "Address cannot be empty")
    private String address;

    @Column(name = "contact", nullable = false, unique = true)
    @Size(min = 10, max = 10, message = "Contact number should be 10 digits")
    @NotEmpty(message = "Contact cannot be empty")
    private String contact;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Email must be a valid email address")
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @Column(name = "message", nullable = false, unique = true)
    private String message;

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
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Contact(String name, String address, String contact, String email, String message) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.message = message;
    }

    //For proper display in the API
    @Override
    public String toString() {
        return "Customer{"
                + "id=" + id
                + ", name=" + name
                + ", address=" + address
                + ", contact=" + contact
                + ", email=" + email
                + ", message=" + message
                + '}';
    }

}
