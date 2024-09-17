/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactform.api;

/**
 *
 * @author malina
 */

import com.mycompany.contactform.model.NumberForm;
import com.mycompany.contactform.repository.NumberFormRepository;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * API for managing NumberForm entities.
 */
@Path("numbers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NumberFormApi {

    @Inject
    private NumberFormRepository numberFormRepository;

    @GET
    public Response getAllNumberForms() {
        try {
            List<NumberForm> numberForms = numberFormRepository.getAll();
            JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
            for (NumberForm numberForm : numberForms) {
                JsonObjectBuilder objectBuilder = Json.createObjectBuilder()
                        .add("id", numberForm.getId())
                        .add("intnum", numberForm.getIntnum())
                        .add("nogroupintnum", numberForm.getNogroupintnum())
                        .add("minmaxfractdigit", numberForm.getMinmaxfractdigit())
                        .add("minmaxboundary", numberForm.getMinmaxboundary())
                        .add("doublenum", numberForm.getDoublenum())
                        .add("user_locale", numberForm.getUser_locale())
                        .add("us_locale", numberForm.getUs_locale())
                        .add("german_locale", numberForm.getGerman_locale())
                        .add("indian_locale", numberForm.getIndian_locale())
                        .add("currency", numberForm.getCurrency())
                        .add("prefiix", numberForm.getPrefiix())
                        .add("suffix", numberForm.getSuffix())
                        .add("stacked", numberForm.getStacked())
                        .add("minmax", numberForm.getMinmax())
                        .add("horizontal_with_step", numberForm.getHorizontal_with_step())
                        .add("vertical_with_step", numberForm.getVertical_with_step());

                arrayBuilder.add(objectBuilder);
            }
            JsonValue jsonResult = arrayBuilder.build();
            return RestResponse.responseBuilder("true", "200", "Number forms retrieved successfully", jsonResult);
        } catch (Exception e) {
            return RestResponse.responseBuilder("false", "500", "An error occurred", Json.createObjectBuilder().add("error", e.getMessage()).build());
        }
    }

    @GET
    @Path("/{id}")
    public Response getNumberFormById(@PathParam("id") Long id) {
        try {
            NumberForm numberForm = numberFormRepository.getById(id);
            if (numberForm != null) {
                JsonObject jsonResult = Json.createObjectBuilder()
                        .add("id", numberForm.getId())
                        .add("intnum", numberForm.getIntnum())
                        .add("nogroupintnum", numberForm.getNogroupintnum())
                        .add("minmaxfractdigit", numberForm.getMinmaxfractdigit())
                        .add("minmaxboundary", numberForm.getMinmaxboundary())
                        .add("doublenum", numberForm.getDoublenum())
                        .add("user_locale", numberForm.getUser_locale())
                        .add("us_locale", numberForm.getUs_locale())
                        .add("german_locale", numberForm.getGerman_locale())
                        .add("indian_locale", numberForm.getIndian_locale())
                        .add("currency", numberForm.getCurrency())
                        .add("prefiix", numberForm.getPrefiix())
                        .add("suffix", numberForm.getSuffix())
                        .add("stacked", numberForm.getStacked())
                        .add("minmax", numberForm.getMinmax())
                        .add("horizontal_with_step", numberForm.getHorizontal_with_step())
                        .add("vertical_with_step", numberForm.getVertical_with_step())
                        .build();
                return RestResponse.responseBuilder("true", "200", "Number form found", jsonResult);
            } else {
                return RestResponse.responseBuilder("false", "404", "Number form not found", JsonValue.EMPTY_JSON_OBJECT);
            }
        } catch (Exception e) {
            return RestResponse.responseBuilder("false", "500", "An error occurred", Json.createObjectBuilder().add("error", e.getMessage()).build());
        }
    }

    @POST
    public Response createNumberForm(NumberForm numberForm) {
        try {
            numberFormRepository.save(numberForm);
            JsonObject jsonResult = Json.createObjectBuilder()
                    .add("id", numberForm.getId())
                    .add("intnum", numberForm.getIntnum())
                    .add("nogroupintnum", numberForm.getNogroupintnum())
                    .add("minmaxfractdigit", numberForm.getMinmaxfractdigit())
                    .add("minmaxboundary", numberForm.getMinmaxboundary())
                    .add("doublenum", numberForm.getDoublenum())
                    .add("user_locale", numberForm.getUser_locale())
                    .add("us_locale", numberForm.getUs_locale())
                    .add("german_locale", numberForm.getGerman_locale())
                    .add("indian_locale", numberForm.getIndian_locale())
                    .add("currency", numberForm.getCurrency())
                    .add("prefiix", numberForm.getPrefiix())
                    .add("suffix", numberForm.getSuffix())
                    .add("stacked", numberForm.getStacked())
                    .add("minmax", numberForm.getMinmax())
                    .add("horizontal_with_step", numberForm.getHorizontal_with_step())
                    .add("vertical_with_step", numberForm.getVertical_with_step())
                    .build();
            return RestResponse.responseBuilder("true", "201", "Number form created successfully", jsonResult);
        } catch (Exception e) {
            return RestResponse.responseBuilder("false", "400", "Failed to create number form", Json.createObjectBuilder().add("error", e.getMessage()).build());
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteNumberForm(@PathParam("id") Long id) {
        try {
            NumberForm numberForm = numberFormRepository.getById(id);
            if (numberForm != null) {
                numberFormRepository.delete(id);
                return RestResponse.responseBuilder("true", "204", "Number form deleted successfully", JsonValue.EMPTY_JSON_OBJECT);
            } else {
                return RestResponse.responseBuilder("false", "404", "Number form not found", JsonValue.EMPTY_JSON_OBJECT);
            }
        } catch (Exception e) {
            return RestResponse.responseBuilder("false", "500", "An error occurred", Json.createObjectBuilder().add("error", e.getMessage()).build());
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateNumberForm(@PathParam("id") Long id, NumberForm numberForm) {
        try {
            NumberForm existingNumberForm = numberFormRepository.getById(id);
            if (existingNumberForm != null) {
                existingNumberForm.setIntnum(numberForm.getIntnum());
                existingNumberForm.setNogroupintnum(numberForm.getNogroupintnum());
                existingNumberForm.setMinmaxfractdigit(numberForm.getMinmaxfractdigit());
                existingNumberForm.setMinmaxboundary(numberForm.getMinmaxboundary());
                existingNumberForm.setDoublenum(numberForm.getDoublenum());
                existingNumberForm.setUser_locale(numberForm.getUser_locale());
                existingNumberForm.setUs_locale(numberForm.getUs_locale());
                existingNumberForm.setGerman_locale(numberForm.getGerman_locale());
                existingNumberForm.setIndian_locale(numberForm.getIndian_locale());
                existingNumberForm.setCurrency(numberForm.getCurrency());
                existingNumberForm.setPrefiix(numberForm.getPrefiix());
                existingNumberForm.setSuffix(numberForm.getSuffix());
                existingNumberForm.setStacked(numberForm.getStacked());
                existingNumberForm.setMinmax(numberForm.getMinmax());
                existingNumberForm.setHorizontal_with_step(numberForm.getHorizontal_with_step());
                existingNumberForm.setVertical_with_step(numberForm.getVertical_with_step());

                numberFormRepository.update(existingNumberForm);

                JsonObject jsonResult = Json.createObjectBuilder()
                        .add("id", existingNumberForm.getId())
                        .add("intnum", existingNumberForm.getIntnum())
                        .add("nogroupintnum", existingNumberForm.getNogroupintnum())
                        .add("minmaxfractdigit", existingNumberForm.getMinmaxfractdigit())
                        .add("minmaxboundary", existingNumberForm.getMinmaxboundary())
                        .add("doublenum", existingNumberForm.getDoublenum())
                        .add("user_locale", existingNumberForm.getUser_locale())
                        .add("us_locale", existingNumberForm.getUs_locale())
                        .add("german_locale", existingNumberForm.getGerman_locale())
                        .add("indian_locale", existingNumberForm.getIndian_locale())
                        .add("currency", existingNumberForm.getCurrency())
                        .add("prefiix", existingNumberForm.getPrefiix())
                        .add("suffix", existingNumberForm.getSuffix())
                        .add("stacked", existingNumberForm.getStacked())
                        .add("minmax", existingNumberForm.getMinmax())
                        .add("horizontal_with_step", existingNumberForm.getHorizontal_with_step())
                        .add("vertical_with_step", existingNumberForm.getVertical_with_step())
                        .build();
                return RestResponse.responseBuilder("true", "200", "Number form updated successfully", jsonResult);
            } else {
                return RestResponse.responseBuilder("false", "404", "Number form not found", JsonValue.EMPTY_JSON_OBJECT);
            }
        } catch (Exception e) {
            return RestResponse.responseBuilder("false", "500", "An error occurred", Json.createObjectBuilder().add("error", e.getMessage()).build());
        }
    }
}

