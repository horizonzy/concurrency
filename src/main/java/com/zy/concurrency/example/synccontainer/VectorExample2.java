package com.zy.concurrency.example.synccontainer;

import java.util.Iterator;
import java.util.Vector;

public class VectorExample2 {


    private static void test1(Vector<Integer> vector) {  //foreach
        for (Integer x : vector) {
            if (x.equals(3)) {
                vector.remove(x);
            }
        }
    }

    private static void test2(Vector<Integer> vector) {  //iterator
        Iterator<Integer> iterator = vector.iterator();
        while (iterator.hasNext()) {
            Integer x = iterator.next();
            if (x.equals(3)) {
                vector.remove(x);
            }
        }
    }

    private static void test3(Vector<Integer> vector) {  //for
        for (int i = 0; i < vector.size(); i++) {
            Integer x = vector.get(i);
            if (x.equals(3)) {
                vector.remove(x);
            }
        }
    }


    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        test3(vector);
    }
}
