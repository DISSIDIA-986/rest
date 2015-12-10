package com.example;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * <p>AirResourceConfig class.</p>
 *
 * @author hanl
 * @version $Id: $Id
 */
@ApplicationPath("/webapi/*")
public class AirResourceConfig extends ResourceConfig {
    /**
     * <p>Constructor for AirResourceConfig.</p>
     */
    public AirResourceConfig() {
        packages("com.example.resource");
        /**register(BookResource.class);**/
    }   
}