package de.papenhagen.service;

import de.papenhagen.utiles.FillerUtil;
import jakarta.enterprise.context.ApplicationScoped;


/**
 * Service for generating Klingon placeholder text.
 * <p>
 * This service provides functionality to generate placeholder text
 * in the form of a Klingon Ipsum, which is essentially a Klingon
 * version of "Lorem Ipsum". The text is generated using the specified
 * repeat count.
 * <p>
 * Methods in this class use the {@code FillerUtil} utility to
 * generate the placeholder text.
 */
@ApplicationScoped
public class PlaceholderService {

    public String generateKlingonText(final int repeatCount) {
        return FillerUtil.filler(repeatCount);
    }
}
