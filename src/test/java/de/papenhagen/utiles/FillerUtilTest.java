package de.papenhagen.utiles;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FillerUtilTest {

    /**
     * Test class for the FillerUtil utility class.
     * This class provides unit tests for the filler method to ensure it behaves as expected
     * under different scenarios.
     */

    @Test
    void givenPositiveTimes_whenFillerIsCalled_thenReturnsRepeatedString() {
        // Given
        final int times = 3;
        final String expectedSubstring = "nIb quvmoH";

        // When
        final String result = FillerUtil.filler(times);

        // Then
        assertThat(result).startsWith(expectedSubstring);
        assertThat(result.split(expectedSubstring, -1).length - 1).isEqualTo(times);
    }

    @Test
    void givenZeroTimes_whenFillerIsCalled_thenReturnsStringRepeatedOnce() {
        // Given
        final int times = 0;
        final String expectedSubstring = "nIb quvmoH";

        // When
        //by given a number smaller than 1, we fall back to positive numbers
        final String result = FillerUtil.filler(times);

        // Then
        assertThat(result).startsWith(expectedSubstring);
        assertThat(result.split(expectedSubstring, -1).length - 1).isEqualTo(1);
    }

    @Test
    void givenNegativeTimes_whenFillerIsCalled_thenReturnsStringRepeatedOnce() {
        // Given
        final int times = -5;
        final String expectedSubstring = "nIb quvmoH";

        // When
        final String result = FillerUtil.filler(times);

        // Then
        assertThat(result).startsWith(expectedSubstring);
        assertThat(result.split(expectedSubstring, -1).length - 1).isEqualTo(1);
    }

    @Test
    void givenLargePositiveTimes_whenFillerIsCalled_thenReturnsCorrectlyRepeatedString() {
        // Given
        final int times = 10;
        final String expectedSubstring = "nIb quvmoH";

        // When
        final String result = FillerUtil.filler(times);

        // Then
        assertThat(result).startsWith(expectedSubstring);
        assertThat(result.split(expectedSubstring, -1).length - 1).isEqualTo(times);
    }
}