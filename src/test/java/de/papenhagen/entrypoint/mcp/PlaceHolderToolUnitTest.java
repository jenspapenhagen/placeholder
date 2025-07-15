package de.papenhagen.entrypoint.mcp;

import de.papenhagen.service.PlaceholderService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PlaceHolderToolUnitTest {

    /**
     * Tests for the PlaceHolderTool class.
     * The PlaceHolderTool class provides a method called placeHolder, which uses a PlaceholderService
     * to generate Klingon placeholder text a given number of times.
     */
    @Test
    void testPlaceHolderSingleRepetition() {
        // Given
        final PlaceholderService mockService = mock(PlaceholderService.class);
        when(mockService.generateKlingonText(1)).thenReturn("klingonText");
        final PlaceHolderTool tool = new PlaceHolderTool(mockService);

        // When
        final String result = tool.placeHolder(1);

        // Then
        assertThat(result).isEqualTo("klingonText");
        verify(mockService).generateKlingonText(1);
    }

    @Test
    void testPlaceHolderMultipleRepetitions() {
        // Given
        final PlaceholderService mockService = mock(PlaceholderService.class);
        when(mockService.generateKlingonText(3)).thenReturn("klingonText klingonText klingonText");
        final PlaceHolderTool tool = new PlaceHolderTool(mockService);

        // When
        final String result = tool.placeHolder(3);

        // Then
        assertThat(result).isEqualTo("klingonText klingonText klingonText");
        verify(mockService).generateKlingonText(3);
    }

    @Test
    void testPlaceHolderZeroRepetitions() {
        // Given
        final PlaceholderService mockService = mock(PlaceholderService.class);
        when(mockService.generateKlingonText(0)).thenReturn("");
        final PlaceHolderTool tool = new PlaceHolderTool(mockService);

        // When
        final String result = tool.placeHolder(0);

        // Then
        assertThat(result).isEmpty();
        verify(mockService).generateKlingonText(0);
    }

    @Test
    void testPlaceHolderNegativeRepetitions() {
        // Given
        final PlaceholderService mockService = mock(PlaceholderService.class);
        when(mockService.generateKlingonText(-1)).thenReturn("");
        final PlaceHolderTool tool = new PlaceHolderTool(mockService);

        // When
        final String result = tool.placeHolder(-1);

        // Then
        assertThat(result).isEmpty();
        verify(mockService).generateKlingonText(-1);
    }
}