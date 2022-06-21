package me.thiagorigonatti.getspawners.customconfig;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VersionComparator {
    private static final Pattern PATTERN = Pattern.compile("^(?<st>\\p{Digit}+)\\.(?<nd>\\p{Digit}+)\\.(?<rd>\\p{Digit}+)$");

    public static boolean isOutOfDate(String userVersion, String githubVersion) {

        Matcher v1Matcher = PATTERN.matcher(userVersion);
        Matcher v2Matcher = PATTERN.matcher(githubVersion);

        if (v1Matcher.matches() && v2Matcher.matches()) {
            int[] v1Array = {
                    Integer.parseInt(v1Matcher.group("st")),
                    Integer.parseInt(v1Matcher.group("nd")),
                    Integer.parseInt(v1Matcher.group("rd"))
            };

            int[] v2Array = {
                    Integer.parseInt(v2Matcher.group("st")),
                    Integer.parseInt(v2Matcher.group("nd")),
                    Integer.parseInt(v2Matcher.group("rd"))
            };

            for (int i = 0; i < 3; i++) {
                if (v1Array[i] != v2Array[i]) {
                    return v1Array[i] < v2Array[i];
                }
            }
        } else throw new IllegalArgumentException("Invalid argument, check provided versions.");

        return false;
    }
}
