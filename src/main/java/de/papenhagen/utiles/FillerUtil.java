package de.papenhagen.utiles;

/**
 * Utility class for generating placeholder text in the form of a Klingon Ipsum.
 * This is the klingon version of "Lorem ipsum"
 * more info:
 * - <a href="https://en.wikipedia.org/wiki/De_finibus_bonorum_et_malorum">Wikipedia</a>
 * - <a href="https://klingon.wiki/En/KlingonIpsum">klingon wiki</a>
 */
public class FillerUtil {

    private FillerUtil() {
    }

    private static final int DEFAULT_TIMES = 1;

    public static String filler(final int times) {

        final String klingonIpsum = "nIb quvmoH chaw nuQ pIqaD way mIQ SeHlaw tungHa' taS, " +
            "ghor jatIh wanI' pab wuv qugh ghoma' jIv. Saqghom mupwI' betleH bey' " +
            "ghem lupDujHom van Dub neb qaywI' loghqam van, " +
            "ghob pegh noD muH run Do Qe' tlhay' chor bargh nuQ, " +
            "HISlaH vIng yuQHom choba' Qol nIb mIQvaD van. SIbI' ghoma' " +
            "HaD wanI' qaywI' toq roS vulqan, tlham yIt voQ Hoqra' SIm " +
            "Qaw, maj 'eb qIvon HIch DIj puq poH. So qeq nuH loghqam " +
            "'ov yIt qImHa', pegh qumwI' matlh janluq pIqarD Saj ray'," +
            " chor bargh to'waQvaD He pegh. taH Hurgh nem SoSbor'a' " +
            "Qan lIghongan SIbI' jey' 'eSpanya Hoqra' meQ, chergh tengchaH " +
            "van chergh may' Huj nagh DIr qorgh SIm. maj poQ poj woj chor " +
            "bargh betleH bey' lev maj nISwI' HIch jIj, chaj Dum poQ qegh " +
            "vemmoH lengwI' ghubDaQ Hurgh, neSlo' He leH ghew baQ yIt rejmorgh.";

        //small range check for the input
        final int minValue = 1;
        final int maxValue = 99;
        final Range<Integer> integerRange = new Range<>(minValue, maxValue);

        return klingonIpsum.repeat(integerRange.contains(times) ? times : DEFAULT_TIMES);
    }
}
