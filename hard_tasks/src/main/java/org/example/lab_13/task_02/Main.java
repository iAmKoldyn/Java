package org.example.lab_13.task_02;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    //все существительные идущие после числительного "Пятый"
    private static String regex = "(\\b[Пп]ят(ый|ая|ое|ые|ого|ому|ом|ой|ую|ою|ых|ым|ыми))\\s(\\w+)";
    public static ArrayList<String> oleglox(String text) {
        Pattern pattern = Pattern.compile(regex, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text);
        ArrayList<String> noun = new ArrayList<>();
        while(matcher.find()) {
            noun.add(matcher.group(3));
        }
        return noun;
    }
}