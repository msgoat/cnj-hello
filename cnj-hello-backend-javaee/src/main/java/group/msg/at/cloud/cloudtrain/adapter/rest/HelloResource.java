package group.msg.at.cloud.cloudtrain.adapter.rest;

import group.msg.at.cloud.cloudtrain.core.boundary.HelloWorld;
import group.msg.at.cloud.cloudtrain.core.entity.Message;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * REST endpoint returning welcome messages.
 * <p>
 * Handles only the mapping of a REST invocation to a Java method invocation;
 * all transactional business logic is encapsulated in a {@code Boundary} this resource class delegates to.
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
