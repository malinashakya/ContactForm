package com.mycompany.contactform.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Represents contact information with various fields.
 */
@Entity
@Table(name = "contact_info")
public class Contact implements Serializable {

    public Contact() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @Size(min = 2, max = 20, message = "Name should be at least 2 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name should be a valid string")
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @Column(name = "address", nullable = false)
    @NotEmpty(message = "Address cannot be empty.")
    private String address;

    @Column(name = "contact", unique = true, nullable = true)
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact must be exactly 10 digits")
    private String contact;

    @Column(name = "email", unique = true, nullable = true)
    @Email(message = "Email must be a valid email address")
    private String email;

    @Column(name = "message", nullable = false)
    @NotEmpty(message = "Message cannot be empty.")
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(name = "contact_via", nullable = false)
    private Contactvia contactVia;

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
        this.contact = (contact!=null && contact.isEmpty())?null:contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = (email!=null && email.isEmpty())?null:email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Contactvia getContactVia() {
        return contactVia;
    }

    public void setContactVia(Contactvia contactVia) {
        this.contactVia = contactVia;
    }

    public Contact(String name, String address, String contact, String email, String message, Contactvia contactVia) {
        this.name = name;
        this.address = address;
        this.contact = (contact!=null && contact.isEmpty())?null:contact;
        this.email = (email!=null && email.isEmpty())?null:email;
        this.message = message;
        this.contactVia = contactVia;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "id=" + id
                + ", name=" + name
                + ", address=" + address
                + ", contact=" + contact
                + ", email=" + email
                + ", message=" + message
                + ", contactVia=" + contactVia
                + '}';
    }

}
