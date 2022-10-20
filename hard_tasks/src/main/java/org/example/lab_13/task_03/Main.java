package org.example.lab_13.task_03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static String replacingWords(String text, String[] heAveragedAnHour, String favoriteWord){
        Pattern myPattern = Pattern.compile("\\b(" + String.join("|", heAveragedAnHour) + ")\\b");
        Matcher myMatcher = myPattern.matcher(text);
        return myMatcher.replaceAll(favoriteWord);
    }
}
