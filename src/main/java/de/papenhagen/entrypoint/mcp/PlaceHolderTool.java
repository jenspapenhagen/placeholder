package de.papenhagen.entrypoint.mcp;

import de.papenhagen.service.PlaceholderService;
import io.quarkiverse.mcp.server.Tool;
import io.quarkiverse.mcp.server.ToolArg;
import jakarta.inject.Singleton;

/**
 * A tool interface class to generate placeholder text in Klingon.
 *
 * The generated text is repeated a specified number of times
 * according to the input parameter.
 */
@Singleton
public class PlaceHolderTool {

    private final PlaceholderService placeholderService;

    public PlaceHolderTool(final PlaceholderService placeholderService) {
        this.placeholderService = placeholderService;
    }

    @Tool(description = "Get placeholder text in klingon.")
    public String placeHolder(@ToolArg(description = "how many times the placeholder text get repeated") final int times) {
        return placeholderService.generateKlingonText(times);
    }
}
