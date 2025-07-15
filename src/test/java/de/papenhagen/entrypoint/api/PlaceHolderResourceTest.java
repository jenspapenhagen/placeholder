package de.papenhagen.entrypoint.api;

import de.papenhagen.service.PlaceholderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PlaceHolderResourceTest {

    /**
     * Tests for the generateKlingonLoremIpsum method in PlaceHolderResource.
     * This method generates Klingon Lorem Ipsum text by invoking the PlaceholderService.
     */

    @Test
    void testGenerateKlingonLoremIpsumWithDefaultRepeatCount() {
        // Given
        final PlaceholderService mockService = Mockito.mock(PlaceholderService.class);
        final PlaceHolderResource resource = new PlaceHolderResource(mockService);
        final int defaultRepeatCount = 1;
        final String expectedResponse = "Klingon text";

        when(mockService.generateKlingonText(defaultRepeatCount)).thenReturn(expectedResponse);

        // When
        final String result = resource.generateKlingonLoremIpsum(defaultRepeatCount);

        // Then
        assertThat(result).isEqualTo(expectedResponse);
        verify(mockService, times(1)).generateKlingonText(defaultRepeatCount);
    }

    @Test
    void testGenerateKlingonLoremIpsumWithCustomRepeatCount() {
        // Given
        final PlaceholderService mockService = Mockito.mock(PlaceholderService.class);
        final PlaceHolderResource resource = new PlaceHolderResource(mockService);
        final int customRepeatCount = 5;
        final String expectedResponse = "Klingon text repeated 5 times";

        when(mockService.generateKlingonText(customRepeatCount)).thenReturn(expectedResponse);

        // When
        final String result = resource.generateKlingonLoremIpsum(customRepeatCount);

        // Then
        assertThat(result).isEqualTo(expectedResponse);
        verify(mockService, times(1)).generateKlingonText(customRepeatCount);
    }

    @Test
    void testGenerateKlingonLoremIpsumWithInvalidRepeatCount() {
        // Given
        final PlaceholderService mockService = Mockito.mock(PlaceholderService.class);
        final PlaceHolderResource resource = new PlaceHolderResource(mockService);
        final int invalidRepeatCount = -1;
        final String expectedResponse = "Invalid repeat count";

        when(mockService.generateKlingonText(invalidRepeatCount)).thenReturn(expectedResponse);

        // When
        final String result = resource.generateKlingonLoremIpsum(invalidRepeatCount);

        // Then
        assertThat(result).isEqualTo(expectedResponse);
        verify(mockService, times(1)).generateKlingonText(invalidRepeatCount);
    }
}