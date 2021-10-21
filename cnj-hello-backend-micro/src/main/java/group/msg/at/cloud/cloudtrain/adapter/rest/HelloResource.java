package group.msg.at.cloud.cloudtrain.adapter.rest;

import group.msg.at.cloud.cloudtrain.core.entity.Message;
import group.msg.at.cloud.cloudtrain.core.boundary.HelloWorld;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

/**
 * REST endpoint returning welcome messages.
 * <p>
 * Handles only the mapping of a REST invocation to a Java method invocation;
 * all transactional business logic is encapsulated in a {@code Boundary} this resource class delegates to.
 * </p>
 * <p>
 * Please note that JAX-RS {@code Resource} classes must be {@code @RequestScoped} according to the JAX-RS 2.1 spec in
 * order for JAX-RS to work properly with CDI.
 * </p>
 */
@RequestScoped
@Path("v1/hello")
public class HelloResource {

    @Inject
    private HelloWorld boundary;

    @GET
    public Response getWelcomeMessage() {
        Response result;
        Message welcomeMessage = this.boundary.getHelloMessage();
        if (welcomeMessage != null) {
            result = Response.ok(welcomeMessage).build();
        } else {
            result = Response.status(Response.Status.NOT_FOUND).build();
        }
        return result;
    }
}
