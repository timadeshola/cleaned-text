package com.tim.cleanedtext.utils;

import org.jsoup.Jsoup;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by timad on 5/9/2019.
 */
public class AppUtils {

    public static String sanitizeText(String text) {
        String str = Jsoup.parse(text).text();
        str = Arrays.stream(str.split("\\s+")).distinct().collect(Collectors.joining(" "));
        return str.trim();
    }
}
