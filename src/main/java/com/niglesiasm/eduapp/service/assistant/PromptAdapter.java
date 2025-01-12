package com.niglesiasm.eduapp.service.assistant;

public class PromptAdapter {

    private static final String TEA_ADAPTATION =
            " Por favor, presenta la información:\n" +
                    "- De forma clara y literal\n" +
                    "- Con estructura ordenada y numerada\n" +
                    "- Sin metáforas ni ambigüedades\n" +
                    "- Con ejemplos concretos";

    private static final String TDAH_ADAPTATION =
            " Por favor, presenta la información:\n" +
                    "- En fragmentos cortos y claros\n" +
                    "- Usando viñetas y elementos visuales\n" +
                    "- Con ejemplos prácticos\n" +
                    "- De forma concisa y dinámica";

    public static String adaptPrompt(String basePrompt, String profile) {
        switch (profile.toUpperCase()) {
            case "TEA":
                return basePrompt + TEA_ADAPTATION;
            case "TDAH":
                return basePrompt + TDAH_ADAPTATION;
            default:
                return basePrompt;
        }
    }
}
