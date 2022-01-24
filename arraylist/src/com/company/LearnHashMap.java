package com.company;


import java.util.HashMap;

class Student {
    String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name.charAt(0);
    }

    @Override
    public String toString() {
        return name;
    }
}
/*

        mp.put(0, 1);
        mp.put(1, 1);
        mp.put(2, 1);

        mp.put(96, 1);
        mp.put(97, 1);
        mp.put(98, 1);

        mp.put(192, 1);
        mp.put(193, 1);
        mp.put(194, 1);

 */

public class LearnHashMap {
    public static void main() {
        HashMap<Student, Integer> mp = new HashMap<>();
        mp.put(new Student("balaji"), 1);
        mp.put(new Student("akash"), 1);
        mp.put(new Student("rubesh"), 1);
        mp.put(new Student("abhi"), 1);
        mp.put(new Student("bala"), 1);
        mp.forEach( (one, two) -> System.out.println(one + " " + two));
    }
}
