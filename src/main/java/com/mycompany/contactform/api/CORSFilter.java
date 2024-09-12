//
//package com.mycompany.contactform.api;
//
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerResponseContext;
//import javax.ws.rs.container.ContainerResponseFilter;
//import javax.ws.rs.ext.Provider;
//import java.io.IOException;
//
//@Provider
//public class CORSFilter implements ContainerResponseFilter {
//
//    @Override
//    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
//        responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
//        responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//        responseContext.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
//        responseContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
//    }
//}
//


//And make changes in the JakartaRestConfiguration for login access

//package com.mycompany.contactform;
//
//import com.mycompany.contactform.api.CORSFilter;
//import com.mycompany.contactform.api.ContactApi;
//
//import javax.ws.rs.ApplicationPath;
//import javax.ws.rs.core.Application;
//import java.util.HashSet;
//import java.util.Set;

/**
 * Configures Jakarta RESTful Web Services for the application.
 * @author Juneau
 */
//@ApplicationPath("/api")
//public class JakartaRestConfiguration extends Application {
//
//    @Override
//    public Set<Class<?>> getClasses() {
//        Set<Class<?>> classes = new HashSet<>();
//        // Register your resource classes
//        classes.add(ContactApi.class);
//        // Register your filter classes
//        classes.add(CORSFilter.class);
//        return classes;
//    }
//}
