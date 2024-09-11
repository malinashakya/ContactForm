/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactform.model;

/**
 *
 * @author malina
 */

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "contact_info")
public class Contact {
    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    @Size(min = 2, max = 20, message = "Name should be at least 2 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name should be a valid string")
    @NotEmpty(message = "Name cannot be empty")
    private String firstName;

    @Column(name = "address", nullable = false)
    @NotEmpty(message = "Address cannot be empty")
    private String address;

    @Column(name = "contact", nullable = false, unique = true)
    @Size(min = 10, max = 10, message = "Contact number should be 10 digits")
    @NotEmpty(message = "Contact cannot be empty")
    private String contact;

   

    
    //For proper display in the API
    @Override
    public String toString() {
        return "Customer{"
                + "id=" + id
                + ", firstname=" + firstName
                + ", address=" + address
                + ", contact=" + contact
                + '}';
    }

}
