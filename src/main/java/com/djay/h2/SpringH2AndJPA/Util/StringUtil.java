package com.djay.h2.SpringH2AndJPA.Util;

public class StringUtil {

    public static boolean isNull (String value) {

        return value.equalsIgnoreCase(null) ||
                value.equalsIgnoreCase("null") ||
                value.equalsIgnoreCase("");
    }
}
