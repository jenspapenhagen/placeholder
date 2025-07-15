package de.papenhagen.entrypoint.api;

import de.papenhagen.service.PlaceholderService;
import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.RestQuery;

@OpenAPIDefinition(
    tags = {
        @Tag(name = "placeholder", description = "Generate placeholder text in Klingon language"),
    },
    info = @Info(
        title = "Klingon Lorem Ipsum Generator API",
        version = "1.0.0",
        contact = @Contact(
            name = "API Support",
            url = "http://exampleurl.com/contact",
            email = "jens.papenhagen@web.de"),
        license = @License(
            name = "Apache 2.0",
            url = "https://www.apache.org/licenses/LICENSE-2.0.html"))
)
@Path("/placeholder")
public class PlaceHolderResource {

    private static final int DEFAULT_REPEAT_COUNT = 1;

    private final PlaceholderService placeholderService;

    @Inject
    public PlaceHolderResource(PlaceholderService placeholderService) {
        this.placeholderService = placeholderService;
    }

    @GET
    @Operation(
        summary = "Generate Klingon Lorem Ipsum text",
        description = "Returns Klingon Lorem Ipsum text repeated the specified number of times"
    )
    @APIResponses(value = {
        @APIResponse(
            responseCode = "200",
            description = "Successfully generated Klingon Lorem Ipsum text"
        ),
        @APIResponse(
            responseCode = "400",
            description = "Qagh"
        )
    })
    @Produces(MediaType.TEXT_PLAIN)
    public String generateKlingonLoremIpsum(
        @RestQuery
        @DefaultValue("" + DEFAULT_REPEAT_COUNT)
        @Parameter(description = "Number of times to repeat the Lorem Ipsum text", required = false) final int repeatCount) {
        return placeholderService.generateKlingonText(repeatCount);
    }

}