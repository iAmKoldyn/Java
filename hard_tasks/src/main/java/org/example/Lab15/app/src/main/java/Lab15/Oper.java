package Lab15;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class Oper {
    public static final int MAXVALUE = 100;
    public static final int SIZE_GENERATION_STRING = 10;

    public static final int MAXAGE = 50;
    private static String generationRandomString() {
        String name = "";
        Random r = new Random();
        for(int i = 0; i < SIZE_GENERATION_STRING; i++) {
            char c = (char)(r.nextInt(26) + 'a');
            name += c;
        }
        return name;

    }
    private static Map<Integer, Person> generateMap() {
        Map<Integer, Person> map = new HashMap<Integer, Person>();
        for (int i = 0; i < MAXVALUE; i++) {
            map.put(i, new Person(generationRandomString(), generationRandomString(), (int) (Math.random() * MAXAGE)));
        }
        return map;
    }
    public static void saveFile(String fileName) {

        FileOutputStream fileOutputStream = null;
        ObjectOutputStream out = null;

        try {
            fileOutputStream = new FileOutputStream(fileName);
            out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(generateMap());
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    public static void lookFile(String fileName) {

        Map<Integer, Person> map = new HashMap<Integer, Person>();

        FileInputStream fileInputStream = null;
        ObjectInputStream in = null;

        try {
            fileInputStream = new FileInputStream(fileName);
            in = new ObjectInputStream(fileInputStream);
            map = (Map<Integer, Person>)in.readObject();
            in.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        Set<Map.Entry<Integer, Person>> set = map.entrySet();
        for (Map.Entry<Integer, Person> me : set) {
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
            System.out.println("\n");
        }
    }

}
