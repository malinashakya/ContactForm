package com.mycompany.contactform.api;

import com.mycompany.contactform.model.Contact;
import com.mycompany.contactform.model.Contactvia;
import com.mycompany.contactform.repository.ContactRepository;
import java.util.Arrays;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
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
import java.util.List;

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
            JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
            for (Contact contact : contacts) {
                JsonObjectBuilder objectBuilder = Json.createObjectBuilder()
                        .add("id", contact.getId())
                        .add("name", contact.getName())
                        .add("address", contact.getAddress())
                        .add("contact", contact.getContact())
                        .add("email", contact.getEmail())
                        .add("message", contact.getMessage())
                        .add("contactVia", contact.getContactVia().name()); // Added this line for Contactvia, other thing same keeping

                arrayBuilder.add(objectBuilder);
            }
            JsonValue jsonResult = arrayBuilder.build();
            return RestResponse.responseBuilder("true", "200", "Contacts retrieved successfully", jsonResult);
        } catch (Exception e) {
            return RestResponse.responseBuilder("false", "500", "An error occurred", Json.createObjectBuilder().add("error", e.getMessage()).build());
        }
    }

    @GET
    @Path("/{id}")
    public Response getContactById(@PathParam("id") Long id) {
        try {
            Contact contact = contactRepository.getById(id);
            if (contact != null) {
                JsonObject jsonResult = Json.createObjectBuilder()
                        .add("id", contact.getId())
                        .add("name", contact.getName())
                        .add("address", contact.getAddress())
                        .add("contact", contact.getContact())
                        .add("email", contact.getEmail())
                        .add("message", contact.getMessage())
                        .add("contactVia", contact.getContactVia().name())// Added this line for Contactvia, other thing same keeping

                        .build();
                return RestResponse.responseBuilder("true", "200", "Contact found", jsonResult);
            } else {
                return RestResponse.responseBuilder("false", "404", "Contact not found", JsonValue.EMPTY_JSON_OBJECT);
            }
        } catch (Exception e) {
            return RestResponse.responseBuilder("false", "500", "An error occurred", Json.createObjectBuilder().add("error", e.getMessage()).build());
        }
    }

    @POST
    public Response createContact(Contact contact) {
        try {
            contactRepository.save(contact);
            JsonObject jsonResult = Json.createObjectBuilder()
                    .add("id", contact.getId())
                    .add("name", contact.getName())
                    .add("address", contact.getAddress())
                    .add("contact", contact.getContact())
                    .add("email", contact.getEmail())
                    .add("message", contact.getMessage())
                    .add("contactVia", contact.getContactVia().name()) // Added this line for Contactvia, other thing same keeping

                    .build();
            return RestResponse.responseBuilder("true", "201", "Contact created successfully", jsonResult);
        } catch (Exception e) {
            return RestResponse.responseBuilder("false", "400", "Failed to create contact", Json.createObjectBuilder().add("error", e.getMessage()).build());
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteContact(@PathParam("id") Long id) {
        try {
            Contact contact = contactRepository.getById(id);
            if (contact != null) {
                contactRepository.delete(id);
                return RestResponse.responseBuilder("true", "204", "Contact deleted successfully", JsonValue.EMPTY_JSON_OBJECT);
            } else {
                return RestResponse.responseBuilder("false", "404", "Contact not found", JsonValue.EMPTY_JSON_OBJECT);
            }
        } catch (Exception e) {
            return RestResponse.responseBuilder("false", "500", "An error occurred", Json.createObjectBuilder().add("error", e.getMessage()).build());
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
                JsonObject jsonResult = Json.createObjectBuilder()
                        .add("id", existingContact.getId())
                        .add("name", existingContact.getName())
                        .add("address", existingContact.getAddress())
                        .add("contact", existingContact.getContact())
                        .add("email", existingContact.getEmail())
                        .add("message", existingContact.getMessage())
                        .add("contactVia", existingContact.getContactVia().name()) // Added this line for Contactvia, other thing same keeping

                        .build();
                return RestResponse.responseBuilder("true", "200", "Contact updated successfully", jsonResult);
            } else {
                return RestResponse.responseBuilder("false", "404", "Contact not found", JsonValue.EMPTY_JSON_OBJECT);
            }
        } catch (Exception e) {
            return RestResponse.responseBuilder("false", "500", "An error occurred", Json.createObjectBuilder().add("error", e.getMessage()).build());
        }
    }

//    http://localhost:8080/ContactForm-1.0-SNAPSHOT/api/contacts/contactvia for api testing
    @GET
    @Path("/contactvia")
    public Response getContactViaOptions() {
        try {
            JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
            Arrays.stream(Contactvia.values()).forEach(contactvia -> arrayBuilder.add(contactvia.name()));
            return Response.ok(arrayBuilder.build()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Json.createObjectBuilder().add("error", e.getMessage()).build())
                    .build();
        }
    }
}
