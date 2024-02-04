/*
интерфейсы List и Map
*/

package _3_java_core.collection.lesson_2.workshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> surnames = new ArrayList<>();
        surnames.add("Ivanov");
        surnames.add("Sidorov");
        surnames.add("Ivanov");

        System.out.println("Surnames list: " + surnames);
        System.out.println("Sidorov index: " + surnames.indexOf("Sidorov"));
        System.out.println("Surname on index 1: " + surnames.get(1));

        surnames.add(1, "Markov");
        System.out.println("Surnames list: " + surnames);

        surnames.set(1, "Igorev");
        System.out.println("Surnames list: " + surnames);

        System.out.println(surnames.contains("Igorev"));
        System.out.println(surnames.size());

        //surnames.clear();
        System.out.println(surnames.isEmpty());

        HashSet<String> surnamesSet = new HashSet<>();

        System.out.println("Surnames set: " + surnamesSet);
        surnamesSet.addAll(surnames);
        System.out.println("Surnames set: " + surnamesSet);

        surnamesSet.add("Ponamarev");
        System.out.println("Surnames set: " + surnamesSet);

        surnamesSet.remove("Ivanov");
        System.out.println("Surnames set: " + surnamesSet);

        System.out.println(surnamesSet.size());
        //surnamesSet.clear();
        System.out.println(surnamesSet.isEmpty());

        HashSet<String> surnamesSet2 = new HashSet<>();
        surnamesSet2.add("Igorev");
        surnamesSet2.add("Ponamarev");
        surnamesSet2.add("Sidorov");

        System.out.println(surnamesSet.equals(surnamesSet2));

        HashMap<String, Integer> nameAndAge = new HashMap<>();
        nameAndAge.put("Igor", 30);
        nameAndAge.put("Anton", 40);

        System.out.println("Hash map: " + nameAndAge);

        System.out.println(nameAndAge.get("Anton"));
        System.out.println(nameAndAge.size());

        nameAndAge.put("Anton", 25);
        System.out.println("Hash map: " + nameAndAge);

        System.out.println(nameAndAge.containsKey("Anton"));
        System.out.println(nameAndAge.containsValue(25));

        System.out.println(nameAndAge.keySet());
        System.out.println(nameAndAge.values());

        for (Map.Entry<String, Integer> entry : nameAndAge.entrySet()) {
            System.out.println("Key and value: " + entry.getKey() + " " + entry.getValue());
        }
    }
}
