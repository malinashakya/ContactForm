/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactform.api;

import com.mycompany.contactform.model.Contact;
import com.mycompany.contactform.repository.ContactRepository;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author malina
 */
@Path("contacts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContactApi {

    @Inject

    private ContactRepository contactRepository;

    @GET
    public Response getAllContacts() {
        try {
            List<Contact> contacts = contactRepository.getAll();
            return RestResponse.responseBuilder("true", "200", "Contacts retrieved successfully", contacts.toString());
        } catch (Exception e) {
            return RestResponse.responseBuilder("false", "500", "An error occurred", e.getMessage());
        }
    }

    @GET
    @Path("/{id}")
    public Response getContactById(@PathParam("id") Long id) {
        try {
            Contact contact = contactRepository.getById(id);
            if (contact != null) {
                return RestResponse.responseBuilder("true", "200", "Contact found", contact.toString());
            } else {
                return RestResponse.responseBuilder("false", "404", "Contact not found", null);
            }
        } catch (Exception e) {
            return RestResponse.responseBuilder("false", "500", "An error occurred", e.getMessage());
        }
    }

    @POST
    public Response createContact(Contact contact) {
        try {
            contactRepository.save(contact);
            return RestResponse.responseBuilder("true", "201", "Contact created successfully", contact.toString());
        } catch (Exception e) {
            return RestResponse.responseBuilder("false", "400", "Failed to create contact", e.getMessage());
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteContact(@PathParam("id") Long id) {
        try {
            Contact contact = contactRepository.getById(id);
            if (contact != null) {
                contactRepository.delete(id);
                return RestResponse.responseBuilder("true", "204", "Contact deleted successfully", null);
            } else {
                return RestResponse.responseBuilder("false", "404", "Contact not found", null);
            }
        } catch (Exception e) {
            return RestResponse.responseBuilder("false", "500", "An error occurred", e.getMessage());
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateContact(@PathParam("id") Long id, Contact contact) {
        try {
            Contact existingContact = contactRepository.getById(id);
            if (existingContact != null) {
                existingContact.setName(contact.getName());
                existingContact.setAddress(contact.getAddress());
                existingContact.setContact(contact.getContact());
                existingContact.setEmail(contact.getEmail());
                existingContact.setMessage(contact.getMessage());
                contactRepository.update(existingContact);
                return RestResponse.responseBuilder("true", "200", "Contact updated successfully", existingContact.toString());
            } else {
                return RestResponse.responseBuilder("false", "404", "Contact not found", null);
            }
        } catch (Exception e) {
            return RestResponse.responseBuilder("false", "500", "An error occurred", e.getMessage());
        }
    }
}
