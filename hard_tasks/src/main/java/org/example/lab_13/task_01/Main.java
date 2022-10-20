package org.example.lab_13.task_01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String condition = "^(\\+7|7|8)((\\(\\d{3}\\))|(\\d{3}))(\\d{3})((\\s)(\\d{2})(\\s)(\\d{2})|(-)(\\d{2})(-)(\\d{2}))$";
    public static boolean phoneNumber(String text) {
        Pattern pattern = Pattern.compile(condition);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }
}