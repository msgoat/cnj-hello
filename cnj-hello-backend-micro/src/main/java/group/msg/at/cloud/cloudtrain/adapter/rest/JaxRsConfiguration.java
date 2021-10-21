package group.msg.at.cloud.cloudtrain.adapter.rest;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * JAX-RS configuration class that triggers activation of the JAX-RS feature
 * and applies some configuration to the JAX-RS environment.
 * <p>
 * Please note that {@code Application} class must be {@code @ApplicationScoped} according to the JAX-RS 2.1 spec in
 * order for JAX-RS to work properly. At least with Payara Micro Profile we faced some issues with REST resources not
 * becoming available directly after server start causing system tests to fail although when using a browser everything
 * just worked fine.
 * </p>
 */
@ApplicationScoped
@ApplicationPath("api")
public class JaxRsConfiguration extends Application {

}
