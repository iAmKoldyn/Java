package org.example.lab_12.task_01;


import java.util.Map;
import java.util.Random;

public class MapsBuilder {

    private final Map<String, Integer> myMap;

    public MapsBuilder(Map<String, Integer> myMap) {
        this.myMap = myMap;
        insertMapValues();
    }

    private void insertMapValues() {
        for (int i = 0; i < 2000000; i++) {
            this.myMap.put(generateString(), generateInteger());
        }
    }

    public Map<String, Integer> getMyMap() {
        return myMap;
    }

    private String generateString() {
        int leftLimitChars = 97;
        int rightLimitChars = 122;
        int stringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(stringLength);
        for (int i = 0; i < stringLength; i++) {
            int randomLimitedInt = leftLimitChars + (int) (random.nextFloat() * (rightLimitChars - leftLimitChars + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    private Integer generateInteger() {
        return new Random().nextInt();
    }
}
